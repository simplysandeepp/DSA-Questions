class Solution {
    public boolean isBalanced(String num) {
        int esum=0;
        int osum = 0;
        for (int i=0; i<num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (i%2==0) {
                esum += digit;
            } else{
                osum += digit;
            }
        }

        return esum == osum;
    }
}
