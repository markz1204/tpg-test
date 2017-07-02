package question1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by markz on 2/7/17.
 */
public class IPValidationRegex {

    final static String IP_REGEX = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}(([01]?\\d\\d?|2[0-4]\\d|25[0-5]))$";

    private Pattern pattern;
    private Matcher matcher;


    public IPValidationRegex(){
        pattern = Pattern.compile(IP_REGEX);
    }

    public boolean isValidIP(String ip){
        matcher = pattern.matcher(ip);

        return matcher.matches();
    }
}
