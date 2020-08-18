package heap;

import java.util.Arrays;

public class Heap {
    private int capacity;
    private int[] arr;
    private int count;

    public Heap(int capacity, int[] arr) {
        this.capacity = capacity;
        this.count = arr.length - 1;
        this.arr = Arrays.copyOf(arr, capacity);
        buildHeap();
    }

    private void buildHeap() {
        for (int i = ((arr.length - 1) / 2); i >= 0; i--) {
            heapify(i);
        }
    }

    public int getMax() {
        return arr[0];
    }

    public int deleteMax() {
        int key = arr[0];
        arr[0] = arr[count];
        heapify(0);
        count--;
        return key;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int deleteElementAtPos(int i) {
        int key = arr[i];
        arr[i] = arr[count];
        heapify(i);
        count--;
        return key;
    }

    public int deleteElement(int key) {
        int res = search(key);
        if (res == -1) {
            return -1;
        }
        return deleteElementAtPos(res);
    }

    private int search(int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public int insertElement(int key) {
        if (count == capacity) {
            return -1;
        }
        arr[++count] = key;
        percolateUp(count);
        return key;
    }

    private void percolateUp(int i) {
        int parent = i / 2;
        if (arr[i] > arr[parent]) {
            switchElements(i, parent);
            percolateUp(parent);
        }
    }

    private void heapify(int i) {
        int left = getLeft(i);
        int right = getRight(i);
        int max = i;
        if (left != -1 && (arr[max] < arr[left])) {
            max = left;
        }
        if (right != -1 && (arr[max] < arr[right])) {
            max = right;
        }
        if (max != i) {
            switchElements(i, max);
            heapify(max);
        }
    }

    private void switchElements(int i, int max) {
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
    }

    private int getRight(int i) {
        int right = 2 * i + 1;
        return right < count ? right : -1;
    }

    private int getLeft(int i) {
        int left = 2 * i;
        return left < count ? left : -1;
    }
}
