package net.alepuzio.reportFile.enumeration;

public enum EnumMessage {
	
	AT_LEAST_1_PARAMETER("At leat 1 paramether"),
	DATE_FORMAT("yyyy_MM_dd_HH_mm_ss"),
	DEFAULT_FILE_NAME("_reportName.txt"),
	ENDED_RUN("End"),
	SEPARATOR_FILENAME_EXTENSION("\\."),
	DEFAULT_SEPARATOR_CSV(";"),
	CARRIAGE_RETURN("\n"),
	ERROR_MANDATORY_PATH("Mandatory path"),
	NO_EXTENSION("NO_EXTENSION"),
	INSIDE_SUBDIRECTORIES("In subdirectories:"),   
	END_WRITING("End writing report file"),
	EXCEPTION_FINALLY("Exception in finally: "),
	
	ERROR_INVALID_ROOT("Invalid root: does it exist? Is it a directory? Can you read?");  
	;
	
	private String message = null;
	
	private EnumMessage(String newMessage){
		this.message = newMessage;
	}

	public String getMessage(){
		return this.message;
	}
}
