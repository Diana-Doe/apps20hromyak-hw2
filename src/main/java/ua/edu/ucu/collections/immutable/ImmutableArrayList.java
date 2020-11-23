package ua.edu.ucu.collections.immutable;


import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] list;

    public ImmutableArrayList() {
        list = new Object[0];
    }

    public ImmutableArrayList(Object element) {
        list = new Object[1];
        list[0] = element;
    }

    public ImmutableArrayList(Object[] elements) {
        list = elements.clone();
    }

    @Override
    public ImmutableArrayList add(Object e) {
        Object[] newArr = Arrays.copyOf(list, list.length + 1);
        newArr[list.length] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        Object[] newArr = Arrays.copyOf(list, list.length + 1);
        for (int i = 0; i < newArr.length; i++) {
            if (index > i) {
                newArr[i] = list[i];
            } else if (index == i) {
                newArr[i] = e;
            } else {
                newArr[i] = list[i - 1];
            }
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        Object[] newArr = new Object[list.length + c.length];
        System.arraycopy(list, 0, newArr, 0, list.length);
        System.arraycopy(c, 0, newArr, list.length, c.length);
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        Object[] newArr = new Object[list.length + c.length];
        System.arraycopy(list, 0, newArr, 0, index);
        System.arraycopy(c, 0, newArr, index, c.length);
        System.arraycopy(list, index, newArr,
                index + c.length, list.length - index);
        return new ImmutableArrayList(newArr);
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        Object[] newArr = new Object[list.length - 1];
        System.arraycopy(list, 0, newArr, 0, index);
        System.arraycopy(list, index + 1, newArr,
                index, list.length - index - 1);
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        Object[] newArr = list.clone();
        newArr[index] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return list.length == 0;
    }

    @Override
    public Object[] toArray() {
        return list.clone();
    }

    @Override
    public String toString() {
        if (list.length == 0) {
            return "";
        }
        String str = new String();
        for (Object el: list) {
            str += el + ", ";
        }
        return str.substring(0, str.length() - 2);
    }
}
