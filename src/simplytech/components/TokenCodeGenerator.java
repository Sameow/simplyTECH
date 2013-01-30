package simplytech.components;

import java.util.Random;

public class TokenCodeGenerator {
	
	public TokenCodeGenerator() {
		
	}
	public static final int newTokenCode() {
	    //Generating random integers in the range 1..10.
	    
	    int START = 1;
	    int END = 10;
	    String tokenCode = "";
	    int finalTokenCode=0;
	    Random random = new Random();
	    for (int idx = 1; idx <= 5; ++idx){
	      tokenCode+=Integer.toString(showRandomInteger(START, END, random));
	    }
	    
	    finalTokenCode=Integer.parseInt(tokenCode);
	    return finalTokenCode;
	  }
	  
	  private static int showRandomInteger(int aStart, int aEnd, Random aRandom){
	    if ( aStart > aEnd ) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	    }
	    //get the range, casting to long to avoid overflow problems
	    long range = (long)aEnd - (long)aStart + 1;
	    // compute a fraction of the range, 0 <= frac < range
	    long fraction = (long)(range * aRandom.nextDouble());
	    int randomNumber =  (int)(fraction + aStart);
	    return randomNumber;
	  }
}
