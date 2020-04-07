
public class Constants {

    public static int [] VALUES = null; // populated automatically
    public static int [] WEIGHTS = null; // populated automatically
    public static double[] RATIO = null; // populated automatically

    /* Change the following to the files that contain the weights and values
     * of the problem instance */
    private static String DATA_FILE = "D:\\test.in";
    
    public static String getDataFile() {
		return DATA_FILE;
	}

	// Setter
	public static void setName(String newDataFile) {
		DATA_FILE = newDataFile;
	}
	
    private static int NUMBER_OBJECTS = 5000;
    
    public static int getDataSize() {
		return NUMBER_OBJECTS;
	}

	// Setter
	public static void setDataSize(int NdataSize) {
		NUMBER_OBJECTS = NdataSize;
	}
	
    private static int MAX_WEIGHT = 500;
    
    public static int getKSCapacity() {
		return MAX_WEIGHT;
	}

	// Setter
	public static void setKSCapacity(int NKSCapacity) {
		MAX_WEIGHT = NKSCapacity;
	}

//
//    static
//    {
//        try
//        {
//            DataProcessor.processData();
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }

    /** Creates a new instance of Constants */
    public Constants() {
    }

}