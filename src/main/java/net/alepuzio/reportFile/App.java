package net.alepuzio.reportFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	
	
	private String rootPath;
	private String extension;
	private String reportName;
	private String separator;
	
	
    public static void main( String[] args )
    {
    	if(null == args || args.length < 1){
    		System.err.println(Messages.getString("error.number.args")); //$NON-NLS-1$
    	}else{
    		ProcessArguments arguments = ProcessArguments.factory(args);
        	App app = arguments.buildPath().buildExtension().buildReportname().buildSeparator().getOutput();
        	VisitFileSystem fileSystem = new VisitFileSystem(app);
        	List<SingleFile> lista = fileSystem.readDirectory();
        	printInFile(app, lista);
    	}
    	System.out.println(Messages.getString("end.program")); //$NON-NLS-1$
    }

	private static void printInFile(App app, List<SingleFile> lista) {
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new File(app.getReportName()));
		
		for(SingleFile singleFile : lista){
			printWriter.write(singleFile.toCSV(app.getSeparator()));
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			if(null != printWriter){
				printWriter.close();
			}
		}
	}

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

