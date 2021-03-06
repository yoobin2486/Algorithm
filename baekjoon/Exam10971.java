package baekjoon;

import java.util.Scanner;

public class Exam10971 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] w = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				w[i][j] = sc.nextInt();
			}
		}

		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = i;
		}

		int answer = Integer.MAX_VALUE;

		do {
			boolean ok = true; // 0이 존재하는지 확인하는 변수, 올바른 경로 인지 판별
			int sum = 0; // 경로의 비용을 담는 변수
			for (int i = 0; i < N - 1; i++) {
				if (w[num[i]][num[i + 1]] == 0) {
					ok = false;
				} else {
					sum += w[num[i]][num[i + 1]];
				}
			}
			if (ok && w[num[N - 1]][num[0]] != 0) { // 마지막 도시에서 원래도시로 돌아왔을 때 0인지 판별
				sum += w[num[N - 1]][num[0]];
				if (answer > sum) {
					answer = sum; // 값을 계산해 최소값을 넣으면 된다.
				}
			}
		} while (next(num));
		System.out.println(answer);
	}

	public static boolean next(int[] num) {
		int i = num.length - 1;

		while (i > 0 && num[i - 1] >= num[i]) {
			i -= 1;
		}

		if (i <= 0) {
			return false;
		}
		int j = num.length - 1;
		while (num[j] <= num[i - 1])
			j -= 1;
		// swap
		int temp = num[i - 1];
		num[i - 1] = num[j];
		num[j] = temp;

		j = num.length - 1;
		while (i < j) {
			// swap
			int tem = num[i];
			num[i] = num[j];
			num[j] = tem;

			i += 1;
			j -= 1;
		}
		return true;
	}
}
