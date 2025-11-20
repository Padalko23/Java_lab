package edu.ntudp.Padalko.L3.view;

import edu.ntudp.Padalko.L3.model.*;

import java.util.List;

public class UniversityPrinter {
    public static void printFullInfo(University university) {
        System.out.println("\n========================================");
        System.out.println(university.toString());
        System.out.println("========================================");

        System.out.println("Number of faculties: " + university.getFaculties().size());

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\n" + faculty);

            for (Department dept : faculty.getDepartments()) {
                System.out.println("  " + dept);

                for (Group group : dept.getGroups()) {
                    System.out.println("    " + group);
                }
            }
        }

        System.out.println("========================================\n");
    }

    public static void printAllStudentsCompact(University university) {
        System.out.println("=== ALL STUDENTS (COMPACT VIEW) ===");
        System.out.println("University: " + university.getName());
        System.out.println("====================================\n");

        List<Faculty> faculties = university.getFaculties();
        int studentCounter = 0;

        for (Faculty faculty : faculties) {
            List<Department> departments = faculty.getDepartments();
            for (Department department : departments) {
                List<Group> groups = department.getGroups();
                for (Group group : groups) {
                    List<Student> students = group.getStudents();
                    for (Student student : students) {
                        studentCounter++;
                        System.out.printf("%3d. %-30s | %-8s | %-25s | %-15s | %s%n",
                                studentCounter,
                                student.getFullName(),
                                student.getStudentId(),
                                group.getName(),
                                department.getName(),
                                faculty.getName());
                    }
                }
            }
        }

        System.out.println("====================================");
        System.out.println("TOTAL: " + studentCounter + " students");
        System.out.println("====================================\n");
    }

    public static void printStatistics(University university) {
        System.out.println("\n=== Statistics ===");

        int totalFaculties = university.getFaculties().size();
        int totalDepartments = 0;
        int totalGroups = 0;
        int totalStudents = 0;

        for (Faculty faculty : university.getFaculties()) {
            totalDepartments += faculty.getDepartments().size();

            for (Department dept : faculty.getDepartments()) {
                totalGroups += dept.getGroups().size();

                for (Group group : dept.getGroups()) {
                    totalStudents += group.getStudents().size();
                }
            }
        }

        System.out.println("Total faculties: " + totalFaculties);
        System.out.println("Total departments: " + totalDepartments);
        System.out.println("Total groups: " + totalGroups);
        System.out.println("Total students: " + totalStudents);
    }
}