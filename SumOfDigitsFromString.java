package week2.day2;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Tes12Le79af65";

		int sum = 0;

		String newStr = text.replaceAll("\\D", "");
		System.out.println(newStr);
		
		char[] nwCharStr = newStr.toCharArray();

		for (int i = 0; i < nwCharStr.length; i++) {
			int charNmValue = Character.getNumericValue(nwCharStr[i]);

			sum = sum + charNmValue;

		}

		System.out.println("The Sum of Digits from String : " + sum);
	}
}
	
	

