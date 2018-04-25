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
	public List<String> userAnswers = new ArrayList<String>();
	public String nextQuestion;
	public String nextAnswer;
	public int counter = 0;
	public int counterAns = 0;

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
		// Creating variables for correct answers, total questions and the grade itself.
		int correct = 0;
		int total = 10;
		float grade = 0;
		// Loop that goes around the list with user's answers and correct answers.
		for (int i = 0; i < 10; i++) {
			// Creating variable result which compare the elements from the two list index
			// by index.
			int result = (userAnswers.get(i).compareTo(correctAnswers.get(i)));
			// Condition that increments the variable correct with one every time when there
			// is match between the lists' elements by index.
			if (result == 0) {
				correct++;
			}
		}
		// Calculating the grade of the student.
		grade = (float) ((double) correct / total * 100);
		return grade;
	}

	public void writeExamResult(String userName, float grade) {
		// TODO Auto-generated method stub

	}

	public String getNextQuestion() {
		if (counter < questions.size()) {
			nextQuestion = questions.get(counter).getQuestion();
			counter++;
		} else {
			nextQuestion = "You complete the test!";
		}
		return nextQuestion;

	}

	public String getNextAnswer() {
		if (counterAns < possibleAnswers.size()) {
			nextAnswer = possibleAnswers.get(counterAns).getPossibleAnswer();
			counterAns++;
		}
		return nextAnswer;
	}

}
