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
import java.awt.event.ActionEvent;

public class EntryUI {

	private JFrame frmEntryUI;
	private JTextField userNameText;
	public static String userName;

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
		frmEntryUI.setBounds(100, 100, 800, 418);
		frmEntryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntryUI.getContentPane().setLayout(null);
		frmEntryUI.setVisible(true);
		frmEntryUI.setResizable(false);
		frmEntryUI.setLocationRelativeTo(null);

		JLabel lblExamType = new JLabel("Exam type: ");
		lblExamType.setBounds(21, 142, 112, 26);
		frmEntryUI.getContentPane().add(lblExamType);

		final JRadioButton rdbtnJava = new JRadioButton("Java");
		rdbtnJava.setBounds(144, 138, 79, 35);
		frmEntryUI.getContentPane().add(rdbtnJava);

		JRadioButton rdbtnChemistry = new JRadioButton("Chemistry");
		rdbtnChemistry.setBounds(250, 138, 131, 35);
		frmEntryUI.getContentPane().add(rdbtnChemistry);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(21, 95, 69, 26);
		frmEntryUI.getContentPane().add(lblName);

		userNameText = new JTextField();
		userNameText.setBounds(90, 92, 186, 32);
		frmEntryUI.getContentPane().add(userNameText);
		userNameText.setColumns(10);

		JLabel lblWelcomeToExamapp = new JLabel("Welcome to ExamApp v.3");
		lblWelcomeToExamapp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblWelcomeToExamapp.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToExamapp.setBounds(0, 21, 774, 26);
		frmEntryUI.getContentPane().add(lblWelcomeToExamapp);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userName = userNameText.getText();
				if (rdbtnJava.isSelected()) {
					JFrame frame = new JFrame();
					frame.setVisible(true);
					
				}
			}
		});
		btnStart.setBounds(126, 264, 141, 35);
		frmEntryUI.getContentPane().add(btnStart);

		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEntryUI.dispose();
			}
		});
		btnNewButton.setBounds(418, 264, 141, 35);
		frmEntryUI.getContentPane().add(btnNewButton);
	}
}
