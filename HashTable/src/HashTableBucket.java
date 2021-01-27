public class HashTableBucket<K,V> {

    private SingleLinkedList<Entry<K,V>>[] table;
    private static final float MAX_LOAD = 0.75f;
    private int nrEntries, capacity;

    public HashTableBucket(int size){
        capacity = size;
        nrEntries = 0;
        table = new SingleLinkedList[size];
    }

    public V put(K key, V value){
        int index = key.hashCode()%table.length;
        if (index < 0) index += table.length;
        if (table[index] == null) {
            table[index] = new SingleLinkedList<Entry<K,V>>();
            table[index].add(new Entry<K, V>(key,value));
            return null;
        } else {
            V oldValue;
            for (Entry<K,V> entry : table[index]){
                if (entry.key.equals(key)){
                    oldValue = entry.value;
                    entry.value = value;
                    return oldValue;
                }
            }
            table[index].add(0,new Entry<K, V>(key,value));
            nrEntries++;
            if (nrEntries > capacity*MAX_LOAD) rehash();
            return null;
        }
    }

    private void rehash() {
        capacity *= 2;
        SingleLinkedList<Entry<K,V>>[] oldTable = table;
        table = new SingleLinkedList[capacity];
        nrEntries = 0;
        for (SingleLinkedList<Entry<K,V>> list : oldTable){
            if (list != null){
                for (Entry<K,V> entry : list){
                    put(entry.key,entry.value);
                }
            }
        }
    }

    public V get(K key){
        int index = key.hashCode()%table.length;
        if (index < 0) index += table.length;
        if (table[index] == null) return null;
        else {
            for (Entry<K,V> entry : table[index]){
                if (entry.key.equals(key)) return entry.value;
            }
            return null;
        }
    }

    public boolean remove(K key){
        int index = key.hashCode()%table.length;
        if (index < 0) index += table.length;
        return false;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<table.length;i++){
            if (table[i] != null) {
                stringBuilder.append("Row " + i + ": " + table[i].toString());
                stringBuilder.append("\n");
            } else {
                stringBuilder.append("Row " + i + ": " + "null");
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private static class Entry<K,V>{
        private K key;
        private V value;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "Key: " + key + " : " + "Value: " + value;
        }
    }
}