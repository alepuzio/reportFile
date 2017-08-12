package net.alepuzio.reportFile.io;

import net.alepuzio.reportFile.logic.PopulatedArguments;


public class FactoryWritingDataWay {
	
	public static WritingDataInFile instance(PopulatedArguments app){
		WritingDataInFile instance = null;
		final String choosedExtension = app.getExtension();
		if(net.alepuzio.reportFile.enumeration.EnumTypeFile.CSV.getExtension().equals(choosedExtension)){
			instance = WritingDataInCSV.instance(app);
		} else { 
			throw new IllegalArgumentException("Unsupported extension[" + choosedExtension + "]");//TODO unify message's  mechanism
		}
		return instance;
	}

}
