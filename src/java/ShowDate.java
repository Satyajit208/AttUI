
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user1
 */
public class ShowDate {
    public static void main(String[] args) {
         DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
             String date1=dateFormat.format(date);
             //calculate no of days
            final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            final LocalDate firstDate = LocalDate.parse(date1, formatter);
            final LocalDate secondDate = LocalDate.parse("2017-08-26", formatter);
            final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
           System.out.println(days);
           int daysRemained=(int) (30-days);
           System.out.println(daysRemained);
    }
}
