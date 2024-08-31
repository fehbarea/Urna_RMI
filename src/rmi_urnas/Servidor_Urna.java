
package rmi_urnas;
import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author felipe
 */
public class Servidor_Urna implements Gerenciador_votos {
    
    private List<Candidatos_Votos> candidatos_votos = new ArrayList<>();
    
    public Servidor_Urna(){
        
    }
    
    @Override
    public void recebeVotos(int numCandidato, int numVotos) throws RemoteException {
       
        boolean candidatoExiste = procuraCandidato(numCandidato);
        
        if(candidatoExiste){
            incrementaVotos(numCandidato, numVotos);
        }
        else{
            candidatos_votos.add(new Candidatos_Votos(numCandidato, numVotos));
        }
        
    }
    
    private void apuracaoVotos(){
        do{
        System.out.println("Apuracao de votos:");
        System.out.println(" Numero candidato/votos");
        for(Candidatos_Votos i : candidatos_votos){
             System.out.println("- " + i.getnumCandidato()+"/" + i.getnumVotos());
        }
        try {
            Thread.sleep(5000); //milissegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }while(true);
    }
    
    private boolean procuraCandidato(int num){
        
        for(Candidatos_Votos i : candidatos_votos){
             if(i.getnumCandidato() == num){
                 return true;
             }
        }
        return false;
    }
    
    private void incrementaVotos(int numC, int numV){
        
        for(Candidatos_Votos i : candidatos_votos){
             if(i.getnumCandidato() == numC){
                 i.setnumVotos(i.getnumVotos()+ numV);
             }
        }
    }
    
    
    
    public static void main(String[] args) {
    
        try{
            Servidor_Urna servidor = new Servidor_Urna();
            
            Gerenciador_votos stub = (Gerenciador_votos)UnicastRemoteObject.exportObject(servidor, 0);
            
            Registry registro = LocateRegistry.createRegistry(1099);
            
            registro.rebind("urna", stub);            
            
            System.out.println("Servidor RMI está pronto para receber candidatos e votos");
            
            servidor.apuracaoVotos();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
            
}

