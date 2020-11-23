package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void test1() {
        Stack stack = new Stack();
        stack.push('a');
        stack.push(-2.9);
        stack.push(1);
        assertEquals(1, stack.pop());
        assertEquals(-2.9, stack.pop());
        assertEquals('a', stack.pop());
    }

    @Test
    public void test2() {
        Stack stack = new Stack();
        stack.push('a');
        stack.push(-2.9);
        assertEquals(-2.9, stack.peek());
        stack.pop();
        assertEquals('a', stack.peek());
    }
    
}
