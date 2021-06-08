import molecule.*;

public class Synchronization extends RunSimulation{
    /**
     * This class is used for running RunSimulation. Checks the input argument is in correct format.
     */
    public static void main(String[] args){
        if (args.length==2){
            try{
                int no_hydrogens = Integer.parseInt(args[0]);
                int no_carbons = Integer.parseInt(args[1]);
                RunSimulation.main(new String[]{Integer.toString(no_hydrogens),Integer.toString(no_carbons)});
            }
            catch (NumberFormatException  exception){
                System.out.println("Incorrect argument syntax. input: 'make run ARGS=\"<no_hydrogens> <no_carbons>\"'");
                System.out.println("Exiting program.");
                System.exit(0);
            }
        }
        else{
            System.out.println("Incorrect argument syntax. input: 'make run ARGS=\"<no_hydrogens> <no_carbons>\"'");
            System.out.println("Exiting program.");
            System.exit(0);
        }
    }
}
