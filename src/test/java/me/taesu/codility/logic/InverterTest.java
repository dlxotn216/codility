package me.taesu.codility.logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by itaesu on 21/04/2020.
 *
 * @author Lee Tae Su
 * @version 1.1.0
 * @since 1.1.0
 */
public class InverterTest {
    @Test
    public void shouldInvertWhenInverterGetNull() {
        //given
        final String input = null;
        final String expected = "";

        //when
        final String inverted = Inverter.invert(input);

        //then
        Assert.assertNotNull(inverted);
        Assert.assertEquals(inverted, expected);
    }

    @Test
    public void shouldInvertWhenInverterGetEmptyString() {
        //given
        final String input = "";
        final String expected = "";

        //when
        final String inverted = Inverter.invert(input);

        //then
        Assert.assertEquals(inverted, expected);
    }

    @Test
    public void shouldInvertWhenInverterGetBlankString() {
        //given
        final String input = " ";
        final String expected = input;

        //when
        final String inverted = Inverter.invert(input);

        //then
        Assert.assertEquals(inverted, expected);
    }

    @Test
    public void shouldInvertWhenInverterGetSingleCharacter() {
        //given
        final String input = "a";
        final String expected = input;

        //when
        final String inverted = Inverter.invert(input);

        //then
        Assert.assertEquals(inverted, expected);
    }

    @Test
    public void shouldInvertWhenInverterGetLongerString() {
        //given
        final String input = "apple";
        final String expected = "elppa";

        //when
        final String inverted = Inverter.invert(input);

        //then
        Assert.assertEquals(inverted, expected);
    }
}