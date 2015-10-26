package glazer.acm;

public class RascalTriangle {
	public static void main(String args[]) {
		int[][] r = new int[100][100];
		// int column = 0;
		int row = 1;

		for (int i = 0; i < row; i++) {
			r[i][0] = 1;
			r[i][row] = 1;
		}

		for (int i = 2; i < row; i++) {
			for (int y = 1; y <= i; i++) {
				r[i][y] = (r[i - 1][i - 1] * r[i - 1][i] + 1) / r[i - 2][i - 1];
			}
		}
		for (int i = 0; i < row; i++) {
			System.out.println();
			for (int y = 0; y < i; y++) {
				System.out.print(r[i][y]);
				System.out.print(" ");
			}
		}
	}
}
