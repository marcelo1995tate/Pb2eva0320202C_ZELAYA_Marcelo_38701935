package ar.edu.unlam.pb220202c.eva03;

public class Camion extends Vehiculo implements Imultable{
	
		private Integer cantidadDeEjes;

	public Camion(String patente, Integer cantidadDeEjes) {
		super(patente,80,0);
		this.cantidadDeEjes=cantidadDeEjes;
	
	}

	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los que crean conveniente
	//el Limite de velociadad para autos es de 80km
	//en caso que supere dicho limite el este sera multado

	@Override
	public void incrmentarVelocidad(Integer Velocidad) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Boolean enInfraccion() {
		if(VelocidadActual>limiteVelocidad) {
			return true;
		}
		return false;
	}

	public Integer getCantidadDeEjes() {
		return cantidadDeEjes;
	}

	public void setCantidadDeEjes(Integer cantidadDeEjes) {
		this.cantidadDeEjes = cantidadDeEjes;
	}
	@Override
	public int compareTo(Vehiculo o) {
	
		return Patente.compareToIgnoreCase(o.getPatente());
	}
	
}
