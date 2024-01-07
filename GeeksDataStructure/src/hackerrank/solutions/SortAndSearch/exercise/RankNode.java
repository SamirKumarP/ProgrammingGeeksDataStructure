package hackerrank.solutions.SortAndSearch.exercise;

public class RankNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int left_size = 0;
	public RankNode left, right;
	public int data = 0;
	public RankNode(int d) {
		data = d;
	}
	public void insert(int d) {
		if (d <= data) {
			if (left != null) left.insert(d);
			else left = new RankNode(d);
			left_size++;
		} else {
			if (right != null) right.insert(d);
			else right = new RankNode(d);
		}
	}
	
	public int getRank(int d) {
		if (d == data) {
			return left_size;
		} else if (d < data) {
			if (left == null) return -1;
			else return left.getRank(d);
		} else {
			int right_rank = right == null ? -1 : right.getRank(d);
			if (right_rank == -1) return -1;
			else return left_size + 1 + right_rank;
		}
	}
}
