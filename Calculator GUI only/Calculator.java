import javax.swing.*;
import java.awt.*;

public class Calculator {

    JFrame frame;
    JTextField display;
    JPanel panel;

    public Calculator(){
        createWindow();
        createDisplay();
        createButtons();
    }

    void createWindow(){
        frame = new JFrame("Calculator");
        frame.setSize(380,500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
    }

    void createDisplay(){
        display = new JTextField();
        display.setPreferredSize(new Dimension(320,80));
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setCaretColor(Color.WHITE);
        display.setFont(new Font("Arial",Font.BOLD,28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        frame.add(display, BorderLayout.NORTH);
    }

    void createButtons(){

        panel = new JPanel(new GridLayout(5,4,15,15));
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        String[] buttons = {
                "AC","%","DEL","/",
                "7","8","9","*",
                "4","5","6","-",
                "1","2","3","+",
                "00","0",".","="
        };

        Color numberColor = new Color(35,35,35);
        Color operatorText = new Color(90,140,255);
        Color equalColor = new Color(70,100,180);
        Color clearText = new Color(255,90,90);

        for(String text : buttons){

            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial",Font.BOLD,18));
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);

            if(text.equals("AC")){
                btn.setBackground(numberColor);
                btn.setForeground(clearText);
            }
            else if(text.equals("=")){
                btn.setBackground(equalColor);
                btn.setForeground(Color.WHITE);
            }
            else if(text.matches("[0-9.]+")){
                btn.setBackground(numberColor);
                btn.setForeground(Color.WHITE);
            }
            else{
                btn.setBackground(numberColor);
                btn.setForeground(operatorText);
            }

            panel.add(btn);
        }

        frame.add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        Calculator calc = new Calculator();
        calc.frame.setVisible(true);
    }
}