import java.util.*;

public class CollectionManager<T> {
    private List<T> list;

    private Set<T> uniqueSet;

    private Map<String, T> itemMap;

    //constructor
    public CollectionManager() {
        this.list = new ArrayList<>();
        this.uniqueSet = new HashSet<>();
        this.itemMap = new HashMap<>();
    }

    // métodos para List
    public void addToList(T item) {
        list.add(item);
    }

    public boolean removeFromList(T item) {
        return list.remove(item);
    }

    public List<T> getAllFromList() {
        return new ArrayList<>(list);
    }

    // métodos para Set
    public boolean addToSet(T item) {
        return uniqueSet.add(item);
    }

    public boolean removeFromSet(T item) {
        return uniqueSet.remove(item);
    }

    public Set<T> getAllFromSet() {
        return new HashSet<>(uniqueSet);
    }

    // métodos para Map
    public void putInMap(String key, T item) {
        itemMap.put(key, item);
    }

    public T getFromMap(String key) {
        return itemMap.get(key);
    }

    public boolean removeFromMap(String key) {
        return itemMap.remove(key) != null;
    }

    public Map<String, T> getAllFromMap() {
        return new HashMap<>(itemMap);
    }





}
