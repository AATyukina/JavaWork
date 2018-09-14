package Parsers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class GUICalcAuto extends JFrame {

	private JTextField arExpr;
	private JTextField res;
	private JPanel panel;
	private JButton clean;

	GUICalcAuto() {

		super("Calculator");
		setSize(350, 100);
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
				ParcerRpn pr = new ParcerRpn();
				if (expr.endsWith("=")) {

					try {
						res.setText(pr.countFr(expr.substring(0, expr.length() - 1)).toString());
					} catch (java.lang.ArithmeticException e) {
						res.setText("ERROR");
					} catch (java.lang.NullPointerException e) {
						res.setText("ERROR");
					}
				}
				try {
					res.setText(pr.countFr(expr).toString());
				} catch (java.lang.ArithmeticException e) {
					res.setText("ERROR");
				} catch (java.lang.NullPointerException l) {
		
				} catch (java.lang.NumberFormatException l) {

				}
				if (expr.length() == 0)
					res.setText(null);
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
		panel.add(res, BorderLayout.WEST);

		setContentPane(panel);
		getContentPane().add(clean, BorderLayout.EAST);
		setVisible(true);

	}

	public static void main(String[] args) {
		new GUICalcAuto();

	}

}
