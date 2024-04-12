package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{
    private final ApiSearch api;
    private JPanel panel1;
    private JComboBox currency1;
    private JComboBox currency2;
    private JTextField value;
    private JTextField result;
    private JButton convertButton;
    private JLabel title;

    public Window(){

        setContentPane(panel1);
        setTitle("Money converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);

        title.setForeground(new Color(0,0,0));

        api = new ApiSearch();

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double v = Double.parseDouble(value.getText());
                    double ratio;
                    try {
                        ratio = api.getCurrencyRatio((String) currency1.getSelectedItem(),(String) currency2.getSelectedItem());
                    }
                    catch (Exception exception) {
                        ratio = 1;
                    }
                    result.setText(Double.toString(v*ratio));
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(Window.this,"Type a valid number");
                }
            }
        });
    }

}
