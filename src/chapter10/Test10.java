package chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test10 {

	public static void main(String[] args) {

		lotto_generator(5);
	}

	public static void lotto_generator(int n) {
		Random number = new Random();
		HashSet<Integer> lotto = null;
		HashSet<HashSet<Integer>> lot = new HashSet<HashSet<Integer>>();
		for (int i = 0; i < n; i++) {

			lotto = new HashSet<Integer>();

			for (int j = 0; lotto.size() <= 6; j++) {
				lotto.add(number.nextInt(45) + 1);
			}
			lot.add(lotto);

			List<Integer> L = new ArrayList<Integer>(lotto);
			Collections.sort(L);
			System.out.println(L);
		}

		System.out.println("========================");
		System.out.println(lot);
	}
}
