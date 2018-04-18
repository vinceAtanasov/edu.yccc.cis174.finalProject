package edu.yccc.cis174.vinceAtanasov.exam;

/**
 * 
 * @author Vince
 *
 */

public class Question {
	// Creating variable question.
	private String question;

	// Getter and setter for the variable question.
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	// Constructor for question.
	public Question(String question) {
		this.question = question;
	}

	// An empty constructor.
	public Question() {

	}

	// Overriding the toString method.
	public String toString() {
		return this.question;
	}
}