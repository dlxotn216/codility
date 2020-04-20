/*
 * 프로그램에 대한 저작권을 포함한 지적재산권은 (주)씨알에스큐브에 있으며, (주)씨알에스큐브가 명시적으로 허용하지 않은
 * 사용, 복사, 변경, 제3자에의 공개, 배포는 엄격히 금지되며, (주)씨알에스큐브의 지적 재산권 침해에 해당됩니다.
 * Copyright ⓒ 2020. CRScube Co., Ltd. All Rights Reserved| Confidential)
 */

package me.taesu.codility.logic;

/**
 *
 * K번 올인 가능하다고 할 때 최소 경기 횟수는?
 *      무조건 이긴다고 가정
 *      1칩 만 배팅 가능
 *      1칩 배팅 시 이기면 2개 얻음
 *      올인 시 두배 얻음
 *
 * 올인을 통해 최대의 이득을 얻어야 횟수를 줄일 수 있다. 따라서 목표개수로부터 역으로 돈다.
 *
 * Created by itaesu on 20/04/2020.
 *
 * @author Lee Tae Su
 * @version 1.1.0
 * @since 1.1.0
 */
public class TestController3 {
    //@formatter:off
    /**
     * N = 18, K = 2
     *
     * while(N <= 1)
     *   N % 2 == 0 => roundCount++
     *                      K > 1  => N = N/2
     *                      K == 0 => N--
     *   N % 2 != 0 => roundCount++, N--
     *
     * @param N 목표 Chip 개수
     * @param K 최대 가능 한 all-in 횟수
     * @return 최소 라운드 수
     */
    //@formatter:on
    public int solution(int N, int K) {
        if (K == 0) {
            return N - 1;
        }

        int reminedChips = N;
        int triedAllInCount = 0;
        int roundCount = 0;
        while (reminedChips > 1) {
            System.out.print(reminedChips + ", ");
            if (canJohnTryToAllIn(K, reminedChips, triedAllInCount)) {
                reminedChips = reminedChips / 2;
                triedAllInCount++;
            } else {
                reminedChips--;
            }

            roundCount++;
        }

        System.out.println();

        return roundCount;
    }

    private boolean canJohnTryToAllIn(int K, int reminedChips, int triedAllInCount) {
        return reminedChips % 2 == 0 && triedAllInCount < K;
    }

    public static void main(String[] args) {
        System.out.println(new TestController3().solution(8, 0));
        System.out.println(new TestController3().solution(18, 2));
        System.out.println(new TestController3().solution(10, 10));
        System.out.println(new TestController3().solution(100, 2));
        System.out.println(new TestController3().solution(10, 100));
        System.out.println(new TestController3().solution(2_147_483_647, 100));
        System.out.println(new TestController3().solution(2_147_483_647, 0));
    }
}