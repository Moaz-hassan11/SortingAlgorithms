public class SelectionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr, SortingStepListener listener) {
        for(int i=0; i<arr.length; i++){
            int temp;
            int indexMin = minArray(arr, i);
            temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
            
            if (listener != null) {
                listener.onStep(arr);
            }
        }
    }
    public static int minArray(int[] arr, int start){
        int res = arr[start];
        int index = start;
        for(int i=start+1; i<arr.length; i++){
            if(arr[i] < res) {
                res = arr[i];
                index = i;
            }
        }
        return index;
    }
}
