class Solution {
    List<List<String>> ans;
    private boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    private void helper(int idx,String s,List<String> list){
        if(idx>=s.length()){
            ans.add(new ArrayList(list));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(idx,i,s)){
                list.add(s.substring(idx,i+1));
                helper(i+1,s,list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        helper(0,s,new ArrayList<>());
        return ans;
    }

}