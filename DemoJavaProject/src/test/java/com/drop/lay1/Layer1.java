package com.drop.lay1;

import com.drop.exception.DivideException;
import com.drop.lay2.Layer2;

public class Layer1 {

	private static Layer2 obj = new Layer2();
	public static void main(String[] args) {

		System.out.println("LAyer1");
		try
		{
				obj.layfunc(2, 0);
		}
		catch(DivideException e)
		{

			System.out.println("LAyer1 exception");
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}

}
