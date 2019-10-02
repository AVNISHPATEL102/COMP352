public class ArrayStack<E> implements Stack<E>

{

    public static int CAPACITY = 100;

    private E[] data;

    private int len = -1;

    public ArrayStack()

    {

        this(CAPACITY);

    }

    public ArrayStack(int capacity)

    {

        data = (E[]) new Object[capacity];

    }

    public int size()

    {

        return (len + 1);

    }

    public boolean isEmpty()

    {

        return (len == -1);

    }

    public void push(E e) throws IllegalStateException

    {

    //if stack is full then double size of the stack

        if (size() == data.length)

            doubleArraySize();

        data[++len] = e;

    }

    public E top()

    {

        if (isEmpty()) return null;

        return data[len];

    }

    public E pop()

    {

        if (isEmpty()) return null;

        E answer = data[len];

        data[len] = null;

        len--;

        return answer;

    }

    //double the size of the stack

    private void doubleArraySize()

    {

    CAPACITY = 2*CAPACITY;

    E[] tmp = (E[]) new Object[CAPACITY];

        System.arraycopy(tmp,0,data,0,data.length);

        System.out.println(tmp.length);

        data = tmp;

    }

}

