// https://leetcode.com/problems/two-sum/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complememnt = target - nums[i];
            if (map.containsKey(complememnt)) {
                return new int[] { i, map.get(complememnt) };
            }
            map.put(nums[i], i);
        }

        return null;
    }
}