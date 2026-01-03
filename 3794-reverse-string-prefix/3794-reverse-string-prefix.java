class Solution {
    public String reversePrefix(String s, int k) {
        StringBuilder st = new StringBuilder();
        st.append(s.substring(0,k));
        st.reverse();

        for(int i=k; i<s.length(); i++) {
            st.append(s.charAt(i));
        }
        return st.toString();        
    }
}
