class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits, (a, b) -> b - a);
        int maxGroup = 0;
        int low = 1, high = usageLimits.size();
        while(low <= high) {
            int mid = (low + high) / 2;
            if(predicate(usageLimits, mid)) {
                maxGroup = mid;
                low = mid + 1;
            }
        }
        return maxGroup;
    }
    private boolean predicate(List<Integer> usageLimits, int size) {
        int gaps = 0;
        for(int usage : usageLimits) {
            if(usage < size) {
                gaps += size - usage;
            }
            else if(gaps > 0) {
                gaps -= usage - size;
            }
            size = Math.max(size - 1, 0);
        }
        return gaps <= 0;
    }
}