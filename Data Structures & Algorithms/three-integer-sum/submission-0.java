class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                int target = nums[i] + nums[j];
                target *= -1;

                int k = findTargetIndex(target,i,j,nums);

                if(k != -1){
                    list.add(nums[k]);
                    Collections.sort(list);
                    if(!mainList.contains(list)){
                        mainList.add(list);
                    }
                }
            }
        }

        return mainList;
    }

    private int findTargetIndex(int target, int i, int j, int[] nums){
        for(int k=0; k< nums.length; k++){
            if(nums[k] == target && k!=i && k!=j) return k;
        }

        return -1;
    }
}
