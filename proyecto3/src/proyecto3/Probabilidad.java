
package proyecto3;

import java.util.concurrent.TimeUnit;

public class Probabilidad {
    private Equipos A;
    private Equipos B;
    private double ProbaA;
    private double ProbaB;
    
    	public Probabilidad(){
            this.A = null;
            this.B = null;
            this.ProbaA = 0;
            this.ProbaB = 0;
        }
    
	public Probabilidad(Equipos A, Equipos B) {
		this.A = A;
		this.B = B;
		setProbabilidad();
	}

	public Equipos ganador(){
		double aux = Math.random();
                try{
                    Thread.sleep(5000);
		if(ProbaA <= ProbaB) {
			if(ProbaA <= aux)
				return A;
			else 
				return B;
			}else {
			if(ProbaB <= aux)
				return B;
			else 
				return A;
			}
                }
                catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
                return null;
	}
	
	public void setProbabilidad() {
		//Sacamos la probabilidad de cada uno y los guardamos en probaA y B
		ProbaA = (double) A.getHabilidad() / (A.getHabilidad() + B.getHabilidad());
		ProbaB = (double) B.getHabilidad() / (A.getHabilidad() + B.getHabilidad());
	}
	
//------------------------------------------------------------------------	
	public void setProbaA(double probabilidad) {
		this.ProbaA = probabilidad;
	}	
	public double getProbaA() {
		return ProbaA;
	}
	public void setProbaB(double probabilidad) {
		this.ProbaB = probabilidad;
	}	
	public double getProbaB() {
		return ProbaB;
	}
//------------------------------------------------------------------------
	public void setEquiposA(Equipos A) {
		this.A = A;
	}
	public void setEquiposB(Equipos B) {
		this.B = B;
	}	
	public Equipos getEquiposA() {
		return A;
	}
	public Equipos getEquiposB() {
		return B;
	}
//------------------------------------------------------------------------
}
