package edu.yccc.cis174.vinceAtanasov.exam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EntryUI {

	private JFrame frmEntryUI;
	private JTextField userNameText;
	// Creating variable for the student's name.
	public String userName;
	// Creating variable of the user name for Slack.
	public String slackUserName = "Vince";
	private JTextField textFieldAnswer;
	// Creating an empty list, where I will collect the student's input.
	public List<String> userAnswers = new ArrayList<String>();
	// Creating JavaExam and ChemistryExam instances.
	private JavaExam jEx = new JavaExam();
	private ChemistryExam chEx = new ChemistryExam();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryUI window = new EntryUI();
					window.frmEntryUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EntryUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEntryUI = new JFrame();
		frmEntryUI.setTitle("ExamApp v.3");
		frmEntryUI.setBounds(100, 100, 919, 500);
		frmEntryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntryUI.getContentPane().setLayout(null);
		frmEntryUI.setVisible(true);
		frmEntryUI.setResizable(false);
		frmEntryUI.setLocationRelativeTo(null);

		JLabel lblExamType = new JLabel("Exam type: ");
		lblExamType.setBounds(21, 121, 112, 26);
		frmEntryUI.getContentPane().add(lblExamType);

		final JRadioButton rdbtnJava = new JRadioButton("Java");
		rdbtnJava.setBounds(144, 117, 79, 35);
		frmEntryUI.getContentPane().add(rdbtnJava);

		final JRadioButton rdbtnChemistry = new JRadioButton("Chemistry");
		rdbtnChemistry.setBounds(250, 117, 131, 35);
		frmEntryUI.getContentPane().add(rdbtnChemistry);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(21, 71, 69, 26);
		frmEntryUI.getContentPane().add(lblName);

		userNameText = new JTextField();
		userNameText.setBounds(90, 68, 186, 32);
		frmEntryUI.getContentPane().add(userNameText);
		userNameText.setColumns(10);

		JLabel lblWelcomeToExamapp = new JLabel("Welcome to ExamApp v.3");
		lblWelcomeToExamapp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblWelcomeToExamapp.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToExamapp.setBounds(0, 21, 902, 26);
		frmEntryUI.getContentPane().add(lblWelcomeToExamapp);

		JLabel lblQuestion = new JLabel("Question: ");
		lblQuestion.setBounds(21, 168, 96, 26);
		frmEntryUI.getContentPane().add(lblQuestion);

		final JLabel lblTestQuestion = new JLabel("");
		lblTestQuestion.setBounds(108, 168, 705, 26);
		frmEntryUI.getContentPane().add(lblTestQuestion);

		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setBounds(21, 327, 79, 26);
		frmEntryUI.getContentPane().add(lblAnswer);

		textFieldAnswer = new JTextField();
		textFieldAnswer.setBounds(119, 324, 461, 32);
		frmEntryUI.getContentPane().add(textFieldAnswer);
		textFieldAnswer.setColumns(10);

		final JLabel lblTestAnswers = new JLabel("");
		lblTestAnswers.setToolTipText("");
		lblTestAnswers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTestAnswers.setBounds(108, 198, 794, 65);
		frmEntryUI.getContentPane().add(lblTestAnswers);

		final JLabel lblGrade = new JLabel("");
		lblGrade.setForeground(Color.RED);
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblGrade.setBounds(696, 327, 53, 26);
		frmEntryUI.getContentPane().add(lblGrade);

		JButton btnSubmit = new JButton("Submit");
		// Method that is called when click on the Submit button.
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Getting the value that student entered in the text area for answering the
				// question.
				String userAnswer = textFieldAnswer.getText().toUpperCase();
				// Condition when the radio button for Java exam is selected.
				if (rdbtnJava.isSelected()) {
					// Adding the student's input to the list his/hers answers.
					jEx.userAnswers.add(userAnswer);
					// Clearing the text field for answer.
					textFieldAnswer.setText(null);
					// Send the focus to the field with answers.
					textFieldAnswer.requestFocusInWindow();
					// Calling the method that gets the next question.
					String thisQuestion = jEx.getNextQuestion();
					// Displaying the next question.
					lblTestQuestion.setText(thisQuestion);
					// Getting the exact possible answers for the current question and displaying
					// them.
					lblTestAnswers.setText(jEx.getNextAnswer());
					// Condition that checks if the student completed the test.
					if (thisQuestion.equals("You completed the test!")) {
						lblTestAnswers.setText(null);
						// Calculating the student's grade and displaying it.
						lblGrade.setText(String.valueOf(jEx.calculateGrade()));
					}
				}
				// Condition when the radio button for Chemistry exam is selected.
				if (rdbtnChemistry.isSelected()) {
					// Adding the student's input to the list his/hers answers.
					chEx.userAnswers.add(userAnswer);
					// Clearing the text field for answer.
					textFieldAnswer.setText(null);
					// Send the focus to the field with answers.
					textFieldAnswer.requestFocusInWindow();
					// Calling the method that gets the next question.
					String thisQuestion = chEx.getNextQuestion();
					// Displaying the next question.
					lblTestQuestion.setText(thisQuestion);
					// Getting the exact possible answers for the current question and displaying
					// them.
					lblTestAnswers.setText(chEx.getNextAnswer());
					// Condition that checks if the student completed the test.
					if (thisQuestion.equals("You completed the test!")) {
						lblTestAnswers.setText(null);
						// Calculating the student's grade and displaying it.
						lblGrade.setText(String.valueOf(chEx.calculateGrade()));
					}
				}
			}
		});
		btnSubmit.setBounds(119, 377, 141, 35);
		frmEntryUI.getContentPane().add(btnSubmit);

		JButton btnSendReport = new JButton("Send report");
		// Method that is called when click on the Send report button.
		btnSendReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Creating a SlackService instance.
				SlackService ss = new SlackService();
				// Calling the method that sends message to the teacher in Slack with the
				// student's score.
				ss.sendMessage("#slack_test", slackUserName, userName + "'s" + " grade is " + lblGrade.getText() + ".");
			}
		});
		btnSendReport.setBounds(278, 377, 164, 35);
		frmEntryUI.getContentPane().add(btnSendReport);

		final JButton btnStart = new JButton("Start");
		// Method that is called when click on the button Start.
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Getting the value of the text field for user name and assigning it to the
				// variable.
				userName = userNameText.getText();
				// Condition when the radio button for Java exam is selected.
				if (rdbtnJava.isSelected()) {
					// Calling the methods for loading the questions, possible answers and answer
					// key.
					jEx.loadQuestions();
					jEx.loadAnswers();
					jEx.loadCorrectAnswers();
					// Getting the first question from the list and displaying it.
					lblTestQuestion.setText(jEx.getNextQuestion());
					// Getting the possible answers for the current question.
					lblTestAnswers.setText(jEx.getNextAnswer());
					// Send the focus to the field with answers.
					textFieldAnswer.requestFocusInWindow();
					// Disabling the Start button when is clicked once.
					btnStart.setEnabled(false);
				}
				// Condition when the radio button for Chemistry exam is selected.
				if (rdbtnChemistry.isSelected()) {
					// Calling the methods for loading the questions, possible answers and answer
					// key.
					chEx.loadQuestions();
					chEx.loadAnswers();
					chEx.loadCorrectAnswers();
					// Getting the first question from the list and displaying it.
					lblTestQuestion.setText(chEx.getNextQuestion());
					// Getting the possible answers for the current question.
					lblTestAnswers.setText(chEx.getNextAnswer());
					// Send the focus to the field with answers.
					textFieldAnswer.requestFocusInWindow();
					// Disabling the Start button when is clicked once.
					btnStart.setEnabled(false);
				}
			}
		});
		btnStart.setBounds(751, 56, 141, 35);
		frmEntryUI.getContentPane().add(btnStart);

		JButton btnExit = new JButton("Exit");
		// Method that is called when click on the button Exit.
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Closing the window.
				frmEntryUI.dispose();
			}
		});
		btnExit.setBounds(751, 112, 141, 35);
		frmEntryUI.getContentPane().add(btnExit);

		JLabel lblGrade_1 = new JLabel("Grade:");
		lblGrade_1.setBounds(628, 327, 69, 26);
		frmEntryUI.getContentPane().add(lblGrade_1);

	}
}
