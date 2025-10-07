class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char maxCh = ' ';
        for (char c : s.toCharArray()) if (c != '9') { maxCh = c; break; }
        int max = Integer.parseInt(maxCh == ' ' ? s : s.replace(maxCh, '9'));
        int min = Integer.parseInt(s.replace(s.charAt(0), '0'));
        return max - min;
    }
}
