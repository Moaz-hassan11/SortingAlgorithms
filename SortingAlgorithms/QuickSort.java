public class QuickSort implements SortingAlgorithm{
    public static int partition(int[]arr, int p, int q, SortingStepListener listener){
        int pivot = arr[q];
        int i = p-1, j, temp;
        for(j=p; j<q; j++){
            if(arr[j] <= pivot){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if(listener != null){
                    listener.onStep(arr);
                }
            }
        }
        temp = arr[q];
        arr[q] = arr[i+1];
        arr[i+1] = temp;

        if(listener != null){
            listener.onStep(arr);
        }

        return i+1;
    }
    public static void quickSort(int[] arr, int p, int q, SortingStepListener listener){
        if(p<q){
            int r = partition(arr, p, q, listener);
            quickSort(arr, p, r-1, listener);
            quickSort(arr, r+1, q, listener);
        }
    }
    public static int[] sorting(int[] arr, SortingStepListener listener){
        quickSort(arr, 0, arr.length-1, listener);
        return arr;
    }

    @Override
    public void sort(int[] arr, SortingStepListener listener) {
        quickSort(arr, 0, arr.length-1, listener);
    }

}
