package edu.yccc.cis174.vinceAtanasov.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChemistryExam implements Exam {

	// Creating empty lists for the questions, possible answers and the answer key,
	// which will host the data from the text files.
	public List<Question> questions = new ArrayList<Question>();
	public List<Answer> possibleAnswers = new ArrayList<Answer>();
	public List<String> correctAnswers = new ArrayList<String>();
	// Creating an empty list for the student's input.
	public List<String> userAnswers = new ArrayList<String>();
	// Creating variables for nextQuestion and nextAnswer.
	public String nextQuestion;
	public String nextAnswer;
	// Creating counter variables for getNextQuestion and getNextAnswer.
	public int counter = 0;
	public int counterAns = 0;

	// Method that reads the file with the questions and returns list with them.
	public List<Question> loadQuestions() {
		Scanner scanner = null;
		try {
			// Creating scanner that reads the questions.txt file.
			scanner = new Scanner(new File("chemistryQuestions.txt"));
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

	// Method that reads the file with the possible answers and returns list with
	// them.
	public List<Answer> loadAnswers() {
		Scanner scanner = null;
		try {
			// Creating scanner that reads the questions.txt file.
			scanner = new Scanner(new File("chemistryAnswers.txt"));
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

	// Method that reads the file with the correct answers and returns list with
	// them.
	public List<String> loadCorrectAnswers() {
		Scanner scanner = null;
		try {
			// Creating scanner that reads the questions.txt file.
			scanner = new Scanner(new File("chemistryCorrectAnswers.txt"));
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

	// Method that calculates the student's score.
	public float calculateGrade() {
		// Creating variables for correct answers, total questions and the grade itself.
		int correct = 0;
		int total = correctAnswers.size();
		float grade = 0;
		// Loop that goes around the list with user's answers and correct answers.
		for (int i = 0; i < correctAnswers.size(); i++) {
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

	// Method that gets the next question from the list with questions.
	public String getNextQuestion() {
		// Condition for getting the exact question, starting from the first question in
		// the list. This will happen until the method reaches the end of the list with
		// questions.
		if (counter < questions.size()) {
			nextQuestion = questions.get(counter).getQuestion();
			// Incrementing the counter with one, so next time the method is called it will
			// get the following question from the list.
			counter++;
		}
		// When the end of the list is reached the next question will take this value.
		else {
			nextQuestion = "You completed the test!";
		}
		return nextQuestion;

	}

	// Method that gets the next possible answers for the question from the list
	// with possible answers.
	public String getNextAnswer() {
		// Condition for getting the exact possible answers for the current question.
		if (counterAns < possibleAnswers.size()) {
			nextAnswer = possibleAnswers.get(counterAns).getPossibleAnswer();
			// Incrementing the counter with one, so next time the method is called it will
			// get the exact answers for the following question.
			counterAns++;
		}
		return nextAnswer;
	}

}
