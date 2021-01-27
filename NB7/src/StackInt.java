/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public interface StackInt<E> {
    E pop();
    E push(E obj);
    E peek();
    boolean empty();
}
