package Parsers;
import java.util.Stack;
import java.util.logging.Level;

public class ParcerRpn {
	private void checkStr(String in) {					//Не уверена
		String check = new String("*:-+1234567890/()");
		String[] in1 = in.split("");
		for (int i = 0; i < in1.length; i++) {
			if (check.indexOf(in1[i]) == -1)
				throw new NumberFormatException();
		}

	}

	public String toRpn(String in) {
		in = in.replace(" ", "");
		try {											//Не уверена
			checkStr(in);
			in = in.replace("(-", "(0-");
			if (in.indexOf("-") == 0){
				in = in.replaceFirst("[-]", "0-");
			}
			String tempNum = new String();
			int maxPrior = 0;
			Stack<String> sign = new Stack<>();
			String out = new String();
			String[] in1 = in.split("");
			for (int i = 0; i < in1.length; i++) {
				if (in1[i].equals("+") || in1[i].equals("-") || in1[i].equals("*") || in1[i].equals(":")
						|| in1[i].equals("(") || in1[i].equals(")")) {
					if (!tempNum.isEmpty()) {
						out = out.concat(tempNum + " ");
						tempNum = "";
					}

					if (in1[i].equals("("))
						sign.push(in1[i]);
					else if (in1[i].equals(")")) {
						while (!sign.peek().equals("(")) {
							out = out.concat(sign.pop() + " ");
						}
						sign.pop();
					} else {

						if (sign.empty() || maxPrior < prior(in1[i])) {
							sign.push(in1[i]);
							maxPrior = prior(in1[i]);
						} else if (prior(sign.peek()) >= prior(in1[i])) {
							while (maxPrior >= prior(in1[i])) {
								out = out.concat(sign.pop() + " ");
								if (sign.empty())
									break;
								else
									maxPrior = prior(sign.peek());
							}
							if (sign.empty() || maxPrior < prior(in1[i])) {
								sign.push(in1[i]);
								maxPrior = prior(in1[i]);
							}
						}else if (prior(sign.peek()) < prior(in1[i])){
							sign.push(in1[i]);
							maxPrior = prior(in1[i]);
						}
					}

				} else {
					tempNum = tempNum.concat(in1[i]);
				}

			}
			if (!tempNum.isEmpty())
				out = out.concat(tempNum + " ");
			while (!sign.empty())
				out = out.concat(sign.pop() + " ");
			return out;
		} catch (NumberFormatException e) {
			System.out.println("Incorrect arithmetic expression");//Тем болеее Не уверена
			return null;
		}

	}

	private static int prior(String sign) {
		if (sign.equals("*") || (sign.equals(":")))
			return 3;
		else if (sign.equals("+") || (sign.equals("-")))
			return 2;
		else
			return 1;

	}

	public int countInt(String out) {
		
		Stack<Integer> st = new Stack<>();
		String[] out1 = out.split(" ");
		int num1, num2;
		for (int i = 0; i < out1.length; i++) {
			if (out1[i].equals("+") || out1[i].equals("-") || out1[i].equals("*") || out1[i].equals(":")) {
				num1 = st.pop();
				num2 = st.pop();
				switch (out1[i]) {
				case "+":
					st.push(num2 + num1);
					break;
				case "-":
					st.push(num2 - num1);
					break;
				case "*":
					st.push(num2 * num1);
					break;
				case ":":
					st.push(num2 / num1);
					break;
				}
			} else
				st.push(Integer.parseInt(out1[i]));
		}
		return st.pop();
	}

	public Fraction countFr(String in) {
		String out = toRpn(in);
		try {
		Fraction res =new Fraction("0");
		Stack<Fraction> st = new Stack<>();
		String[] out1 = out.split(" ");
		Fraction num1, num2;
		for (int i = 0; i < out1.length; i++) {
			if (out1[i].equals("+") || out1[i].equals("-") || out1[i].equals("*") || out1[i].equals(":")) {
				num1 = st.pop();
				num2 = st.pop();
				switch (out1[i]) {
				case "+":
					st.push(num1.add(num1, num2));
					break;
				case "-":
					st.push(num1.deny(num1, num2));
					break;
				case "*":
					st.push(num1.multiply(num1, num2));
					break;
				case ":":
					st.push(res.divide(num2, num1));
					break;
				}
			} else
				st.push(new Fraction(out1[i]));
		}
		return st.pop();
		}catch (java.util.EmptyStackException e) {
			System.out.println("Incorrect arithmetic expression");
			return null;
		}
	}

	public static void main(String[] args) {
		ParcerRpn pr = new ParcerRpn();
		// int res = pr.countInt("1 2 + 3 * 4 5 + *");
		// System.out.println(res);
		// Fraction res1 = pr.countFr("1/3 1/6 + 1/2 *");
		// res1.printFraction();
		Fraction.setLogLevel(Level.OFF);
		Fraction ex = pr.countFr("5/7:3/7");
		ex.printFraction();

//		Fraction fr1 = pr.countFr(ex);
//		

	}

}
