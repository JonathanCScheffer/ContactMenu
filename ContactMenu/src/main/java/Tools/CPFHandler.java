package Tools;

/**
 * Class that verify if a CPF number is or not valid
 *@author:Jonathan Scheffer
*/

public class CPFHandler {
	private static String cpfString;
	private static int[] cpfNumList = new int[11];
	/**
	 * Verify if the CPF String is Valid(parameter included).
	 * @param cpfString
	 * @return
	 */
	public static Boolean isValid(String cpfString) {
		if(cpfString.length()!=14)
			return false;
		for (int i = 0, j = 0; i < cpfString.length(); i++) {
			char c = cpfString.charAt(i);
			if (tryParseInt(c)) {
				int num = Character.getNumericValue(c);
				cpfNumList[j] = num;
				j++;
			}

		}
		int count = 10;
		int sum = 0;
		for (int i = 0; i < cpfNumList.length - 2; i++) {
			sum += count * cpfNumList[i];
			count--;
		}
		int firstDigit = 11 - (sum % 11);
		if ((firstDigit == 10 && cpfNumList[9] != 0)||(firstDigit!=cpfNumList[9]))
			return false;
		count = 11;
		sum = 0;
		for (int i = 0; i < cpfNumList.length - 1; i++) {
			sum += count * cpfNumList[i];
			count--;
		}
		int secondDigit = 11 - (sum % 11);
		if ((secondDigit == 10 && cpfNumList[10] != 0) || (secondDigit != cpfNumList[10]))
			return false;
		return true;
	}
	/**
	 * Verify if c corresponds to an Integer
	 * @param c
	 * @return
	 */
	public static boolean tryParseInt(char c) {
		try {
			Integer.parseInt(String.valueOf(c));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	/**
	 *Overrided toString method of CPFHandler
	 */
	@Override
	public String toString() {
		for (int num : cpfNumList) {
			System.out.println(num);
		}
		return "CPFHandler [cpfString=" + cpfString + ", cpfNumList=" + cpfNumList + "]";
	}
}