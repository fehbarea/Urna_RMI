
package rmi_urnas;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author felipe
 */
public interface Gerenciador_votos extends Remote {
    
    void recebeVotos(int numCandidato, int numVotos) throws RemoteException;
    
}
