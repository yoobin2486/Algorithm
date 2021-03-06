package baekjoon;

import java.util.Scanner;

public class Exam1520 {
	static int M, N;
	static int[][] map;
	static int[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		map = new int[M][N];
		cache = new int[M][N];//

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				cache[i][j] = -1;
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		System.out.println(traveling(0, 0));
	}

	// 경로가 존재 : 1, X : 0
	static int traveling(int x, int y) {
		if (cache[x][y] != -1) {
			return cache[x][y];
		} //~> != -1 : 이미 지나왔던 경로
		
		if (x == M - 1 && y == N - 1) {
			return 1;
		}

		int result = 0;

		// 오
		if (y + 1 < N && map[x][y + 1] < map[x][y]) {
			result += traveling(x, y + 1);
		}

		// 왼
		if (y - 1 >= 0 && map[x][y - 1] < map[x][y]) {
			result += traveling(x, y - 1);
		}

		// 위
		if (x - 1 >= 0 && map[x - 1][y] < map[x][y]) {
			result += traveling(x - 1, y);
		}

		// 아래
		if (x + 1 < M && map[x + 1][y] < map[x][y]) {
			result += traveling(x + 1, y);
		}
		
		cache[x][y] = result;//
		return result;
	}
}
