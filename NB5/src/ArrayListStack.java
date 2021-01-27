
import java.util.ArrayList;
import java.util.EmptyStackException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class ArrayListStack<E> implements StackInt<E> {

    private ArrayList<E> data;
    private int top;
    
    public ArrayListStack() {
        top = -1;   // !!!
        data = new ArrayList<E>();
    }
    
    @Override
    public E pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        E old = data.remove(top);
        top--;
        return old;
    }

    @Override
    public E push(E obj) {
        top++;
        data.add(top, obj);
        return obj;
    }

    @Override
    public E peek() {
        if(empty()) {
            throw new EmptyStackException();
        }  
        return data.get(top);
    }

    @Override
    public boolean empty() {
        return top == -1;
    }
    
}
