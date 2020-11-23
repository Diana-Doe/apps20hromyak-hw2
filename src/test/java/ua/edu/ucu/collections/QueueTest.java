package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void test1() {
        Queue queue = new Queue();
        queue.enqueue('a');
        queue.enqueue(-2.9);
        queue.enqueue(1);

        assertEquals('a', queue.dequeue());
        assertEquals(-2.9, queue.dequeue());
        assertEquals(1, queue.dequeue());
    }

    @Test
    public void test2() {
        Queue queue = new Queue();
        queue.enqueue('a');
        queue.enqueue(-2.9);

        assertEquals('a', queue.peek());
        queue.dequeue();
        assertEquals(-2.9, queue.peek());
    }
}
