package molecule;

public class Carbon extends Thread {
	
	private static int carbonCounter =0;
	private int id;
	private Propane sharedPropane;
	
	public Carbon(Propane propane_obj) {
		Carbon.carbonCounter+=1;
		id=carbonCounter;
		this.sharedPropane = propane_obj;
	}
	
	public void run() {
	    try {	 
	    	 // TODO: you will need to fix below
	    	System.out.println("---Group ready for bonding---");	
	    	sharedPropane.bond("C"+ this.id);  //bond   	   	 
	    }
	    catch (InterruptedException ex) { /* not handling this  */}
	   // System.out.println(" ");
	}
}
