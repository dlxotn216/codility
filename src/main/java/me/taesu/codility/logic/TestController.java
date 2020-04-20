/*
 * 프로그램에 대한 저작권을 포함한 지적재산권은 (주)씨알에스큐브에 있으며, (주)씨알에스큐브가 명시적으로 허용하지 않은
 * 사용, 복사, 변경, 제3자에의 공개, 배포는 엄격히 금지되며, (주)씨알에스큐브의 지적 재산권 침해에 해당됩니다.
 * Copyright ⓒ 2020. CRScube Co., Ltd. All Rights Reserved| Confidential)
 */

package me.taesu.codility.logic;

import java.util.Map;

import static java.lang.Long.valueOf;
import static java.lang.Math.max;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 * 하나만 내서 얻을 수 있는 가장 큰 수 계산하기
 *
 * Created by itaesu on 20/04/2020.
 *
 * @author Lee Tae Su
 * @version 1.1.0
 * @since 1.1.0
 */
public class TestController {
    //@formatter:off
    /**
     *            Paper  Rock  Scissors
     * Paper        1     2      0
     * Rock         0     1      2
     * Scissors     2     0      1
     *
     *  @param G Friends gesture string
     * @return Maximum number of points.
     */
    //@formatter:on
    public int solution(String G) {
        final Map<Character, Long> friendGestureCount = G.chars()
                                                         .mapToObj(value -> ((char) value))
                                                         .collect(groupingBy(o -> o, counting()));

        final Long ifFrancoTakePaper
                = friendGestureCount.getOrDefault('P', 0L) * 1
                + friendGestureCount.getOrDefault('R', 0L) * 2
                + friendGestureCount.getOrDefault('S', 0L) * 0;

        final Long ifFrancoTakeRock
                = friendGestureCount.getOrDefault('P', 0L) * 0
                + friendGestureCount.getOrDefault('R', 0L) * 1
                + friendGestureCount.getOrDefault('S', 0L) * 2;

        final Long ifFrancoTakeScissors
                = friendGestureCount.getOrDefault('P', 0L) * 2
                + friendGestureCount.getOrDefault('R', 0L) * 0
                + friendGestureCount.getOrDefault('S', 0L) * 1;

        return valueOf(max(max(ifFrancoTakePaper, ifFrancoTakeRock), ifFrancoTakeScissors)).intValue();
    }

    public static void main(String[] args) {
        System.out.println(new TestController().solution("RSPRS"));
        System.out.println(new TestController().solution("SRR"));
        System.out.println(new TestController().solution("PRPRRPP"));
        System.out.println(new TestController().solution("PPPPRRSSSSS"));
        System.out.println(new TestController().solution("P"));
    }
}
