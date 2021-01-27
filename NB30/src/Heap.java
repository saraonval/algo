
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saraonval
 */

import java.util.Arrays;

public class Heap<E extends Comparable<E>> {
    private int size;
    private E[] data;
    private int nextPos;

    public Heap(int size) {
        this.size = size;
        data = (E[]) new Comparable[size];
        nextPos = 0;
    }

    public boolean insert(E element) {
        if(size == nextPos){
            reallocate();
        }
        data[nextPos] = element;
        int pos = nextPos;
        int parent = (pos-1)/2;
        while(data[parent].compareTo(data[pos]) > 0 && pos > 0){
            E temp = data[parent];
            data[parent] = data[pos];
            data[pos] = temp;
            pos = parent;
            parent = (pos-1)/2;
        }
        nextPos++;
        return true;
    }

    public E extract() {
        E result = data[0];
        data[0] = data[nextPos-1];
        int pos =  0;
        int leftChild = 2*pos+1;
        int rightChild = 2*pos+2;
        while((leftChild<nextPos && rightChild<nextPos) && (data[pos].compareTo(data[leftChild])>0 || data[pos].compareTo(data[rightChild])>0)){
            if(data[leftChild].compareTo(data[rightChild]) < 0){
                E temp = data[leftChild];
                data[leftChild] = data[pos];
                data[pos] = temp;
                pos = leftChild;
                leftChild = 2*pos+1;
                rightChild = 2*pos+2;
            }
            else{
                E temp = data[rightChild];
                data[rightChild] = data[pos];
                data[pos] = temp;
                pos = rightChild;
                leftChild = 2*pos+1;
                rightChild = 2*pos+2;
            }
        }
        nextPos--;
        return result;
    }

    private void reallocate(){
        size *= 2;
        data = Arrays.copyOf(data, size);
    }

    public void print(){
        System.out.print("[");
        System.out.print(data[0]);
        for(int i = 1; i < nextPos; i++){
            if(data[i] != null){
                System.out.print(" " + data[i]);
            }
        }
        System.out.println("]");
    }
}

/*
public class Heap<E extends Comparable<E>> {

    private int size;
    private E[] data;
    private int nextPos;

    public Heap(int size) {
        this.size = size;
        data = (E[]) new Comparable[size];
        nextPos = 0;
    }
    
    public int size() {
        return nextPos;
    }

    // Sätt in nytt element på första lediga plats
    public boolean insert(E element) {

        // Kolla om size överskridits
        if (nextPos == size) {
            reallocate();
        }

        data[nextPos] = element; // första lediga platsen
        // fixa
        fixInsert(nextPos);
        nextPos++;
        return true;
    }

    // Medans elementet inte är i rotnoden och elementets nyckel är mindre än förälderns nyckel:
    // byt plats på förälder och elementet
    private void fixInsert(int p) {
        int parent = (p - 1) / 2;
        if (p != 0 && data[p].compareTo(data[parent]) < 0) {
            swap(p, parent);
            fixInsert(parent);
        }
    }

    public E extract() {
        if (nextPos == 0) {
            throw new IllegalStateException();
        }
        E removedElement = data[0];
        data[0] = data[size - 1];
        nextPos--;
        fixExtract(0);
        return removedElement;
    }

    private void fixExtract(int s) {
        // Steg 2:
        // Så länge S har barn och S har mindre nyckel än något av sina barn:
        // swappa S med största barnet

        int leftChild = 2 * s + 1;
        int rightChild = 2 * s + 2;

        // Om S har vänster barn
        // rot = minst nyckel
        // barn = högre nyckel
        // s saknar left child
        if (leftChild > size - 1) {
            return;
        }

        // s saknar höger barn
        if (rightChild > size - 1) {
            // kolla om s har större nyckel än vänster barn
            if (data[s].compareTo(data[leftChild]) < 0) {
                swap(s, leftChild);
                fixExtract(leftChild);
            }
            return;
        }

        // Vänster barn < höger barn
        if (data[leftChild].compareTo(data[rightChild]) < 0) {
            if (data[s].compareTo(data[rightChild]) < 0) {
                swap(s, rightChild);
                fixExtract(rightChild);
            }
            // s har större nyckel än vänster barn
            if (data[s].compareTo(data[leftChild]) < 0) {
                swap(s, leftChild); // byt s med vänster barn
                fixExtract(leftChild); // s är nu vänster barn
            }
        } 
        // annars är vänster barn > höger barn
        // s har större nyckel än vänster barn
        else if (data[s].compareTo(data[leftChild]) < 0) {
            swap(s, leftChild); // byt s med vänster barn
            fixExtract(leftChild); // s är nu vänster barn
        }
    }

    private void reallocate() {
        size *= 2;
        data = Arrays.copyOf(data, size);
    }

    private void swap(int index1, int index2) {
        E tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

}
*/