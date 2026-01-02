
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the  index and value of array.  
        HashMap <Integer, Integer> hashMap = new HashMap<>(); 
        // Iterate over the array.   
        for(int i=0; i<nums.length; i++){
            //get a complement of target - index 
            int remainingValue = target-nums[i]; 
            // If it matches the value of the hashmap then return the indexes. 
            if(hashMap.containsKey(remainingValue)){
                return new int[]{ hashMap.get(remainingValue), i};
            }
            // for putting value in hashmap 
             hashMap.put(nums[i], i);

        }  
        //return empty array if not found. 
        return new int[]{};

    }
}