package examenParcial.tercer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservaClaseStatic {
    public ReservaClaseStatic(){}

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion) throws Exception {
        String out="";
        if ((mes<1 || mes>12)||(dia<1 || dia>31) || (gestion<0 || gestion>9999)){
            throw new Exception("El numero asignado para la fecha esta incorrecto");
        }
        if (ReservServiceStatic.existePasajes(cantidad,destino)){
            String dayStr=ReservServiceStatic.getDay(dia,mes,gestion);

            String dateSent=dia+"/"+mes+"/"+gestion;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date convertedVer=null;
            String monStr="";
            convertedVer=sdf.parse(dateSent);
                switch(convertedVer.getMonth()+1){
                    case 1:
                        monStr="Enero";
                        break;
                    case 2:
                        monStr="Febrero";
                        break;
                    case 3:
                        monStr="Marzo";
                        break;
                    case 4:
                        monStr="Abril";
                        break;
                    case 5:
                        monStr="Mayo";
                        break;
                    case 6:
                        monStr="Junio";
                        break;
                    case 7:
                        monStr="Julio";
                        break;
                    case 8:
                        monStr="Agosto";
                        break;
                    case 9:
                        monStr="Septiembre";
                        break;
                    case 10:
                        monStr="Octubre";
                        break;
                    case 11:
                        monStr="Noviembre";
                        break;
                    case 12:
                        monStr="Diciembre";
                        break;
                }
                out="El dia "+dayStr+" "+dia+" de "+monStr+" "+gestion+" existen "+cantidad+" pasajes para "+destino;

        } else {
            out="No existen suficientes pasajes para "+destino;
        }
        return out;
    }

}
