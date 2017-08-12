package net.alepuzio.reportFile.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;




import net.alepuzio.reportFile.enumeration.EnumMessage;
import net.alepuzio.reportFile.logic.PopulatedArguments;
import net.alepuzio.reportFile.logic.SingleFile;

public class WritingDataInCSV implements WritingDataInFile {
	
	private PopulatedArguments app = null;

	public static WritingDataInCSV instance(PopulatedArguments newApp){
		return new WritingDataInCSV(newApp);
	}
	
	private WritingDataInCSV(PopulatedArguments newApp){
		this.app = newApp;
	}

	public void write(List<SingleFile> lista){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(this.getApp().getReportName()));
			for(SingleFile singleFile : lista){
				String content = singleFile.toCSV(this.getApp().getSeparator());
				bw.write(content);
			}
			System.out.println(EnumMessage.END_WRITING.getMessage()); //$NON-NLS-1$
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(null != bw){
				try {
					bw.close();
				} catch (IOException e) {
					System.err.println(EnumMessage.EXCEPTION_FINALLY.getMessage() + e.getMessage()); //$NON-NLS-1$
				}
			}
		}
	}

	public PopulatedArguments getApp() {
		return this.app;
	}

}
