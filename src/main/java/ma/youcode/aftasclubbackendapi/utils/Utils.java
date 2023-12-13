package ma.youcode.aftasclubbackendapi.utils;

public class Utils {
    public static String generateCode(String location, String date) {
        String locationCode = location.substring(0, 3);
        String dayAndMonth = date.substring(0, 5);
        String year = date.substring(8, 10);
        return locationCode.toLowerCase() + "-" + dayAndMonth + "-" + year;
    }
}
