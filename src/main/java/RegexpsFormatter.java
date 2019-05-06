import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpsFormatter {


    public static String formatMobileNumber(String string) {
        String defaultStr = string;
        Pattern pattern = Pattern.compile("\\+\\d\\(\\d{3}\\)\\s\\d{3}\\s\\d{2}\\s\\d{2}");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String mobileNumber = matcher.group();
            String newY = String.valueOf(Integer.valueOf(mobileNumber.substring(1,2)) + 1);
            String correctMobileNumber = mobileNumber.replaceAll("\\+\\d", newY)
                                                   .replaceAll("\\W", "");
            defaultStr = defaultStr.replace(mobileNumber, correctMobileNumber);
        }

        return defaultStr;
    }
}
