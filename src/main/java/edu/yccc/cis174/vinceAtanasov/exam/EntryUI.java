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

public class EntryUI {

	private JFrame frmEntryUI;
	private JTextField userNameText;
	public String userName;
	public String slackUserName = "Vince"; 
	private JTextField textFieldAnswer;
	// Creating an empty list, where I will collect the student's input.
	public List<String> userAnswers = new ArrayList<String>();
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
		lblTestQuestion.setBounds(120, 168, 693, 26);
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
		lblTestAnswers.setBounds(21, 198, 881, 65);
		frmEntryUI.getContentPane().add(lblTestAnswers);

		final JLabel lblGrade = new JLabel("");
		lblGrade.setBounds(680, 327, 212, 26);
		frmEntryUI.getContentPane().add(lblGrade);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userAnswer = textFieldAnswer.getText().toUpperCase();
				if (rdbtnJava.isSelected()) {
					jEx.userAnswers.add(userAnswer);
					textFieldAnswer.setText(null);
					String thisQuestion = jEx.getNextQuestion();
					lblTestQuestion.setText(thisQuestion);
					lblTestAnswers.setText(jEx.getNextAnswer());
					if(thisQuestion.equals("You complete the test!")) {
						lblTestAnswers.setText(null);
						lblGrade.setText(userName + ", your grade is " + String.valueOf(jEx.calculateGrade()));
					}

				}
				if (rdbtnChemistry.isSelected()) {
					chEx.userAnswers.add(userAnswer);
					textFieldAnswer.setText(null);
					String thisQuestion = chEx.getNextQuestion();
					lblTestQuestion.setText(thisQuestion);
					lblTestAnswers.setText(chEx.getNextAnswer());
					if(thisQuestion.equals("You complete the test!")) {
						lblTestAnswers.setText(null);
						lblGrade.setText(userName + ", your grade is " + String.valueOf(chEx.calculateGrade()));
					}
				}
			}
		});
		btnSubmit.setBounds(119, 377, 141, 35);
		frmEntryUI.getContentPane().add(btnSubmit);

		JButton btnSendReport = new JButton("Send report");
		btnSendReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SlackService ss = new SlackService();
				ss.sendMessage("#slack_test", slackUserName, lblGrade.getText());
			}
		});
		btnSendReport.setBounds(278, 377, 164, 35);
		frmEntryUI.getContentPane().add(btnSendReport);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userName = userNameText.getText();
				if (rdbtnJava.isSelected()) {
					jEx.loadQuestions();
					jEx.loadAnswers();
					jEx.loadCorrectAnswers();
					lblTestQuestion.setText(jEx.getNextQuestion());
					lblTestAnswers.setText(jEx.getNextAnswer());
				}
				if (rdbtnChemistry.isSelected()) {
					chEx.loadQuestions();
					chEx.loadAnswers();
					chEx.loadCorrectAnswers();
					lblTestQuestion.setText(chEx.getNextQuestion());
					lblTestAnswers.setText(chEx.getNextAnswer());
				}
			}
		});
		btnStart.setBounds(751, 56, 141, 35);
		frmEntryUI.getContentPane().add(btnStart);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEntryUI.dispose();
			}
		});
		btnExit.setBounds(751, 112, 141, 35);
		frmEntryUI.getContentPane().add(btnExit);

	}
}
