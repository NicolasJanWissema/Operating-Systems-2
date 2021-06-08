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
			//creates permits for 8 hydrogen atoms
			if (id==carbonCounter){
				sharedPropane.hydrogensQ.release(8);
			}
			sharedPropane.hydrogensQ.acquire();
			sharedPropane.barrier.b_wait();

			sharedPropane.mutex.acquire();
			if (sharedPropane.getCarbon()==0 && sharedPropane.getHydrogen()==0){
				System.out.println("---Group ready for bonding---");
			}
			sharedPropane.addHydrogen();
			sharedPropane.bond("H"+ this.id);
			sharedPropane.mutex.release();

			sharedPropane.hydrogensQ.release();
	    }
	   catch (InterruptedException ex) { /* not handling this  */}
	    //System.out.println(" ");
	}
}
