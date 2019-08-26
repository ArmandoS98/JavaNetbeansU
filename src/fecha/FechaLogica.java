/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asantos
 */
public class FechaLogica {
    private final Calendar calendar;

    public FechaLogica(String fecha) {
        this.calendar = Calendar.getInstance();
        transformData(fecha);
    }
    
    private void transformData(String fecha){
        String delims = "[/]";
        String[] tokens = fecha.split(delims);
        
        if (validacionesBasicas(tokens)) {
            try {
                calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fecha));
                
                if(validarAnio())
                    getFechaNueva(tokens[0]);
                 else
                    getFechaNueva(tokens[0]);
                
            } catch (ParseException ex) {
                System.out.println("Formato de la fecha no admitido " + fecha + "!");
            }
        }else
            System.out.println("Formato de la fecha no admitido " + fecha + "!");
    }
    
    private void getFechaNueva(String dia){
        if(verificarDias(Integer.parseInt(dia)))
             System.out.println(dia + " de " + mesEnLetras() + " de " +calendar.get(Calendar.YEAR));
        else
            System.out.println("Formato de la fecha no admitido!");
    }
    
    /**
     * Valido que el dia y el mes no sean mayour a los que establece el calendario
     * @param data
     * @return 
     */
    private boolean validacionesBasicas(String[] data){
        if (Integer.parseInt(data[0]) <= 31 && Integer.parseInt(data[1]) <= 12) 
            return true;
        else
            return false;
    }
    
    /**
     * valido que los dias que el usuario ingreso no sean mayor a los dias que tiene el mes
     * @param dia
     * @return 
     */
    private boolean verificarDias(int dia){
        calendar.set(calendar.get(Calendar.YEAR), (calendar.get(Calendar.MONTH) + 1), 0);
        
        int maxDay = ((calendar.get(calendar.MONTH) + 1) == 2) ? 29 : 28;
                        
        if(dia <= maxDay)
            return true;
        else
            return false;
    }
    
    private boolean validarAnio(){
        return (calendar.get(Calendar.YEAR) % 4 == 0) && ((calendar.get(Calendar.YEAR) % 100 != 0) || (calendar.get(Calendar.YEAR) % 400 == 0));
    }
      
    /**
     * Visualizacin de los meses en su texto 
     * @return 
     */
    private String mesEnLetras(){
        String mes = "";
        switch(calendar.get(Calendar.MONTH) + 1){
            case 1:
                mes = String.valueOf(Meses.Enero);
                break;
            case 2:
                mes = String.valueOf(Meses.Febrero);
                break;
            case 3:
                mes = String.valueOf(Meses.Marzo);
                break;
            case 4:
                mes = String.valueOf(Meses.Abril);
                break;
            case 5:
                mes = String.valueOf(Meses.Mayo);
                break;
            case 6:
                mes = String.valueOf(Meses.Junio);
                break;
            case 7:
                mes = String.valueOf(Meses.Julio);
                break;
            case 8:
                mes = String.valueOf(Meses.Agosto);
                break;
            case 9:
                mes = String.valueOf(Meses.Septiembre);
                break;
            case 10:
                mes = String.valueOf(Meses.Octubre);
                break;
            case 11:
                mes = String.valueOf(Meses.Noviembre);
                break;
            case 12:
                mes = String.valueOf(Meses.Diciembre);
                break;
        }
        return mes;
    }
}
