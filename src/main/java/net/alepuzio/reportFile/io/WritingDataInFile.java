package net.alepuzio.reportFile.io;

import java.util.List;

import net.alepuzio.reportFile.logic.PopulatedArguments;
import net.alepuzio.reportFile.logic.SingleFile;


public interface WritingDataInFile {

	public PopulatedArguments getApp();

	void write(List<SingleFile> lista);

}
