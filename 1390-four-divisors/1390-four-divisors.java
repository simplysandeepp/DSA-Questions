class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;
        for (int i : nums) {
            int cnt = 0;
            int sum = 0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    int k = i / j;
                    cnt++;
                    sum += j;
                    if (j != k) {
                        cnt++;
                        sum += k;
                    }
                    if (cnt > 4) 
                        break;
                }
            }
            if (cnt == 4) 
                total += sum;
        }
        return total;
    }
}