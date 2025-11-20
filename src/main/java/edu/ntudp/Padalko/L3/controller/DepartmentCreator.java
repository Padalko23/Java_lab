package edu.ntudp.Padalko.L3.controller;

import edu.ntudp.Padalko.L3.model.Department;
import edu.ntudp.Padalko.L3.model.Human;
import edu.ntudp.Padalko.L3.model.Group;
import edu.ntudp.Padalko.L3.model.Student;
import edu.ntudp.Padalko.L3.model.Sex;
import java.util.List;

public class DepartmentCreator extends BaseCreator<Department> {
    private GroupCreator groupCreator;

    public DepartmentCreator() {
        this.groupCreator = new GroupCreator();
    }

    public Department createDepartment(String name, Human head, String[] groupNames, int studentsPerGroup) {
        Department department = new Department(name, head);

        for (String groupName : groupNames) {
            Group group = groupCreator.createGroup(groupName, studentsPerGroup);
            department.addGroup(group);
        }

        return department;
    }

    public Department createDepartment(String name, String[] groupNames, int studentsPerGroup) {
        Human head = createDepartmentHead(name);
        return createDepartment(name, head, groupNames, studentsPerGroup);
    }

    private Human createDepartmentHead(String departmentName) {
        switch (departmentName) {
            case "Department of Software Engineering":
                return new Human("Mykhailo", "Software", "Ivanovych", Sex.MALE);
            case "Department of Applied Mathematics":
                return new Human("Olena", "Mathematical", "Sergiivna", Sex.FEMALE);
            case "Department of Theoretical Physics":
                return new Human("Viktor", "Theoretical", "Petrovych", Sex.MALE);
            case "Department of Experimental Physics":
                return new Human("Svitlana", "Experimental", "Mykhailivna", Sex.FEMALE);
            case "Department of Economic Theory":
                return new Human("Bohdan", "Economic", "Vasylovych", Sex.MALE);
            case "Department of Finance":
                return new Human("Tamara", "Financial", "Olegivna", Sex.FEMALE);
            default:
                String[] nameParts = departmentName.split(" ");
                String lastName = nameParts.length > 2 ? nameParts[2] : "Department";
                return new Human("Head", lastName, "of Department", Sex.MALE);
        }
    }

    @Override
    public Department create() {
        return createDepartment("Department of Software Engineering", new String[]{"SE-01"}, 3);
    }

    public String getDepartmentDetailedInfo(Department department) {
        StringBuilder sb = new StringBuilder();
        sb.append("  Department: ").append(department.getName())
                .append(", Head: ").append(department.getHead().getFullName()).append("\n");

        List<Group> groups = department.getGroups();
        for (Group group : groups) {
            sb.append("    Group: ").append(group.getName())
                    .append(", Head: ").append(group.getHead().getFullName()).append("\n");

            List<Student> students = group.getStudents();
            sb.append("      Students (").append(students.size()).append("):\n");
            for (Student student : students) {
                sb.append("        - ").append(student.getFullName())
                        .append(" (").append(student.getStudentId()).append(")\n");
            }
        }

        return sb.toString();
    }
}