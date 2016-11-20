
package Logica;

import GUI.InterfazPrincipal;
import GUI.RecursosDelSistema;
import javax.swing.UIManager;

public class Proyecto2SO {

    public static void main(String[] args) {
        try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
        ex.printStackTrace(); 
        }   
        
        Recurso vecRecursos [] = new Recurso [150];
        Proceso vecProcesos [] = new Proceso [150];
        
        RecursosDelSistema IngresarDatos = new RecursosDelSistema(vecRecursos, vecProcesos);
        IngresarDatos.setVisible(true);
        
        
        
    }
    
}
