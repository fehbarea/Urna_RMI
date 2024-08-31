/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi_urnas;

/**
 *
 * @author felip
 */
public class Candidatos_Votos {
    
    private int numCandidato;
    private int numVotos;

    
    public Candidatos_Votos(int numCandidato, int numVotos){
        this.numCandidato = numCandidato;
        this.numVotos = numVotos;
    }
    
    public int getnumCandidato(){
        return numCandidato;
    }
    public int getnumVotos(){
        return numVotos;
    }
 
    
    public void setnumCandidato(int numCandidato){
        this.numCandidato = numCandidato;
    }
    
    public void setnumVotos(int numVotos){
        this.numVotos = numVotos;
    }

}
