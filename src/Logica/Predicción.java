
package Logica;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Predicción {
    
    private int necesarios [][] = new int[150][150];     // Matriz resta entre maximos y asignados  
    private int asignados [][] = new int[150][150];      // Matriz que posee los recursos asignados em cierto momento
    private int maximos [][] = new int[150][150];        // Matriz que posee la cantidad maxima de recursos de cada Proceso
    private int bloqueados[][] = new int[150][150];      // Matriz que posee los procesos bloqueados
    private int recursos [] = new int[150];              // Vector que posee los recursos maximos del sistema 
    private int disponibles [] = new int[150];           // Vector que posee los recursos disponibles por asignar 
    private int finalizados [] = new int[150];           // Vector que indica si el proceso hs finalizado o no
    private int auxiliar [] = new int[150];
    public JTextArea ConsolePrediccion;
    private int CantProcesos;
    private int CantRecursos;
    private long tiempo = 0;
    private int ProcesosBloqueados = 0;
    private int ProcesosBloqueadosT = 0;
    private int ProcesosFinalizados = 0;
    private int SolicitudesRealizadas = 0;
    private int ProcesosSistema = 0;
    private int ProcesosT = 0;
    
    // ----------------------------- GET & SET -----------------------------
    
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

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public int getProcesosBloqueados() {
        return ProcesosBloqueados;
    }

    public void setProcesosBloqueados(int ProcesosBloqueados) {
        this.ProcesosBloqueados = ProcesosBloqueados;
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

    public int getProcesosT() {
        return ProcesosT;
    }

    public void setProcesosT(int ProcesosT) {
        this.ProcesosT = ProcesosT;
    }

    
    
    // --------------------------- CONSTRUCTOR ---------------------------
    

    public Predicción(Recurso [] x, JTextArea ConsolePrediccion) {

        this.CantRecursos = x.length;
        this.CantProcesos = 150;
        this.ConsolePrediccion=ConsolePrediccion;
        
        
        for (int i = 0; i < 150; i++) {
            for (int j = 0; j < 150; j++) {
                asignados[i][j]=0;
            }
        }
        
        for (int i = 0; i < 150; i++) {
            for (int j = 0; j < 150; j++) {
                maximos[i][j]=0;
            }
        }
        
        for (int i = 0; i < 150; i++) {
            for (int j = 0; j < 150; j++) {
                bloqueados[i][j]=0;
            }
        }
        
        for (int i = 0; i < 150; i++) {   
            finalizados[i]=0;    
        }
        
        for (int i = 0; i < 150; i++) {
            recursos[i]=0;
        }
        
        for (int i = 0; i < 150; i++) {
            if (x[i]!=null) {
                recursos[i] = x[i].getCantRecurso();
            }
            
        }
        
         for (int i = 0; i < 150; i++) {
            if (x[i]!=null) {
                disponibles[i] = x[i].getCantRecurso();
            }
        }
        
    }

    
    // ----------------------------- METODOS -----------------------------
    
    // Metodo que Inicializa las matrices
    public void entrada() {
           
    }
    
    //Metodo que Inserta cada proceso en las matrices Maximos y Asignados 
    public void insertarProceso (int [] maxRecursosPerProceso, int idProceso ) {
    
        for (int j = 0; j < recursos.length; j++) {
            asignados[idProceso][j]=0;
        }

        for (int j = 0; j < maxRecursosPerProceso.length; j++) {
            maximos[idProceso][j]=maxRecursosPerProceso[j];
        } 
        
        ProcesosSistema++;
        ProcesosT++;
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
        else if (!bloqueado) {
            
            boolean conceder = true;
            
            for (int i = 0; i < recursos.length; i++) {
                if (solicitud[i] > disponibles[i]) {
                    conceder = false;
                }
            }
            
            if (conceder == true) {
                
                for (int i = 0; i <recursos.length; i++) {
                    asignados[idProceso][i] = asignados[idProceso][i] + solicitud[i];
                    disponibles[i]= disponibles[i] - solicitud[i];
                }   
            }
            else 
            {
                bloquearProceso(idProceso, solicitud, 0);
            }
            return true;    
        }
        else
        {
            return false;
        }
    }
    
    // Metodo que bloquea a un proceso
    public void bloquearProceso (int idProceso, int [] solicitud, int x) {
        
        if (x==1) {
        
            for (int i = 0; i <solicitud.length; i++) {
                bloqueados[idProceso][i] = solicitud[i];
                asignados[idProceso][i] = asignados[idProceso][i] - solicitud[i];
                disponibles[i] = disponibles[i] + solicitud[i];
                 
            }
            ProcesosBloqueados++;
            ProcesosBloqueadosT++;
            ConsolePrediccion.append("Se Bloqueo el proceso "+idProceso+" \n");
        }
        else
        {
            for (int i = 0; i <solicitud.length; i++) {
                bloqueados[idProceso][i] = solicitud[i];
            }
            ProcesosBloqueados++;
            ProcesosBloqueadosT++;
            ConsolePrediccion.append("Se Bloqueo el proceso "+idProceso+" \n");
        }
    }
    
    // Metodo que desbloquea a un proceso
    public void desbloquearProceso (int idProceso) {
    
        for (int i = 0; i < bloqueados[idProceso].length; i++) {
            asignados[idProceso][i] = asignados[idProceso][i] + bloqueados[idProceso][i];
            bloqueados [idProceso][i] = 0;
        }
        
        ProcesosBloqueados--;
    }
    
    // Metodo que calcula la matriz Necesidad
    public void calculoNecesarios() {
        
        for (int i = 0; i < 150; i++) {
            for (int j = 0; j < CantRecursos; j++) 
            {
                necesarios[i][j] = maximos[i][j] - asignados[i][j];
            }
        }
    }
 
    // Metodo que chequea si todos los recursos para el proceso pueden ser asignados
    public boolean chequear(int i, int [] auxiliar) {
        
        for (int j = 0; j < CantRecursos; j++) {
            if (auxiliar[j] < necesarios[i][j]) {
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
        
        for (int x = 0; x <disponibles.length; x++) 
        {
            auxiliar[x] = disponibles[x];
        }
        
        while (j < CantProcesos) 
        {     
            boolean asignado = false;
            
            for (int i = 0; i < CantProcesos; i++) {
                
                if (!done[i] && chequear(i, auxiliar)) 
                {  
                    for (int k = 0; k < CantRecursos; k++) {
                        auxiliar[k] = auxiliar[k] - necesarios[i][k] + maximos[i][k];
                    }
                    //System.out.println("Proceso asignado : " + i);
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
            ConsolePrediccion.append("Asignado de forma segura \n");
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
        
        System.out.println(CantProcesos);
        
        long tiempo = System.nanoTime();
        boolean end = comprobarFinalizado(idProceso);
        if( end == false){
            boolean valido = asignar(idProceso, solicitud);
            if(valido == true){
                if( esSeguro(idProceso) == false)
                {
                   bloquearProceso(idProceso, solicitud, 1);
                }
                else
                {
                   finalizarProceso(idProceso);
                }
            }
            else
                 ConsolePrediccion.append("Solicitud Negada \n");
        }
        long finishTime = System.nanoTime();
        tiempo = (finishTime-tiempo)/1000000;
        
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
            ProcesosFinalizados++;
            ConsolePrediccion.append("Proceso Numero: "+idProceso+"  finalizo exitosamente \n");
        }
    }
    
    // Metodo que comprueba si un proceso ha finalizado
    public boolean comprobarFinalizado (int idProceso) {
        if (finalizados[idProceso] != 0) {
            return true;
        }
        else
            return false;
    }
}
