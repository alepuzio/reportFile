package net.alepuzio.reportFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VisitFileSystem {
	
	private App app = null;

	VisitFileSystem (App newApp){
		this.app = newApp;
	}
	
	public List<SingleFile> readDirectory(){
		String path = this.getApp().getRootPath();
		List<SingleFile> list = new ArrayList<SingleFile>();
		File file = new File(path);
		if(file.exists() && file.isDirectory() && file.canRead()){
	        walkdir(file, list);
		}else{
			throw new IllegalArgumentException(Messages.getString("error.invalid.root")); //$NON-NLS-1$
		}
		return list;
			
	}
	
	protected void write(App app, List<SingleFile> lista){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(app.getReportName()));
			for(SingleFile singleFile : lista){
				String content = singleFile.toCSV(app.getSeparator());
				bw.write(content);
			}
			System.out.println(Messages.getString("end.writing")); //$NON-NLS-1$
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(null != bw){
				try {
					bw.close();
				} catch (IOException e) {
					System.err.println(Messages.getString("exception.finally") + e.getMessage()); //$NON-NLS-1$
				}
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
				System.out.println(Messages.getString("inside.subdirectories")+currentSubDirectory.getName()); //$NON-NLS-1$
				walkdir(currentSubDirectory, lista);
			}
		}
		final File[] fileesistenti = file.listFiles(/*new FileFilter() {
			public boolean accept(File pathname) {
				boolean fileUtile = pathname.exists()&& pathname.canRead() && pathname.isFile();
				boolean expectedExtension = false;
				if(fileUtile){
					String filter = this.getApp().getExtension();
					String estensione = pathname.getName().split(Messages.getString("VisitFileSystem.4"))[1]; //$NON-NLS-1$
					expectedExtension = Messages.getString("VisitFileSystem.5").equals(filter) ? true : filter.equals(estensione); //$NON-NLS-1$
				}
				return fileUtile && expectedExtension;
			}

		}*/);
		if(null != fileesistenti){
			for(File f : fileesistenti){
				SingleFile singleFile = new SingleFile(f);
				lista.add(singleFile);
			}
		}
	}
		
	public App getApp() {
		return this.app;
	}
}
