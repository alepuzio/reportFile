package net.alepuzio.reportFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SingleFile {

	private String name;
	private String directory;
	private String extension;
	private long weigth;
	private Date timeStamp;

	public SingleFile(File newFile) {
		String[] parti = newFile.getName().split(Messages.getString("separator.filename.extension")); //$NON-NLS-1$
		this.name = parti[0];
		this.directory = newFile.getPath();
		if(newFile.isFile()){
			this.extension = parti[1];
		} else{
			this.extension = Messages.getString("default.extension"); //$NON-NLS-1$
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
		builder.append(Messages.getString("carriage.return")); //$NON-NLS-1$
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
		return new SimpleDateFormat(Messages.getString("date.format")).format(this.getTimeStamp()); //$NON-NLS-1$
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
