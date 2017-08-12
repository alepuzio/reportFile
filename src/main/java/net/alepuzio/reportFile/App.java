package net.alepuzio.reportFile;


import java.util.List;

import net.alepuzio.reportFile.enumeration.EnumMessage;
import net.alepuzio.reportFile.enumeration.EnumNumericConstants;
import net.alepuzio.reportFile.io.FactoryWritingDataWay;
import net.alepuzio.reportFile.io.VisitFileSystem;
import net.alepuzio.reportFile.io.WritingDataInFile;
import net.alepuzio.reportFile.logic.PopulatedArguments;
import net.alepuzio.reportFile.logic.ProcessInputArguments;
import net.alepuzio.reportFile.logic.SingleFile;

/**
 * Running class
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	if(null == args || args.length < EnumNumericConstants.MIN_NUMBER_PARAMETHER.getNumber()){
    		System.err.println(EnumMessage.AT_LEAST_1_PARAMETER.getMessage()); //$NON-NLS-1$
    	} else {
    		ProcessInputArguments arguments = ProcessInputArguments.factory(args);
    		PopulatedArguments app = arguments.buildPath().buildExtension().buildReportname().buildSeparator().getOutput();
        	VisitFileSystem fileSystem = VisitFileSystem.factory(app);
        	List<SingleFile> lista = fileSystem.readDirectory();
        	WritingDataInFile instance = FactoryWritingDataWay.instance(app);
        	instance.write(lista);
      	}
    	System.out.println(EnumMessage.ENDED_RUN.getMessage()); //$NON-NLS-1$
    }

	

	
}

