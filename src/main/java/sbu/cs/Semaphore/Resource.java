package sbu.cs.Semaphore;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Resource {

    public static void accessResource() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:m:s");
        String formattedTime = localTime.format(formatter);
        try {
        System.out.println(Thread.currentThread().getName() +" : " + formattedTime);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
