class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= n - k; i++){
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++){
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }
            List<Map.Entry<Integer, Integer>> items = new ArrayList<>(freq.entrySet());
            items.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue()))
                    return b.getValue() - a.getValue();
                return b.getKey() - a.getKey();
            });
            int total = 0;
            for (int j = 0; j < x && j < items.size(); j++){
                total += items.get(j).getKey() * items.get(j).getValue();
            }
            res.add(total);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}