class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0]. length;
        return helper(matrix, 0, row*col-1, col, target);
    }

    public boolean helper(int[][] matrix, int left, int right, int col,target){
        if(left > right){
            return false;
        }
        int mid = left + (right-left)/2;
        int r = mid/col;
        int c = mid % col;
        if(matrix[r][c] == target){
            return true;
        }
        else if(matrix[r][c] > target){
            return helper(matrix, left, mid-1, col, target);
        }
        else {
            return helper(matrix, mid+1, right, col, target);
        }
    }
}