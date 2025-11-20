class Solution {
    String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits){
        List <String> ans = new ArrayList<>();
        helper(digits, 0, "", ans);
        return ans;
    }
    public void helper(String digits, int index, String curr, List<String> ans){
        if (index == digits.length()){
            ans.add(curr);
            return;
        }
        for(char c : map[digits.charAt(index) - '0'].toCharArray()) {
            helper(digits, index+1, curr + c, ans);
        }


    }
}