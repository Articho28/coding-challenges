

public class RotateArray {

    /**
     * Rotates array by k steps.
     * Question asked here: https://leetcode.com/problems/rotate-array/
      * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        // Avoid rotating over entire array
        k = k % nums.length;
        //If k == 0 or length is one, array already in place
        if (k == 0 || nums.length == 1) {

        } else {
            int index = 0;
            int stop = 0;
            int place = nums[index];
            int store = 0;
            int next = 0;
            // For every element, get its next index.
            // If we've already seen this location, offset by one and continue until all are treated.
            for (int i = 0; i < nums.length; i++) {
                next = (index + k) % nums.length;
                if (next == stop) {
                    nums[next] = place;
                    stop = (next + 1) % nums.length;
                    index = stop;
                    place = nums[stop];
                } else {
                    store = nums[next];
                    nums[next] = place;
                    place = store;
                    index = next;
                }
            }
        }
    }
}
