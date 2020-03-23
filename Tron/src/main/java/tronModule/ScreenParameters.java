package tronModule;

public class ScreenParameters {
    private static ScreenParameters screenParameters = null; 
 
    public int width;
    public int height;
  
    private ScreenParameters() {}
   
    public static ScreenParameters getInstance() 
    { 
        if (screenParameters == null) 
            screenParameters = new ScreenParameters(); 
  
        return screenParameters; 
    } 
}
