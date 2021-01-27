/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class PhoneEntry implements Comparable {

    public String firstName, lastName, number;

    public PhoneEntry(String f, String l, String n) {
        firstName = f;
        lastName = l;
        number = n;
    }
    
    /*
    @Override
    public int compareTo(PhoneEntry e) {
        if (lastName.compareTo(e.lastName) == 0) {
            return firstName.compareTo(e.firstName);
        } else {
            return lastName.compareTo(e.lastName);
        }
    }*/

    @Override
    public String toString() {
        return firstName.toString() + " " + lastName.toString() + " " + number.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof PhoneEntry) {
                PhoneEntry e = (PhoneEntry) o; // cast
        if (lastName.compareTo(e.lastName) == 0) {
            return firstName.compareTo(e.firstName);
        } else {
            return lastName.compareTo(e.lastName);
        }
        }
        return -1;
    }

}
