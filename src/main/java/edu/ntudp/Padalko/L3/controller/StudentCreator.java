package edu.ntudp.Padalko.L3.controller;

import edu.ntudp.Padalko.L3.model.Student;
import edu.ntudp.Padalko.L3.model.Sex;
import java.util.ArrayList;
import java.util.List;

public class StudentCreator extends BaseCreator<Student> {
    private static int studentCounter = 1;

    public Student createStudent(String firstName, String lastName, String patronymic, Sex sex) {
        String studentId = generateId("STD", studentCounter++);
        return new Student(firstName, lastName, patronymic, sex, studentId);
    }

    @Override
    public Student create() {
        return createStudent("John", "Doe", "Smith", Sex.MALE);
    }

    public List<Student> createMultipleStudents(int count, String groupName) {
        List<Student> students = new ArrayList<>();


        String[][][] allNames = {
                {
                        {"Oleksandr", "Petrenko", "Volodymyrovych", "MALE"},
                        {"Maria", "Kovalenko", "Petrivna", "FEMALE"},
                        {"Andriy", "Sydorenko", "Olexandrovych", "MALE"}
                },
                {
                        {"Elena", "Shevchenko", "Ivanivna", "FEMALE"},
                        {"Dmytro", "Melnyk", "Serhiyovych", "MALE"},
                        {"Anastasia", "Bondarenko", "Volodymyrivna", "FEMALE"}
                },
                {
                        {"Maxim", "Tkachenko", "Andriyovych", "MALE"},
                        {"Victoria", "Kravchenko", "Olexandrivna", "FEMALE"},
                        {"Ivan", "Polishchuk", "Igorovych", "MALE"}
                },
                {
                        {"Olga", "Savchenko", "Viktorivna", "FEMALE"},
                        {"Serhiy", "Koval", "Mykolayovych", "MALE"},
                        {"Kateryna", "Oliynyk", "Sergiivna", "FEMALE"}
                },
                {
                        {"Pavlo", "Zayets", "Vasylovych", "MALE"},
                        {"Natalia", "Lysenko", "Olegivna", "FEMALE"},
                        {"Yuriy", "Bilyk", "Petrovych", "MALE"}
                },
                {
                        {"Tetiana", "Marchuk", "Anatoliivna", "FEMALE"},
                        {"Vitaliy", "Shyshko", "Viktorovych", "MALE"},
                        {"Sofia", "Ponomarenko", "Yuriivna", "FEMALE"}
                },
                {
                        {"Artem", "Kravets", "Olegovych", "MALE"},
                        {"Alina", "Symonenko", "Valeriivna", "FEMALE"},
                        {"Roman", "Hrytsenko", "Sergiyovych", "MALE"}
                },
                {
                        {"Yana", "Moroz", "Vasylivna", "FEMALE"},
                        {"Bohdan", "Savchuk", "Ihorovych", "MALE"},
                        {"Diana", "Kuzmenko", "Oleksandrivna", "FEMALE"}
                },
                {
                        {"Mykola", "Yurchenko", "Petrovych", "MALE"},
                        {"Valentyna", "Tkachuk", "Mykolaivna", "FEMALE"},
                        {"Oleg", "Fedorenko", "Vasylovych", "MALE"}
                },
                {
                        {"Liliya", "Shevchuk", "Andriivna", "FEMALE"},
                        {"Viktor", "Kuznetsov", "Yuriyovych", "MALE"},
                        {"Iryna", "Pavlenko", "Dmytrivna", "FEMALE"}
                },
                {
                        {"Stanislav", "Boyko", "Sergiyovych", "MALE"},
                        {"Oksana", "Kovalchuk", "Volodymyrivna", "FEMALE"},
                        {"Maksym", "Taran", "Ivanovych", "MALE"}
                }
        };

        int groupIndex = createUniqueGroupIndex(groupName, allNames.length);
        String[][] selectedNames = allNames[groupIndex];

        for (int i = 0; i < count && i < selectedNames.length; i++) {
            String[] nameData = selectedNames[i];
            Sex sex = nameData[3].equals("MALE") ? Sex.MALE : Sex.FEMALE;
            students.add(createStudent(nameData[0], nameData[1], nameData[2], sex));
        }
        return students;
    }

    private int createUniqueGroupIndex(String groupName, int maxIndex) {

        int hash = groupName.hashCode();

        hash = hash * 31 + groupName.length();
        hash = hash ^ (hash >>> 15);

        return Math.abs(hash) % maxIndex;
    }
}
