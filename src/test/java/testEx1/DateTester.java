package testEx1;

import examenParcial.primer.DayAdder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.ParseException;

public class DateTester {
    DayAdder dayAdder= new DayAdder();
    @ParameterizedTest
    @CsvSource(
            {
                    "31,12,0,01/01/1",
                    "01,01,2000,02/01/2000",
                    "01,01,2023,02/01/2023",
                    "31,12,1999,01/01/2000",
                    "31,12,2023,01/01/2024",
            }
    )
    public void verifyDayAdder(int day, int month, int year, String expected) throws ParseException {
        String actualResult=dayAdder.nextDay(day,month,year);
        Assertions.assertEquals(actualResult,expected,"Error, los resultados no son lo mismo");
    }
}
