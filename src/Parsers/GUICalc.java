package Parsers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class GUICalc extends JFrame {

	private JTextField arExpr;
	private JTextField res;
	private JButton eq;
	private JPanel panel;
	private JButton clean;

	GUICalc() {

		super("Calculator");
		setSize(400, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		arExpr = new JTextField(22);
		arExpr.setHorizontalAlignment(JTextField.RIGHT);
		arExpr.setFont(new Font("monospaced", Font.PLAIN, 19));
		arExpr.requestFocus();
		arExpr.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent arg0) {
				String expr = arExpr.getText();
				if (expr.endsWith("=")) {
					ParcerRpn pr = new ParcerRpn();
					try {
						res.setText(pr.countFr(expr.substring(0, expr.length() - 1)).toString());
					} catch (java.lang.ArithmeticException e) {
						res.setText("ERROR");
					} catch (java.lang.NullPointerException e) {
						res.setText("ERROR");
					} catch (java.lang.NumberFormatException l) {

					}
				}
				if (expr.length() == 0)
					res.setText(null);

			}
		});
		arExpr.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					String expr = arExpr.getText();

					ParcerRpn pr = new ParcerRpn();
					try {
						res.setText(pr.countFr(expr).toString());
					} catch (java.lang.ArithmeticException l) {
						res.setText("ERROR");
					} catch (java.lang.NullPointerException l) {
						res.setText("ERROR");
					}
					if (expr.length() == 0)
						res.setText(null);
				}
			}
		});

		eq = new JButton("=");
		eq.setMargin(new Insets(1, 1, 1, 1));
		eq.setPreferredSize(new Dimension(30, 30));
		eq.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {

				String expr = arExpr.getText();
				ParcerRpn pr = new ParcerRpn();
				try {
					res.setText(pr.countFr(expr).toString());
				} catch (java.lang.ArithmeticException e) {
					res.setText("ERROR");
				} catch (java.lang.NullPointerException l) {
					res.setText("ERROR");
				} catch (java.lang.NumberFormatException l) {

				}
			}
		});

		res = new JTextField(6);
		res.setHorizontalAlignment(JTextField.CENTER);
		res.setEditable(false);
		res.setFont(new Font("monospaced", Font.BOLD, 19));

		clean = new JButton("Clean");
		clean.setMargin(new Insets(1, 1, 1, 1));
		clean.setPreferredSize(new Dimension(50, 30));
		clean.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent click) {
				arExpr.setText(null);
				res.setText(null);
			}
		});

		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(arExpr, BorderLayout.EAST);
		panel.add(eq, BorderLayout.CENTER);
		panel.add(res, BorderLayout.WEST);

		setContentPane(panel);
		getContentPane().add(clean, BorderLayout.EAST);
		setVisible(true);

	}

	public static void main(String[] args) {
		new GUICalc();

	}

}
