package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exam1759 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int C = sc.nextInt();

		String[] arr = new String[C];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}

		Arrays.sort(arr);
		travel(L, arr, "", 0);
	}

	public static void travel(int L, String[] arr, String pwd, int i) {
		if (pwd.length() == L) {
			if (check(pwd)) {
				System.out.println(pwd);
			}
			return;
		}
		if (i >= arr.length)
			return;
		travel(L, arr, pwd + arr[i], i + 1);
		travel(L, arr, pwd, i + 1);
	}

	public static boolean check(String pwd) {
		int m = 0;
		int j = 0;
		for (char c : pwd.toCharArray()) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				m++;
			} else {
				j++;
			}
		}
		
		if (m >= 1 && j >= 2) {
			return true;
		} else {
			return false;
		}
	}
}
