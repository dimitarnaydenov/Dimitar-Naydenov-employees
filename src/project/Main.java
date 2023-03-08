package project;

import project.UI.UserInterface;
import project.helper.Helper;
import project.model.Employee;
import project.model.Pair;
import project.reader.Reader;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Pair> pairs = new ArrayList<>();

        File file = new File("input.csv");

        Reader.readEmployees(employees, file);
        Helper.findEmployeesWorkedTogether(employees, pairs);

        pairs.sort((p1,p2) -> p2.getLength() - p1.getLength()); // Sort pairs descending by length

        if(pairs.size() > 0){
            Pair pair = pairs.get(0);

            System.out.println(pair.getFirstEmployee().getEmployeeId() + ", " + pair.getSecondEmployee().getEmployeeId() + ", " + pair.getLength());
        }

        //UI
        new UserInterface();
    }

}
