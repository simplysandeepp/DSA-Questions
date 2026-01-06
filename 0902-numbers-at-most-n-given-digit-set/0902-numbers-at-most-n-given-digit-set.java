class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int mask = 0;
        for (int i = 0; i < digits.length; i++) {
            int digit = Integer.parseInt(digits[i]);
            mask = mask | (1 << digit);  
        }
        String s = String.valueOf(n);
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            res += Math.pow(digits.length, i);
        }
        res += solve(s, 0, 1, mask);
        return res;
    }

    public int solve(String s, int idx, int tight, int mask) {
        if (idx == s.length()) {   
            return 1;
        }
        int lb = 0;
        int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int res = 0;
        for (int digit = lb; digit <= ub; digit++) {  
            int newTight = (tight == 1 && digit == ub) ? 1 : 0;
            int isDigitUsed = (mask >> digit) & 1;    
            if (isDigitUsed == 0) {
                continue;
            }
            res += solve(s, idx + 1, newTight, mask);
        }
        return res;
    }
}
