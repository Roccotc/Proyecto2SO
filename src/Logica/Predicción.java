
package Logica;

public class Predicción {
    
    private int necesarios [][];
    private int asignados [][];
    private int maximos [][];
    private int disponibles [];
    private int CantProcesos;
    private int CantRecursos;
 
    private void entrada() {
         
        necesarios = new int[CantProcesos][CantRecursos];  //inicializacion de arrays
        maximos = new int[CantProcesos][CantRecursos];
        asignados = new int[CantProcesos][CantRecursos];
        disponibles = new int [CantRecursos];
        
    }
     
 
    private int[][] calculoNecesarios() {
        for (int i = 0; i < CantProcesos; i++) {
            for (int j = 0; j < CantRecursos; j++) //calculando matriz de necesarios
            {
                 necesarios[i][j] = maximos[i][j] - asignados[i][j];
            }
        }
 
        return necesarios;
    }
 
    private boolean chequear(int i) {
         //chequeando si todos los recursos para el proceso pueden ser asignados
        for (int j = 0; j < CantRecursos; j++) {
            if (disponibles[j] < necesarios[i][j]) {
                return false;
            }
        }
 
        return true;
    }
 
    public void esSeguro() {
        
        entrada();
        calculoNecesarios();
        boolean done[] = new boolean[CantProcesos];
        int j = 0;
 
        while (j < CantProcesos) {  //hasta que todos los procesos se asignen
            boolean asignado = false;
            for (int i = 0; i < CantProcesos; i++) {
                if (!done[i] && chequear(i)) {  //intentando asignar
                    for (int k = 0; k < CantRecursos; k++) {
                        disponibles[k] = disponibles[k] - necesarios[i][k] + maximos[i][k];
                    }
                    System.out.println("Proceso asignado : " + i);
                    asignado = done[i] = true;
                    j++;
                }
            }
            if (!asignado) {
                break;  //si no esta asignado
            }
        }
        
        if (j == CantProcesos) //si todos los procesos estan asignados
        {
            System.out.println("\nAsignado de forma segura");
        } else {
            System.out.println("Todos los procesos se pueden asignar de forma segura");
        }
     } 
}
