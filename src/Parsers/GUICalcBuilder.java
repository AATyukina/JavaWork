package Parsers;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Currency;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.event.CaretEvent;

public class GUICalcBuilder {

	private JFrame frmCalculatorbuilder;
	private JTextField curNum;
	private boolean trigger = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICalcBuilder window = new GUICalcBuilder();
					window.frmCalculatorbuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUICalcBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculatorbuilder = new JFrame();
		frmCalculatorbuilder.setTitle("CalculatorBuilder");
		frmCalculatorbuilder.setBounds(100, 100, 255, 281);
		frmCalculatorbuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculatorbuilder.getContentPane().setLayout(null);

		JTextField arExpr = new JTextField();
		arExpr.setEnabled(false);
		arExpr.setBounds(10, 11, 215, 18);
		arExpr.setFont(new Font("Monospaced", Font.BOLD, 14));
		arExpr.setBorder(null);
		arExpr.setHorizontalAlignment(JTextField.RIGHT);
		frmCalculatorbuilder.getContentPane().add(arExpr);

		JButton bseven = new JButton("7");
		bseven.setMargin(new Insets(1, 1, 1, 1));
		bseven.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.equals("0")) {
					curNum.setText("7");
				}
				else if (trigger) {
					exp = "";
					exp = exp.concat("7");
					curNum.setText(exp);
					trigger = false;
				}
				else {	
					exp = exp.concat("7");
					curNum.setText(exp);
				}

			}
		});
		bseven.setBounds(10, 54, 35, 35);
		frmCalculatorbuilder.getContentPane().add(bseven);

		JButton beight = new JButton("8");
		beight.setMargin(new Insets(1, 1, 1, 1));
		beight.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.equals("0")) {
					curNum.setText("8");
				}
				else if (trigger) {
					exp = "";
					exp = exp.concat("8");
					curNum.setText(exp);
					trigger = false;
				}
				else {	
					exp = exp.concat("8");
					curNum.setText(exp);
				}
			}
		});
		beight.setBounds(55, 54, 35, 35);
		frmCalculatorbuilder.getContentPane().add(beight);

		JButton bnine = new JButton("9");
		bnine.setMargin(new Insets(1, 1, 1, 1));
		bnine.setBounds(100, 54, 35, 35);
		bnine.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.equals("0")) {
					curNum.setText("9");
				}
				else if (trigger) {
					exp = "";
					exp = exp.concat("9");
					curNum.setText(exp);
					trigger = false;
				}
				else {	
					exp = exp.concat("9");
					curNum.setText(exp);
				}
			}
		});
		frmCalculatorbuilder.getContentPane().add(bnine);

		JButton bdiv = new JButton(":");
		bdiv.setMargin(new Insets(1, 1, 1, 1));
		bdiv.setBounds(145, 54, 35, 35);
		bdiv.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				String curExpr = arExpr.getText();
				String exp1 = exp.concat(":");
				arExpr.setText(curExpr.concat(exp1));
				trigger = true;
			}
		});
		frmCalculatorbuilder.getContentPane().add(bdiv);

		JButton bdel = new JButton("<-");
		bdel.setMargin(new Insets(1, 1, 1, 1));
		bdel.setBounds(190, 54, 35, 35);
		bdel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.length() != 0) {
					curNum.setText(exp.substring(0, exp.length() - 1));
				}
			}
		});
		frmCalculatorbuilder.getContentPane().add(bdel);

		JButton bfour = new JButton("4");
		bfour.setMargin(new Insets(1, 1, 1, 1));
		bfour.setBounds(10, 100, 35, 35);
		bfour.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.equals("0")) {
					curNum.setText("4");
				}
				else if (trigger) {
					exp = "";
					exp = exp.concat("4");
					curNum.setText(exp);
					trigger = false;
				}
				else {	
					exp = exp.concat("4");
					curNum.setText(exp);
				}
			}
		});
		frmCalculatorbuilder.getContentPane().add(bfour);

		JButton bfive = new JButton("5");
		bfive.setMargin(new Insets(1, 1, 1, 1));
		bfive.setBounds(55, 100, 35, 35);
		bfive.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.equals("0")) {
					curNum.setText("5");
				}
				else if (trigger) {
					exp = "";
					exp = exp.concat("5");
					curNum.setText(exp);
					trigger = false;
				}
				else {	
					exp = exp.concat("5");
					curNum.setText(exp);
				}
			}
		});
		frmCalculatorbuilder.getContentPane().add(bfive);

		JButton bsix = new JButton("6");
		bsix.setMargin(new Insets(1, 1, 1, 1));
		bsix.setBounds(100, 100, 35, 35);
		bsix.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.equals("0")) {
					curNum.setText("6");
				}
				else if (trigger) {
					exp = "";
					exp = exp.concat("6");
					curNum.setText(exp);
					trigger = false;
				}
				else {	
					exp = exp.concat("6");
					curNum.setText(exp);
				}
			}
		});
		frmCalculatorbuilder.getContentPane().add(bsix);

		JButton bmult = new JButton("*");
		bmult.setMargin(new Insets(1, 1, 1, 1));
		bmult.setBounds(145, 100, 35, 35);
		bmult.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				String curExpr = arExpr.getText();
				String exp1 = exp.concat("*");
				arExpr.setText(curExpr.concat(exp1));
				trigger = true;
			}
		});
		frmCalculatorbuilder.getContentPane().add(bmult);

		JButton bcancel = new JButton("C");
		bcancel.setMargin(new Insets(1, 1, 1, 1));
		bcancel.setBounds(190, 100, 35, 35);
		bcancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				curNum.setText(null);
				arExpr.setText(null);
			}
		});
		frmCalculatorbuilder.getContentPane().add(bcancel);

		JButton bone = new JButton("1");
		bone.setMargin(new Insets(1, 1, 1, 1));
		bone.setBounds(10, 146, 35, 35);
		bone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.equals("0")) {
					curNum.setText("1");
				}
				else if (trigger) {
					exp = "";
					exp = exp.concat("1");
					curNum.setText(exp);
					trigger = false;
				}
				else {	
					exp = exp.concat("1");
					curNum.setText(exp);
				}
			}
		});
		frmCalculatorbuilder.getContentPane().add(bone);

		JButton btwo = new JButton("2");
		btwo.setMargin(new Insets(1, 1, 1, 1));
		btwo.setBounds(55, 146, 35, 35);
		btwo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.equals("0")) {
					curNum.setText("2");
				}
				else if (trigger) {
					exp = "";
					exp = exp.concat("2");
					curNum.setText(exp);
					trigger = false;
				}
				else {	
					exp = exp.concat("2");
					curNum.setText(exp);
				}
			}
		});
		frmCalculatorbuilder.getContentPane().add(btwo);

		JButton bthree = new JButton("3");
		bthree.setMargin(new Insets(1, 1, 1, 1));
		bthree.setBounds(100, 146, 35, 35);
		bthree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.equals("0")) {
					curNum.setText("3");
				}
				else if (trigger) {
					exp = "";
					exp = exp.concat("3");
					curNum.setText(exp);
					trigger = false;
				}
				else {	
					exp = exp.concat("3");
					curNum.setText(exp);
				}
			}
		});
		frmCalculatorbuilder.getContentPane().add(bthree);

		JButton bmin = new JButton("-");
		bmin.setMargin(new Insets(1, 1, 1, 1));
		bmin.setBounds(145, 146, 35, 35);
		bmin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				String curExpr = arExpr.getText();
				String exp1 = exp.concat("-");
				arExpr.setText(curExpr.concat(exp1));
				trigger = true;
			}
		});
		frmCalculatorbuilder.getContentPane().add(bmin);

		JButton bfr = new JButton("/");
		bfr.setMargin(new Insets(1, 1, 1, 1));
		bfr.setBounds(100, 192, 35, 35);
		bfr.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				exp = exp.concat("/");
				curNum.setText(exp);
			}
		});
		frmCalculatorbuilder.getContentPane().add(bfr);

		JButton bplus = new JButton("+");
		bplus.setMargin(new Insets(1, 1, 1, 1));
		bplus.setBounds(145, 192, 35, 35);
		bplus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				String curExpr = arExpr.getText();
				String exp1 = exp.concat("+");
				arExpr.setText(curExpr.concat(exp1));
				trigger = true;
			}
		});
		frmCalculatorbuilder.getContentPane().add(bplus);

		JButton bzero = new JButton("0");
		bzero.setMargin(new Insets(1, 1, 1, 1));
		bzero.setBounds(10, 192, 80, 35);
		bzero.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				String exp = curNum.getText();
				if (exp.equals("0")) {
					curNum.setText("0");
				}
				else if (trigger) {
					exp = "";
					exp = exp.concat("0");
					curNum.setText(exp);
					trigger = false;
				}
				else {	
					exp = exp.concat("0");
					curNum.setText(exp);
				}
			}
		});
		frmCalculatorbuilder.getContentPane().add(bzero);

		JButton bres = new JButton("=");
		bres.setMargin(new Insets(1, 1, 1, 1));
		bres.setBounds(190, 146, 35, 81);
		bres.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				ParcerRpn pr = new ParcerRpn();
				String exp = arExpr.getText();
				String exp1 = curNum.getText();
				arExpr.setText(null);
				curNum.setText(pr.countFr(exp.concat(exp1)).toString());
			}
		});
		frmCalculatorbuilder.getContentPane().add(bres);

		curNum = new JTextField();
		curNum.setText("0");
		curNum.setEnabled(false);
		curNum.setFont(new Font("Monospaced", Font.BOLD, 19));
		curNum.setBounds(10, 27, 215, 17);
		curNum.setBorder(null);
		curNum.setHorizontalAlignment(JTextField.RIGHT);
		frmCalculatorbuilder.getContentPane().add(curNum);
	}
}
