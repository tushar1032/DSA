package heap;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowProblem {

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;
        List<Integer> res = new ArrayList<>();
        int window[] = new int[windowSize];
        for (int i = 0; i < windowSize; i++) {
            window[i] = arr[i];
        }

        Heap heap = new Heap(windowSize, window);
        res.add(heap.getMax());
        for (int i = windowSize; i < arr.length; i++) {
            heap.deleteElement(arr[i - windowSize]);
            heap.insertElement(arr[i]);
            res.add(heap.getMax());
        }
        System.out.println(res);
    }
}
