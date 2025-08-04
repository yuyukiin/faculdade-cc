
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

/***
 * classe responsavel por movimentar componentes botoes para cima, baixo, esquerda e direita
 * @author laboratorio
 */

public class Movimenta {
    public static void cima(JButton botao) {
        if (botao.getY() > 0) {
        botao.setBounds(botao.getX(), botao.getY() - 10, botao.getWidth(), botao.getHeight());
        }
    }
    
    public static void baixo(JButton botao, JFrame frame) {
        int limiteInferior = frame.getContentPane().getHeight() - botao.getHeight();
        if (botao.getY() < limiteInferior) {
        botao.setBounds(botao.getX(), botao.getY() + 10, botao.getWidth(), botao.getHeight());
        }
    }
    
    public static void esquerda(JButton botao) {
        if (botao.getX() > 0) {
        botao.setBounds(botao.getX() - 10, botao.getY(), botao.getWidth(), botao.getHeight());
        }
    }
    
    public static void direita(JButton botao, JFrame frame) {
        int limiteDireita = frame.getContentPane().getWidth() - botao.getWidth();
        if (botao.getX() < limiteDireita) {
        botao.setBounds(botao.getX() + 10, botao.getY(), botao.getWidth(), botao.getHeight());
        }
    }
    
        public static void sorteiaPosicao(JButton botao, JFrame frame) {
            Random gerador = new Random();
            int limiteInferior = frame.getContentPane().getHeight() - botao.getHeight();
            int limiteDireita = frame.getContentPane().getWidth() - botao.getHeight();
            int x = gerador.nextInt(10, limiteDireita);
            int y = gerador.nextInt(10, limiteInferior);
            
            botao.setBounds(x, y, botao.getWidth(), botao.getHeight());

        }
}
