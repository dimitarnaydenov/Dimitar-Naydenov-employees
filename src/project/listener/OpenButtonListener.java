package project.listener;

import project.helper.Helper;
import project.model.Employee;
import project.model.Pair;
import project.reader.Reader;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class OpenButtonListener implements ActionListener {

    private JTable jTable;

    public OpenButtonListener(JTable jTable) {
        this.jTable = jTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Pair> pairs = new ArrayList<>();

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0); // delete all rows if file is already loaded

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();

            Reader.readEmployees(employees, file);
            Helper.findEmployeesWorkedTogether(employees, pairs);

            if(pairs.size() > 0){
                pairs.sort((p1,p2) -> (int) (p2.getLength() - p1.getLength()));
                Pair pair = pairs.get(0);

                pairs.stream().filter(p -> isEmployeesPair(pair, p))
                        .forEach( p -> model.addRow(new Object[]{p.getFirstEmployee().getEmployeeId(), p.getSecondEmployee().getEmployeeId(), p.getProjectId(),p.getLength()}));
            }

        }
    }

    private boolean isEmployeesPair(Pair pair, Pair p) {
        // checks all possible options
        return (p.getFirstEmployee().getEmployeeId().equals(pair.getFirstEmployee().getEmployeeId())
                && p.getSecondEmployee().getEmployeeId().equals(pair.getSecondEmployee().getEmployeeId())) ||
                (p.getFirstEmployee().getEmployeeId().equals(pair.getSecondEmployee().getEmployeeId())
                        && p.getSecondEmployee().getEmployeeId().equals(pair.getFirstEmployee().getEmployeeId()));
    }
}
