package framwork.Appium;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int a[] = {5,10,15};
    	
    	
      System.out.println( myfun (a));
    }
    
    public static int  myfun (int a[]) {
    	 int i; 
         
    	    // Initialize maximum element 
    	    int max = a[0]; 
    	  
    	    // Traverse array elements  
    	    // from second and compare 
    	    // every element with current max  
    	    for (i = 1; i < a.length; i++) 
    	        if (a[i] > max) 
    	            max = a[i]; 
    	  
    	    return max; 
    }
    
}
