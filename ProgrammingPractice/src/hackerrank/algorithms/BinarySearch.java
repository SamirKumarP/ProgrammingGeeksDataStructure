package hackerrank.algorithms;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean binarySearchRecursive(int[] array, int x) {
		return binarySearchRecursive(array, x, 0, array.length - 1);
	}

	private boolean binarySearchRecursive(int[] array, int x, int left, int right) {
		if (left > right) {
			return false;
		}
		int mid = left + ((right - left)/ 2);
		if (array[mid] == x) {
			return true;
		} else if (x < array[mid]) {
			return binarySearchRecursive(array, x, left, mid - 1);
		} else {
			return binarySearchRecursive(array, x, left + 1, mid);
		}
	}
	
	private boolean binarySearchIterative(int[] array, int x) {
		int left = 0;
		int right = array.length - 1;
		while (right > left) {
			int mid = left + ((right - left)/ 2);
			if (array[mid] == x) {
				return true;
			} else if (x < array[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

}
