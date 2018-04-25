package edu.yccc.cis174.vinceAtanasov.exam;
/**
 * Vince
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamService {
	// Creating empty list for the exams.
	List<Exam> exams = new ArrayList<Exam>();
	// Variable for the user's choice
	public String userChoice;
	// Scanner for
	public Scanner console = new Scanner(System.in);

	// Method that adds the exams to the list of exams.
	public void loadExams() {
		exams.add(new JavaExam());
		exams.add(new ChemistryExam());
	}

	// Method that gives the user to choose the exam and returning the value of the
	// choice.
	public String selectExam() {
		int count = 1;
		System.out.println("Welcome!\n");
		System.out.println("Please, select an exam!");
		for (Exam ex : exams) {
			System.out.print(count++ + ": ");
			ex.describe();
		}
		userChoice = console.next();
		return userChoice;
	}

	// Method that calls all the methods from the interface. This is where we are
	// performing the selected exam from the user.
	public void runExam() {
		Exam exam = exams.get(Integer.valueOf(userChoice).intValue() - 1);
		exam.loadQuestions();
		exam.loadAnswers();
		exam.loadCorrectAnswers();
		exam.exam();
		exam.calculateGrade();
		exam.writeExamResult(exam.getUserName(), exam.calculateGrade());
	}

	// The main method.
	public static void main(String[] args) {
		// Creating an instance of ExamService.
		ExamService exS = new ExamService();
		// 1. Load exams;
		exS.loadExams();
		// 2. Offer to the user all of the available exams.
		exS.selectExam();
		// 3. Give exam, Ask questions, collect responses, calculate grade and write the
		// result to a file.
		exS.runExam();
	}
}