// Solution 1
/*
    Time complexity: O(n^2)
    Space complexity: O(1)
*/
class Solution {
    /*
    The brute force approach
    Loop through each element x in "nums" and find
    if there is another value that equals to target−x
    */
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] intArray = new int[]{ i, j }; 
                    return intArray;
                }
            }
        }
        //in case there is no solution return null
        return null;
    }
}


// Solution 2
/*
    Time complexity: O(n)
    Space complexity: O(n)
*/
class Solution {
    /*
    We iterate and insert elements into the hash table,
    and at the same time we look back to check if current element complement
    already exists in the hash table. If it exists, we have found a solution and return the indices immediately
    */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            //first item in the list and we can add it to hashmap immediately
            if (i == 0) {
                numsMap.put(nums[i], i);
            } else {
                int get = target - nums[i]; //value we need to get to the target
                Integer key = numsMap.get(get);
                //if found element in need, you can return it
                if (key != null) {
                    int[] intArray = new int[]{ i, key };
                    return intArray;
                } else {
                    numsMap.put(nums[i], i);
                }
            }
        }
        //in case there is no solution return null
        return null;
    }
}
