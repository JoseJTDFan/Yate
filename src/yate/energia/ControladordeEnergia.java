package yate.energia;


public class ControladordeEnergia {

	public static void main(String args[]){
		int segundos=1;
		Batería vectorBateria[] = new Batería[Constantes.CANTIDAD_DE_BATERIAS];
		panelSolar vectorPanel[] = new panelSolar[Constantes.CANTIDAD_DE_PANELES];
		Navío navio= new Navío();
		float energiaPaneles = 0.0f;
		float porcentajeBateria = 0.0f;
		float porcentajeOtros = 0.0f;
		int otrosElementos = Constantes.CANTIDAD_DE_OTROS_ELEMENTOS;
		
		for (int x = 1; x <= Constantes.CANTIDAD_DE_BATERIAS; x++) {
	        String nombre = "bateria"+Integer.toString(x);
	        vectorBateria[x-1] = new Batería(nombre);
		}
		for (int x = 1; x <= Constantes.CANTIDAD_DE_PANELES; x++) {
	        String nombre = "panelSolar"+Integer.toString(x);
	        vectorPanel[x-1] = new panelSolar(nombre);
		}
		
		while (segundos<=60) {
			try {	
			Thread.sleep(1000);
			for (panelSolar panel : vectorPanel) {
				if (segundos%5==0) {
					panel.resetCapacity();
				}
				panel.setSunlevel();
				panel.setCapacity();
				energiaPaneles+=panel.getCapacity();
			} 
			navio.setVelocidad(segundos);
			for (Batería bateria : vectorBateria) {
				System.out.println("Carga "+bateria.getName()+": "+bateria.consumirEnergia(navio.setConsumo()));
				if (segundos%3==0) {
					porcentajeBateria= (energiaPaneles*0.50f)/(vectorBateria.length+0.0f);
					System.out.println(porcentajeBateria);
					bateria.cargar(porcentajeBateria);
					energiaPaneles-=porcentajeBateria;
					
				}
				if (otrosElementos != 0) {
					porcentajeOtros=(energiaPaneles*0.50f)/(otrosElementos+0.0f);
					//ACÁ PARA AGREGAR NEUVOS ELEMENTOS
				}
				
			}
			energiaPaneles=0.0f;
			System.out.println("Velocidad Navío : "+navio.getVelocidad()+" km/h.");
			segundos++;
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
}
}