class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        char[] sorted = chars.clone();
        
        java.util.Arrays.sort(sorted);
        if (java.util.Arrays.equals(chars, sorted)) return 0;
        if (n == 2) return -1;
        
        int mx = -1, mn = 1000;
        for (char x : chars) {
            mx = Math.max(mx, (int) x);
            mn = Math.min(mn, (int) x);
        }
        
        if ((int) chars[0] == mx && (int) chars[n-1] == mn) {
            for (int i = 1; i < n-1; i++) {
                if ((int) chars[i] == mn || (int) chars[i] == mx) return 2;
            }
            return 3;
        }
        
        if ((int) chars[0] == mn || (int) chars[n-1] == mx) return 1;
        if ((int) chars[0] == mx) return 2;
        if ((int) chars[n-1] == mn) return 2;
        
        return 2;
    }
}