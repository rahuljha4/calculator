import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 6/23/2015.
 */
public class Cal extends JFrame implements ActionListener {
    private double firstnumber;
    private String operand;
    private boolean isinnumberenteringmode = false;


    private JButton ButtonOne;
    private JPanel panel;
    private JButton ButtonTwo;
    private JButton ButtonThree;
    private JButton ButtonAdd;
    private JButton ButtonSub;
    private JButton ButtonSix;
    private JButton ButtonFive;
    private JButton ButtonFour;
    private JButton ButtonEight;
    private JButton ButtonSeven;
    private JButton ButtonNine;
    private JButton ButtonMultiply;
    private JButton ButtonEquals;
    private JButton ButtonZero;
    private JButton ButtonDivide;
    private JTextField ResultField;

    public Cal() {

        super();
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.ButtonOne.addActionListener(this);
        this.ButtonTwo.addActionListener(this);
        this.ButtonThree.addActionListener(this);
        this.ButtonThree.addActionListener(this);
        this.ButtonFour.addActionListener(this);
        this.ButtonFive.addActionListener(this);
        this.ButtonSix.addActionListener(this);
        this.ButtonSeven.addActionListener(this);
        this.ButtonEight.addActionListener(this);
        this.ButtonNine.addActionListener(this);
        this.ButtonZero.addActionListener(this);
        this.ButtonEquals.addActionListener(this);
        this.ButtonAdd.addActionListener(this);
        this.ButtonSub.addActionListener(this);
        this.ButtonMultiply.addActionListener(this);
        this.ButtonDivide.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        e.getSource();
        JButton buttonpressed = (JButton)e.getSource();
        if (e.getSource() == this.ButtonOne ||
                buttonpressed == this.ButtonTwo ||
                buttonpressed == this.ButtonThree ||
                buttonpressed == this.ButtonFour ||
                buttonpressed == this.ButtonFive ||
                buttonpressed == this.ButtonSix ||
                buttonpressed == this.ButtonSeven ||
                buttonpressed == this.ButtonEight ||
                buttonpressed == this.ButtonNine)
        {

            this.digitpressed(buttonpressed.getText());
        } else if(buttonpressed == this.ButtonEquals){
            this.calculate();
        } else {
            this.operationpressed(buttonpressed.getText());
        }
    }

    private void digitpressed(String digit) {

        if (this.isinnumberenteringmode) {
            this.ResultField.setText(this.ResultField.getText() + digit);
        } else {
            this.ResultField.setText(digit);
            this.isinnumberenteringmode = true;
        }

    }

    private void operationpressed(String operand) {
        this.firstnumber = Double.parseDouble(this.ResultField.getText());
        this.operand = operand;

        this.isinnumberenteringmode = false;

    }

    private void calculate() {
        if (this.operand.length() > 0) {
            double secondnumber = Double.parseDouble(this.ResultField.getText());
            double result;
            if (this.operand.equals("+")) {
                result = this.firstnumber + secondnumber;
            } else if (this.operand.equals("-")) {
                result = this.firstnumber - secondnumber;
            } else if (this.operand.equals("*")) {
                result = this.firstnumber * secondnumber;
            } else if (this.operand.equals("/")) {
                result = this.firstnumber / secondnumber;
            } else {
                result = 0;
            }
            this.ResultField.setText(Double.toString(result));

            this.isinnumberenteringmode = false;
            this.operand = "";
        }
    }
}

