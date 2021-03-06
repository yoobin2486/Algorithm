package baekjoon;

import java.util.Scanner;

public class Exam2163 {
	static int N, M, K;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		K = N * M;

		arr = new int[K+1];
		
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 1;

		for (int i = 3; i <= K; i++) {
			arr[i] = arr[i - 1] + 1;
		}
		System.out.println(arr[K]);
	}
}
