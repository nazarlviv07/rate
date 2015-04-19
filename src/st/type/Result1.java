package st.type;

public enum Result1 {
	INTERWORKING_UNSPECIFIED(127, 
			"interworking, unspecified");
	
	private int mCoding;
	  private String mName;
	  
	Result1(int coding, String name)
	  {
	    mCoding = coding;
	    mName = name;
	  }
	public int getCoding()
	  {
	    return mCoding;
	  }
	    
	  public String getName()
	  {
	    return mName;
	  }
}
