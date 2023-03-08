package project.helper;

import project.model.Employee;
import project.model.Pair;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Helper {

    public static void findEmployeesWorkedTogether(ArrayList<Employee> employees, ArrayList<Pair> pairs) {
        for (int i = 0; i < employees.size()-1; i++) {
            for (int j = i+1; j < employees.size(); j++) {
                Employee employee1 = employees.get(i);
                Employee employee2 = employees.get(j);

                if(employee1.getProjectId() == employee2.getProjectId() && workedInTheSameTime(employee1, employee2)){

                    LocalDate start;
                    LocalDate end;

                    //finds which of the two employees started work earlier
                    if(employee1.getDateFrom().isBefore(employee2.getDateFrom())) start = employee2.getDateFrom();
                    else start = employee1.getDateFrom();

                    //finds which of the two employees stopped work earlier
                    if(employee1.getDateTo().isBefore(employee2.getDateTo())) end = employee1.getDateTo();
                    else end = employee2.getDateTo();

                    int length = (int) ChronoUnit.DAYS.between(start, end);

                    Pair pair = new Pair(employee1,employee2, employee1.getProjectId(),length);
                    pairs.add(pair);
                }
            }
        }
    }

    private static boolean workedInTheSameTime(Employee employee1, Employee employee2) {
        return !employee1.getDateFrom().isAfter(employee2.getDateTo()) && !employee1.getDateTo().isBefore(employee2.getDateFrom());
    }
}
