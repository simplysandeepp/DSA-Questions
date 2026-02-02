// class Solution {
//     public boolean isPerfectSquare(int num) {
//         if(num == 0 ) return false;
//         if(num == 1 ) return true;
//         for(long i=1; i<=num/2; i++) {
//             if(i*i == num) return true;
//         }
//         return false;
//     }
// }

class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = (left + right)/2;
            long midSquare = (long) mid * mid;
            if (midSquare == num) return true;
            else if (midSquare > num) right = mid - 1;
            else {
                left = mid + 1;
            }
        }

        return false;
    }
}