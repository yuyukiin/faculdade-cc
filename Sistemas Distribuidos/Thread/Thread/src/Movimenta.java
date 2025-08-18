
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 */
public class Movimento {
    
    public static void cima(JButton botao) {
        if(botao.getY() > 0){
            botao.setBounds(botao.getX(), botao.getY() - 10, botao.getWidth(), botao.getHeight());
        }
    }
    
    public static void baixo(JButton botao, JFrame frame) {
        int limiteInferior = frame.getContentPane().getHeight() - botao.getHeight();
        if(botao.getY() < limiteInferior){
            botao.setBounds(botao.getX(), botao.getY() + 10, botao.getWidth(), botao.getHeight());
        }
    }
    
    public static void esquerda(JButton botao) {
        if(botao.getX() > 0){
            botao.setBounds(botao.getX() - 10, botao.getY(), botao.getWidth(), botao.getHeight());
        }
    }
    
    public static void direita(JButton botao, JFrame frame) {
        int limiteDireita = frame.getContentPane().getWidth() - botao.getWidth();
        if(botao.getX() < limiteDireita){
            botao.setBounds(botao.getX() + 10, botao.getY(), botao.getWidth(), botao.getHeight());
        }
    }
}
