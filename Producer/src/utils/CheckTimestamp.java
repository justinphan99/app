package utils;

public class CheckTimestamp {

    public static boolean checkTimestamp(final String str) {
        //2016-06-22 19:10:25-07
        if (str.length() < 19) {
            return false;
        }
        if ((str.charAt(4) != '-') && (str.charAt(7) != '-') && (str.charAt(10) != ' ') && (str.charAt(13) != ':') && (str.charAt(16) != ':')) {
            return false;
        }
        return true;
    }
}
