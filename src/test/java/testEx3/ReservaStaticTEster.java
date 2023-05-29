package testEx3;

import examenParcial.segundoytercer.ReservaClase;
import examenParcial.tercer.ReservServiceStatic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ReservaStaticTEster {

    @BeforeAll
    public static void setup(){
        MockedStatic<ReservServiceStatic> overrideServ= Mockito.mockStatic(ReservServiceStatic.class);
        overrideServ.when(()->ReservServiceStatic.existePasajes(2,"La Paz")).thenReturn(true);
        overrideServ.when(()->ReservServiceStatic.existePasajes(1,"Tarija")).thenReturn(false);
        overrideServ.when(()->ReservServiceStatic.existePasajes(3,"La Paz")).thenReturn(true);
        overrideServ.when(()->ReservServiceStatic.existePasajes(4,"Santa Cruz")).thenReturn(true);
        overrideServ.when(()->ReservServiceStatic.existePasajes(0,"Sucre")).thenReturn(false);


        overrideServ.when(()->ReservServiceStatic.getDay(29,05,2023)).thenReturn("Lunes");
        overrideServ.when(()->ReservServiceStatic.getDay(30,05,2023)).thenReturn("Martes");
        overrideServ.when(()->ReservServiceStatic.getDay(31,05,2023)).thenReturn("Miercoles");
        overrideServ.when(()->ReservServiceStatic.getDay(18,12,2000)).thenReturn("Jueves");
        overrideServ.when(()->ReservServiceStatic.getDay(19,11,19)).thenReturn("Viernes");
        overrideServ.when(()->ReservServiceStatic.getDay(10,1,200)).thenReturn("Sabado");
        overrideServ.when(()->ReservServiceStatic.getDay(1,2,1)).thenReturn("Domingo");
    }
    @ParameterizedTest
    @CsvSource(
            {
                    "La Paz, 2, 29, 05, 2023,El dia Lunes 29 de Mayo 2023 existen 2 pasajes para La Paz",
                    "Tarija, 1, 30, 05, 2023,No existen suficientes pasajes para Tarija",
                    "La Paz, 3, 31, 05, 2023,El dia Miercoles 31 de Mayo 2023 existen 3 pasajes para La Paz",
                    "Santa Cruz, 4, 19, 11, 20,No existen suficientes pasajes para Tarija",
                    "La Paz, 3, 31, 05, 2023,El dia Miercoles 31 de Mayo 2023 existen 3 pasajes para La Paz",


            }
    )
    public void verifyPasajes(String destino, int pasajes,int dia, int mes, int gestion, String expected) throws Exception {

        ReservaClase reservaClase= new ReservaClase();

        String actual=reservaClase.reservaVuelo(destino,pasajes,dia,mes,gestion);
        Assertions.assertEquals(expected, actual, "ERROR el metodo no esta funcionando");

    }

    @ParameterizedTest
    @CsvSource(
            {
                    "La Paz, 2, -1, 05, 2023,",
                    "Tarija, 1, 32, 13, 2023,",
                    "La Paz, 1, 34, 05, -1,",

            }
    )
    public void verifyPasajesException(String destino, int pasajes,int dia, int mes, int gestion, String expected) throws Exception {

        ReservaClase reservaClase= new ReservaClase();
        Assertions.assertThrows(Exception.class,()->reservaClase.reservaVuelo(destino,pasajes,dia,mes,gestion));

    }




}
