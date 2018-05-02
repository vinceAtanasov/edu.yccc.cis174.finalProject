package edu.yccc.cis174.vinceAtanasov.exam;
/**
 * This is my final project which is upgraded version of the Exam application. The five acceptance criteria are:
 * 1. Taking input through UI;
 * 2. Reading files;
 * 3. Integration with slack;
 * 4. Using interface;
 * 5. Writing to a file.
 * 
 * @author Vince
 * 
 */

import java.util.List;

public interface Exam {

	public List<Question> loadQuestions();

	public List<Answer> loadAnswers();

	public List<String> loadCorrectAnswers();

	public float calculateGrade();

	public String getNextQuestion();

	public String getNextAnswer();

	public void writeExamResult(String userName, float grade);
}