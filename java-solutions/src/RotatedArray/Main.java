import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(nums));
        sol.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        
    }
}
