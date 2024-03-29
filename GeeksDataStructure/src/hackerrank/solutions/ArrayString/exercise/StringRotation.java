package hackerrank.solutions.ArrayString.exercise;

// O(N) runtime
public class StringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean isRotation(String s1, String s2) {
		int len = s1.length();
		/*
		 * Check that s1 and s2 are equal length and not empty
		 */
		if (len == s2.length() && len > 0) {
			/*
			 * Concatenate s1 and s1 within new buffer
			 */
			String s1s1 = s1 + s1;
			return isSubString(s1s1, s2);
		}
		return false;
	}
	
//	Implemented myself
	boolean isSubString(String s1, String s2) {
		if (s1.contains(s2)) {
			return true;
		} else return false;
	}

}
