public class Sensor {
	private boolean start;
	
	public Sensor(boolean start){
		this.start = start;
	}
	
	public void toggle(boolean start){
		this.start = start;
	}
	
	public boolean getStart(){
		return this.start;
	}
}