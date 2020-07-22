import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class UpperCaseCounterTest {

    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    //null을 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_null_input(){
        String str = null;
        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        assertThat(numberOfUpperCaseCharactersInString,is(0));
        assertThat(numberOfUpperCaseCharactersInString, not(3));
    }

    //반겂울 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_empty_input() {
        String str = "";


        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertThat(numberOfUpperCaseCharactersInString,is(0));
        //assertEquals(numberOfUpperCaseCharactersInString, 1);
    }

    //대문자들이 포함된 문자열을 전달했을 때 카운팅된 숫자와 맞는지 검증하는 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_10_for_ABCDEFGHIJ() {
        String str = "ABCDEFGHIJ";

        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        assertTrue(upperCaseCounter.getNumberOfUpperCaseCharactersInString(str) == 10);
        //assertTrue로 맞는 테스트 코드 작성
        //assertFalse로 틀리는 값을 넣어 테스트 작성
        assertFalse(upperCaseCounter.getNumberOfUpperCaseCharactersInString(str)==5);
        //assertThat 단정문을 사용해서 True인 테스트 코드 작성
        assertThat(upperCaseCounter.getNumberOfUpperCaseCharactersInString(str), is(10));
        assertThat(upperCaseCounter.getNumberOfUpperCaseCharactersInString(str), instanceOf(int.class));
        System.out.println("여기까지 완료");
        //assertThat(upperCaseCounter.getNumberOfUpperCaseCharactersInString(str), instanceOf(String.class));
    }

    //대소문자가 섞여 있을 때 정확히 카운팅 되는 지에 대한 테스트 코드 작성
    @Test
    public void getNumberOfUpperCaseCharacterInString_return_6_for_ABCdefGHI(){
        String str = "ABCdefGHI";
        assertThat(str.getClass(), sameInstance(String.class));
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        assertTrue(upperCaseCounter.getNumberOfUpperCaseCharactersInString(str) == 6);

        assertThat(upperCaseCounter.getNumberOfUpperCaseCharactersInString(str), greaterThan(1));
        assertThat(upperCaseCounter.getNumberOfUpperCaseCharactersInString(str), lessThan(111));
        assertFalse(upperCaseCounter.getNumberOfUpperCaseCharactersInString(str)==5);


        assertThat(upperCaseCounter.getNumberOfUpperCaseCharactersInString(str), is(6));
        System.out.println("result :: " + result);
    }

    //잘못된 값을 참조했을 때 IndexOutOfBoundsException Exception이 발생하는지 테스트 코드 작성
    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenGetZeroIndex() {
        new ArrayList<Object>().get(0);
    }
    @Test
    public void shouldThrowExceptionWhenGetZeroIndex1() {
        ArrayList<Object> abc = new ArrayList<Object>();
        abc.add(1);
        abc.get(0);
    }

    //해당 메소드가 제한된 시간내에 실행되는지에 대한 테스트 코드 작성 : timeout 사용
    //두번째로 해당 메소드는 테스트 하지 않도록 어노테이션 추가 적용 해봅니다. Ignore


    @Test(timeout = 123)
    public void testShouldRunInLimitedTime() throws InterruptedException {

        Thread.sleep(120);

        System.out.println("제한된 시간 내에 수행되면 테스트 Passed!");

    }



    @Ignore
    @Test
    public void ignoreTest(){
        int a= 1;
        assertThat(a, is(2));
        System.out.println("무시합니다");

    }


}
