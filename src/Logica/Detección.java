
package Logica;

public class Detección {
    
    private int asignacion [][];
    private int necesarios [][];
    private int maximos [][];
    private int bloqueados [][];
    private int vectorAuxiliar [];
    private int disponible [];
    private boolean marcados[];
    private int finalizados[];
    private int eliminados [];
    private int CantProcesos;
    private int CantRecursos;
    private long tiempo;

    //Getters and Setters
    
    public int[][] getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(int[][] asignacion) {
        this.asignacion = asignacion;
    }

    public int[][] getNecesarios() {
        return necesarios;
    }

    public void setNecesarios(int[][] necesarios) {
        this.necesarios = necesarios;
    }

    public int[][] getMaximos() {
        return maximos;
    }

    public void setMaximos(int[][] maximos) {
        this.maximos = maximos;
    }

    public int[][] getBloqueados() {
        return bloqueados;
    }

    public void setBloqueados(int[][] bloqueados) {
        this.bloqueados = bloqueados;
    }

    public int[] getVectorAuxiliar() {
        return vectorAuxiliar;
    }

    public void setVectorAuxiliar(int[] vectorAuxiliar) {
        this.vectorAuxiliar = vectorAuxiliar;
    }

    public int[] getDisponible() {
        return disponible;
    }

    public void setDisponible(int[] disponible) {
        this.disponible = disponible;
    }

    public boolean[] getMarcados() {
        return marcados;
    }

    public void setMarcados(boolean[] marcados) {
        this.marcados = marcados;
    }

    public int[] getFinalizados() {
        return finalizados;
    }

    public void setFinalizados(int[] finalizados) {
        this.finalizados = finalizados;
    }

    public int[] getEliminados() {
        return eliminados;
    }

    public void setEliminados(int[] eliminados) {
        this.eliminados = eliminados;
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

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }
    
    // Constructor
    
    public Detección(int[][] asignacion, int[][] necesarios, int[][] maximos, int[][] bloqueados, int[] vectorAuxiliar, int[] disponible, boolean[] marcados, int[] finalizados, int[] eliminados, int CantProcesos, int CantRecursos, long tiempo) {
        this.asignacion = asignacion;
        this.necesarios = necesarios;
        this.maximos = maximos;
        this.bloqueados = bloqueados;
        this.vectorAuxiliar = vectorAuxiliar;
        this.disponible = disponible;
        this.marcados = marcados;
        this.finalizados = finalizados;
        this.eliminados = eliminados;
        this.CantProcesos = CantProcesos;
        this.CantRecursos = CantRecursos;
        this.tiempo = tiempo;
    }
    
    // ----------------------------- METODOS -----------------------------

    
    //Metodo que Inserta cada proceso en las matrices Maximos y Asignados 
    public void insertarProceso (int [] maxRecursosPerProceso, int [] vectorDeRecursos, int idProceso ) {
    
        for (int j = 0; j < vectorDeRecursos.length; j++) {
            asignacion[idProceso][j]=0;
        }

        for (int j = 0; j < maxRecursosPerProceso.length; j++) {
            maximos[idProceso][j]=maxRecursosPerProceso[j];
        } 
    }
    
    // Metodo que finaliza el proceso
    public void finalizarProceso (int idProceso)
    {
        boolean procesoFinalizo = true;
        
        for (int i = 0; i < asignacion[idProceso].length; i++) {
            if (asignacion[idProceso][i] != maximos[idProceso][i]) {
                procesoFinalizo = false;
            }
        }
        
        if (procesoFinalizo == true) {
            for (int i = 0; i < asignacion[idProceso][i]; i++) {
                disponible[i] = asignacion[idProceso][i];
                asignacion[idProceso][i] = 0;
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
        
        for (int i = 0; i < bloqueados[idProceso].length; i++) 
        {
            if (bloqueados[idProceso][i] != solicitud[i]) 
            {
                desbloquea = false;
            }
            
            if (bloqueados[idProceso][i] != 0) 
            {
                bloqueado = true;
            }
        }
        
        if (desbloquea == true) 
        {
            desbloquearProceso (idProceso);
            return true;
        }
        else if (bloqueado == false) 
        {
            
            boolean conceder = true;
            
            for (int i = 0; i < disponible[i]; i++) {
                
                if (solicitud[i] > disponible[i]) 
                {
                    conceder = false;
                }
            }
            
            if (conceder == true) {
                
                for (int i = 0; i <disponible[i]; i++) 
                {
                    asignacion[idProceso][i] = asignacion[idProceso][i] + solicitud[i];
                    disponible[i]=disponible[i] - solicitud[i];
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
    
    // Metodo que desbloquea a un proceso
    public void desbloquearProceso (int idProceso) {
    
        for (int i = 0; i <bloqueados[idProceso].length; i++) {
            asignacion[idProceso][i] = asignacion[idProceso][i] + bloqueados[idProceso][i];
            bloqueados [idProceso][i] = 0;
        }
    }
    
    // Metodo que bloquea a un proceso
    public void bloquearProceso (int idProceso, int [] solicitud) {
    
        for (int i = 0; i <solicitud.length; i++) {
            bloqueados[idProceso][i] = solicitud[i];
            asignacion[idProceso][i] = asignacion[idProceso][i] - solicitud[i];
        }
    }
    
    // Metodo que calcula la matriz Necesidad
    public int[][] calculoNecesarios() {
        
        for (int i = 0; i < CantProcesos; i++) {
            for (int j = 0; j < CantRecursos; j++) 
            {
                necesarios[i][j] = maximos[i][j] - asignacion[i][j];
            }
        }
 
        return necesarios;
    }
    
    // Metodo que Inicializa las matrices
    public void entrada() {
         
        necesarios = new int[CantProcesos][CantRecursos];  
        maximos = new int[CantProcesos][CantRecursos];
        asignacion = new int[CantProcesos][CantRecursos];
        disponible = new int[CantRecursos];
        bloqueados = new int [CantProcesos][CantRecursos];
        finalizados = new int [CantProcesos]; 
        marcados = new boolean [CantProcesos];
        vectorAuxiliar = new int [CantProcesos];
    }
    
    // Metodo de deteccion
    private boolean detectar()
    {
        
        entrada();
        calculoNecesarios();
        
        for (int i = 0; i < asignacion.length; i++) 
        {
            boolean marcar = true;
            
            for (int j = 0; j < asignacion[i].length; j++) {
                
                if(asignacion[i][j] != 0)
                {
                   marcar = false;
                }
            }
            
            if(marcar)
            {
                marcados[i] = true;
            }
                
        }
        
        for (int i = 0; i <disponible.length; i++) {
            
            vectorAuxiliar[i] = disponible[i];     
        }
        
        boolean proceder = true;
        
        while(proceder == true)
        {
            proceder = false;
            
            for(int i = 0; i <asignacion.length; i++) {
                
                boolean verificar = true;
               
                if(marcados[i] == false){
                    
                    for (int j = 0; j < asignacion[i].length; j++) {
                        
                        if(necesarios[i][j] > vectorAuxiliar[j])
                        {
                           verificar = false;
                        }
                    }
                    if(verificar == true){
                        
                        proceder = true;
                        
                        for (int j = 0; j < asignacion[i].length; j++) {
                            vectorAuxiliar[j] = vectorAuxiliar[j] + asignacion[i][j];
                            marcados[i] = true;
                        }
                    }
                }    
            }
        }
        
        boolean exito = true;
        
        for (int i = 0; i < marcados.length; i++) {
            
            if(marcados[i] == false){
                
                eliminarProceso(i);
                exito = false;
            }
        }
        return exito;
    }
    
    // Metodo que elimina un proceso
    private void eliminarProceso(int idProcesos){
         
        for (int i = 0; i < asignacion[idProcesos][i]; i++) {
            
            disponible[i]= disponible[i] + asignacion[idProcesos][i];
            asignacion[idProcesos][i] = 0;
            maximos[idProcesos][i] = 0;
        }
        
        eliminados[idProcesos] = 1;
    }
    
    // Metodo que comprueba si hay proceso eliminado
    private boolean comprobarEliminado(int idProcesos){
        
        if(eliminados[idProcesos] != 0)
        {
           return true;
        }
        else
        {
           return false;
        }
        
    }
    
    // Metodo que ejecuta el algoritmo 
    private void ejecutar(int idProcesos, int[] solicitud){
       
        long tiempo = System.nanoTime();
        boolean finalizo = comprobarFinalizado(idProcesos);
        boolean eliminado = comprobarEliminado(idProcesos);
        
        if( finalizo == false && eliminado == false)
        {
            boolean x;
            asignar(idProcesos, solicitud);
            x = detectar();
            
            if(x)
            {
               finalizarProceso(idProcesos);    
            }
        }
        
        for (int i = 0; i < marcados.length; i++) {
           marcados[i] = false;
        }
        
        long finishTime = System.nanoTime();
        tiempo = (finishTime - tiempo)/1000000;
        
    }
    
    
}
