public class Solution 
{
    public String answerString(String word, int numFriends) 
    {
        if (numFriends == 1)
        {
            return word;
        } 
        int n = word.length();
        int maxLen = n - numFriends + 1;
        String res = "";

        for (int i = 0; i < n; ++i) 
        {
            int k = Math.min(n - i, maxLen);
            String substr = word.substring(i, i + k);

            if (substr.compareTo(res) > 0) 
            {
                res = substr;
            }
        }
        return res;
    }
}