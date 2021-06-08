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
			sharedPropane.barrier.b_wait();
			boolean unused=true;
			while(unused){
				sharedPropane.mutex.acquire();
				if (sharedPropane.getHydrogen()==0 && sharedPropane.getCarbon()==0){
					System.out.println("---Group ready for bonding---");
				}
				if (sharedPropane.getCarbon()<3){
					unused=false;
					sharedPropane.addCarbon();
					sharedPropane.bond("C"+ this.id);
				}
				sharedPropane.mutex.release();
			}
	    }
	    catch (InterruptedException ex) { /* not handling this  */}
	   // System.out.println(" ");
	}
}
