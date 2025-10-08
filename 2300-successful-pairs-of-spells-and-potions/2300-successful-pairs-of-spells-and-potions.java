class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int ans[] = new int[spells.length];

        for(int i=0; i<spells.length; i++){
            int index = getMinPotion(spells[i], potions, success);
            ans[i] = n-index;
        }
        return ans;
    }
    
    public static int getMinPotion(int spell, int[] potions, long success) {
    int left = 0, right = potions.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if ((long) potions[mid] * spell >= success) {
            right = mid - 1;
        } else {
            left = mid + 1;   
        }
    }
    return left;  
    }
}