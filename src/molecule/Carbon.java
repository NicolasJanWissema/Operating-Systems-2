package molecule;

import java.awt.*;

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
			//creates permits for 3 carbon atoms after all carbon atoms have been generated.
			if (id==1){
				sharedPropane.carbonQ.release(3);
			}
			//3 carbon atom threads continue. Others wait for current propane bonding to finish.
			sharedPropane.carbonQ.acquire();
			//wait for 3 carbon and 8 hydrogen atoms to become available for bonding.
			sharedPropane.barrier.b_wait();

			//bond atoms to make propane molecule. Using mutex to maintain thread safety.
			sharedPropane.mutex.acquire();
			if (sharedPropane.getCarbon()==0 && sharedPropane.getHydrogen()==0){
				System.out.println("---Group ready for bonding---");
			}
			sharedPropane.addCarbon();
			sharedPropane.bond("C"+ this.id);
			sharedPropane.mutex.release();

			//allow new atom to prepare for bonding process.
			sharedPropane.carbonQ.release();
	    }
	    catch (InterruptedException ex) { /* not handling this  */}
	   // System.out.println(" ");
	}
}
