class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;

        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int longSeq = 1;
        int currLongSeq = 1;

        while(right < nums.length){
            if(nums[left]+1 == nums[right]){
                currLongSeq++;
                longSeq = Math.max(longSeq,currLongSeq);
                left = right;
                right++;
            }else if(nums[left] == nums[right]){
                right++;
            }else{
                left = right;
                right++;
                currLongSeq = 1;
            }
        }

        return longSeq;
    }
}
