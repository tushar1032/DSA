package heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestADT {

    Heap heap;

    @Before
    public void init() {
        int[] arr = {5, 6, 4, 7, 3, 8, 2, 9, 1, 0};
        heap = new Heap(15, arr);
    }

    @Test
    public void testDeleteMax() {
        for (int i = 9; i >= 0; i--) {
            int max = heap.getMax();
            Assert.assertEquals(max, i);
            heap.deleteMax();
        }
    }

    @Test
    public void insertElement() {
        heap.insertElement(11);
        int max = heap.getMax();
        Assert.assertEquals(max, 11);
    }
}
