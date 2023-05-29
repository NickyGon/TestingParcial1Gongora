package examenParcial.primer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayAdder {

    public String nextDay(int day, int month, int year) throws Exception {
        if ((month<1 || month>12)||(day<1 || day>31) || (year<-999999 || year>999999)){
            throw new Exception("El numero asignado para la fecha esta incorrecto");
        }

        String datecon=day+"/"+month+"/"+year;
        SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyyy");

        Calendar cal= Calendar.getInstance();
        cal.setTime(sf.parse(datecon));
        cal.add(Calendar.DATE,1);
        Date modified=cal.getTime();
        return sf.format(modified);
    }
}
