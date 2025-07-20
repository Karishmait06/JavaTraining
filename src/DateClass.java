import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateClass {
    public static void main(String[] args) {

//        using Date class
//        Date currentDate = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//        String timeString = formatter.format(currentDate);
//        System.out.println("Current Time: " + timeString);

//        using Calendar class
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//        String timeString = formatter.format(calendar.getTime());
//        System.out.println("Current Time: " + timeString);

//        using java.time.API
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Current Time: " + time.format(formatter));
    }
}
