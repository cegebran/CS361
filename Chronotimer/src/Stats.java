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
	
	public String getLastToFinish(){
		if(end.isEmpty()){
			return null;
		}else{
			Node lastNode = end.getLast();
			int value = end.indexOf(lastNode);
			boolean pos = false;
			while(value >= 0 && pos == false){
				Racer last = end.get(value).racer;
				int bib = last.getBib();
				String bibS = Integer.toString(bib);
				long raceTime = getRaceTime(last);
				if(raceTime < 0){
					pos = false;
				}else{
					String raceTimeS = String.valueOf(raceTime);
					return bibS + ";" + raceTimeS;
				}
				value--;
			}
			return null;
		}
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
	
	public void cancel(Racer racer){
		Iterator<Node> it = start.iterator();
		while(it.hasNext()){
			Node tmp = it.next();
			if(racer == tmp.racer){
				it.remove();
				break;
			}
		}
		Iterator<Racer> it2 = racers.iterator();
		while(it2.hasNext()){
			Racer tmp2 = it2.next();
			if(racer == tmp2){
				it2.remove();
				break;
			}
		}
		Iterator<Node> it3 = end.iterator();
		while(it3.hasNext()){
			Node tmp3 = it3.next();
			if(racer == tmp3.racer){
				it3.remove();
				break;
			}
		}
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