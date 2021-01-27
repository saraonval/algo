/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
// HashTableOpen med Öppen Adressering
public class HashTableOpen<K, V> {

    private static class Entry<K, V> {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " : " + value;
        }
    }

    private Entry<K, V>[] table;
    private static final int START_CAPACITY = 101;
    private static final double LOAD_THRESHOLD = 0.75;
    private int noOfKeys;
    private int noOfDeletes;
    private final Entry<K, V> DELETED = new Entry<K, V>(null, null); // dummy

    // Konstruktor
    public HashTableOpen() {
        table = new Entry[START_CAPACITY];
    }

    public V get(Object key) {
        // hitta första elementet som är tomt eller innehåller nyckeln
        int index = find(key);

        // om sökningen är lyckad, returnera värdet
        if (table[index] != null) {
            return table[index].value;
        } else {
            return null;
        }
    }

    public V put(K key, V value) {
        // hitta första elementet som är tomt eller innehåller nyckeln
        int index = find(key);

        // om elementet var tomt, lägg till en ny
        if (table[index] == null) {
            table[index] = new Entry<K, V>(key, value);
            noOfKeys++;

            // Kolla om rehash behövs
            double loadFactor = (double) (noOfKeys + noOfDeletes) / table.length;
            if (loadFactor > LOAD_THRESHOLD) {
                rehash();
            }
            return null;
        } else {
            // assert: table element that contains the key was found
            // replace value for this key
            V oldValue = table[index].value;
            table[index].value = value;
            return oldValue;
        }
    }

    public V remove(Object key) {
        // hitta första elementet som är tomt eller innehåller nyckeln
        int index = find(key);

        // om elementet var tomt, 
        if (table[index] == null) {
            return null;
        }

        // Key was found
        // Save the old value
        V oldValue = table[index].value;
        table[index] = DELETED;
        noOfDeletes++;
        noOfKeys--;
        return oldValue;
    }

    private int find(Object key) {
        int index = key.hashCode() % table.length;

        if (index < 0) {
            index += table.length;  // så att den blir positiv
        }

        // inkremera index tills en plats blir tom eller tills vi hittat nyckeln
        while (table[index] != null) {

            // hoppa ur loopen om vi hittar nyckeln
            if (key.equals(table[index].key)) {
                break;
            }

            index++;

            // check for wrap-around
            if (index >= table.length) {
                index += 0; // wrap-around
            }
        }
        return index;
    }

    private void rehash() {

        // Save a reference to the old table
        Entry<K, V>[] oldTable = table;

        // Double the capacity of this table
        table = new Entry[2 * oldTable.length + 1]; // + 1 för att bli primtal

        // Reinsert all items in old table into the expanded table
        noOfKeys = 0;
        noOfDeletes = 0;

        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null) && (oldTable[i]) != DELETED) {
                // Insert entry in expanded table
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append(table[i].toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
