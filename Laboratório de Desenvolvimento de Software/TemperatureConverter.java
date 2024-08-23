import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversão de Temperatura");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(null);

        JTextField fahrenheitField = new JTextField();
        fahrenheitField.setBounds(20, 20, 100, 30);
        frame.add(fahrenheitField);

        JButton convertButton = new JButton("Converter");
        convertButton.setBounds(130, 20, 120, 30);
        frame.add(convertButton);

        JLabel resultLabel = new JLabel("Temperatura em Celsius:");
        resultLabel.setBounds(20, 70, 250, 30);
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    resultLabel.setText(String.format("Temperatura em Celsius: %.2f", celsius));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
