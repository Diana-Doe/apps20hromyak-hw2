package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void createList() {
        Object[] arr = {1, 'a', -3.2, "apple"};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        Object[] expResult1 = {1, 'a', -3.2, "apple"};

        assertArrayEquals(expResult1, list.toArray());

        ImmutableArrayList emptyList = new ImmutableArrayList();
        Object[] expResult2 = {};

        assertArrayEquals(expResult2, emptyList.toArray());

        ImmutableArrayList oneList = new ImmutableArrayList('a');
        Object[] expResult3 = {'a'};

        assertArrayEquals(expResult3, oneList.toArray());
    }

    @Test
    public void addElement() {
        Object[] arr = {1, 2, 3};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        Object[] expResult1 = {1, 2, 3};
        Object[] expResult2 = {1, 2, 3, 4};

        ImmutableArrayList newList = list.add(4);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());
    }

    @Test
    public void addElementIndex() {
        Object[] arr = {1, 2, 3};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        Object[] expResult1 = {1, 2, 3};
        Object[] expResult2 = {1, 4, 2, 3};

        ImmutableArrayList newList = list.add(1,4);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addElementIndexEx() {
        ImmutableArrayList list = new ImmutableArrayList();

        list.add(1,4);
    }

    @Test
    public void addElements() {
        Object[] arr = {"apple", "milk", "cookies"};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        Object[] addList = {"banana", "carrot"};
        Object[] expResult1 = {"apple", "milk", "cookies"};
        Object[] expResult2 = {"apple", "milk", "cookies", "banana", "carrot"};

        ImmutableArrayList newList = list.addAll(addList);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());
    }

    @Test
    public void addElementsIndex() {
        Object[] arr = {"apple", "milk", "cookies"};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        Object[] addList = {"banana", "carrot"};
        Object[] expResult1 = {"apple", "milk", "cookies"};
        Object[] expResult2 = {"apple", "banana", "carrot", "milk", "cookies"};

        ImmutableArrayList newList = list.addAll(1, addList);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addElementsIndexEx() {
        ImmutableArrayList list = new ImmutableArrayList();
        Object[] els = {1, 2};
        list.add(1, els);
    }

    @Test
    public void getElement() {
        Object[] arr = {'a', 'b', 'c'};
        ImmutableArrayList list = new ImmutableArrayList(arr);

        assertEquals('a', list.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementEx() {
        Object[] arr = {'a', 'b', 'c'};
        ImmutableArrayList list = new ImmutableArrayList(arr);

        list.get(4);
    }

    @Test
    public void remove() {
        Object[] arr = {'a', 'b', 'c'};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        Object[] expResult1 = {'a', 'b', 'c'};
        Object[] expResult2 = {'a', 'c'};

        ImmutableArrayList newList = list.remove(1);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeEx() {
        Object[] arr = {'a', 'b', 'c'};
        ImmutableArrayList list = new ImmutableArrayList(arr);

        list.remove(4);
    }

    @Test
    public void setElement() {
        Object[] arr = {1.0, 1.5, 1.2};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        Object[] expResult1 = {1.0, 1.5, 1.2};
        Object[] expResult2 = {1.0, 1.1, 1.2};

        ImmutableArrayList newList = list.set(1, 1.1);

        assertArrayEquals(expResult1, list.toArray());
        assertArrayEquals(expResult1, arr);
        assertArrayEquals(expResult2, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setElementEx() {
        ImmutableArrayList list = new ImmutableArrayList();
        list.set(0, 1.1);
    }

    @Test
    public void indexOf() {
        Object[] arr = {'b', 1, "apple"};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        int expResult1 = 2;
        int expResult2 = -1;

        int actualResult1 = list.indexOf("apple");
        int actualResult2 = list.indexOf('a');

        assertEquals(expResult1, actualResult1);
        assertEquals(expResult2, actualResult2);
    }

    @Test
    public void size() {
        Object[] arr = {'b', 1, "apple"};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList empty = new ImmutableArrayList();
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
        ImmutableArrayList list = new ImmutableArrayList(arr);

        Object[] actualResult = list.clear().toArray();

        assertEquals(actualResult.length, 0);
    }

    @Test
    public void isEmpty() {
        Object[] arr = {'b', 1, "apple"};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList empty = new ImmutableArrayList();

        assertFalse(list.isEmpty());
        assertTrue(empty.isEmpty());
    }

    @Test
    public void toArray() {
        Object[] arr = {'b', 1, "apple"};
        ImmutableArrayList list = new ImmutableArrayList(arr);

        assertArrayEquals(arr, list.toArray());
    }

    @Test
    public void String() {
        Object[] arr = {-0.2, 'a', "apple", 1};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        String expResult1 = "-0.2, a, apple, 1";

        String actualResult1 = list.toString();

        assertEquals(expResult1, actualResult1);

        ImmutableArrayList empty = new ImmutableArrayList();
        String expResult2 = "";

        String actualResult2 = empty.toString();

        assertEquals(expResult2, actualResult2);
    }
}
