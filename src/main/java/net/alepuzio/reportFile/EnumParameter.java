package net.alepuzio.reportFile;
/*
 * args[0]: path
 * args[1]: extension
 * args[2]: reportName
 * args[3]: separator
 */
public enum EnumParameter {
PATH(0),
EXTENSION(1),
REPORT_NAME(2),
SEPARATOR(3);

	private int position = -1;

	private EnumParameter(int newPosition){
		this.position = newPosition;
	}
	
	public int position(){
		return this.position;
	}
	
	public int numberParameterBefore(){
		return this.position() ;
	}

}
