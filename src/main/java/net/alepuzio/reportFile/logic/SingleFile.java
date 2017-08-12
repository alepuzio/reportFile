package net.alepuzio.reportFile.logic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.alepuzio.reportFile.enumeration.EnumMessage;

public class SingleFile {

	private String name;
	private String directory;
	private String extension;
	private long weigth;
	private Date timeStamp;

	public SingleFile(File newFile) {
		String[] parti = newFile.getName().split(EnumMessage.SEPARATOR_FILENAME_EXTENSION.getMessage()); //$NON-NLS-1$
		this.name = parti[0];
		this.directory = newFile.getPath();
		if(newFile.isFile()){
			this.extension = parti[1];
		} else{
			this.extension = EnumMessage.NO_EXTENSION.getMessage(); //$NON-NLS-1$
		}
		this.weigth = newFile.length();
		this.timeStamp = new Date(newFile.lastModified());
	}

	public String toCSV(String separator) {
		StringBuilder builder = new StringBuilder();
		builder.append(getName());
		builder.append(separator);
		builder.append(getExtension());
		builder.append(separator);
		builder.append(getWeigth());
		builder.append(separator);
		builder.append(getTimeStampFormatted());
		builder.append(separator);
		builder.append(getDirectory());
		builder.append(EnumMessage.CARRIAGE_RETURN.getMessage()); //$NON-NLS-1$
		return builder.toString();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirectory() {
		return this.directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public long getWeigth() {
		return this.weigth;
	}

	public void setWeigth(long weigth) {
		this.weigth = weigth;
	}

	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public String getTimeStampFormatted() {
		return new SimpleDateFormat(EnumMessage.DATE_FORMAT.getMessage()).format(this.getTimeStamp()); 
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
