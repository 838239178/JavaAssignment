package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    //region -JComponents-
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel numberPanel;
    private JPanel operatorPanel;
    private JPanel southPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JTextField textArea;
    private JButton[] numberBtn;
    private JButton[] operatorBtn;
    private JButton point;
    private JButton delete;
    private JButton neg;
    //endregion

    private final Calculator calculator;

    private void initComponent() {
        this.setLayout(new BorderLayout(10, 10));

        centerPanel = new JPanel(new BorderLayout(10, 6));
        numberPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        operatorPanel = new JPanel(new GridLayout(6, 1, 10, 6));

        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();

        textArea = new JTextField("0", 1);

        numberBtn = new JButton[10];
        operatorBtn = new JButton[5];
        delete = new JButton("AC");
        point = new JButton(".");
        neg = new JButton("neg");

        textArea.setEditable(false);
        textArea.setFont(new Font("微软雅黑", Font.BOLD, 24));
        textArea.setHorizontalAlignment(SwingConstants.TRAILING);

        point.setFont(new Font("黑体", Font.BOLD, 18));
        delete.setFont(new Font("黑体", Font.BOLD, 15));

        delete.addActionListener(event -> {
            textArea.setText("0");
            calculator.reset();
        });
        point.addActionListener(new OperatorButtonListener("."));
        neg.addActionListener(new OperatorButtonListener("neg"));

        for (int i = 0; i < 10; i++) {
            numberBtn[i] = new JButton(String.valueOf(i));
            numberBtn[i].addActionListener(new NumberButtonListener(i));
            numberBtn[i].setFont(new Font("黑体", Font.BOLD, 18));
            numberPanel.add(numberBtn[i]);
        }

        numberPanel.add(point);
        numberPanel.add(delete);

        operatorPanel.add(neg);

        String[] temp = {"+", "-", "*", "/", "="};
        for (int i = 0; i < operatorBtn.length; i++) {
            operatorBtn[i] = new JButton(temp[i]);
            operatorBtn[i].setFont(new Font("黑体", Font.BOLD, 18));
            operatorBtn[i].addActionListener(new OperatorButtonListener(temp[i]));
            operatorPanel.add(operatorBtn[i]);
        }


        centerPanel.add(BorderLayout.NORTH, textArea);
        centerPanel.add(BorderLayout.CENTER, numberPanel);
        centerPanel.add(BorderLayout.EAST, operatorPanel);

        this.add(BorderLayout.NORTH, northPanel);
        this.add(BorderLayout.CENTER, centerPanel);
        this.add(BorderLayout.SOUTH, southPanel);
        this.add(BorderLayout.EAST, eastPanel);
        this.add(BorderLayout.WEST, westPanel);

        this.pack();
        this.setSize(300, 300);
    }

    public CalculatorFrame() {
        initComponent();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("简易计算器");

        calculator = new Calculator();
    }

    private class NumberButtonListener implements ActionListener {
        private final int value;

        public NumberButtonListener(int value) {
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (calculator.isCalculated()) {
                calculator.reset();
                textArea.setText(String.valueOf(value));
            } else {
                textArea.setText(textArea.getText() + value);
            }

            calculator.inputNum(value);
        }
    }

    private class OperatorButtonListener implements ActionListener {
        private final String value;

        public OperatorButtonListener(String value) {
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (value.equals("=")) {
                    textArea.setText(String.valueOf(calculator.getResult()));
                } else {
                    if (value.equals("neg") && calculator.isCalculated()) {
                        textArea.setText("neg");
                    } else {
                        textArea.setText(textArea.getText() + value);
                    }
                    calculator.inputOperator(value);
                }
            } catch (ArithmeticException ae) {
                calculator.reset();
                textArea.setText("Error Input");
                System.out.println(ae.toString());
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorFrame();
    }
}
