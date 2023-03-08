package project.UI;

import project.listener.OpenButtonListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserInterface {

    public UserInterface() {
        JFrame jf = new JFrame();

        JButton openButton = new JButton("Open file");

        jf.add(openButton, BorderLayout.NORTH);

        Object[][] data = {};
        String[] column = {"Employee ID #1", "Employee ID #2", "Project ID", "Days worked"};
        final JTable jt = new JTable(new DefaultTableModel(data,column));

        jf.add(new JScrollPane(jt));

        jf.setSize(400, 500);
        jf.setVisible(true);

        openButton.addActionListener(new OpenButtonListener(jt));
    }
}
