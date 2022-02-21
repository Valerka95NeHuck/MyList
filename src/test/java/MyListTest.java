import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyListTest {
    private MyArrayList testList ;
    class People implements Comparator<People> {
        String name;
        Integer age;
        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compare(People o1, People o2) {
            return o2.age.compareTo(o1.age);
        }
    }
    People testPeople = new People("VALERA2",23);

    @BeforeEach
    void initList() {
         testList = new MyArrayList<Object>(){};
        Random r = new Random();
        for (int i = 0; i < 99;i++){
            testList.add(new People("Человек" + 1,r.nextInt(60)+1));
            if (i == 50){
                testList.add(testPeople);
            }
        }
    }

    @Test
    void givenArrayListSize100ElementWhenAddElementReturnTrueSize101() {
    assertEquals(100,testList.size());
    assertTrue(testList.add(new People("VAlERA",43)));
    assertEquals(101,testList.size());
    }

    @Test
    void givenArrayList100ElementWhenListSizeThen100ElementSize() {
        assertEquals(100, testList.size());
    }

    @Test
    void givenListSize100ElementWhenRemovedElementByIndexThenSize99Element() {
        assertTrue(testList.remove(10));
        assertEquals(99,testList.size());
    }

    @Test
    void givenListSize100ElementPlusOneElementWhenRemovedElementByElementThenSizeDecreased() {
        People people = new People(":@!",32);
        testList.add(people);
        assertEquals(101,testList.size());
        assertTrue(testList.remove(people));
        assertEquals(100,testList.size());
    }

    @Test
    void givenListSize100ElementWhenListClearedThenSize0() {
        testList.clear();
        assertEquals(0,testList.size());

    }

    @Test
    void whenPutTheElementAtTheIndexOfTheCollectionTrueIndexElement () {
        People people = new People(":@!",32);
        testList.add(people,25);
        assertEquals(25,testList.getIndexElement(people));
    }

    @Test
    void givenListSize100ElementWhenCheckingAnElementInACollection () {
        assertTrue(testList.contains(testPeople));
    }

}