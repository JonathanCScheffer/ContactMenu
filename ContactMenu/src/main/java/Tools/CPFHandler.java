package Tools;

/**
 * Class that verify if a CPF number is or not valid
 *@author:Jonathan Scheffer
*/

public class CPFHandler {
	private String cpfString;
	private int[] cpfNumList = new int[11];

	/**
	 * CPFHandler constructor
	 * @param cpfString
	 */
	public CPFHandler(String cpfString) {
		super();
		this.cpfString = cpfString;
	}
	/**
	 * gets the CPF string
	 * @return cpfString
	 */
	public String getCpfString() {
		return cpfString;
	}
	/**
	 * Verify if the cpfString is valid
	 * @return bool
	 */
	public Boolean isValid() {
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
		if (firstDigit > 9 && cpfNumList[9] != 0)
			return false;
		count = 11;
		sum = 0;
		for (int i = 0; i < cpfNumList.length - 1; i++) {
			sum += count * cpfNumList[i];
			count--;
		}
		int secondDigit = 11 - (sum % 11);
		if (secondDigit > 9 && cpfNumList[10] != 0)
			return false;
		return true;
	}
	/**
	 * Verify if the CPF String is Valid(parameter included).
	 * @param cpfString
	 * @return
	 */
	public Boolean isValid(String cpfString) {
		if(cpfString.length()!=14)
			return false;
		for (int i = 0, j = 0; i < cpfString.length(); i++) {
			char c = cpfString.charAt(i);
			if (tryParseInt(c)) {
				cpfNumList[j] = c;
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
		if (firstDigit > 9 && cpfNumList[9] != 0)
			return false;
		for (int i = 0; i < cpfNumList.length - 1; i++) {
			sum += count * cpfNumList[i];
			count--;
		}
		int secondDigit = 11 - (sum % 11);
		if (secondDigit > 9 && cpfNumList[10] != 0)
			return false;
		return true;
	}
	/**
	 * Verify if c corresponds to an Integer
	 * @param c
	 * @return
	 */
	private boolean tryParseInt(char c) {
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