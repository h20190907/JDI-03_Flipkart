package com.drop.lay3;

import com.drop.exception.DivideException;

public class Layer3 {

	public double func (int a , int b) throws DivideException
	{

			if(b == 0)
				throw new DivideException(b);
			double c = a/b;
			return c;
		
	}
	
}
