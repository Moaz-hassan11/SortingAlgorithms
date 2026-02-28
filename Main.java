public class Main {
    public static void main(String[] args) {
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        SortingAlgorithm sorter = AlgorithmFactory.getAlgorithm("Merge");
        
        sorter.sort(testArray, (arr) -> {
            for (int i : arr) System.out.print(i + " ");
            System.out.println(); 
        });
    }
}

