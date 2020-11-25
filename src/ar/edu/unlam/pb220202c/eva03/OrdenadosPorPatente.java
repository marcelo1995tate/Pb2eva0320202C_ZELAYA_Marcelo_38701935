package ar.edu.unlam.pb220202c.eva03;

import java.util.Comparator;

public class OrdenadosPorPatente implements Comparator<Vehiculo> {

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
			if(o1.getPatente().compareToIgnoreCase(o2.getPatente())==0)
			return 0;
			if(o1.getPatente().compareToIgnoreCase(o2.getPatente())<0)
				return -1;
			return 1;

	}

}
