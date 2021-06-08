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
			sharedPropane.barrier.b_wait();
			boolean unused=true;
			while(unused){
				sharedPropane.mutex.acquire();
				if (sharedPropane.getHydrogen()==0 && sharedPropane.getCarbon()==0){
					System.out.println("---Group ready for bonding---");
				}
				if (sharedPropane.getHydrogen()<8){
					unused=false;
					sharedPropane.addHydrogen();
					sharedPropane.bond("H"+ this.id);
				}
				sharedPropane.mutex.release();
			}
	    }
	   catch (InterruptedException ex) { /* not handling this  */}
	    //System.out.println(" ");
	}
}
