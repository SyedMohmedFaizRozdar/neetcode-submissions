class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();
        Arrays.sort(nums); // Required for Two-Pointer logic

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate 'i' values
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    mainList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move pointers first
                    left++;
                    right--;

                    // NOW skip duplicates by checking against the elements just moved past
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return mainList;
    }
}