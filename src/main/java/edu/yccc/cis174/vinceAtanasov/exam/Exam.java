package edu.yccc.cis174.vinceAtanasov.exam;
/**
 * Vince
 * This project is to create a program that gives exams to the user by using interface.
 */

import java.util.List;

public interface Exam {
	
	public String getUserName();

	public List<Question> loadQuestions();

	public List<Answer> loadAnswers();

	public List<String> loadCorrectAnswers();

	public void describe();

	public float calculateGrade();

	public List<String> exam();

	public void writeExamResult(String userName, float grade);
}