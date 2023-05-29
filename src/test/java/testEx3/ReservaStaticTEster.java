package testEx3;

import examenParcial.tercer.ReservServiceStatic;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ReservaStaticTEster {
    MockedStatic<ReservServiceStatic> overrideServ= Mockito.mockStatic(ReservServiceStatic.class);

}
