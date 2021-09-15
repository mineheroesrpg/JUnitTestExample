package main;

import org.junit.jupiter.api.*;

public class MySolutionTestOld {

    private MySolution solution;

    private static int[] arr;

    @BeforeAll
    public static void setUp() {
        arr = new int[]{1, 2, 3, 4, 5};
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("finished");
    }

    @BeforeEach     // JUnit5-ben: BeforeEach
    public void init() {
        System.out.println("one test is running soon...");
        solution = new MySolution();
    }

    @AfterEach      // JUnit5-ben: AfterEach
    public void tearDown() {
        System.out.println("test finished");
        solution = null;
    }

    @Test
    public void testExample() {
        int x = 10; // ez egy képzelt metódus eredmény

        System.out.println("\ttestExample runs...");


        Assertions.assertEquals(10, x);
    }

    @Test
    public void getLastNumberTestWithPosNums() {    // test_getLastNumber_with_pos_nums
        int[] arr = getArr(3);

        int result = MySolution.getLastNumber(arr);

        System.out.println("\tgetLastNumberTestWithPosNums runs...");

        Assertions.assertEquals(2, result);
    }

    @Test
    public void getLastNumberTestWithOneElementArr() {
        int[] arr = getArr(1);

        int result = MySolution.getLastNumber(arr);

        System.out.println("\tgetLastNumberTestWithOneElementArr runs...");

        Assertions.assertEquals(0, result);
    }

    private int[] getArr(int length) {
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }

        return arr;
    }

}
