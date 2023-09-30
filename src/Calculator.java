
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[9];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton, negButton;
    private JPanel panel;

    private Font myFont = new Font("Ink Free", Font.BOLD, 30);

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {



        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setTitle("Calculator");

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.GRAY);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        //System.out.println("Hello");
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        handleNumberFunctions(e);

        handleDecimalFunctions(e);

        handleAdditionFunctions(e);

        handleSubtractionFunctions(e);

        handleMultiplicationFunctions(e);

        handleDivisionFunctions(e);

        handleEqualFunctions(e);

        handleClearFunctions(e);

        handleDeleteFunctions(e);

        handleNegativeFunctions(e);


    }

    /*
     * Description: Handler methods to improve code quality
     */
    private void handleNumberFunctions(ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                if(textField.getText().equals("0") || result != 0) {
                    textField.setText("");
                }

                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
    }

    private void handleDecimalFunctions(ActionEvent e) {
        if(e.getSource() == decButton && !textField.getText().contains(".")) {
            if(textField.getText().length() == 0) {
                textField.setText("0.");
            } else {
                textField.setText(textField.getText().concat("."));
            }
        }
    }

    private void handleAdditionFunctions(ActionEvent e) {
        if(e.getSource() == addButton) {
            if(num1 == 0) {
                num1 = Double.parseDouble(textField.getText());
            } else {
                num1 += Double.parseDouble(textField.getText());
            }

            operator = '+';
            textField.setText("");

            System.out.println("num1: " + num1);
            System.out.println("num2: " + num2);
            System.out.println("result: " + result);
            System.out.println("operator: " + operator);
        }
    }

    private void handleSubtractionFunctions(ActionEvent e) {
        if(e.getSource() == subButton) {

            if(num1 == 0) {
                num1 = Double.parseDouble(textField.getText());

            } else {
                num1 -= Double.parseDouble(textField.getText());
            }

            operator = '-';
            textField.setText("");

            System.out.println("num1: " + num1);
            System.out.println("num2: " + num2);
            System.out.println("result: " + result);
            System.out.println("operator: " + operator);
        }
    }

    private void handleMultiplicationFunctions(ActionEvent e) {
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
    }

    private void handleDivisionFunctions(ActionEvent e) {
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
    }

    private void handleEqualFunctions(ActionEvent e) throws NumberFormatException {
        if(e.getSource() == equButton) {
            try {
                num2 = Double.parseDouble(textField.getText());
            } catch (NumberFormatException exception) {
                System.out.println(exception.getMessage());
            }
            switch(operator) {
                case '+' :
                    result = num1 + num2;
                    break;
                case '-' :
                    result = num1 - num2;
                    break;
                case '*' :
                    result = num1 * num2;
                    break;
                case '/' :
                    result = num1 / num2;
                    break;
                default:
                    //textField.setText(textField.getText());

            }

            System.out.println("Equal");

            System.out.println("num1: " + num1);
            System.out.println("num2: " + num2);
            System.out.println("result: " + result);
            System.out.println("operator: " + operator);

            textField.setText(String.valueOf(result));
            num1 = 0;
            //operator = '~';
            num2 = 0;
            result = 0;

            System.out.println("num1: " + num1);
            System.out.println("num2: " + num2);
            System.out.println("result: " + result);
            System.out.println("operator: " + operator);

        }
    }

    private void handleClearFunctions(ActionEvent e) {
        if(e.getSource() == clrButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }

        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("result: " + result);
        System.out.println("operator: " + operator);
    }

    private void handleDeleteFunctions(ActionEvent e) {
        if(e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }

        }
    }

    private void handleNegativeFunctions(ActionEvent e) {
        if(e.getSource() == negButton) {
            Double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
