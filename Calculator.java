import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    Button b1, b2, b3, b4, b5;
    TextField tf1, tf2, tf3;
    Label l1, l2, l3;
    Panel p1, p2, p3, p4;

    public Calculator() {
        // Create buttons
        b1 = new Button("+");
        b2 = new Button("-");
        b3 = new Button("*");
        b4 = new Button("/");
        b5 = new Button("Clear");

        // Create text fields
        tf1 = new TextField(20);
        tf2 = new TextField(20);
        tf3 = new TextField(20);
        tf3.setEditable(false); // Result field should not be editable

        // Create labels
        l1 = new Label("Enter the first number: ");
        l2 = new Label("Enter the second number: ");
        l3 = new Label("Result:");

        // Create panels
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();

        // Add components to panels
        p1.add(l1);
        p1.add(tf1);

        p2.add(l2);
        p2.add(tf2);

        p3.add(l3);
        p3.add(tf3);

        p4.add(b1);
        p4.add(b2);
        p4.add(b3);
        p4.add(b4);
        p4.add(b5);

        // Set layout for the main frame
        setLayout(new GridLayout(4, 1)); // 4 rows, 1 column
        add(p1);
        add(p2);
        add(p3);
        add(p4);

        // Set frame properties
        setFont(new Font("Arial", Font.PLAIN, 20));
        setBackground(Color.cyan);
        setForeground(Color.blue);
        setSize(400, 500);
        setTitle("Calculator");
        setVisible(true);

        // Add action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        // Add window listener for closing the frame
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        String buttonName = ae.getActionCommand();
        String s1 = tf1.getText();
        String s2 = tf2.getText();

        float n1 = 0, n2 = 0, n3 = 0;
        boolean validInput = true;

        try {
            n1 = Float.parseFloat(s1);
            n2 = Float.parseFloat(s2);
        } catch (NumberFormatException e) {
            tf3.setText("Input should be a number");
            validInput = false;
        }

        if (validInput) {
            if (buttonName.equals("+")) {
                n3 = n1 + n2;
            } else if (buttonName.equals("-")) {
                n3 = n1 - n2;
            } else if (buttonName.equals("*")) {
                n3 = n1 * n2;
            } else if (buttonName.equals("/")) {
                if (n2 == 0) {
                    tf3.setText("Denominator should be non-zero");
                    return;
                }
                n3 = n1 / n2;
            }

            tf3.setText("" + n3);
        }
    }

    public static void main(String args[]) {
        new Calculator();
    }
}