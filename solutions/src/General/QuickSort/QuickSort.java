import java.util.Arrays;


public class QuickSort {
    
    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length -1);
    }

    public static void quicksort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index - 1);
        quicksort(array, index, right);

    }

    public static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                //Implemented my own swap but can import from Collections too.
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, 9, 3, 8};
        System.out.println(Arrays.toString(nums));

        quicksort(nums);
        
        System.out.println(Arrays.toString(nums));
    }

}