package com.flipkart.constant;

public enum Grade {
    A(10),
    A_MINUS(9),
    B(8),
    B_MINUS(7),
    C(6),
	C_MINUS(5),
    D(4),
    E(3);

    final private int value;

    private Grade(int value) {
        this.value = value;
    }

    public int hasValue() {
        return this.value;
    }

    @Override
    public String toString() {
    	
        final String name = name();
        
        if (name.contains("PLUS")) 
            return name.charAt(0) + "+"; 
        else if (name.contains("MINUS")) 
            return name.charAt(0) + "-"; 
        else 
            return name;
    }

}