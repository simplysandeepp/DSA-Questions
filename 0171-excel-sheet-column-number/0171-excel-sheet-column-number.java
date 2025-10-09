class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int val;
        for (int i = 0; i < columnTitle.length(); i++){
            val = (int) columnTitle.charAt(i) - 64;
            result = result * 26 + val;
        }
        return result;
    }
}