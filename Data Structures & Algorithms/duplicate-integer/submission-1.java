class Solution {
    Map<Integer,Integer> duplicates = new HashMap<>();
    public boolean hasDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(duplicates.get(nums[i])==null){
                duplicates.put(nums[i],1);
                continue;
            }
                return true;
            
        }
        return false;
    }
}
