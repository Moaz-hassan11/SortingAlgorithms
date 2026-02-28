import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr, SortingStepListener listener) {
        int[] sorted = mergeSort(arr, listener);
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }

    public static int[] mergeSort(int[]arr, SortingStepListener listener){
        if(arr.length<=1)return arr;

        int mid = arr.length/2;
        int[] arrLeft = Arrays.copyOfRange(arr, 0, mid);
        int[] arrRight = Arrays.copyOfRange(arr, mid, arr.length);

        arrLeft = mergeSort(arrLeft, listener);
        arrRight = mergeSort(arrRight, listener);

        return merge(arrLeft, arrRight, listener);
    }

    public static int[] merge(int[]a, int[]b, SortingStepListener listener){
        int index1 = 0;
        int index2 = 0;
        int counter = 0;
        int[] result = new int[a.length+b.length];
        
        while(index1 < a.length && index2 < b.length){
            if(a[index1] <= b[index2]) result[counter++] = a[index1++];
            else result[counter++] = b[index2++];
        }
        while(index1 < a.length) result[counter++] = a[index1++];
        while(index2 < b.length) result[counter++] = b[index2++];
        if (listener != null) {
            listener.onStep(result);
        }
        
        return result;
    }
}
