import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    public GUI() {
        int inputRow;
        int inputCol;
        do {
            JTextField xField = new JTextField(5);
            JTextField yField = new JTextField(5);

            JPanel dialogPanel = new JPanel();
            dialogPanel.add(new JLabel("Row:"));
            dialogPanel.add(xField);
            dialogPanel.add(Box.createHorizontalStrut(15));
            dialogPanel.add(new JLabel("Column:"));
            dialogPanel.add(yField);
            int result = JOptionPane.showConfirmDialog(null, dialogPanel,
                    "Please enter Row and Column values", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                System.out.println("Row value: " + xField.getText());
                System.out.println("Col value: " + yField.getText());
            }
            inputRow = parseInt(xField.getText());
            inputCol = parseInt(yField.getText());
        } while (inputRow == -1 || inputCol == -1 || inputRow != inputCol);
        JFrame guiFrame = new JFrame();
        guiFrame.setLayout(new GridLayout(3, 1));
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Gaussian Elimination for Inverse Matrices");
        guiFrame.setSize(400, 400);
        guiFrame.setLocation(450, 250);
        JPanel inputPanel = new JPanel();
        JPanel outputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(inputRow, inputCol));
        JTextField[][] inputFields = new JTextField[inputRow][inputCol];
        for (int i = 0; i < inputRow; i++) {
            for (int j = 0; j < inputCol; j++) {
                JTextField inputField = new JTextField(5);
                inputFields[i][j] = inputField;
                inputPanel.add(inputField);
            }
        }
        outputPanel.setLayout(new GridLayout(inputRow, inputCol));
        JLabel[][] outputFields = new JLabel[inputRow][inputCol];
        for (int i = 0; i < inputRow; i++) {
            for (int j = 0; j < inputCol; j++) {
                JLabel outputField = new JLabel();
                outputFields[i][j] = outputField;
                outputPanel.add(outputField);
            }
        }
        JButton calculateButton = new JButton("Calculate!");
        int finalInputRow = inputRow;
        int finalInputCol = inputCol;
        calculateButton.addActionListener(new ActionListener() {
            double[][] inputs = new double[finalInputRow][finalInputCol];

            @Override
            public void actionPerformed(ActionEvent event) {
                for (int i = 0; i < finalInputRow; i++) {
                    for (int j = 0; j < finalInputCol; j++) {
                        try {
                            inputs[i][j] = Integer.parseInt(inputFields[i][j].getText());
                        } catch (Exception e) {
                            System.out.println("Only integers please!");
                        }
                    }
                }
                double[][] inverted = Calculator.augmenter(inputs);
                for (int i = 0; i < finalInputRow; i++) {
                    for (int j = 0; j < finalInputCol; j++) {
                        double round = (double) Math.round(inverted[i][j] * 100) / 100;
                        outputFields[i][j].setText("" +  round);
                    }
                }

            }
        });
        guiFrame.add(inputPanel);
        guiFrame.add(outputPanel);
        guiFrame.add(calculateButton);
        guiFrame.setVisible(true);
    }

    private int parseInt(String value) {
        switch (value) {
            case "0":
                return 0;
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 5;
            case "7":
                return 5;
            case "8":
                return 5;
            case "9":
                return 5;
            case "10":
                return 5;
            default:
                return -1;
        }
    }
}


