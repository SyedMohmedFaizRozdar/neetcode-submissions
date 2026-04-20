class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqCnt = new HashMap<>();

        for(int i: nums){
            freqCnt.put(i,freqCnt.getOrDefault(i,0)+1);
        }

        List<Integer> arr[] = new ArrayList[nums.length+1];

        for(Integer key: freqCnt.keySet()){
            if(arr[freqCnt.get(key)] == null){
                arr[freqCnt.get(key)] = new ArrayList<>();
            }
            arr[freqCnt.get(key)].add(key);
        }

        int[] result = new int[k];
        int index = 0;

        int parseIndex = arr.length-1;
        while(parseIndex>0 && k>0){
            if(arr[parseIndex] == null) parseIndex--;
            else{
                for(int i=0; i<arr[parseIndex].size() && k>0; i++){
                    result[index] = arr[parseIndex].get(i);
                    index++;
                    k--;
                }
                parseIndex--;
            }
        }

        return result;
    }
}
