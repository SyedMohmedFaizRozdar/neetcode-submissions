class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,target,0,list,result);
        return result;
    }
    public void helper(int[] nums,int target, int index, List<Integer> list,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }else if(target < 0 || index > nums.length-1){
            return;
        }else{
            list.add(nums[index]);
            helper(nums,target-nums[index],index,list,result);
            list.remove(list.size()-1);
            helper(nums,target,index+1,list,result);
        }
    }
}
