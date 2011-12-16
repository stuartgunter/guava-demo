package org.stuartgunter.demo.guava.fp;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.math.BigDecimal;

import static org.testng.AssertJUnit.assertEquals;

/**
 * User: gunters
 * Created: 05/12/2011 09:23
 */
@Test
public class FunctionsTest {

    public void shouldComposeFunctions() {
        // converts a String to an Integer
        final Function<String, Integer> stringToInt = new Function<String, Integer>() {
            public Integer apply(@Nullable String input) {
                return input == null ? null : Integer.parseInt(input);
            }
        };

        // converts an Integer (pence) to a BigDecimal (pounds)
        final Function<Integer, BigDecimal> intToMoney = new Function<Integer, BigDecimal>() {
            final BigDecimal divisor = new BigDecimal(100);
            public BigDecimal apply(@Nullable Integer input) {
                return input == null ? null : new BigDecimal(input).divide(divisor);
            }
        };

        final String input = "150"; // represents 1.50

        assertEquals(new BigDecimal(1.5d),
                Functions.compose(intToMoney, stringToInt).apply(input));
    }
}
