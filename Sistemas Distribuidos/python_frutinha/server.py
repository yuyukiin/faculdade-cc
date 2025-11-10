import socket
import threading
import json
import random
import time

HOST = '127.0.0.1'
PORT = 65432
GRID_WIDTH = 20
GRID_HEIGHT = 10
TICK_RATE = 0.1

players = {}
reward = {'x': random.randint(0, GRID_WIDTH - 1), 'y': random.randint(0, GRID_HEIGHT - 1)}

game_state_lock = threading.Lock()

def create_new_reward():
    global reward
    reward['x'] = random.randint(0, GRID_WIDTH - 1)
    reward['y'] = random.randint(0, GRID_HEIGHT - 1)

def handle_client_movement(player_id, direction):
    with game_state_lock:
        player = players.get(player_id)
        if not player:
            return

        if direction == 'w':
            player['y'] = max(0, player['y'] - 1)
        elif direction == 's':
            player['y'] = min(GRID_HEIGHT - 1, player['y'] + 1)
        elif direction == 'a':
            player['x'] = max(0, player['x'] - 1)
        elif direction == 'd':
            player['x'] = min(GRID_WIDTH - 1, player['x'] + 1)

        if player['x'] == reward['x'] and player['y'] == reward['y']:
            player['score'] += 1
            print(f"[Game] Jogador {player['char']} ({player_id}) coletou a recompensa! Pontuação: {player['score']}")
            create_new_reward()

def get_game_state():
    with game_state_lock:
        state = {
            'players': list(players.values()),
            'reward': reward
        }
        return json.dumps(state)

def client_handler(conn, addr):
    player_id = f"{addr[0]}:{addr[1]}"
    
    player_char = random.choice('ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$&')
    
    with game_state_lock:
        players[player_id] = {
            'x': random.randint(0, GRID_WIDTH - 1),
            'y': random.randint(0, GRID_HEIGHT - 1),
            'score': 0,
            'char': player_char
        }
    
    print(f"[Servidor] Novo jogador conectado: {player_id} como '{player_char}'")

    try:
        while True:
            data = conn.recv(1024)
            if not data:
                break

            direction = data.decode('utf-8').strip().lower()
            if direction in ['w', 'a', 's', 'd']:
                handle_client_movement(player_id, direction)

    except ConnectionResetError:
        print(f"[Servidor] Conexão com {player_id} perdida (reset).")
    except Exception as e:
        print(f"[Servidor] Erro com cliente {player_id}: {e}")
    finally:
        with game_state_lock:
            if player_id in players:
                del players[player_id]
        print(f"[Servidor] Jogador {player_id} desconectado.")
        conn.close()

def broadcast_game_state(server_socket):
    active_connections = []
    
    def accept_connections():
        while True:
            try:
                conn, addr = server_socket.accept()
                with game_state_lock:
                    active_connections.append(conn)
                
                handler_thread = threading.Thread(target=client_handler, args=(conn, addr), daemon=True)
                handler_thread.start()
            except OSError:
                break

    accept_thread = threading.Thread(target=accept_connections, daemon=True)
    accept_thread.start()
    print("[Servidor] Aguardando novas conexões...")

    while True:
        game_state_json = get_game_state()
        
        disconnected_clients = []
        with game_state_lock:
            for conn in active_connections:
                try:
                    conn.sendall(game_state_json.encode('utf-8'))
                except (ConnectionAbortedError, ConnectionResetError, BrokenPipeError):
                    disconnected_clients.append(conn)
        
        if disconnected_clients:
            with game_state_lock:
                for conn in disconnected_clients:
                    if conn in active_connections:
                        active_connections.remove(conn)
        
        time.sleep(TICK_RATE)

def main():
    print("[Servidor] Iniciando o servidor do Jogo de Coleta...")
    
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        s.bind((HOST, PORT))
        s.listen()
        print(f"[Servidor] Escutando em {HOST}:{PORT}")

        try:
            broadcast_game_state(s)
        except KeyboardInterrupt:
            print("\n[Servidor] Desligando o servidor...")
        finally:
            s.close()

if __name__ == "__main__":
    main()
