package yate.energia;


public class panelSolar {
	private float sunlevel=0.0f;
	private float capacidad=0.0f;
	private float descarga=0;
	public boolean enabled;
	
	public panelSolar(String pname) {
		this.capacidad=0.0f;
		this.sunlevel=0.0f;
		descarga=0;
	}
	
	public void encender() {
		enabled = true;
	}
	
	public void apagar() {
		this.enabled = false;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setSunlevel() {
		this.sunlevel = ((int)(Math.random()*Constantes.MAX_ENERGY_SUN+Constantes.MIN_ENERGY_SUN)+0.0f);
		if (this.sunlevel>Constantes.MAX_ENERGY_SUN){
			this.sunlevel-=1;
		}
	}
	
	public void setCapacity() {
		if (this.capacidad+this.sunlevel>Constantes.MAX_CAPACITY);
			this.capacidad+=this.sunlevel;
	}
	
	public void resetCapacity() {
		this.capacidad-=0.8f;
	}
	
	public float getCapacity() {
		return this.capacidad;
	}
	
	public float getSunlevel() {
		return this.sunlevel;
	}
	
	public float  carga() {
		float carga=0.0f;
		carga= capacidad;
		return descarga;
	}
}
