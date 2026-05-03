class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        		int n = a.length;
		int[] ans = new int[n - k + 1];
        		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < k; i++) {
			pq.add(a[i]);
		}
		for (int i = k; i <= n; i++) {
			ans[i - k] = pq.peek();
			if (i < n) {
				pq.remove(a[i - k]);
				pq.add(a[i]);
			}
		}
        return ans;
    }
}
