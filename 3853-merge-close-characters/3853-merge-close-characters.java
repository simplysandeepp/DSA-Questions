class Solution {
    public String mergeCharacters(String s, int k) {
        int cnt=0;
        int[] idxs=new int[26];
        int[] pre=new int[s.length()];
        Arrays.fill(idxs,-1);
        idxs[s.charAt(0)-'a']=0;
        StringBuilder st=new StringBuilder();
        st.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            int c=s.charAt(i)-'a';
            int rem=0;
            if(idxs[c]!=-1) rem=cnt-pre[idxs[c]];
            if(idxs[c]!=-1 && (i-idxs[c]-rem)<=k){
                 cnt++;
            }else{
                idxs[c]=i;
                st.append((char)(c+((int)'a')));
            }
            pre[i]=cnt;
        }
        return st.toString();
    }
}