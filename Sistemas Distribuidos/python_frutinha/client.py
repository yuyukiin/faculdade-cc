import socket
import threading
import json
import os
import time

HOST = '127.0.0.1'
PORT = 65432
GRID_WIDTH = 20
GRID_HEIGHT = 10

game_state = {'players': [], 'reward': {}}
game_state_lock = threading.Lock()
client_socket = None

def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')

def draw_game():
    global game_state
    
    with game_state_lock:
        players = list(game_state.get('players', []))
        reward = game_state.get('reward', {})
    
    grid = [[' .' for _ in range(GRID_WIDTH)] for _ in range(GRID_HEIGHT)]
    
    if reward:
        grid[reward['y']][reward['x']] = ' F'
    
    for player in players:
        grid[player['y']][player['x']] = f" {player['char']}"
    
    clear_screen()
    print("--- Jogo da Coleta (Terminal Edition) ---")
    print("Mova-se com W, A, S, D + Enter")
    
    for row in grid:
        print(''.join(row))
        
    print("\n--- Placar ---")
    for i, player in enumerate(players):
        print(f"Jogador '{player['char']}': {player['score']} pontos")

def receive_data_thread(sock):
    global game_state
    while True:
        try:
            data = sock.recv(4096)
            if not data:
                print("\n[Cliente] Desconectado do servidor.")
                break
                
            with game_state_lock:
                game_state = json.loads(data.decode('utf-8'))
                
        except (ConnectionAbortedError, ConnectionResetError):
            print("\n[Cliente] Conexão com o servidor perdida.")
            break
        except json.JSONDecodeError:
            pass 
        except Exception as e:
            print(f"\n[Cliente] Erro ao receber dados: {e}")
            break
            
    global client_socket
    if client_socket:
        client_socket.close()

def send_input_thread(sock):
    while True:
        try:
            direction = input() 
            if direction.lower() in ['w', 'a', 's', 'd']:
                sock.sendall(direction.lower().encode('utf-8'))
            elif direction.lower() == 'exit':
                break
                
        except EOFError:
            break
        except OSError:
            break
            
    global client_socket
    if client_socket:
        client_socket.close()

def main():
    global client_socket
    try:
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
            client_socket = s
            s.connect((HOST, PORT))
            print("[Cliente] Conectado ao servidor!")

            receiver = threading.Thread(target=receive_data_thread, args=(s,), daemon=True)
            receiver.start()
            
            sender = threading.Thread(target=send_input_thread, args=(s,), daemon=True)
            sender.start()

            while receiver.is_alive() and sender.is_alive():
                draw_game()
                time.sleep(0.05)
            
    except ConnectionRefusedError:
        print(f"[Cliente] Não foi possível conectar ao servidor em {HOST}:{PORT}.")
        print("Verifique se o 'server.py' está rodando.")
    except KeyboardInterrupt:
        print("\n[Cliente] Saindo...")
    finally:
        if client_socket:
            client_socket.close()
            
if __name__ == "__main__":
    main()
