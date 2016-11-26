
package Logica;

import javax.swing.JTextArea;

public class Detección {
    
    private int necesarios [][] = new int[150][150];      
    private int asignacion [][] = new int[150][150];     
    private int maximos [][] = new int[150][150];        
    private int bloqueados[][] = new int[150][150];      
    private int vectorAuxiliar [] = new int[150];
    private int disponible [] = new int[150];
    private int recursos [] = new int[150]; 
    private boolean marcados[] = new boolean[150];
    private int finalizados[] = new int[150];
    private int eliminados [] = new int[150];
    private int CantProcesos;
    private int CantRecursos;
    private int pFin = 0;
    private int pEli = 0;
    private int bloqActual=0;
    private long tiempo = 0;
    private int ProcesosBloqueadosT = 0;
    private int ProcesosFinalizados = 0;
    private int SolicitudesRealizadas = 0;
    private int ProcesosSistema = 0;
    private int ProcesosEliminados = 0;
    private int ProcesosT = 0;
    public JTextArea ConsoleDeteccion;
    

   
    // ------------------------- GET & SET -------------------------
    
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

    public int getpFin() {
        return pFin;
    }

    public void setpFin(int pFin) {
        this.pFin = pFin;
    }

    public int getpEli() {
        return pEli;
    }

    public void setpEli(int pEli) {
        this.pEli = pEli;
    }

    public int getBloqActual() {
        return bloqActual;
    }

    public void setBloqActual(int bloqActual) {
        this.bloqActual = bloqActual;
    }

    public int getProcesosBloqueadosT() {
        return ProcesosBloqueadosT;
    }

    public void setProcesosBloqueadosT(int ProcesosBloqueadosT) {
        this.ProcesosBloqueadosT = ProcesosBloqueadosT;
    }

    public int getProcesosFinalizados() {
        return ProcesosFinalizados;
    }

    public void setProcesosFinalizados(int ProcesosFinalizados) {
        this.ProcesosFinalizados = ProcesosFinalizados;
    }

    public int getSolicitudesRealizadas() {
        return SolicitudesRealizadas;
    }

    public void setSolicitudesRealizadas(int SolicitudesRealizadas) {
        this.SolicitudesRealizadas = SolicitudesRealizadas;
    }

    public int getProcesosSistema() {
        return ProcesosSistema;
    }

    public void setProcesosSistema(int ProcesosSistema) {
        this.ProcesosSistema = ProcesosSistema;
    }

    public int getProcesosEliminados() {
        return ProcesosEliminados;
    }

    public void setProcesosEliminados(int ProcesosEliminados) {
        this.ProcesosEliminados = ProcesosEliminados;
    }

    public int getProcesosT() {
        return ProcesosT;
    }

    public void setProcesosT(int ProcesosT) {
        this.ProcesosT = ProcesosT;
    }
    
    
    
    
    // --------------------------- CONSTRUCTOR ---------------------------
    
    public Detección(Recurso [] x, JTextArea ConsoleDeteccion) {
        
        this.CantRecursos = x.length;
        this.ConsoleDeteccion = ConsoleDeteccion;
        
        for (int i = 0; i < 150; i++) {
            for (int j = 0; j < 150; j++) {
                asignacion[i][j]=0;
            }
        }
                
        for (int i = 0; i < 150; i++) 
        {
            for (int j = 0; j < 150; j++) 
            {
                necesarios[i][j]=0;
            }
        }
        
        for (int i = 0; i < 150; i++) 
        {
            vectorAuxiliar[i]=0;    
        }
                
        for (int i = 0; i < 150; i++) 
        {
            marcados[i]=false;    
        }
        
        for (int i = 0; i < 150; i++) {
            for (int j = 0; j < 150; j++) {
                maximos[i][j]=0;
            }
        }
    
        for (int i = 0; i < 150; i++) 
        {
            eliminados[i]=0;           
        }
                
        for (int i = 0; i < 150; i++)
        {
            finalizados[i]=0;           
        }
               
        for (int i = 0; i < 150; i++) 
        {
            for (int j = 0; j < 150; j++) 
            {
                bloqueados[i][j]=0;
            }
        }
        
        for (int i = 0; i < 150; i++) {
            if (x[i]!=null) {
                recursos[i] = x[i].getCantRecurso();
            }
            
        }
        
         for (int i = 0; i < 150; i++) {
            if (x[i]!=null) {
                disponible[i] = x[i].getCantRecurso();
            }
        }
    }
    
    
    // ----------------------------- METODOS -----------------------------

    // Metodo que Inicializa las matrices
    public void entrada() {
         
    }
    
    //Metodo que Inserta cada proceso en las matrices Maximos y Asignados 
    public void insertarProceso (int [] maxRecursosPerProceso, int idProceso ) {
    
        for (int j = 0; j < maximos.length; j++) {
            maximos[idProceso][j]=maxRecursosPerProceso[j];
        }
        
        marcados[idProceso]=false;
                
        ProcesosSistema++;
        ProcesosT++;
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
            
            for (int i = 0; i < disponible.length; i++) {
                
                if (solicitud[i] > disponible[i]) 
                {
                    conceder = false;
                }
            }
            
            if (conceder == true) {
                
                for (int i = 0; i <disponible.length; i++) 
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
    
    // Metodo que bloquea a un proceso
    public void bloquearProceso (int idProceso, int [] solicitud) {
    
        for (int i = 0; i <solicitud.length; i++) {
            bloqueados[idProceso][i] = solicitud[i];
            
        }
        bloqActual++;
        ProcesosBloqueadosT++;
        ConsoleDeteccion.append("Se Bloqueo el proceso "+idProceso+" \n");
    }
    
    // Metodo que desbloquea a un proceso
    public void desbloquearProceso (int idProceso) {
    
        for (int i = 0; i <bloqueados[idProceso].length; i++) {
            asignacion[idProceso][i] = asignacion[idProceso][i] + bloqueados[idProceso][i];
            bloqueados [idProceso][i] = 0;
        }
        bloqActual--;
        ConsoleDeteccion.append("Se Desbloqueo el proceso "+idProceso+" \n");
    }
    
    // Metodo que calcula la matriz Necesidad
    public void calculoNecesarios() {
        
        for (int i = 0; i < asignacion.length; i++) {
            for (int j = 0; j < disponible.length; j++) 
            {
                necesarios[i][j] = maximos[i][j] - asignacion[i][j];
            }
        }
 
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
            
            if(marcar == true)
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
                
                boolean comprob = true;
               
                if(marcados[i] == false)
                {         
                    for (int j = 0; j < asignacion[i].length; j++) {
                        
                        if(necesarios[i][j] > vectorAuxiliar[j])
                        {
                           comprob = false;
                        }
                    }
                    
                    if(comprob == true)
                    {  
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
                ProcesosT--;
                exito = false;
            }
        }
        return exito;
    }
    
    // Metodo que ejecuta el algoritmo 
    public void ejecutar(int idProcesos, int[] solicitud){
       
        long tiempo = System.nanoTime();
        boolean finalizo = comprobarFinalizado(idProcesos);
        boolean eliminado = comprobarEliminado(idProcesos);
        
        if( finalizo == false && eliminado == false)
        {
            boolean x;
            asignar(idProcesos, solicitud);
            x = detectar();
            
            if(x == true)
            {
               finalizarProceso(idProcesos);    
            }
        }
        
        for (int i = 0; i < marcados.length; i++) {
           marcados[i] = false;
        }
        
        long finishTime = System.nanoTime();
        tiempo = (finishTime - tiempo)/1000000;
        
        System.out.println(ProcesosSistema);
        
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
            pFin++;
            ProcesosSistema--;
            ConsoleDeteccion.append("Proceso Numero: "+idProceso+" finalizo exitosamente \n");
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
    
    // Metodo que elimina un proceso
    private void eliminarProceso(int idProceso){
         
        for (int i = 0; i < asignacion[idProceso][i]; i++) {
            
            disponible[i]= disponible[i] + asignacion[idProceso][i];
            asignacion[idProceso][i] = 0;
            maximos[idProceso][i] = 0;
        }
        
        eliminados[idProceso] = 1;
        ProcesosEliminados++;
        ProcesosSistema--;
        ConsoleDeteccion.append("Se elimino el proceso "+idProceso+" \n");
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
    
    
    
    
}
