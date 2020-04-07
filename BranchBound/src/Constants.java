
/**
 * Constants
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class Constants {

    public static int [] VALUES = null; // populated automatically
    public static int [] WEIGHTS = null; // populated automatically

    /* Change the following to the files that contain the weights and values
     * of the problem instance */
    private static String DATA_FILE = "D:\\test1.in";

	public static String getDataFile() {
		return DATA_FILE;
	}

	// Setter
	public static void setName(String newDataFile) {
		DATA_FILE = newDataFile;
	}
    
    private static int NUMBER_OBJECTS = 50000;
    
    public static int getDataSize() {
		return NUMBER_OBJECTS;
	}

	// Setter
	public static void setDataSize(int NdataSize) {
		NUMBER_OBJECTS = NdataSize;
	}

    private static int MAX_WEIGHT = 50;
    
    public static int getKSCapacity() {
		return MAX_WEIGHT;
	}

	// Setter
	public static void setKSCapacity(int NKSCapacity) {
		MAX_WEIGHT = NKSCapacity;
	}


    /* Lagrangian Relaxation Parameters */
    public static double INITIAL_LAMBDA = 0;
    public static double INITIAL_INCREMENT = 1;
    public static double LAMBDA_TOLERANCE = 0.01;

    /* Variables for random improvement */
    public static final int REMOVED = 2;
    public static final int LOOP = 100;
    public static final int INNER_LOOP = 100;

    static
    {
        try
        {
            DataProcessor.processData();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /** Creates a new instance of Constants */
    public Constants() {
    }

}
