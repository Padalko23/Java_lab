package edu.ntudp.Padalko.L3.view;
import edu.ntudp.Padalko.L3.model.Department;
import edu.ntudp.Padalko.L3.model.Group;

public class DepartmentPrinter {
    public static void print(Department department) {
        System.out.println(department.toString());
        System.out.println("Number of groups: " + department.getGroups().size());
        for (Group group : department.getGroups()) {
            System.out.println("  - " + group.getName());
        }
    }
}