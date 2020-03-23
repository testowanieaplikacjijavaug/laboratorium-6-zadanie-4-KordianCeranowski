import org.assertj.core.api.AbstractAssert;

class FractionAssert extends AbstractAssert<FractionAssert, Fraction> {
    private FractionAssert(Fraction actual) {
        super(actual, FractionAssert.class);
    }

    static FractionAssert assertThat(Fraction actual) {
        return new FractionAssert(actual);
    }

    FractionAssert isMoreThan(double expected) {
        isNotNull();
        if (actual.doubleValue() < expected) {
            failWithMessage("Expected fraction value to be over <%s>, but was only <%s>", expected, actual.doubleValue());
        }
        return this;
    }

    FractionAssert isEqualTo(double expected) {
        isNotNull();
        if (actual.doubleValue() == expected) {
            failWithMessage("Expected fraction value to be equal to <%s>, but was <%s>", expected, actual.doubleValue());
        }
        return this;
    }

    FractionAssert isLessThan(double expected) {
        isNotNull();
        if (actual.doubleValue() > expected) {
            failWithMessage("Expected fraction value to be less than <%s>, but was <%s>", expected, actual.doubleValue());
        }
        return this;
    }
}
