public class AlgorithmFactory {
    public static SortingAlgorithm getAlgorithm(String type) {
        return switch (type) {
            case "Bubble" -> new BubbleSort();
            case "Selection" -> new SelectionSort();
            case "Insertion" -> new InsertionSort();
            case "Merge" -> new MergeSort();
            case "Quick" -> new QuickSort();
            case "Heap" -> new HeapSort();
            default -> throw new IllegalArgumentException("Unknown Algorithm");
        };
    }
}