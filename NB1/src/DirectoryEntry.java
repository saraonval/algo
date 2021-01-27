

import java.util.Objects;

/**
 *
 * @author bfelt
 */
public class DirectoryEntry {

    public String name;
    public String number;

    public DirectoryEntry(String name, String number) {
        this.name = name;
        this.number = number;
    }

    /**
     * Returns true if directory entries are equal.
     */
    @Override
    public boolean equals(Object other) {
        if(other instanceof DirectoryEntry) {
            DirectoryEntry de = (DirectoryEntry) other;
            if(this.name.equals(de.name)) {
                return true;
            }
        }
        return false;
    }

}
