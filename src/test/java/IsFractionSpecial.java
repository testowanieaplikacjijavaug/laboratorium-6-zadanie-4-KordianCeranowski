import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class IsFractionSpecial  extends TypeSafeMatcher<Fraction> {
    @Override
    protected boolean matchesSafely(Fraction item) {
        return item == Fraction.FULL || item == Fraction.HALF || item == Fraction.ONE_THIRD || item == Fraction.INDETERMINATE;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Fraction is special");
    }

    public static IsFractionSpecial specialFraction() {
        return new IsFractionSpecial();
    }
}
