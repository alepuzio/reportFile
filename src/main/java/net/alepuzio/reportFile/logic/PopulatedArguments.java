package net.alepuzio.reportFile.logic;

public class PopulatedArguments {

	private String rootPath;
	private String extension;
	private String reportName;
	private String separator;
	
	public void setExtension(String extension) {
		this.extension = extension;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getRootPath() {
		return this.rootPath;
	}


	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}


	public String getExtension() {
		return this.extension;
	}



	public String getReportName() {
		return this.reportName;
	}

	public String getSeparator() {
		return this.separator;
	}


}
