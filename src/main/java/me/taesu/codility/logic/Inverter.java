/*
 * 프로그램에 대한 저작권을 포함한 지적재산권은 (주)씨알에스큐브에 있으며, (주)씨알에스큐브가 명시적으로 허용하지 않은
 * 사용, 복사, 변경, 제3자에의 공개, 배포는 엄격히 금지되며, (주)씨알에스큐브의 지적 재산권 침해에 해당됩니다.
 * Copyright ⓒ 2020. CRScube Co., Ltd. All Rights Reserved| Confidential)
 */

package me.taesu.codility.logic;

import org.springframework.util.StringUtils;

/**
 * Inverter class test 작성하기
 *
 * Created by itaesu on 20/04/2020.
 *
 * @author Lee Tae Su
 * @version 1.1.0
 * @since 1.1.0
 */
public class Inverter {
    public static String invert(String string) {
        if (StringUtils.isEmpty(string)) {
            return "";
        }

        if (string.length() == 1) {
            return string;
        }

        return new StringBuilder(string).reverse().toString();
    }
}
