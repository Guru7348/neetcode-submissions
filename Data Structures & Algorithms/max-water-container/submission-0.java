class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j=heights.length-1;
        int max = 0;
        while(i<j){
            int cap = (j-i)*Math.min(heights[i],heights[j]);
            max = Math.max(max,cap);
            if(heights[i]<heights[j]){
                i++;
            }
            else if(heights[i]>heights[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return max;
    }
}
