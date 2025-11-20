package edu.ntudp.Padalko.L3;
import edu.ntudp.Padalko.L3.controller.UniversityCreator;
import edu.ntudp.Padalko.L3.model.University;
import edu.ntudp.Padalko.L3.view.UniversityPrinter;


public class Run {
    public static void main(String[] args) {

        System.out.println("=== University Management System ===\n");

        UniversityCreator creator = new UniversityCreator();
        University university = creator.createTypicalUniversity();

        UniversityPrinter.printFullInfo(university);
        UniversityPrinter.printStatistics(university);
        UniversityPrinter. printAllStudentsCompact(university);
    }
}
