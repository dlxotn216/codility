/*
 * 프로그램에 대한 저작권을 포함한 지적재산권은 (주)씨알에스큐브에 있으며, (주)씨알에스큐브가 명시적으로 허용하지 않은
 * 사용, 복사, 변경, 제3자에의 공개, 배포는 엄격히 금지되며, (주)씨알에스큐브의 지적 재산권 침해에 해당됩니다.
 * Copyright ⓒ 2020. CRScube Co., Ltd. All Rights Reserved| Confidential)
 */

package me.taesu.codility.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itaesu on 20/04/2020.
 *
 * @author Lee Tae Su
 * @version 1.1.0
 * @since 1.1.0
 */
public class TestController4 {
    /**
     * 2, 4, 1, 6, 5, 9 , 7
     * 2 | 4, 1, 6, 5, 9 , 7 => all of left < right ? split : index++
     * 2, 4 | 1, 6, 5, 9 , 7 => all of left < right ? split : index++
     * 2, 4, 1 | 6, 5, 9 , 7 => all of left < right ? split : index++
     * (2, 4, 1) | 6, 5, 9 , 7 => all of left < right ? split : index++
     *
     * (2, 4, 1) 6 | 5, 9, 7  => all of left < right ? split : index++
     * (2, 4, 1) 6, 5 | 9, 7  => all of left < right ? split : index++
     * (2, 4, 1) (6, 5) | 9, 7  => all of left < right ? split : index++
     *
     * (2, 4, 1) (6, 5) 9 | 7  => all of left < right ? split : index++
     * (2, 4, 1) (6, 5) (9, 7)
     *
     * @param A
     *
     * @return
     */
    public int solution(int[] A) {
        int groupCount = 0;
        int maximumOfLeft = A[0];
        List<Integer> groups = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
            groups.add(A[i]);

            boolean canSplit = canSplit(A, i, maximumOfLeft) && groups.size() > 1;

            if (canSplit) {
                groupCount++;
                System.out.println();
                try {
                    maximumOfLeft = A[i + 1];
                } catch (ArrayIndexOutOfBoundsException ignore) {
                    //end of arrays
                }
                groups.clear();
            }

            maximumOfLeft = maximumOfLeft < A[i] ? A[i] : maximumOfLeft;
        }
        System.out.print("result is ");
        return groupCount + (groups.size() > 0 ? 1 : 0);
    }

    /**
     * @return i + 1 이후의 모든 요소가 좌측의 최대 값보다 큰 지 여부
     */
    private boolean canSplit(int[] A, int i, int maximumOfLeft) {
        for (int j = i + 1; j < A.length; j++) {
            if (maximumOfLeft > A[j]) {
                return false;
            }
        }
        return true;
    }

    private boolean canJohnTryToAllIn(int K, int reminedChips, int triedAllInCount) {
        return reminedChips % 2 == 0 && triedAllInCount < K;
    }

    public static void main(String[] args) {
        System.out.println(new TestController4().solution(new int[]{2, 4, 1, 6, 5, 9, 7}));
        System.out.println();
        System.out.println(new TestController4().solution(new int[]{4, 3, 2, 6, 1}));
        System.out.println();
        System.out.println(new TestController4().solution(new int[]{2, 1, 6, 4, 3, 7}));
        System.out.println();
        System.out.println(new TestController4().solution(new int[]{3, 8, 2, 4, 7, 9}));
        System.out.println();
        System.out.println(new TestController4().solution(new int[]{3}));
        System.out.println();
        System.out.println(new TestController4().solution(new int[]{3, 4}));
        System.out.println();
        System.out.println(new TestController4().solution(new int[]{3, 1, 4}));
        System.out.println();
        System.out.println(new TestController4().solution(new int[]{1, 2, 3}));
        System.out.println();
        System.out.println(new TestController4().solution(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println();
    }
}