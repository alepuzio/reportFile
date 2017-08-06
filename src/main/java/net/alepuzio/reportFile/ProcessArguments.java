package net.alepuzio.reportFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

public class ProcessArguments {

	private String args[] = null;

	private App output = null;
	
	public ProcessArguments buildExtension() {
		String extension = null;
	    if (this.getArgs().length > EnumParameter.EXTENSION.numberParameterBefore()){
	        extension = this.getArgs()[EnumParameter.EXTENSION.position()];
	    } else{
	    	extension = StringUtils.EMPTY;
	    }
	    this.output.setExtension(extension);
	    return this;
	}

	public ProcessArguments buildReportname() {
		String reportName = null;
	    if (this.getArgs().length> EnumParameter.REPORT_NAME.numberParameterBefore()){
	        reportName = this.getArgs()[EnumParameter.REPORT_NAME.position()];
	    } else{
	    	DateFormat dateFormat = new SimpleDateFormat(Messages.getString("date.format")); //$NON-NLS-1$
	    	reportName = dateFormat.format(Calendar.getInstance().getTime()) + Messages.getString("default.file.name"); //$NON-NLS-1$
	    }
	    this.output.setReportName(reportName);
	    return this;
	}

	
	public App getOutput() {
		return this.output;
	}


	public ProcessArguments buildSeparator() {
		String separator = null; 
		if (this.getArgs().length> EnumParameter.SEPARATOR.numberParameterBefore()){
	    	separator = this.getArgs()[EnumParameter.SEPARATOR.position()];
	    } else{
	        separator = Messages.getString("default.separator.csv"); //$NON-NLS-1$
	    }
	    this.output.setSeparator(separator);
	    return this;
	}

	public ProcessArguments buildPath() {
	    String rootPath = null;
		if (this.getArgs().length> EnumParameter.PATH.numberParameterBefore()){
	        rootPath = this.getArgs()[EnumParameter.PATH.position()];
	    } else{
	    	throw new IllegalArgumentException(Messages.getString("error.mandatory.path")); //$NON-NLS-1$
	    }
	    this.output.setRootPath(rootPath);
	    return this;
	}


	
	public String[] getArgs() {
		return this.args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	protected static final ProcessArguments factory(String[] args) {
		return new ProcessArguments(args);
	}

	
	private ProcessArguments(String[] args) {
		super();
		this.args = args;
		this.output = new App();
	}
	
	
}
