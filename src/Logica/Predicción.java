
package Logica;

public class Predicción {
    
    private int necesarios [][];     // Matriz resta entre maximos y asignados  
    private int asignados [][];      // Matriz que posee los recursos asignados em cierto momento
    private int maximos [][];        // Matriz que posee la cantidad maxima de recursos de cada Proceso
    private Recurso recursos [];         // Vector que posee los recursos maximos del sistema 
    private int disponibles [];      // Vector que posee los recursos disponibles por asignar 
    private int finalizados [];      // Vector que indica si el proceso hs finalizado o no
    private int CantProcesos;
    private int CantRecursos;
    private int posi = 0;
    private int posj;
    
    
    // Getters and Setters
    public int[][] getNecesarios() {
        return necesarios;
    }

    public void setNecesarios(int[][] necesarios) {
        this.necesarios = necesarios;
    }

    public int[][] getAsignados() {
        return asignados;
    }

    public void setAsignados(int[][] asignados) {
        this.asignados = asignados;
    }

    public int[][] getMaximos() {
        return maximos;
    }

    public void setMaximos(int[][] maximos) {
        this.maximos = maximos;
    }

    public int[] getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int[] disponibles) {
        this.disponibles = disponibles;
    }

    public int getCantProcesos() {
        return CantProcesos;
    }

    public void setCantProcesos(int CantProcesos) {
        this.CantProcesos = CantProcesos;
    }

    public int getCantRecursos() {
        return CantRecursos;
    }

    public void setCantRecursos(int CantRecursos) {
        this.CantRecursos = CantRecursos;
    }

    public int getPosi() {
        return posi;
    }

    public void setPosi(int posi) {
        this.posi = posi;
    }

    public int getPosj() {
        return posj;
    }

    public void setPosj(int posj) {
        this.posj = posj;
    }
    
    
    //Constructores
    public Predicción(Recurso[] recursos) {
        this.recursos = recursos;
    }

    public Predicción(int[][] necesarios, int[][] asignados, int[][] maximos, Recurso[] recursos, int[] disponibles, int[] finalizados, int CantProcesos, int CantRecursos) {
        this.necesarios = necesarios;
        this.asignados = asignados;
        this.maximos = maximos;
        this.recursos = recursos;
        this.disponibles = disponibles;
        this.finalizados = finalizados;
        this.CantProcesos = CantProcesos;
        this.CantRecursos = CantRecursos;
    }
    
    
    
    
    // ----------------------------- METODOS -----------------------------
    
    //Metodo que Inserta cada proceso en las matrices Maximos y Asignados 
    private void insertarProceso (int [] maxRecursosPerProceso, int [] vectorDeRecursos, int idProceso ) {
    
        for (int j = 0; j < vectorDeRecursos.length; j++) {
            asignados[idProceso][j]=0;
        }

        for (int j = 0; j < maxRecursosPerProceso.length; j++) {
            maximos[idProceso][j]=maxRecursosPerProceso[j];
        } 
    }
    
    // Metodo que finaliza el proceso
    private void finalizarProceso (int idProceso)
    {
        boolean procesoFinalizo = true;
        
        for (int i = 0; i < asignados[idProceso][i]; i++) {
            if (asignados[idProceso][i] != maximos[idProceso][i]) {
                procesoFinalizo = false;
            }
        }
        
        if (procesoFinalizo == true) {
            for (int i = 0; i < asignados[idProceso][i]; i++) {
                asignados[idProceso][i] = 0;
                maximos[idProceso][i] = 0;
            }
            
            finalizados[idProceso]= 1;
        }
    }
    
    // Metodo que comprueba si un proceso ha finalizado
    private boolean comprobarFinalizado (int idProceso) {
        if (finalizados[idProceso]!=0) {
            return true;
        }
        else
            return false;
    }
    
    //Metodo que Asigna los recursos a cada proceso
    private boolean asignar (int idProceso, int [] solicitud ){
        
        boolean desbloquea = true;
        boolean bloqueado = false;
        
        for (int i = 0; i < bloqueados[idProceso].lenght; i++) {
            if (bloqueados[idProceso][i] != solicitud[i]) {
                desbloquea = false;
            }
            
            if (bloqueados[idProceso][i] != 0) {
                bloqueado = true;
            }
        }
        
        if (desbloquea == true) {
            desbloquearProceso (idProceso);
            return true;
        }
        else if (bloqueado == false) {
            
            boolean conceder = true;
            
            for (int i = 0; i < recursos.length; i++) {
                if (solicitud[i]>recursos[i]) {
                    conceder = false;
                }
            }
            
            if (conceder == true) {
                
                for (int i = 0; i <recursos.length; i++) {
                    asignados[idProceso][i] = asignados[idProceso][i] + solicitud[i];
                }
                
            }
            
        }
        
        for (int i = 0; i <recursos.length; i++) {
            if ( solicitud[i] > maximos[posi][i] )
            {
                bloquear();
            }
        }
        
        for (int j = 0; j <recursos.length; j++) {
            asignados[idProceso][j]= asignados[idProceso][j] + solicitud[j];
        }
        
        for (int j = 0; j <recursos.length; j++) {
            recursos[j]= recursos[j]-asignados[posi][j];
        }
    
    }
    
    // Metodo que Inicializa las matrices
    private void entrada() {
         
        necesarios = new int[CantProcesos][CantRecursos];  
        maximos = new int[CantProcesos][CantRecursos];
        asignados = new int[CantProcesos][CantRecursos];
        disponibles = new int[CantRecursos];
        
    }
    
    // Metodo que calcula la matriz Necesidad
    private int[][] calculoNecesarios() {
        
        for (int i = 0; i < CantProcesos; i++) {
            for (int j = 0; j < CantRecursos; j++) 
            {
                necesarios[i][j] = maximos[i][j] - asignados[i][j];
            }
        }
 
        return necesarios;
    }
 
    // Metodo que chequea si todos los recursos para el proceso pueden ser asignados
    private boolean chequear(int i) {
        
        for (int j = 0; j < CantRecursos; j++) {
            if (disponibles[j] < necesarios[i][j]) {
                return false;
            }
        }
 
        return true;
    }
 
    // Metodo Es Seguro 
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
