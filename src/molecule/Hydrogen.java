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
			//creates permits for 8 hydrogen atoms after all hydrogen atoms have been generated.
			if (id==carbonCounter){
				sharedPropane.hydrogensQ.release(8);
			}
			//8 hydrogen atom threads continue. Others wait for current propane bonding to finish.
			sharedPropane.hydrogensQ.acquire();
			//wait for 3 carbon and 8 hydrogen atoms to become available for bonding.
			sharedPropane.barrier.b_wait();

			//bond atoms to make propane molecule. Using mutex to maintain thread safety.
			sharedPropane.mutex.acquire();
			if (sharedPropane.getCarbon()==0 && sharedPropane.getHydrogen()==0){
				System.out.println("---Group ready for bonding---");
			}
			sharedPropane.addHydrogen();
			sharedPropane.bond("H"+ this.id);
			sharedPropane.mutex.release();

			//allow new atom to prepare for bonding process.
			sharedPropane.hydrogensQ.release();
	    }
	   catch (InterruptedException ex) { /* not handling this  */}
	    //System.out.println(" ");
	}
}
