package project.reader;

import project.model.Employee;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    public static void readEmployees(ArrayList<Employee> employees, File file) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .toFormatter();

        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNext())
            {
                String[] line = sc.nextLine().split(",");
                Employee employee = new Employee();
                String employeeId = line[0].trim();
                String projectId = line[1].trim();
                String dateFrom = line[2].trim();
                String dateTo = line[3].trim();

                employee.setEmployeeId(Long.parseLong(employeeId));
                employee.setProjectId(Long.parseLong(projectId));
                employee.setDateFrom(LocalDate.parse(dateFrom,formatter));
                if(dateTo.equals("NULL")){
                    employee.setDateTo(LocalDate.now());
                }
                else{
                    employee.setDateTo(LocalDate.parse(dateTo,formatter));
                }

                employees.add(employee);
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
