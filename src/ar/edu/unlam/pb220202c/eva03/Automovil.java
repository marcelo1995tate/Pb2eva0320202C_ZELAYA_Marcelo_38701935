package ar.edu.unlam.pb220202c.eva03;

public class Automovil  extends Vehiculo implements Imultable{

	public Automovil(String patente) {	
		super(patente,130,0);
	}

	@Override
	public void incrmentarVelocidad(Integer Velocidad) {
		this.VelocidadActual=Velocidad;
	}

	@Override
	public Boolean enInfraccion() {
		if(VelocidadActual>limiteVelocidad) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Vehiculo o) {
	
		return Patente.compareToIgnoreCase(o.getPatente());
	}

	//Si es necesario Utilice herencia o implemente de Interfaces
//	Se debe crear contructeres getters y Setters y loos que crean convenientes
	
//el Limite de velociadad para autos es de 130km
//en caso que supere dicho limite el este sera multado

	
	
   
	
}
