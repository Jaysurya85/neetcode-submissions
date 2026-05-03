class Solution {
   	public int calculate(int[][] a, boolean[][] visited, int[][] ans, int i, int j) {
	if (visited[i][j]) {
		return ans[i][j];
	}
	int n = a.length;
	int m = a[0].length;
	ans[i][j] = 1;
	if (i > 0 && a[i - 1][j] > a[i][j]) {
		calculate(a, visited, ans, i - 1, j);
		ans[i][j] = Math.max(ans[i][j], ans[i - 1][j] + 1);
	}
	if (i < n - 1 && a[i + 1][j] > a[i][j]) {
		calculate(a, visited, ans, i + 1, j);
		ans[i][j] = Math.max(ans[i][j], ans[i + 1][j] + 1);
	}
	if (j > 0 && a[i][j - 1] > a[i][j]) {
		calculate(a, visited, ans, i, j - 1);
		ans[i][j] = Math.max(ans[i][j], ans[i][j - 1] + 1);
	}
	if (j < m - 1 && a[i][j + 1] > a[i][j]) {
		calculate(a, visited, ans, i, j + 1);
		ans[i][j] = Math.max(ans[i][j], ans[i][j + 1] + 1);
	}
	return ans[i][j];
	}
    public int longestIncreasingPath(int[][] a) {
   		int n = a.length;
		int m = a[0].length;
		boolean[][] visited = new boolean[n][m];
		int[][] ans = new int[n][m];
		int maxVal = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans[i][j] = calculate(a, visited, ans, i, j);
				maxVal = Math.max(maxVal, ans[i][j]);
			}
		}
        return maxVal;
     
    }

}
