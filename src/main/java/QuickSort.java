import java.util.Comparator;
import java.util.Random;

public class QuickSort<T>{
    public static final Random RND = new Random();

    private void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private int partition(T[] array, int begin, int end, Comparator<T> cmp) {
        int index = begin + RND.nextInt(end - begin + 1);
        Object pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++ i) {
            if (cmp.compare(array[i], (T)pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }
    private void qsort(T[] array, int begin, int end, Comparator <T>cmp) {
        if (end > begin) {
            int index = partition(array, begin, end, cmp);
            qsort(array, begin, index - 1, cmp);
            qsort(array, index + 1,  end,  cmp);
        }
    }
    public void sort(T[] array, Comparator <T>cmp,int size) {
        qsort(array, 0, size - 1, cmp);
    }

}
