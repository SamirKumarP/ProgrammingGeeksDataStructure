package hackerrank.algorithms;

import java.util.HashMap;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {25, 10, 5, 1};
		int money = 17;
		System.out.println(makeChange(coins, money));

	}
	
	public static long makeChange(int[] coins, int money) {
		return makeChange(coins, money, 0, new HashMap<String, Long>());
	}
	
	public static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
		if (money == 0) {
			return 1;
		}
		if (index >= coins.length) {
			return 0;
		}
		String key = money + "_" + index;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		int amountWithCoin = 0;
		long ways = 0;
		while (amountWithCoin <= money) {
			int remaining = money - amountWithCoin;
			ways += makeChange(coins, remaining, index + 1, memo) ;
			amountWithCoin += coins[index];
		}
		memo.put(key, ways);
		return ways;
	}

}
