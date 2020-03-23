import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsStringInFractionFormat extends TypeSafeMatcher<String> {

    @Override
    protected boolean matchesSafely(String string) {
        int positionOfRhomb = string.indexOf('/');
        if(positionOfRhomb == -1){
            return false;
        }
        try {
            Integer.parseInt(string.substring(0, positionOfRhomb));
            Integer.parseInt(string.substring(positionOfRhomb + 1));
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("format x/x");
    }

    public static Matcher<String> fractionFormat() {
        return new IsStringInFractionFormat();
    }
}