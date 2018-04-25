package edu.yccc.cis174.vinceAtanasov.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaExam implements Exam {
	// Creating empty lists for the questions, possible answers and the answer key,
	// which will host the data from the text files.
	public List<Question> questions = new ArrayList<Question>();
	public List<Answer> possibleAnswers = new ArrayList<Answer>();
	public List<String> correctAnswers = new ArrayList<String>();
	// Creating an empty list, where I will collect the student's input.
	public List<String> userAnswers = new ArrayList<String>();
	// Variable for user's name.
	public String userName;

	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> loadQuestions() {
		Scanner scanner = null;
		try {
			// Creating scanner that reads the questions.txt file.
			scanner = new Scanner(new File("javaQuestions.txt"));
			// Loop that goes over the file and adding each line as a string element to the
			// list. The result is full list with the questions.
			while (scanner.hasNextLine()) {
				Question q = new Question();
				q.setQuestion(scanner.nextLine());
				questions.add(q);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Closing the scanner.
		finally {
			scanner.close();
		}
		return questions;
	}

	public List<Answer> loadAnswers() {
		Scanner scanner = null;
		try {
			// Creating scanner that reads the questions.txt file.
			scanner = new Scanner(new File("javaAnswers.txt"));
			// Loop that goes over the file and adding each line as a string element to the
			// list. The result is full list with the questions.
			while (scanner.hasNextLine()) {
				Answer a = new Answer();
				a.setPossibleAnswer(scanner.nextLine());
				possibleAnswers.add(a);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Closing the scanner.
		finally {
			scanner.close();
		}
		return possibleAnswers;
	}

	public List<String> loadCorrectAnswers() {
		Scanner scanner = null;
		try {
			// Creating scanner that reads the questions.txt file.
			scanner = new Scanner(new File("javaCorrectAnswers.txt"));
			// Loop that goes over the file and adding each line as a string element to the
			// list. The result is full list with the questions.
			while (scanner.hasNextLine()) {

				correctAnswers.add(scanner.nextLine());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Closing the scanner.
		finally {
			scanner.close();
		}
		return correctAnswers;
	}


	public float calculateGrade() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<String> exam() {
		// TODO Auto-generated method stub
		return null;
	}

	public void writeExamResult(String userName, float grade) {
		// TODO Auto-generated method stub

	}

}
