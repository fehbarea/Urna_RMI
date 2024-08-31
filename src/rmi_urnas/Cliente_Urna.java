
package rmi_urnas;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


/**
 *
 * @author felip
 */
public class Cliente_Urna {
    
    public static void main(String[] args){
        
        try{
        Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            
        Gerenciador_votos stub = (Gerenciador_votos)registro.lookup("urna");
        
        Scanner leitor = new Scanner(System.in);

        System.out.println("Informe o NUMERO do candidato:"); 
        int numCandidato = leitor.nextInt();
        System.out.println("Informe o NUMERO de votos:"); 
        int numVotos = leitor.nextInt();
        
        stub.recebeVotos(numCandidato, numVotos);
        
        System.out.println(numVotos + " votos foram cadastrados para "+ numCandidato);
        
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
