
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Classe com metodos utilitarios
 */
public class Util {
    
        /***
         * Sorteia a posicao da fruta apos um jogador colidir com ela
         * @param fruta
         * @param frame
         * @param ghost1
         * @param ghost2
         * @return 
         */
        public static JButton sorteiaPosicao(JButton fruta, JFrame frame, JButton ghost1, JButton ghost2){
        Random gerador = new Random();
        int limiteInferior = frame.getContentPane().getHeight() - fruta.getHeight();
        int limiteDireita = frame.getContentPane().getWidth() - fruta.getWidth();
        int x, y; 
        
        // Faz com que a fruta nao nasca onde estao os jogadores
        do {            
            x = gerador.nextInt(10, limiteDireita);
            y = gerador.nextInt(10, limiteInferior);
            fruta.setBounds(x, y, fruta.getWidth(), fruta.getHeight());
        } while ((fruta.getBounds().intersects(ghost1.getBounds())) || 
                fruta.getBounds().intersects(ghost2.getBounds()));
        
        return fruta;
    }
    /***
     * Verifica qual jogador pegou a frutinha
     * @param origem
     * @param destino
     * @return 
     */
    public static boolean pegou(JButton origem, JButton destino) {
        return origem.getBounds().intersects(destino.getBounds());
    }
}
