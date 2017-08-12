package net.alepuzio.reportFile.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.alepuzio.reportFile.enumeration.EnumMessage;
import net.alepuzio.reportFile.enumeration.EnumParameter;

import org.apache.commons.lang3.StringUtils;

public class ProcessInputArguments {

	private String args[] = null;

	private PopulatedArguments output = null;
	
	public ProcessInputArguments buildExtension() {
		String extension = null;
	    if (this.getArgs().length > EnumParameter.EXTENSION.numberParameterBefore()){
	        extension = this.getArgs()[EnumParameter.EXTENSION.position()];
	    } else{
	    	extension = StringUtils.EMPTY;
	    }
	    this.output.setExtension(extension);
	    return this;
	}

	public ProcessInputArguments buildReportname() {
		String reportName = null;
	    if (this.getArgs().length> EnumParameter.REPORT_NAME.numberParameterBefore()){
	        reportName = this.getArgs()[EnumParameter.REPORT_NAME.position()];
	    } else{
	    	DateFormat dateFormat = new SimpleDateFormat(EnumMessage.DATE_FORMAT.getMessage()); //$NON-NLS-1$
	    	reportName = dateFormat.format(Calendar.getInstance().getTime()) + EnumMessage.DEFAULT_FILE_NAME.getMessage(); //$NON-NLS-1$
	    }
	    this.output.setReportName(reportName);
	    return this;
	}

	
	public PopulatedArguments getOutput() {
		return this.output;
	}


	public ProcessInputArguments buildSeparator() {
		String separator = null; 
		if (this.getArgs().length> EnumParameter.SEPARATOR.numberParameterBefore()){
	    	separator = this.getArgs()[EnumParameter.SEPARATOR.position()];
	    } else{
	        separator = EnumMessage.DEFAULT_SEPARATOR_CSV.getMessage(); //$NON-NLS-1$
	    }
	    this.output.setSeparator(separator);
	    return this;
	}

	public ProcessInputArguments buildPath() {
	    String rootPath = null;
		if (this.getArgs().length> EnumParameter.PATH.numberParameterBefore()){
	        rootPath = this.getArgs()[EnumParameter.PATH.position()];
	    } else{
	    	throw new IllegalArgumentException(EnumMessage.ERROR_MANDATORY_PATH.getMessage()); //$NON-NLS-1$
	    }
	    this.output.setRootPath(rootPath);
	    return this;
	}


	
	public String[] getArgs() {
		return this.args;
	}

	public static final ProcessInputArguments factory(String[] args) {
		return new ProcessInputArguments(args);
	}
	
	private ProcessInputArguments(String[] args) {
		super();
		this.args = args;
		this.output = new PopulatedArguments();
	}
	
	
}
