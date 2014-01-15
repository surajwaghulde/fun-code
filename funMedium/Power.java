package funMedium;

public class Power {

    public static double Power(double x, int y)
    {
        double result = 1;

        boolean isNegative = y < 0 ? true : false;

        if (isNegative)
            y = -1 * y;

        while (y > 0)
        {
            if ((y & 1) > 0)
            {
                result *= x;
            }
            y = (y >> 1);
            x *= x;
        }

        if (isNegative)
            result = 1 / result;

        return result;
    }
    


	/**
	 * Returns a^b, as the standard mathematical exponentiation function
	 */
	public static double pow(double a, int b) {
	    // implementation here
	    if (b == 0) {
	    	return 1;
	    }
		
	    if (b % 2 == 1)
	        return pow(a, b - 1) * a;
	    else {	    
	    	return pow(a*a, b/2);	    	
	    }
    	    
	}
    
	public static void main(String[] args) {
		System.out.println(Power(2.5, 7));
		System.out.println(pow(2.5,7));
	}

}
