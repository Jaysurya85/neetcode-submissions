class Solution {
    public int trap(int[] a) {
		int n = a.length;
		int[] maxOnLeft = new int[n];
		int[] maxOnRight = new int[n];
		maxOnLeft[0] = a[0];
		for (int i = 1; i < n; i++) {
			maxOnLeft[i] = Math.max(maxOnLeft[i - 1], a[i - 1]);
		}
		maxOnRight[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			maxOnRight[i] = Math.max(maxOnRight[i + 1], a[i + 1]);
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += Math.max(0, Math.min(maxOnLeft[i], maxOnRight[i]) - a[i]);
		}
        return ans;        
    }
}
