
package Logica;

public class Predicción {
    
    private int necesarios [][];     // Matriz resta entre maximos y asignados  
    private int asignados [][];      // Matriz que posee los recursos asignados em cierto momento
    private int maximos [][];        // Matriz que posee la cantidad maxima de recursos de cada Proceso
    private int bloqueados[][];
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
    public void insertarProceso (int [] maxRecursosPerProceso, int [] vectorDeRecursos, int idProceso ) {
    
        for (int j = 0; j < vectorDeRecursos.length; j++) {
            asignados[idProceso][j]=0;
        }

        for (int j = 0; j < maxRecursosPerProceso.length; j++) {
            maximos[idProceso][j]=maxRecursosPerProceso[j];
        } 
    }
    
    // Metodo que finaliza el proceso
    public void finalizarProceso (int idProceso)
    {
        boolean procesoFinalizo = true;
        
        for (int i = 0; i < asignados[idProceso].length; i++) {
            if (asignados[idProceso][i] != maximos[idProceso][i]) {
                procesoFinalizo = false;
            }
        }
        
        if (procesoFinalizo == true) {
            for (int i = 0; i < asignados[idProceso][i]; i++) {
                disponibles[i] = asignados[idProceso][i];
                asignados[idProceso][i] = 0;
                maximos[idProceso][i] = 0;
            }
            
            finalizados[idProceso]= 1;
        }
    }
    
    // Metodo que comprueba si un proceso ha finalizado
    public boolean comprobarFinalizado (int idProceso) {
        if (finalizados[idProceso]!=0) {
            return true;
        }
        else
            return false;
    }
    
    //Metodo que Asigna los recursos a cada proceso
    public boolean asignar (int idProceso, int [] solicitud ){
        
        boolean desbloquea = true;
        boolean bloqueado = false;
        
        for (int i = 0; i < bloqueados[idProceso].length; i++) {
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
                if (solicitud[i]>recursos[i].getCantRecurso()) {
                    conceder = false;
                }
            }
            
            if (conceder == true) {
                
                for (int i = 0; i <recursos.length; i++) {
                    asignados[idProceso][i] = asignados[idProceso][i] + solicitud[i];
                    recursos[i].setCantRecurso(recursos[i].getCantRecurso() - solicitud[i]);
                }   
            }
            else 
            {
                bloquearProceso(idProceso, solicitud);
            }
            return true;    
        }
        else
        {
            return false;
        }
    }
    
    // Metodo que Inicializa las matrices
    public void entrada() {
         
        necesarios = new int[CantProcesos][CantRecursos];  
        maximos = new int[CantProcesos][CantRecursos];
        asignados = new int[CantProcesos][CantRecursos];
        disponibles = new int[CantRecursos];
        bloqueados = new int [CantProcesos][CantRecursos];
        finalizados = new int [CantProcesos];
        
    }
    
    // Metodo que desbloquea a un proceso
    public void desbloquearProceso (int idProceso) {
    
        for (int i = 0; i <bloqueados[idProceso].length; i++) {
            asignados[idProceso][i] = asignados[idProceso][i] + bloqueados[idProceso][i];
            bloqueados [idProceso][i] = 0;
        }
    }
    
    // Metodo que bloquea a un proceso
    public void bloquearProceso (int idProceso, int [] solicitud) {
    
        for (int i = 0; i <solicitud.length; i++) {
            bloqueados[idProceso][i] = solicitud[i];
            asignados[idProceso][i] = asignados[idProceso][i] - solicitud[i];
        }
    }
    
    // Metodo que calcula la matriz Necesidad
    public int[][] calculoNecesarios() {
        
        for (int i = 0; i < CantProcesos; i++) {
            for (int j = 0; j < CantRecursos; j++) 
            {
                necesarios[i][j] = maximos[i][j] - asignados[i][j];
            }
        }
 
        return necesarios;
    }
 
    // Metodo que chequea si todos los recursos para el proceso pueden ser asignados
    public boolean chequear(int i) {
        
        for (int j = 0; j < CantRecursos; j++) {
            if (disponibles[j] < necesarios[i][j]) {
                return false;
            }
        }
 
        return true;
    }
 
    // Metodo Es Seguro 
    public boolean esSeguro(int idProceso) {
        
        entrada();
        calculoNecesarios();
        boolean [] done = new boolean[CantProcesos];
        int j = 0;
 
        while (j < CantProcesos) 
        {     
            boolean asignado = false;
            
            for (int i = 0; i < CantProcesos; i++) {
                
                if (!done[i] && chequear(i)) 
                {  
                    for (int k = 0; k < CantRecursos; k++) {
                        disponibles[k] = disponibles[k] - necesarios[i][k] + maximos[i][k];
                    }
                    System.out.println("Proceso asignado : " + i);
                    asignado = done[i] = true;
                    j++;
                }
            }
            
            if (!asignado) {
                break;  
            }
        }
        
        if (j == CantProcesos) 
        {
            System.out.println("\nAsignado de forma segura");
            return true;
        } 
        else 
        {
            System.out.println("Todos los procesos se pueden asignar de forma segura");
            return false;
        } 
    }
    
    // Metodo que ejecuta el algoritmo
    public void ejecutar(int idProceso, int [] solicitud){
        long tiempo = System.nanoTime();
        boolean end = comprobarFinalizado(idProceso);
        if( end == false){
            boolean valido = asignar(idProceso, solicitud);
            if(valido == true){
                if( esSeguro(idProceso) == false)
                    bloquearProceso(idProceso, solicitud);
            }
            else
                System.out.println("SE NEGO LA SOLICITUD");
        }
        long finishTime = System.nanoTime();
        tiempo=(finishTime-tiempo)/1000000;
        
    }
}
