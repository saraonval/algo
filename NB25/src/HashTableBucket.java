
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saraonval
 */
public class HashTableBucket<K, V> {

    private static class Entry<K, V> {

        public K key;
        public V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }

        public String toString() {
            return key + " : " + value;
        }
    }

    private SingleLinkedList<Entry<K, V>>[] table;

    public HashTableBucket(int size) {
        table = new SingleLinkedList[size];
    }

    public V put(K key, V value) {
        int index = key.hashCode() % table.length;

        // Om index är negativ
        if (index < 0) {
            index += table.length;
        }

        // Om det är tomt
        if (table[index] == null) {

            table[index] = new SingleLinkedList<Entry<K, V>>();
            // Nu har vi en enkellänkad lista på plats index

            // På listan lägger vi till ett entry (nyckel-värde-par)
            table[index].add(new Entry<K, V>(key, value));
            return null; // För att visa att det var tomt
        } // Om det finns data på plats index
        else {
            V oldValue;
            // Går igenom den enkellänkade listan
            // Vi går inte igenom tabellen
            // table[index] är en enkellänkad lista som finns på plats index
            for (Entry<K, V> e : table[index]) {
                // På varje plats kollar vi...
                // om vi hittar nyckeln
                // om det redan finns ett element med den nyckeln
                // byter vi ut värdet med det nya
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }

            // Om nyckeln inte redan finns
            // Då lägger vi till ett nytt entry först
            table[index].add(0, new Entry<K, V>(key, value));
            
            // Rehash om antal entries överstiger 75 %
            // Vi gör rehash här eftersom det är enda stället där vi lägger till en ny entry
            if (getNoOfEntries() > 0.75 * table.length) {
                rehash();
            }
            
            return null;
        }
    }

    public V get(K key) {
        int index = key.hashCode() % table.length;

        // Om index är negativ
        if (index < 0) {
            index += table.length;
        }

        // Om null på index
        if (table[index] == null) {
            return null;
        }

        // Leta igenom listan tills vi hittar nyckeln
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    @Override
    // Default toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            sb.append("Table " + i + ": " + table[i].toString() + "\n");
        }
        return sb.toString();
    }

    // Variation of toString
    public String toString2() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < table.length; i++) {
            sb.append("Table " + i + "\n" + "**********" + "\n");
            for (Entry<K, V> e : table[i]) {
                sb.append(e.toString() + "\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //  tar bort key, value elementet om det finns och returnerar value, annars returneras null.
    public V remove(Object key) {
        int index = key.hashCode() % table.length;

        // Om index är negativ
        if (index < 0) {
            index += table.length;
        }

        // Om null på index
        if (table[index] == null) {
            return null;
        }

        Iterator iter = table[index].iterator();
        // Leta igenom listan tills vi hittar nyckeln
        for (Entry<K, V> e : table[index]) {
            iter.next();
            if (e.key.equals(key)) {
                iter.remove();
                return e.value;
            }
        }
        return null;

    }

    private int getNoOfEntries() {
        int counter = 0;
        for (int i = 0; i < table.length; i++) {
            counter += table[i].size();
            /*for (Entry<K, V> e : table[i]) {
                counter++;
            }*/
        }
        return counter;
    }
    
    private void rehash() {
        // Spara referens till gamla table
        SingleLinkedList<Entry<K,V>>[] oldTable = table;
        
        // Dubbla storleken för nya table
        // Vi sparar nya table arrayen i table, den kommer alltså att peka om
        table = new SingleLinkedList[2 * oldTable.length + 1]; 
        // Boken gör +1, för att det är bra att ha primtal som längd

        // Vi får inte glömma att initiera varje table med en ny SingleLinkedList
        // Annars får vi NullPointerExcepetion
        for(int i=0; i<table.length; i++) {
            table[i] = new SingleLinkedList<Entry<K,V>>();
        }
     
        // Ominstallera alla entries från oldTable till den expanderade table
        // På så sätt undviker vi kollisioner
        for(int i=0; i<oldTable.length; i++) {
            for(Entry<K,V> e : oldTable[i]) {
                put(e.key, e.value);
            }
        } 
    }

}
