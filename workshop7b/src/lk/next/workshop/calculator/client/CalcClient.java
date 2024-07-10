package lk.next.workshop.calculator.client;

import java.rmi.*;
import java.net.MalformedURLException;
import java.awt.*;
import javax.swing.*;

import lk.next.workshop.calculator.Calculator;

import java.awt.event.*;

public class CalcClient extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Calculator dt;

	JTextField txtScr;
	JButton cmdBack, cmdClr, cmdEnter, cmdSign, cmdPlus, cmdMinus, cmdMult, cmdDiv, cmdSqrt, cmdRecipro, cmdDot;
	JButton cmdOne, cmdTwo, cmdThree, cmdFour, cmdFive, cmdSix, cmdSeven, cmdEight, cmdNine, cmdZero;
	Float num1, num2, ans;
	String op;

	char ch;
	int asc;
	Container cp;

	CalcClient() {
		cp = getContentPane();
		cp.setLayout(null);

		try {
			dt = (Calculator) Naming.lookup("Calculator");
		}

		catch (Exception e) {
		}

		txtScr = new JTextField();
		txtScr.setBounds(10, 10, 290, 30);
//txtScr.addKeyListener(this);
		cp.add(txtScr);

		cmdSeven = new JButton("7");
		cmdSeven.setBounds(10, 100, 50, 40);
		cp.add(cmdSeven);
		cmdSeven.addActionListener(this);
		cmdEight = new JButton("8");
		cmdEight.setBounds(70, 100, 50, 40);
		cp.add(cmdEight);
		cmdEight.addActionListener(this);
		cmdNine = new JButton("9");
		cmdNine.setBounds(130, 100, 50, 40);
		cp.add(cmdNine);
		cmdNine.addActionListener(this);
		cmdDiv = new JButton("/");
		cmdDiv.setBounds(190, 100, 50, 40);
		cp.add(cmdDiv);
		cmdDiv.addActionListener(this);
		cmdSqrt = new JButton("s");
		cmdSqrt.setBounds(250, 100, 50, 40);
		cp.add(cmdSqrt);
		cmdSqrt.addActionListener(this);
		cmdClr = new JButton("C");
		cmdClr.setBounds(250, 150, 50, 40);
		cp.add(cmdClr);
		cmdClr.addActionListener(this);
		cmdFour = new JButton("4");
		cmdFour.setBounds(10, 150, 50, 40);
		cp.add(cmdFour);
		cmdFour.addActionListener(this);
		cmdFive = new JButton("5");
		cmdFive.setBounds(70, 150, 50, 40);
		cp.add(cmdFive);
		cmdFive.addActionListener(this);
		cmdSix = new JButton("6");
		cmdSix.setBounds(130, 150, 50, 40);
		cp.add(cmdSix);
		cmdSix.addActionListener(this);
		cmdMult = new JButton("*");
		cmdMult.setBounds(190, 150, 50, 40);
		cp.add(cmdMult);
		cmdMult.addActionListener(this);
		cmdOne = new JButton("1");

		cmdOne.setBounds(10, 200, 50, 40);
		cp.add(cmdOne);
		cmdOne.addActionListener(this);
		cmdTwo = new JButton("2");
		cmdTwo.setBounds(70, 200, 50, 40);
		cp.add(cmdTwo);
		cmdTwo.addActionListener(this);
		cmdThree = new JButton("3");
		cmdThree.setBounds(130, 200, 50, 40);
		cp.add(cmdThree);
		cmdThree.addActionListener(this);
		cmdMinus = new JButton("-");
		cmdMinus.setBounds(190, 200, 50, 40);
		cp.add(cmdMinus);
		cmdMinus.addActionListener(this);
		cmdRecipro = new JButton("/x");
		cmdRecipro.setBounds(250, 200, 50, 40);
		cp.add(cmdRecipro);
		cmdRecipro.addActionListener(this);
		cmdZero = new JButton("0");
		cmdZero.setBounds(10, 250, 50, 40);
		cp.add(cmdZero);
		cmdZero.addActionListener(this);

		cmdSign = new JButton("+-");
		cmdSign.setBounds(70, 250, 50, 40);
		cp.add(cmdSign);
		cmdSign.addActionListener(this);

		cmdDot = new JButton(".");
		cmdDot.setBounds(130, 250, 50, 40);
		cp.add(cmdDot);
		cmdDot.addActionListener(this);

		cmdPlus = new JButton("+");
		cmdPlus.setBounds(190, 250, 50, 40);
		cp.add(cmdPlus);
		cmdPlus.addActionListener(this);
		cmdEnter = new JButton("=");

		cmdEnter.setBounds(250, 250, 50, 40);
		cp.add(cmdEnter);
		cmdEnter.addActionListener(this);

		setSize(320, 360);
		setVisible(true);
	}// constructor

	public void actionPerformed(ActionEvent ae) {
		try {
			if (ae.getActionCommand().equals("0"))
				txtScr.setText(txtScr.getText() + "0");
			else if (ae.getActionCommand().equals("1"))
				txtScr.setText(txtScr.getText() + "1");
			else if (ae.getActionCommand().equals("2"))
				txtScr.setText(txtScr.getText() + "2");
			else if (ae.getActionCommand().equals("3"))
				txtScr.setText(txtScr.getText() + "3");
			else if (ae.getActionCommand().equals("4"))
				txtScr.setText(txtScr.getText() + "4");
			else if (ae.getActionCommand().equals("5"))
				txtScr.setText(txtScr.getText() + "5");
			else if (ae.getActionCommand().equals("6"))
				txtScr.setText(txtScr.getText() + "6");
			else if (ae.getActionCommand().equals("7"))
				txtScr.setText(txtScr.getText() + "7");
			else if (ae.getActionCommand().equals("8"))
				txtScr.setText(txtScr.getText() + "8");
			else if (ae.getActionCommand().equals("9"))
				txtScr.setText(txtScr.getText() + "9");
			else if (ae.getActionCommand().equals("."))
				txtScr.setText(txtScr.getText() + ".");

			if (ae.getActionCommand().equals("C")) {
				txtScr.setText("");
				txtScr.grabFocus();
			}
			if (ae.getActionCommand().equals("<<")) {
				int len = (txtScr.getText()).length();
				String str = txtScr.getText();
				txtScr.setText("");

				if (len > 0) {
					for (int i = 0; i < len - 1; i++) {
						txtScr.setText(txtScr.getText() + "" + (str).charAt(i));
					}
				}
			}

			if (ae.getActionCommand().equals("+")) {
				num1 = Float.parseFloat(txtScr.getText());
				op = "+";

				txtScr.setText("");
				txtScr.grabFocus();

			} else if (ae.getActionCommand().equals("-")) {
				num1 = Float.parseFloat(txtScr.getText());
				op = "-";
				txtScr.setText("");
				txtScr.grabFocus();
			} else if (ae.getActionCommand().equals("*")) {
				num1 = Float.parseFloat(txtScr.getText());
				op = "*";
				txtScr.setText("");
				txtScr.grabFocus();
			} else if (ae.getActionCommand().equals("/")) {
				num1 = Float.parseFloat(txtScr.getText());
				op = "/";
				txtScr.setText("");
				txtScr.grabFocus();
			} else if (ae.getActionCommand().equals("1/x")) {
				num1 = Float.parseFloat(txtScr.getText());
				num2 = (float) (0.0);
				op = "1/x";

				txtScr.grabFocus();
				txtScr.setText(String.valueOf(dt.calculate(num1, num2, op)));
			} else if (ae.getActionCommand().equals("s")) {
				num1 = Float.parseFloat(txtScr.getText());
				num2 = (float) (0.0);
				op = "s";
				txtScr.grabFocus();
				txtScr.setText(String.valueOf(dt.calculate(num1, num2, op)));
			} else if (ae.getActionCommand().equals("+-")) {
				if (Float.parseFloat(txtScr.getText()) > 0)
					txtScr.setText("-" + txtScr.getText());
				else
					txtScr.setText(Math.abs(Float.parseFloat(txtScr.getText())) + "");
			}
			if (ae.getActionCommand().equals("=")) {
				num2 = Float.parseFloat(txtScr.getText());
				System.out.println(num1 + op + num2);
				txtScr.setText(String.valueOf(dt.calculate(num1, num2, op)));
			}

		} catch (Exception eee) {
		}

	}// actionPerformed

	public static void main(String[] rgs) {
		new CalcClient();
	}
}
