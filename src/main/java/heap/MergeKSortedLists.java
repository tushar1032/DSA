package heap;

public class MergeKSortedLists {
    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 4}, {5, 7}, {6, 8}, {9, 0}};
        int arr[] = new int[10];
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                arr[c] = a[i][j];
                c++;
            }
        }
        Heap heap = new Heap(10, arr);
        heapSort(heap);
    }

    public static void heapSort(Heap heap) {
        int[] res = new int[10];
        int c = 0;
        while (!heap.isEmpty()) {
            res[c] = heap.deleteMax();
            c++;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
