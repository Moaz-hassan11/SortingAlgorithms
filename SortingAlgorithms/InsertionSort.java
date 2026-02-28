public class InsertionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr, SortingStepListener listener) {
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<i; j++){
                if(arr[j] <= arr[i])continue;
                int replacing = arr[i];
                for(int k=i; k>j; k--){
                    arr[k] = arr[k-1];
                }
                arr[j] = replacing;
                if (listener != null) {
                    listener.onStep(arr);
                }
                break;
            }
        }
    }
}
