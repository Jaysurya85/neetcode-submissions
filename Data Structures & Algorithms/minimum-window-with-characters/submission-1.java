class Solution {
    	public boolean check(HashMap<Character, Integer> map) {
		boolean isValid = true;
		for (char c : map.keySet()) {
			if (map.get(c) < 0) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

    public String minWindow(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) - 1);
		}
		int left = 0, right = 0;
		int finalLeft = 0, finalRight = 0;
		int ans = Integer.MAX_VALUE;
		while (right < s.length()) {
			boolean isValid = check(map);
			if (isValid) {
				if (ans > right - left + 1) {
					finalLeft = left;
					finalRight = right;
					ans = right - left + 1;
				}
				map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
				left++;
			} else {
				map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
				right++;
			}
		}
		while (left < s.length()) {
			boolean isValid = check(map);
			if (isValid) {
				if (ans > right - left + 1) {
					finalLeft = left;
					finalRight = right;
					ans = right - left + 1;
				}
				map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
				left++;
			} else {
				break;
			}
		}
        if(ans!=Integer.MAX_VALUE){
		    return s.substring(finalLeft, finalRight);
        }
        return "";

    }
}
