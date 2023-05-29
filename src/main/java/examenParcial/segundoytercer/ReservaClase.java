package examenParcial.segundoytercer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservaClase {
    private ReservService reservService;
    public ReservaClase(){reservService=new ReservService();}
    public void setReservService(ReservService reservService){this.reservService=reservService;}

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion) throws Exception{
        String out="";
        if (reservService.existePasajes(cantidad,destino)){
            String dayStr=reservService.getDay(dia,mes,gestion);
            String date=dia+"/"+mes+"/"+gestion;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date convertedVer=null;
            try {
                convertedVer=sdf.parse()
            } catch (Exception e){

            }
            out="El dia "+dayStr+" "+dia+" de "+" "+" "+gestion+" existen "+cantidad+" pasajes para "+destino;
        } else {
            out="No existen suficientes pasajes para "+destino;
        }
        return out;
    }

}
