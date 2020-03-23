import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class FractionAssertJTest {

    private Fraction fraction;

    @BeforeEach
    void setUp(){
        fraction = new Fraction(1,1);
    }

    @DisplayName("Double value is more or equal to")
    @ParameterizedTest(name = "Checking if value of fraction {0}/{1} is greater or equal to {2}")
    @CsvSource({
            "10, 2, 1",
            "5, 1, 3",
            "30, 2, 1",
            "120, 6, 5",
            "40, 8, 1",
            "50, 2, 2",
            "10, 5, 1",
            "80, 2, 3",
            "40, 8, 1",
            "60, 6, 1",
            "10, 2, 2",
            "30, 3, 6"
    })
    void isValueGreaterOrEqualTo(int a, int b, int expected) {
        FractionAssert.assertThat(Fraction.of(a, b)).isMoreThan(expected).isEqualTo(expected);
    }

    @DisplayName("Double value is less or equal to")
    @ParameterizedTest(name = "Checking if value of fraction {0}/{1} is less or equal to {2}")
    @CsvSource({
            "10, 2, 10",
            "5, 1, 30",
            "30, 2, 100",
            "12, 6, 50",
            "40, 8, 10",
            "5, 2, 20",
            "10, 5, 10",
            "8, 2, 30",
            "40, 8, 10",
            "60, 6, 15",
            "10, 2, 50",
            "30, 3, 60"
    })
    void isValueSmallerOrEqualTo(int a, int b, int expected) {
        FractionAssert.assertThat(Fraction.of(a, b)).isLessThan(expected).isEqualTo(expected);
    }

    @Test
    @DisplayName("Check class")
    void checkClass(){
        assertThat(fraction).isOfAnyClassIn(Fraction.class); // isA matcher
    }

    @Test
    @DisplayName("Check equality to class instance")
    void checkEqualityToClassInstance(){
        assertThat(fraction).isInstanceOf(Fraction.class); // instanceOf matcher
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
        assertThat(Fraction.of(a, b).add(Fraction.of(c, d))).isEqualTo(Fraction.of(e, f));
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
    void multiplyTest(int a, int b, int c, int d, int e, int f) {
        assertThat(Fraction.of(a, b).add(Fraction.of(c, d))).isEqualTo(Fraction.of(e, f));
    }

    @Test
    void INDETERMINATETest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->Fraction.of(1,0));
        assertThatThrownBy(() -> Fraction.of(1,0)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Fraction denominator cannot be equal to 0");
    }

    @Test
    void HALFTest() {
        final Fraction result = Fraction.of(1, 2);
        assertThat(result).isEqualTo(Fraction.HALF);
    }

    @Test
    void ONE_THIRDTest() {
        final Fraction result = Fraction.of(1, 3);
        assertThat(result).isEqualTo(Fraction.ONE_THIRD);
    }

    @Test
    void doubleValueTest() {
        final Fraction result = Fraction.of(1, 7);
        assertThat(result.doubleValue()).isBetween(0.14, 0.15);
    }

    @Test
    void hashCodeTest() {
        final Fraction result = Fraction.of(2, 3);
        assertThat(result.hashCode()).isEqualTo(5);
    }

    @Test
    void toStringTest() {
        final Fraction result = Fraction.of(2, 3);
        assertThat(result.toString()).isInstanceOf(String.class).contains("2/3");
    }

    @Test
    void equalsTest() {
        final Fraction result = Fraction.of(2, 3);
        final Fraction result2 = Fraction.of(2, 3);
        assertThat(result.equals(result2)).isTrue();
    }

    @Test
    void getNominatorTest() {
        final Fraction result = Fraction.of(2, 3);
        assertThat(result.getNominator()).isEqualTo(2);
    }

    @Test
    void getDenominatorTest() {
        final Fraction result = Fraction.of(2, 3);
        assertThat(result.getDenominator()).isEqualTo(3);
    }

}
