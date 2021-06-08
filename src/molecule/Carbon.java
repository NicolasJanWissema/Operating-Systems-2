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
	    	 // TODO: you will need to fix below
			//creates permits for 3 carbon atoms
			if (id==carbonCounter){
				sharedPropane.carbonQ.release(3);
			}
			sharedPropane.carbonQ.acquire();
			sharedPropane.barrier.b_wait();

			sharedPropane.mutex.acquire();
			if (sharedPropane.getCarbon()==0 && sharedPropane.getHydrogen()==0){
				System.out.println("---Group ready for bonding---");
			}
			sharedPropane.addCarbon();
			sharedPropane.bond("C"+ this.id);
			sharedPropane.mutex.release();

			sharedPropane.carbonQ.release();
	    }
	    catch (InterruptedException ex) { /* not handling this  */}
	   // System.out.println(" ");
	}
}
