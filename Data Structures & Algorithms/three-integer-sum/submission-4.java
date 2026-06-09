class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            int left = i+1;
            int right = nums.length - 1;
            int target = nums[i] * -1;

            while(left < right){
                if(nums[left] + nums[right] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(!mainList.contains(list)){
                        mainList.add(list);
                    }
                    left++;
                    right--;
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else{
                    right--;
                }
            }
        }

        return mainList;
    }
}
