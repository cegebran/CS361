public class Sensor implements Runnable{
	
	private int id;
	private Chronotimer c;
	
	public Sensor(int id, Chronotimer c){
		this.id = id;
		this.c = c;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				System.out.println("Sensor for Channel " + id + " triggered");
				c.trigger(Integer.toString(id));
			}
		}
	}
}