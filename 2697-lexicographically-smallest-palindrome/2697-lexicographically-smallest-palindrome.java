class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] a = s.toCharArray();
        int left = 0, right = a.length - 1;
        
        while (left < right) {
            if (a[left] != a[right]) {
                // Pick the smaller character directly
                char smaller = (char) Math.min(a[left], a[right]);
                a[left] = a[right] = smaller;
            }
            left++;
            right--;
        }
        
        return new String(a);
    }
}