package textEx2;

import examenParcial.segundoytercer.ReservService;
import examenParcial.segundoytercer.ReservaClase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class ReservaTester {
    ReservService serviceMock= Mockito.mock(ReservService.class);

    @BeforeEach
    public void setup(){
        Mockito.when(serviceMock.existePasajes(2,"La Paz")).thenReturn(true);
        Mockito.when(serviceMock.existePasajes(1,"Tarija")).thenReturn(false);
        Mockito.when(serviceMock.existePasajes(3,"La Paz")).thenReturn(true);


        Mockito.when(serviceMock.getDay(29,05,2023)).thenReturn("Lunes");
        Mockito.when(serviceMock.getDay(30,05,2023)).thenReturn("Martes");
        Mockito.when(serviceMock.getDay(31,05,2023)).thenReturn("Miercoles");


    }

    @ParameterizedTest
    @CsvSource(
            {
                    "La Paz, 2, 29, 05, 2023,El dia Lunes 29 de Mayo 2023 existen 2 pasajes para La Paz",
                    "Tarija, 1, 30, 05, 2023,No existen suficientes pasajes para Tarija",
                    "La Paz, 3, 31, 13, 2023,",
                    "Tarija, 1, 30, 05, 2023,No existen suficientes pasajes para Tarija",

            }
    )
    public void verifyPasajes(String destino, int pasajes,int dia, int mes, int gestion, String expected) throws Exception {

        ReservaClase reservaClase= new ReservaClase();
        reservaClase.setReservService(serviceMock);

        String actual=reservaClase.reservaVuelo(destino,pasajes,dia,mes,gestion);
        Assertions.assertEquals(expected, actual, "ERROR el metodo no esta funcionando");



    }
}
