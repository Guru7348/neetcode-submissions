class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] numsleft = new int[size];
        int[] numsright = new int[size];
        numsleft[0] = 1;
        numsright[size-1]= 1;
        for (int i=1;i<size;i++){
            numsleft[i] =  numsleft[i-1] * nums[i-1];
            numsright[size-i-1] = numsright[size-i] * nums[size-i];
        }
        for(int i=0;i<size;i++){
            nums[i] = numsleft[i] * numsright[i];
        }
        return nums;
    }
}  
