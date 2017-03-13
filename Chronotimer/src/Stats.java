import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Stats {
	private LinkedList<Node> start;
	private LinkedList<Node> end;
	private ArrayList<Racer> racers;
	
	private class Node{
		private Racer racer;
		private long time;
		public Node(Racer racer, long time){
			this.racer = racer;
			this.time = time;
		}
	}
	
	public Stats(){
		start = new LinkedList<Node>();
		end = new LinkedList<Node>();
		racers = new ArrayList<Racer>();
	}
	
	public ArrayList<Racer> getRacers(){
		return this.racers;
	}
	
	public LinkedList<Node> getEndList(){
		return this.end;
	}
	
	public long getStart(Racer racer){
		Iterator<Node> it = start.iterator();
		while(it.hasNext()){
			Node tmp = it.next();
			if(racer == tmp.racer){
				return tmp.time;
			}
		}
		return -1; //return -1 if there is no start time for that racer
	}
	
	public void setStart(Racer racer, long time){
		start.add(new Node(racer, time));
		racers.add(racer);
	}
	
	public long getEnd(Racer racer){
		Iterator<Node> it = end.iterator();
		while(it.hasNext()){
			Node tmp = it.next();
			if(racer == tmp.racer){
				return tmp.time;
			}
		}
		return -1; //return -1 if there is no end time for that racer
	}
	
	public void setEnd(Racer racer, long time){
		Iterator<Node> it = end.iterator();
		boolean removed = false;	// new to not get a concurrent modification exception when all racers in the run are running
		while(it.hasNext() && removed == false){	// new 2nd condition to prevent concurrent modification exception
			Node tmp = it.next();
			if(racer == tmp.racer){
				end.remove(tmp);
				removed = true;	// new	to prevent concurrent modification exception
			}
		}
		end.add(new Node(racer, time));
	}
	
	public long getRaceTime(Racer racer) {
		long raceTime = -1;
		if ((this.getStart(racer) != -1) && (this.getEnd(racer) != -1)) {
			raceTime = this.getEnd(racer) - this.getStart(racer);
		}
		return raceTime;
	}
}