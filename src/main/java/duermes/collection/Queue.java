package duermes.collection;

public class Queue<E> {
    protected int first, last;
    protected E[] queue;
    int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = (E[]) new Object[capacity];
        init();
    }
    public Queue() {
        init();
        capacity = 4;
        queue = (E[]) new Object[capacity];
    }
    public E offer(E element) {
        // enqueue
        if (last == queue.length-1) {
            grow();
        }
        queue[++last] = element;
        if (first == -1) {
            first++;
        }

        return element;
    }

    public E poll() {
        //dequeue
        if (isEmpty()) {
            return null;
        }
        E value = queue[first];
        for (int i = 0; i < last; i++) {
            queue[i] = queue[i+1];
        }
        queue[last--] = null;
        if (last < 0) {
            init();
        } else if (queue.length < queue.length/4 && queue.length > 1) {
            shrink();
        }
        return value;

    }

    public E pollAsStack() {
        //dequeue
        if (isEmpty()) {
            return null;
        }
        E value = queue[last];
        queue[last--] = null;
        if (last < 0) {
            init();
        } else if (queue.length < queue.length/4 && queue.length > 1) {
            shrink();
        }
        return value;

    }

    public Object peek () {
        // Ver el primer elemento en nuestra cola
        if (!isEmpty()) {
            return queue[first];
        } else {
            return null;
        }
    }


    public boolean isEmpty() {
        return first == -1;
    }

    private void init() {
        first = -1;
        last = -1;
    }
    public int size() {
        return last+1;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i <= last; i++) {
            string += queue[i] + "-";

        }

        if (string != "") {
            string = "["+string.substring(0, string.length()-1)+"]";

        } else {
            string = "[]";
        }

        return string;
    }

    public void grow() {
        int newCapacity = (int)(capacity * 2);
        E[] newArray = (E[])new Object[newCapacity];

        for (int i = 0; i < queue.length; i++) {
            newArray[i] = queue[i];
        }
        capacity = newCapacity;
        queue = newArray;

    }
    public void shrink() {
        int newCapacity = (int)(capacity / 2);
        E[] newArray = (E[])new Object[newCapacity];

        for (int i = 0; i < queue.length; i++) {
            newArray[i] = queue[i];
        }
        capacity = newCapacity;
        queue = newArray;
    }

    public Object[] getQueue() {
        return queue;
    }


}
