package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telapase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	public Autopista() {
		telapase=new HashMap<Integer, Vehiculo>();
		vehiculosEnCirculacion= new HashSet<Vehiculo>();
	}
	
	public void registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		telapase.put(numeroTelpase, vehiculo);
	}
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException{
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	   // y no permite ingresar al autopista	
	if(telapase.get(numeroTelepase)==null) {
		throw new VehiculoNotFounException("Vehiculo no ingresado a la autopista");
	}
		return vehiculosEnCirculacion.add(telapase.get(numeroTelepase));
	}
	
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFounException {
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
				if (vehiculosEnCirculacion.remove(vehiculo)) {
					return;
				}
				throw new VehiculoNotFounException("El vehiculo no esta en circulacion");

		}
		
	
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		TreeSet<Vehiculo> orden= new TreeSet<Vehiculo>(new OrdenadosPorPatente());
		for (Vehiculo vehiculo : vehiculosEnCirculacion) {
			if (vehiculo.enInfraccion()) {
				orden.add(vehiculo);
			}
		}
		return orden;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
	
		return vehiculosEnCirculacion.size();
}
	public HashMap<Integer, Vehiculo> getTelapase() {
		return telapase;
	}
	public void setTelapase(HashMap<Integer, Vehiculo> telapase) {
		this.telapase = telapase;
	}
	public HashSet<Vehiculo> getVehiculosEnCirculacion() {
		return vehiculosEnCirculacion;
	}
	public void setVehiculosEnCirculacion(HashSet<Vehiculo> vehiculosEnCirculacion) {
		this.vehiculosEnCirculacion = vehiculosEnCirculacion;
	}
	
	
	}
