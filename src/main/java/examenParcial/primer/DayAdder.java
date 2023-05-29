package examenParcial.primer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayAdder {

    public String nextDay(int day, int month, int year) throws ParseException {
        String datecon=day+"/"+month+"/"+year;
        SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal= Calendar.getInstance();
        cal.setTime(sf.parse(datecon));
        cal.add(Calendar.DATE,1);
        Date modified=cal.getTime();
        return sf.format(modified);
    }
}
