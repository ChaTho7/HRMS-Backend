package ChaTho.hrms.core.utilities.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final Pattern validEmailRegex =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String email) {
        Matcher matcher = validEmailRegex.matcher(email);
        return matcher.matches();
    }
}
