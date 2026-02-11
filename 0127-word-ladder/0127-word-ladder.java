class Solution {
    static class Pair{
        String str;
        int step;
        public Pair(String str, int step) {
            this.str = str;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }
        set.remove(beginWord);
        if(!set.contains(endWord) == false) {
            return 0;
        } 

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()) {
            Pair.curr = q.poll();
            String word = curr.str;
            int level = curr.step;
            if(word.equals(endWord)) {
                return level;
            }
            int len = word.length();
            for(int i=0; i<len; i++) {
                char[] arr =  word.toCharArray();
                for(char ch='a'; ch='z'; ch++) {
                    if(arr[i]==ch) {
                        continue; // h--->>h skip krna hai 
                    }
                    arr[i]=ch;
                    String replaceWord = new String(arr);
                    if(set.contains(replaceWord)) {
                        q.offer(new Pair(replaceWord, level+1));
                        set.remove(replaceWord);
                    }
                }

            }

        }
    }
}