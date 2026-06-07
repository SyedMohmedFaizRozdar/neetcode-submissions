class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeroProd = 1;
        int zeroCount = 0;
        int arr[] = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zeroCount ++;
                prod = 0;
            }else{
                prod *= nums[i];
                zeroProd *= nums[i];
            }
        }

        if(zeroCount > 1){
            return arr;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                arr[i] = zeroProd;
            }else{
                arr[i] = prod/nums[i];
            }
        }

        return arr;
    }
}  
