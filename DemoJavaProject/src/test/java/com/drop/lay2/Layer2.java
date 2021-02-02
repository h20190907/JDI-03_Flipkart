package com.drop.lay2;

import com.drop.exception.DivideException;
import com.drop.lay3.Layer3;

public class Layer2 {

	Layer3  obj = new Layer3();
	
	public double layfunc(int a, int b) throws DivideException
	{


		System.out.println("LAyer2");
			return obj.func(a, b);
		
	}
}
