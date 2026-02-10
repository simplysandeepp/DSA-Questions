class Solution {
    public String findOrder(String[] words) {

        // 26 letters (a–z) ke liye adjacency list bana rahe hain
        // adj[u] me wo saare characters honge jo u ke baad aate hain
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // 26 empty lists add kar di (har letter ke liye ek list)
        for (int i = 0; i < 26; i++) 
            adj.add(new ArrayList<>());

        // indegree array:
        // indegree[x] = kitne letters x se pehle aate hain
        int[] indegree = new int[26];

        // pehle sabko -1 set kiya
        // -1 ka matlab: ye character dictionary me exist hi nahi karta
        Arrays.fill(indegree, -1);

        // yaha hum mark kar rahe hain ki kaun-kaun se characters actually words me present hain
        for (String word : words) {
            for (char c : word.toCharArray()) {
                // jaise hi character mila, uska indegree 0 kar diya
                // 0 ka matlab: exist karta hai, lekin abhi tak koi dependency nahi pata
                indegree[c - 'a'] = 0;
            }
        }

        // yaha se graph banana start hota hai
        // adjacent words ko compare karte hain
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];       // current word
            String w2 = words[i + 1];   // next word

            // dono words ka minimum length le rahe hain
            int len = Math.min(w1.length(), w2.length());

            // ye flag batata hai ki first different character mila ya nahi
            boolean found = false;

            // character by character compare kar rahe hain
            for (int j = 0; j < len; j++) {

                char c1 = w1.charAt(j); // w1 ka jth character
                char c2 = w2.charAt(j); // w2 ka jth character

                // jaha pe first time characters different mile
                if (c1 != c2) {

                    // iska matlab: c1 c2 se pehle aata hai
                    // graph me edge bana do: c1 -> c2
                    adj.get(c1 - 'a').add(c2 - 'a');

                    // c2 ka indegree badhao kyunki ek dependency add hui
                    indegree[c2 - 'a']++;

                    // mark kar diya ki difference mil gaya
                    found = true;

                    // first difference ke baad ruk jao
                    break;
                }
            }

            // prefix invalid case handle kar rahe hain
            // example: ["abc", "ab"]
            // yaha koi difference nahi mila + pehla word bada hai
            // to dictionary invalid hai
            if (!found && w1.length() > w2.length()) {
                return "";
            }
        }

        // Topological sort ke liye queue use karenge (Kahn’s Algorithm)
        Queue<Integer> q = new LinkedList<>();

        // jinke indegree 0 hai unko queue me daal do
        // indegree 0 ka matlab: inke pehle koi character nahi aata
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) 
                q.add(i);
        }

        // answer store karne ke liye StringBuilder
        StringBuilder ans = new StringBuilder();

        // jab tak queue empty nahi hoti
        while (!q.isEmpty()) {

            // queue se ek node nikala
            int node = q.poll();

            // us node ko answer me add kar diya
            ans.append((char)(node + 'a'));

            // us node ke saare neighbors ke liye
            for (int nbr : adj.get(node)) {

                // neighbor ka indegree kam karo
                indegree[nbr]--;

                // agar indegree 0 ho gaya, to queue me daal do
                if (indegree[nbr] == 0) 
                    q.add(nbr);
            }
        }

        // yaha total kitne valid characters the wo count kar rahe hain
        int charCount = 0;
        for (int i = 0; i < 26; i++) {
            if (indegree[i] != -1) 
                charCount++;
        }

        // agar answer length == total characters
        // matlab cycle nahi hai aur order valid hai
        // warna cycle hai → empty string return
        return ans.length() == charCount ? ans.toString() : "";
    }
}
