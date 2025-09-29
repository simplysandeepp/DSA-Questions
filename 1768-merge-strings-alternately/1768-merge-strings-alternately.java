class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0, j=0, k=0;
        int n=word1.length();
        int m=word2.length();
        char[] res = new char[n+m];
        while(i<n || j<m) {
            if(i<n) res[k++] = word1.charAt(i++);
            if(j<m) res[k++] = word2.charAt(j++);
        }
        return new String(res);
        
    }
}