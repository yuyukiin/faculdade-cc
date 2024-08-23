import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        JTextField display = new JTextField();
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            buttonPanel.add(button);
            button.addActionListener(new ButtonClickListener(display));
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

class ButtonClickListener implements ActionListener {
    private JTextField display;
    private StringBuilder currentInput = new StringBuilder();
    
    public ButtonClickListener(JTextField display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();
        
        if (command.equals("=")) {
            try {
                double result = eval(currentInput.toString());
                display.setText(String.valueOf(result));
                currentInput.setLength(0);
            } catch (Exception ex) {
                display.setText("Erro");
            }
        } else {
            currentInput.append(command);
            display.setText(currentInput.toString());
        }
    }

    private double eval(String expression) {
        try {
            javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = manager.getEngineByName("JavaScript");
            return ((Number) engine.eval(expression)).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
