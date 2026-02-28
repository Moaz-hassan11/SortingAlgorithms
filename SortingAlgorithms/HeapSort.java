public class HeapSort implements SortingAlgorithm {
    public void hepify(int[] arr, int n, int i, SortingStepListener listener){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && arr[l] > arr[largest])largest = l;
        if(r<n && arr[r] > arr[largest])largest = r;

        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            if (listener != null) {
                listener.onStep(arr);
            }
            hepify(arr, n, largest, listener);
        }
    }
    public void buildHeap(int[] arr, SortingStepListener listener){
        int n = arr.length;
        int start = n/2 - 1;

        for(int i=start; i>=0; i--)hepify(arr, n, i, listener);
    }

    public int[] sorting(int[] arr, SortingStepListener listener){
        int n = arr.length;
        for(int i=n-1; i>=1; i--){
            int temp = arr[i];
            arr[i] = arr[0]; 
            arr[0] = temp;
            if (listener != null) listener.onStep(arr);
            hepify(arr, i, 0, listener);
        }
        return arr;
    }

    @Override
    public void sort(int[] arr, SortingStepListener listener) {
        buildHeap(arr, listener);
        sorting(arr, listener);
    }
}
