package edu.yccc.cis174.vinceAtanasov.exam;

/**
 * 
 * @author Vince
 *
 */

public class Answer {
	// Creating variable for possibleAnswer.
	private String possibleAnswer;

	// Getter and setter for the variable possibleAnswer.
	public String getPossibleAnswer() {
		return possibleAnswer;
	}

	public void setPossibleAnswer(String possibleAnswer) {
		this.possibleAnswer = possibleAnswer;
	}

	// An empty constructor for answer.
	public Answer() {

	}

	// Constructor for Answer.
	public Answer(String possibleAnswer) {
		this.possibleAnswer = possibleAnswer;
	}

	// Overriding the toString method.
	public String toString() {
		return this.possibleAnswer;
	}
}