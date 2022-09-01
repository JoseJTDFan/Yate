package yate.energia;


public class Batería {
	public boolean enabled;
	private String name;
	private float energyLevel;
	private panelSolar panel;
	private boolean charging = false;
	
	public Batería(String pname){
		this.energyLevel= 100.0f;
		this.name= pname;
	}
	public void encender() {
		enabled = true;
	}
	
	public void apagar() {
		this.enabled = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float consumirEnergia(float porcentaje) {
		if (this.energyLevel-porcentaje>=0) {
			this.energyLevel-= porcentaje;
		}
		return this.energyLevel;
		
	}
	
	public void cargar(float carga) {
		if (this.energyLevel+carga<=Constantes.MAX_BATERIA) {
			this.energyLevel+= carga;
		}
		
	}
	
}
