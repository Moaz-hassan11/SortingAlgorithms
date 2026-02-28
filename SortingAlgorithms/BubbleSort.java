public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr, SortingStepListener listener) {
        int n = arr.length;
        boolean swapped;
        for(int i=0; i<n-1; i++){
            swapped = false;
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    if (listener != null) {
                        listener.onStep(arr);
                    }
                }
            }
            if(!swapped)break;
        }
    }
}