class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int i = spaces[0];
        int m = spaces.length;
        while (i <= m-1){
            sb.insert(i, " ");
            i++;
        }
        return sb.toString();

    }
}