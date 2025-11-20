package edu.ntudp.Padalko.L3.controller;

import edu.ntudp.Padalko.L3.model.Group;
import edu.ntudp.Padalko.L3.model.Human;
import edu.ntudp.Padalko.L3.model.Student;
import edu.ntudp.Padalko.L3.model.Sex;
import java.util.List;

public class GroupCreator extends BaseCreator<Group> {
    private StudentCreator studentCreator;
    private int groupCounter = 0;

    public GroupCreator() {
        this.studentCreator = new StudentCreator();
    }

    public Group createGroup(String name, Human head, int studentCount) {
        Group group = new Group(name, head);
        List<Student> students = studentCreator.createMultipleStudents(studentCount, name + "_" + groupCounter++);
        for (Student student : students) {
            group.addStudent(student);
        }
        return group;
    }

    public Group createGroup(String name, int studentCount) {

        String uniqueGroupId = name + "_" + groupCounter;
        List<Student> students = studentCreator.createMultipleStudents(studentCount, uniqueGroupId);
        groupCounter++;


        Human head;
        if (!students.isEmpty()) {
            Student groupLeader = students.get(0);
            head = new Human(groupLeader.getFirstName(), groupLeader.getLastName(),
                    groupLeader.getPatronymic(), groupLeader.getSex());
        } else {
            head = new Human("Group", "Leader", name, Sex.MALE);
        }


        Group group = new Group(name, head);
        for (Student student : students) {
            group.addStudent(student);
        }
        return group;
    }

    @Override
    public Group create() {
        return createGroup("CS-01", 3);
    }
}