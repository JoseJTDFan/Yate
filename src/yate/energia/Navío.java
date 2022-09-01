package yate.energia;

public class Navío {
	public boolean enabled;
	private float velocidad;
	
	public Navío(){
		velocidad=0.0f;
		
	}
	
	
	public void setVelocidad(int cont) {
		if (cont%5==0) {
			this.velocidad+=5.0f;
		}
	}
	
	public float getVelocidad() {
		return this.velocidad;
	}
	
	public float setConsumo() {
		float consumo=0.0f;
		consumo=(this.velocidad+1.0f)*0.1f;
		return consumo;
	}
}
