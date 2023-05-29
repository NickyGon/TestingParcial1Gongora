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
                    "16,05,-1,17/05/-0001",
                    "31,12,99,01/01/0100",
                    "16,05,1000,17/05/1000",
                    "31,09,2010,01/10/2010",
                    "31,12,2019,01/01/2020",
                    "31,12,0,01/01/0001",
                    "01,01,2000,02/01/2000",
                    "02,01,2003,03/01/2003",
                    "01,02,2000,02/02/2000",
                    "31,10,1999,01/11/1999",
                    "01,04,2100,02/04/2100",
                    "01,01,2002,02/01/2002",
                    "31,12,1089,01/01/1090",
                    "01,01,2023,02/01/2023",
                    "31,12,1999,01/01/2000",
                    "31,12,2023,01/01/2024",
            }
    )
    public void verifyDayAdder(int day, int month, int year, String expected) throws Exception {
        String actualResult=dayAdder.nextDay(day,month,year);
        Assertions.assertEquals(actualResult,expected,"Error, los resultados no son lo mismo");
    }
}
