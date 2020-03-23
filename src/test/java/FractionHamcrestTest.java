import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FractionHamcrestTest {

    Fraction fraction;

    @BeforeEach
    void setUp() throws Exception{
        fraction = new Fraction(1,1);
    }

    @Test
    @DisplayName("Check class")
    void checkClass(){
        assertThat(fraction, isA(Fraction.class)); // isA matcher
    }

    @Test
    @DisplayName("Check equality to class instance")
    void checkEqualityToClassInstance(){
        assertThat(fraction, instanceOf(Fraction.class)); // instanceOf matcher
    }


    @DisplayName("Adding Test")
    @ParameterizedTest(name = "Checking if {0}/{1} + {2}/{3} = {4}/{5}")
    @CsvSource({
            "1, 2, 1, 2, 2, 2",
            "1, 3, 5, 2, 17, 6",
            "3, 2, 1, 2, 4, 2",
            "4, 2, 3, 2, 7, 2",
            "1, 2, 4, 2, 5, 2",
            "5, 2, 1, 2, 6, 2",
            "1, 5, 1, 4, 9, 20",
            "8, 2, 1, 2, 9, 2",
            "1, 2, 4, 2, 5, 2",
            "2, 2, 3, 2, 5, 2",
            "1, 2, 1, 2, 2, 2",
            "1, 1, 3, 2, 5, 2"
    })
    void addTest(int a, int b, int c, int d, int e, int f) {
        final Fraction actual = Fraction.of(a, b).add(Fraction.of(c, d));
        assertThat(actual, is(Fraction.of(e, f)));          // is matcher
    }

    @DisplayName("Adding Test")
    @ParameterizedTest(name = "Checking if {0}/{1} + {2}/{3} = {4}/{5}")
    @CsvSource({
            "1, 2, 1, 2, 1, 2",
            "1, 3, 5, 2, 5, 15",
            "3, 2, 1, 2, 3, 2",
            "4, 2, 3, 2, 12, 6",
            "1, 2, 4, 2, 4, 8",
            "5, 2, 1, 2, 5, 2",
            "1, 5, 1, 4, 1, 5",
            "8, 2, 1, 2, 8, 2",
            "1, 2, 4, 2, 4, 8",
            "2, 2, 3, 2, 6, 6",
            "1, 2, 1, 2, 1, 2",
            "1, 1, 3, 2, 3, 3"
    })
    void multiplyTest(int a, int b, int c, int d, int e, int f) {
        final Fraction actual = Fraction.of(a, b).multiply(Fraction.of(c, d));
        assertThat(actual, is(Fraction.of(e, f)));
    }

    @Test
    void INDETERMINATETest() {
        Assertions.assertThrows( IllegalArgumentException.class, ()->Fraction.of(1,0));
    }

    @Test
    void HALFTest() {
        final Fraction result = Fraction.of(1, 2);
        assertThat(result, is(Fraction.HALF));
    }

    @Test
    void ONE_THIRDTest() {
        final Fraction result = Fraction.of(1, 3);
        assertThat(result, is(Fraction.ONE_THIRD));
    }

    @Test
    void doubleValueTest() {
        final Fraction result = Fraction.of(1, 7);
        assertThat(result.doubleValue(), allOf(greaterThanOrEqualTo(0.14), lessThanOrEqualTo(0.15))); // allOf, greaterThanOrEqualTo, lessThanOrEqualTo matchers
    }

    @Test
    void hashCodeTest() {
        final Fraction result = Fraction.of(2, 3);
        assertThat(result.hashCode(), is(5));
    }

    @Test
    void toStringTest() {
        final Fraction result = Fraction.of(2, 3);
        assertThat(result.toString(), is("2/3"));
    }

    @Test
    void equalsTest() {
        final Fraction result = Fraction.of(2, 3);
        final Fraction result2 = Fraction.of(2, 3);
        assertThat(result.equals(result2), is(Boolean.TRUE));
    }

    @Test
    void getNominatorTest() {
        final Fraction result = Fraction.of(2, 3);
        assertThat(result.getNominator(), is(2));
    }

    @Test
    void getDenominatorTest() {
        final Fraction result = Fraction.of(2, 3);
        assertThat(result.getDenominator(), is(3));
    }

}
