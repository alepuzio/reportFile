package net.alepuzio.reportFile.io;


import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.alepuzio.reportFile.enumeration.EnumMessage;
import net.alepuzio.reportFile.logic.PopulatedArguments;
import net.alepuzio.reportFile.logic.SingleFile;

public class VisitFileSystem {
	
	private PopulatedArguments app = null;

	public static final VisitFileSystem factory(PopulatedArguments newApp){
		return new VisitFileSystem (newApp);
	}
	
	private VisitFileSystem (PopulatedArguments newApp){
		this.app = newApp;
	}
	
	public List<SingleFile> readDirectory(){
		String path = this.getApp().getRootPath();
		List<SingleFile> list = new ArrayList<SingleFile>();
		File file = new File(path);
		if(file.exists() && file.isDirectory() && file.canRead()){
	        walkdir(file, list);
		}else{
			throw new IllegalArgumentException(EnumMessage.ERROR_INVALID_ROOT.getMessage()); //$NON-NLS-1$
		}
		return list;
			
	}
	
	
	
	protected void writeDataInFile(List<SingleFile> lista) {
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new File(this.getApp().getReportName()));
		
			for(SingleFile singleFile : lista){
				printWriter.write(singleFile.toCSV(this.getApp().getSeparator()));
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
	
    /* 
     * traverse root directory, and list directories as dirs and files as files
     */
	
	protected void walkdir(File file, List<SingleFile> lista){
		final File[] subDirectories = file.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.exists()&& pathname.canRead() && pathname.isDirectory() ;
			}
		});
		if(null != subDirectories){
			for(File currentSubDirectory : subDirectories){
				System.out.println(EnumMessage.INSIDE_SUBDIRECTORIES.getMessage()+currentSubDirectory.getName()); //$NON-NLS-1$
				walkdir(currentSubDirectory, lista);
			}
		}
		final File[] existingfiles = file.listFiles();
		if(null != existingfiles){
			for(File f : existingfiles){
				SingleFile singleFile = new SingleFile(f);
				lista.add(singleFile);
			}
		}
	}
		
	public PopulatedArguments getApp() {
		return this.app;
	}
}
