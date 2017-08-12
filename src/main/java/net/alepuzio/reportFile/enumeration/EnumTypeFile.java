package net.alepuzio.reportFile.enumeration;

public enum EnumTypeFile {
	CSV("csv")
	;
	
	private String extension = null;

	private EnumTypeFile(String newExtension){
		this.extension = newExtension;
	}

	public String getExtension() {
		return this.extension;
	}
	
}
