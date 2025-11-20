package edu.ntudp.Padalko.L3.controller;

import edu.ntudp.Padalko.L3.model.*;

import java.util.List;

public class UniversityCreator extends BaseCreator<University> {
    private FacultyCreator facultyCreator;

    public UniversityCreator() {
        this.facultyCreator = new FacultyCreator();
    }

    public University createTypicalUniversity() {
        Human rector = new Human("Volodymyr", "Rektorenko", "Rektorovych", Sex.MALE);

        University university = new University(
                "Oles Honchar Dnipro National University",
                rector
        );

        Human deanMath = new Human("Alexander", "Mathematician", "Alexandrovych", Sex.MALE);
        String[][] mathDepartments = {
                {"Department of Software Engineering", "SE-21", "SE-22", "SE-23"},
                {"Department of Applied Mathematics", "AM-21", "AM-22"}
        };
        Faculty mathFaculty = facultyCreator.createFaculty(
                "Faculty of Applied Mathematics",
                deanMath,
                mathDepartments
        );
        university.addFaculty(mathFaculty);

        Human deanPhys = new Human("Natalia", "Physicist", "Vasylivna", Sex.FEMALE);
        String[][] physDepartments = {
                {"Department of Theoretical Physics", "TP-21", "TP-22"},
                {"Department of Experimental Physics", "EP-21"}
        };
        Faculty physFaculty = facultyCreator.createFaculty(
                "Faculty of Physics",
                deanPhys,
                physDepartments
        );
        university.addFaculty(physFaculty);

        Human deanEcon = new Human("Iryna", "Ekonomova", "Mykhailivna", Sex.FEMALE);
        String[][] econDepartments = {
                {"Department of Economic Theory", "EC-21", "EC-22"},
                {"Department of Finance", "FIN-21"}
        };
        Faculty econFaculty = facultyCreator.createFaculty(
                "Faculty of Economics",
                deanEcon,
                econDepartments
        );
        university.addFaculty(econFaculty);

        return university;
    }

    @Override
    public University create() {
        return createTypicalUniversity();
    }

    public String getUniversityDetailedInfo(University university) {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("University: ").append(university.getName())
                .append(", Head: ").append(university.getHead().getFullName()).append("\n");
        sb.append("========================================\n");
        sb.append("Number of faculties: ").append(university.getFaculties().size()).append("\n\n");

        List<Faculty> faculties = university.getFaculties();
        for (Faculty faculty : faculties) {
            sb.append(facultyCreator.getFacultyDetailedInfo(faculty)).append("\n");
        }

        return sb.toString();
    }
}