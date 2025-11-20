package edu.ntudp.Padalko.L3.controller;

import edu.ntudp.Padalko.L3.model.Faculty;
import edu.ntudp.Padalko.L3.model.Human;
import edu.ntudp.Padalko.L3.model.Department;
import edu.ntudp.Padalko.L3.model.Sex;
import java.util.List;

public class FacultyCreator extends BaseCreator<Faculty> {
    private DepartmentCreator departmentCreator;

    public FacultyCreator() {
        this.departmentCreator = new DepartmentCreator();
    }

    public Faculty createFaculty(String name, Human head, String[][] departmentsData) {
        Faculty faculty = new Faculty(name, head);

        for (String[] deptData : departmentsData) {
            String deptName = deptData[0];
            String[] groupNames = java.util.Arrays.copyOfRange(deptData, 1, deptData.length);
            Department dept = departmentCreator.createDepartment(deptName, groupNames, 3);
            faculty.addDepartment(dept);
        }

        return faculty;
    }

    public Faculty createFaculty(String name, String[][] departmentsData) {
        Human head = new Human("Dean", "Of Faculty", name, Sex.MALE);
        return createFaculty(name, head, departmentsData);
    }

    @Override
    public Faculty create() {
        Human head = new Human("Peter", "Petrov", "Petrovych", Sex.MALE);
        String[][] departments = {{"Department of CS", "CS-01", "CS-02"}};
        return createFaculty("Faculty of Information Technology", head, departments);
    }


    public String getFacultyDetailedInfo(Faculty faculty) {
        StringBuilder sb = new StringBuilder();
        sb.append("Faculty: ").append(faculty.getName())
                .append(", Head: ").append(faculty.getHead().getFullName()).append("\n");

        List<Department> departments = faculty.getDepartments();
        for (Department department : departments) {
            sb.append(departmentCreator.getDepartmentDetailedInfo(department));
        }

        return sb.toString();
    }
}