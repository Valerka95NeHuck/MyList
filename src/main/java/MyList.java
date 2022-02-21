import java.util.Comparator;

/**
 * Интерфейс лист со стандартными методами, получить, положить, удалить, размер
 * очистить, проверить наличие обьекта в коллекции
 * @param <T> где Т может быть любым классом
 */


public interface MyList<T> {
    T get(int index);
    boolean add(T object);
    boolean remove(T object);
    boolean remove(int index);
    int size();
    void clear();
    boolean add(T object, int index);
    boolean contains(T object);
    void sort(Comparator<T> comparator);
    boolean set(T object, int index);
    int getIndexElement(T element);
}
