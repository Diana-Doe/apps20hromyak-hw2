package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void createList() {
        Object[] arr = {1, 'a', -3.2, "apple"};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object[] expResult1 = {1, 'a', -3.2, "apple"};

        assertArrayEquals(expResult1, list.toArray());

        ImmutableLinkedList emptyList = new ImmutableLinkedList(new Object[0]);
        Object[] expResult2 = {};

        assertArrayEquals(expResult2, emptyList.toArray());

        ImmutableLinkedList oneList = new ImmutableLinkedList('a');
        Object[] expResult3 = {'a'};

        assertArrayEquals(expResult3, oneList.toArray());
    }

    @Test
    public void addElement() {
        Object[] arr = {1, 2, 3};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList empty = new ImmutableLinkedList();
        Object[] expResult1 = {1, 2, 3};
        Object[] expResult2 = {1, 2, 3, 4};
        Object[] expResult3 = {4};

        ImmutableLinkedList newList1 = list.add(4);
        ImmutableLinkedList newList2 = empty.add(4);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult2, newList1.toArray());
        assertArrayEquals(expResult3, newList2.toArray());
    }

    @Test
    public void addElementIndex() {
        Object[] arr = {1, 2, 3};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object[] expResult1 = {1, 2, 3};
        Object[] expResult2 = {1, 4, 2, 3};

        ImmutableLinkedList newList = list.add(1,4);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addElementIndexEx() {
        ImmutableLinkedList list = new ImmutableLinkedList();

        list.add(1,4);
    }

    @Test
    public void addElements() {
        Object[] arr = {"apple", "milk", "cookies"};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object[] addList = {"banana", "carrot"};
        Object[] expResult1 = {"apple", "milk", "cookies"};
        Object[] expResult2 = {"apple", "milk", "cookies", "banana", "carrot"};

        ImmutableLinkedList newList = list.addAll(addList);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());

        ImmutableLinkedList empty = new ImmutableLinkedList();
        Object[] expResult3 = {"banana", "carrot"};

        ImmutableLinkedList newList2 = empty.addAll(addList);

        assertArrayEquals(expResult3, newList2.toArray());
    }

    @Test
    public void addElementsIndex() {
        Object[] arr = {"apple", "milk", "cookies"};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object[] addList = {"banana", "carrot"};
        Object[] expResult1 = {"apple", "milk", "cookies"};
        Object[] expResult2 = {"apple", "banana", "carrot", "milk", "cookies"};

        ImmutableLinkedList newList = list.addAll(1, addList);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addElementsIndexEx() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        Object[] els = {1, 2};
        list.add(1, els);
    }

    @Test
    public void getElement() {
        Object[] arr = {'a', 'b', 'c'};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);

        assertEquals('a', list.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementEx() {
        Object[] arr = {'a', 'b', 'c'};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);

        list.get(4);
    }

    @Test
    public void remove() {
        Object[] arr = {'a', 'b', 'c'};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object[] expResult1 = {'a', 'b', 'c'};
        Object[] expResult2 = {'a', 'c'};

        ImmutableLinkedList newList = list.remove(1);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeEx() {
        Object[] arr = {'a', 'b', 'c'};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);

        list.remove(4);
    }

    @Test
    public void setElement() {
        Object[] arr = {1.0, 1.5, 1.2};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object[] expResult1 = {1.0, 1.5, 1.2};
        Object[] expResult2 = {1.0, 1.1, 1.2};

        ImmutableLinkedList newList = list.set(1, 1.1);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setElementEx() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list.set(0, 1.1);
    }

    @Test
    public void indexOf() {
        Object[] arr = {'b', 1, "apple"};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        int expResult1 = 2;
        int expResult2 = -1;

        int actualResult1 = list.indexOf("apple");
        int actualResult2 = list.indexOf('a');

        assertEquals(expResult1, actualResult1);
        assertEquals(expResult2, actualResult2);

        ImmutableLinkedList empty = new ImmutableLinkedList();
        int actualResult3 = empty.indexOf('e');

        assertEquals(expResult2, actualResult3);
    }

    @Test
    public void size() {
        Object[] arr = {'b', 1, "apple"};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList empty = new ImmutableLinkedList();
        int expResult1 = 3;
        int expResult2 = 0;

        int actualResult1 = list.size();
        int actualResult2 = empty.size();

        assertEquals(expResult1, actualResult1);
        assertEquals(expResult2, actualResult2);
    }

    @Test
    public void clear() {
        Object[] arr = {'b', 1, "apple"};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);

        Object[] actualResult = list.clear().toArray();

        assertEquals(actualResult.length, 0);
    }

    @Test
    public void isEmpty() {
        Object[] arr = {'b', 1, "apple"};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        ImmutableLinkedList empty = new ImmutableLinkedList();

        assertFalse(list.isEmpty());
        assertTrue(empty.isEmpty());
    }

    @Test
    public void toArray() {
        Object[] arr = {'b', 1, "apple"};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);

        assertArrayEquals(arr, list.toArray());
    }

    @Test
    public void String() {
        Object[] arr = {-0.2, 'a', "apple", 1};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        String expResult1 = "-0.2, a, apple, 1";

        String actualResult1 = list.toString();

        assertEquals(expResult1, actualResult1);

        ImmutableLinkedList empty = new ImmutableLinkedList();
        String expResult2 = "";

        String actualResult2 = empty.toString();

        assertEquals(expResult2, actualResult2);
    }

    @Test
    public void getFirst() {
        Object[] arr = {1, 2, 3};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object expResult1 = 1;

        Object actualResult1 = list.getFirst();

        assertEquals(expResult1, actualResult1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void GetFirstEx() {
        ImmutableLinkedList empty = new ImmutableLinkedList();
        empty.getFirst();
    }

    @Test
    public void getLast() {
        Object[] arr = {1, 2, 3};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object expResult = 3;

        Object actualResult = list.getLast();

        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void GetLastEx() {
        ImmutableLinkedList empty = new ImmutableLinkedList();
        empty.getLast();
    }

    @Test
    public void addFirst() {
        Object[] arr = {1, 2, 3};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object[] expResult = {0, 1, 2, 3};

        Object[] actualResult = list.addFirst(0).toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void addLast() {
        Object[] arr = {1, 2, 3};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object[] expResult = {1, 2, 3, 4};

        Object[] actualResult = list.addLast(4).toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void removeFirst() {
        Object[] arr = {1, 2};
        ImmutableLinkedList list1 = new ImmutableLinkedList(arr);
        ImmutableLinkedList list2 = new ImmutableLinkedList('a');
        Object[] expResult1 = {2};
        Object[] expResult2 = {};

        Object[] actualResult1 = list1.removeFirst().toArray();
        Object[] actualResult2 = list2.removeFirst().toArray();

        assertArrayEquals(expResult1, actualResult1);
        assertArrayEquals(expResult2, actualResult2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void RemoveFirstEx() {
        ImmutableLinkedList empty = new ImmutableLinkedList();
        empty.removeFirst();
    }

    @Test
    public void removeLast() {
        Object[] arr = {1, 2, 3};
        ImmutableLinkedList list = new ImmutableLinkedList(arr);
        Object[] expResult = {1, 2};

        Object[] actualResult = list.removeLast().toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void RemoveLastEx() {
        ImmutableLinkedList empty = new ImmutableLinkedList();
        empty.removeLast();
    }

}
