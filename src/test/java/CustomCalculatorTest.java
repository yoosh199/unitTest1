
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.addadd(10,15);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 25);
        assertThat(result, is(25));
        assertSame(result,25);

        System.out.println("result :: " + result);

    }
    @Ignore
    @Test
    public void ignoreTest(){
        System.out.println("무시합니다");
    }

    //빼기 테스트 작성
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertNotSame(result, 25);
        assertEquals(result,13);
        //빼기테스트();
        System.out.println("result :: " + result);
    }
    @Test
    public void 빼기테스트(){
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        assertFalse(result == 12);
        assertThat(result, is(13));
        assertSame(result,13);
        System.out.println("빼기 테스트");



    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertThat(result, equalTo(45));
        assertTrue(result == 45);
        assertEquals(result,45);

        System.out.println("result :: " + result);
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertThat(result, lessThan(6));
        assertThat(result, is(5));
        System.out.println("result :: " + result);
    }
    @Test(timeout = 4000)
    public void timeInMethodTest() throws InterruptedException {
        Thread.sleep(2999);
        Thread.sleep(1000);

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsEmpty() {
            new ArrayList<Object>().get(0);
        }
    @Test
    public void testIsEmptyOne() {
        new ArrayList<Object>().get(0);

    }

    @Test
    public void testIsEmptyArray() {
        ArrayList<Object> myList = new ArrayList<>();
        assertThat(myList, is(empty()));
        assertThat(myList, empty());
        assertThat(myList, equalTo(empty()));


    }


}