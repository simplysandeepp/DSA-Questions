class Solution {
    public boolean isFascinating(int n) {
        boolean result = true;
        int n2 = n * 2;
        int n3 = n * 3;

        String str = Integer.toString(n) + Integer.toString(n2) + Integer.toString(n3);

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '0') {
                return false;
            }
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (str.indexOf(ch) == -1 || str.indexOf(ch) != str.lastIndexOf(ch)) {
                return false;
            }
        }

        return result;
    }
}
