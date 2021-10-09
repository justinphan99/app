package utils;

public class CheckNumeric {
	public static boolean checkNumeric(final String str) {
		if(str == null || str.equals("")) {
			return false;
		}
		return str.chars().allMatch(Character::isDigit);
	}
}
