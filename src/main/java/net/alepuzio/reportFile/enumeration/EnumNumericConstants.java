package net.alepuzio.reportFile.enumeration;

public enum EnumNumericConstants {
	
	MIN_NUMBER_PARAMETHER(1)
	;
	
	private int number = -1;

	private EnumNumericConstants(int newNumber){
		this.number = newNumber;
	}

	public int getNumber() {
		return this.number;
	}
	
}
