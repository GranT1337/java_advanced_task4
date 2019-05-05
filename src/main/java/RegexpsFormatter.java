import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpsFormatter {


    public static String formatMobileNumber(String string) {
        String defaultStr = string;
        Pattern pattern = Pattern.compile("\\+\\d{1}\\({1}\\d{3}\\){1}\\s\\d{3}\\s\\d{2}\\s\\d{2}");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String mobileNumber = matcher.group();
            String correctMobileNumber = mobileNumber.replace("+7", "+8")
                                                   .replaceAll("\\W", "");
            defaultStr = defaultStr.replace(mobileNumber, correctMobileNumber);
        }

        return defaultStr;
    }
}
