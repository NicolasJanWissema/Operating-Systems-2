package molecule;

public class Hydrogen extends Thread {

	private static int carbonCounter =0;
	private int id;
	private Propane sharedPropane;
	
	
	public Hydrogen(Propane propane_obj) {
		Hydrogen.carbonCounter+=1;
		id=carbonCounter;
		this.sharedPropane = propane_obj;
		
	}
	
	public void run() {
	    try {
	    	 // TODO: you will need to fix below
	    	System.out.println("---Group ready for bonding---");			 
	    	sharedPropane.bond("H"+ this.id);
	    }
	   catch (InterruptedException ex) { /* not handling this  */}
	    //System.out.println(" ");
	}
}
