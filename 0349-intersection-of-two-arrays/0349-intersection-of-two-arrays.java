class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> list = new HashSet<>();
        for (int num : nums1) {
            list.add(num);
        }
        Set<Integer> list2 = new HashSet<>();
        for (int num : nums2) {
            if (list.contains(num)) {
                list2.add(num);
            }
        }
        int[] result = new int[list2.size()];
        int index = 0;
        for (int num : list2) {
            result[index++] = num;
        }

        return result;
    }
}
