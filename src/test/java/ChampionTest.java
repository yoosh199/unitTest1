import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");


        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();



        assertThat(emptyList, empty());
        assertTrue(emptyList.isEmpty());
        assertThat(emptyList, is(empty()));

    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());
        assertFalse(lck.equals("123"));
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        String lck1 = "";
        assertThat(lck, nullValue());
        assertNotNull(lck1);

        //assertThat(lck1, nullValue());
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";
        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString2, is(endsWith(endString)));
        assertThat(sampleString1, anyOf(startsWith(endString),startsWith(startString)));
        assertThat(sampleString2, allOf(startsWith("Player"), endsWith(endString)));
        assertThat(sampleString2, containsString("Pl"));
        assertThat(sampleString2, containsString(" "));
        assertThat(sampleString2, containsString("a"));
        assertThat(sampleString2, startsWith("Pl"));
        //assertThat(sampleString2, startsWith("l"));
        assertThat(sampleString2, endsWith("t"));
        assertThat(sampleString2, endsWith("nt"));
        assertThat(sampleString2, endsWith(""));
        //assertThat(sampleString2, endsWith("oi"));


        //assertThat(sampleString1, allOf(startsWith("Player"), endsWith(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        assertThat(3.14, closeTo(4, 3));

        assertThat(3.14, closeTo(3, 0.4));
        assertThat(3.14, closeTo(3, 0.1));

    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(4), anything());
        assertThat(championList.get(1).getName(), is("리신"));



        //assertEquals(championList.get(2), anything());
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        assertTrue(championList.size() == 5);
        assertEquals(championList.size(), 5);
        assertThat(championList.size(), is(5));
        assertThat(championList, hasSize(5));

        assertThat(championList, hasSize(4));
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));

        assertTrue(supportChamp.getName() == "타릭");
        assertTrue(supportChamp.getName().equals("타릭"));
        assertEquals(supportChamp.getPosition(),"바텀");

    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {

        assertThat(championList.get(0), hasProperty("name"));
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
        //assertEquals(championList.get(0), hasProperty("name"));
        //assertThat(championList, hasProperty("champion"));

        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(0), hasProperty("name", is("다리우스")));

    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "루시안 1킬", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
        assertThat(champListNames.get(0), hasToString("루시안"));

        assertThat(champListNames.get(0), hasToString("루시 안"));

        assertThat(champListNames.get(0), hasToString("1킬"));
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames3 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "카사딘", "블라디미르");
        List<Integer> championNames4 = Arrays.asList(1,2,3,4);
        List<Integer> championNames5 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        assertThat(championNames1, samePropertyValuesAs(championNames2));
        assertThat(championNames1, samePropertyValuesAs(championNames3));
        assertThat(championNames1, samePropertyValuesAs(championNames4));
        assertThat(championNames2, samePropertyValuesAs(championNames5));
        assertThat(championNames4, samePropertyValuesAs(championNames5));
        Champion champ1 = new Champion("갈리오", "미드");
        Champion champ2 = new Champion("갈리오", "미드");
        assertThat(champ1, samePropertyValuesAs(champ2));

    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));


        Optional<Champion> filterChamp = championList.stream()
                .filter(champion -> champion.getPosition().equals("정글"))
                .findFirst();
        String champ = filterChamp.get().getName();
        assertThat(champ, is("리신"));
    }

}