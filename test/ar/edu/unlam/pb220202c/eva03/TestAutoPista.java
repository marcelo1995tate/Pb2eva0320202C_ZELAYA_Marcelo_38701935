package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista autopista=new Autopista();
		Automovil automovil=new Automovil("asd123");
		
		autopista.registrarTelepase(1, automovil);
		Integer  vehiculosIngresados=1;
		
		assertEquals(autopista.getTelapase().size(), vehiculosIngresados,0.1);
	}
	@Test(expected= VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		Autopista autopista=new Autopista();
		Automovil automovil=new Automovil("sd123a");
		
		autopista.salirAutpista(automovil);
	}
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFounException{
		Autopista autopista=new Autopista();
		Automovil automovil1=new Automovil("zzzz");
		Automovil automovil2=new Automovil("cccc");
		Automovil automovil3=new Automovil("aaaa");
		Automovil automovil4=new Automovil("mmmm");
		Automovil automovil=new Automovil("dddd");

		automovil4.incrmentarVelocidad(500);
		automovil1.incrmentarVelocidad(500);
		automovil2.incrmentarVelocidad(500);
		automovil3.incrmentarVelocidad(50);
		automovil.incrmentarVelocidad(200);

		try {
		autopista.registrarTelepase(4, automovil4);
		autopista.registrarTelepase(1, automovil1);
		autopista.registrarTelepase(2, automovil2);
		autopista.registrarTelepase(3, automovil3);
		autopista.registrarTelepase(0, automovil);
		
		autopista.ingresarAutopista(0);
		autopista.ingresarAutopista(4);
		autopista.ingresarAutopista(1);
		autopista.ingresarAutopista(2);
		autopista.ingresarAutopista(3);

		assertEquals(automovil1,autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().last());
		assertEquals(automovil2,autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().first());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	@Test
	public void ingresarUnVehiculoALaAutopista() throws VehiculoNotFounException {
		Autopista autopista=new Autopista();
		Automovil automovil1=new Automovil("zzz");
		
		autopista.registrarTelepase(1, automovil1);	
		try {
		autopista.ingresarAutopista(1);
		
		assertEquals(1, autopista.getVehiculosEnCirculacion().size());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Test
	public void sacarUnVehiculoDeLaAutopista() throws VehiculoNotFounException {
		Autopista autopista=new Autopista();
		Automovil automovil1=new Automovil("zzz");

		try {
		autopista.registrarTelepase(1, automovil1);
		autopista.ingresarAutopista(1);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		autopista.salirAutpista(automovil1);
		
		assertEquals(0, autopista.getVehiculosEnCirculacion().size());
	}
	
}
