/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		} else if (s.length() == 1 ) {
			return true;
		}
		return isPalindromeHelper(s, 0, s.length() - 1);
	}

	private static boolean isPalindromeHelper(String s, int left, int right) {
		if (left >= right) {
			return true;
		}
		if (s.charAt(left) != s.charAt(right)) {
			return false;
		}
		return isPalindromeHelper(s, left + 1, right - 1);
	}
}