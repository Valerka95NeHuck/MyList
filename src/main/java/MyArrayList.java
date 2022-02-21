import java.util.Arrays;
import java.util.Comparator;

/**
 * Динамический массив объектов
 *
 * @param <T>
 */
public class MyArrayList<T> implements MyList<T> {
    private Object[] array;
    private int size = 0;
    private QuickSort<T> quickSort;
    private final int INITIAL_CAPACITY = 10;

    /**
     * Конструктор ArrayList с дефолтной длинной массива
     */
    public MyArrayList() {
        this.array = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * С наше сигнатурой длинный
     * массива под копотом ArrayList
     *
     * @param length
     */

    public MyArrayList(int length) {
        this.array = (T[]) new Object[length];
    }

    /**
     * Получение обьекта по index
     *
     * @param index целочисленое число
     * @return возвращает объект из коллекции
     */
    @Override
    public T get(int index) {
        checkValidIndex(index);
        return (T) array[index];
    }

    /**
     * Добавление объекта в конец списка
     * осуществляется проверка размера коллекции и длинны массива
     *
     * @param object может быть любым обьектом
     * @return возвращает boolean выражение о успехе.
     */
    @Override
    public boolean add(T object) {
        checkMaxSizeToGrowAnArray();
        array[size] = object;
        size++;
        return true;
    }

    /**
     * удаление обьекта по обьекту если он есть в коллекции
     *
     * @param object
     * @return
     */
    @Override
    public boolean remove(T object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(array[i])) {
                return remove(i);
            }
        }
        return false;
    }

    /**
     * удаление обьекта по индексу
     *
     * @param index
     * @return
     */
    @Override
    public boolean remove(int index) {
        checkValidIndex(index);
        if (size - 1 - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size--;
        return true;
    }

    /**
     * возвращает размер коллекции
     *
     * @return размер коллекции
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * полная очистка коллекции
     */
    @Override
    public void clear() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * добавление обьекта в любое место по индексу
     *
     * @param object
     * @param index  index <= size
     * @return true or false
     */
    @Override
    public boolean add(T object, int index) {
        checkMaxSizeToGrowAnArray();
        checkValidIndex(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = object;
        size++;
        return true;
    }

    /**
     * Добавление элемента в коллекцию
     * за место существующего элемента
     *
     * @param object
     * @param index
     * @return
     */
    @Override
    public boolean set(T object, int index) {
        checkValidIndex(index);
        this.array[index] = object;
        return true;
    }

    /**
     * поиск обьекта в колекции
     *
     * @param object
     * @return true or false
     */
    @Override
    public boolean contains(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Быстрая сортировка
     * принимает в себя компаратор объекта
     *
     * @param comparator
     */

    @Override
    public void sort(Comparator<T> comparator) {
        quickSort = new QuickSort<T>();
        quickSort.sort((T[]) this.array, comparator,size);
    }

    /**
     * Получить индекс элемента
     * @param element
     * @return
     */
    @Override
    public int getIndexElement(T element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                index = i;
            }
        }
        if (contains(element)){
            System.out.println("Искомого обьекта найден его индекс ");
        }else {
            System.out.println("Искомый обьект не найден");
        }
        return  index;
    }

    /**
     * провека указываемого индекса на валидность
     *
     * @param index
     */

    private void checkValidIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * проверка размера коллекции с длинной массива
     */

    private void checkMaxSizeToGrowAnArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}
