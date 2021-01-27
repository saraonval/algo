package uppgift4;

public class PhoneEntry implements Comparable<PhoneEntry> {

    public String firstName, lastName, number;

    public PhoneEntry(String f, String l, String n) {
        firstName = f;
        lastName = l;
        number = n;
    }

    @Override
    public int compareTo(PhoneEntry e) {
        if (lastName.compareTo(e.lastName) == 0) {
            return firstName.compareTo(e.firstName);
        } else {
            return lastName.compareTo(e.lastName);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + number;
    }

}
