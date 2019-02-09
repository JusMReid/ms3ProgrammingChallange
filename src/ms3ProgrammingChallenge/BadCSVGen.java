package ms3ProgrammingChallenge;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * Each record needs to be verified to contain the right number of data 
 * elements to match the columns.  
	a. Records that do not match the column count must be 
		written to the bad-data-<timestamp>.csv file
	b. Elements with commas will be double quoted
*/
public class BadCSVGen {
	static PrintWriter printWriter;
	static StringBuilder stringBuilder = new StringBuilder();
	static String time;
	static List<String> failedRecord;
	static int columnCount = 0;

	// no-arg Constructor
	public BadCSVGen() {

	}

	public static void createCSV() throws FileNotFoundException {
		// Get timestamp
		time = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Timestamp(System.currentTimeMillis()));

		// Create the 'bad-data-<timestamp>.csv' file to be written to
		printWriter = new PrintWriter(new File("bad-data-" + time + ".csv"));
	}

	public static void writeToCSV(List<String> line) throws FileNotFoundException {
		failedRecord = line;
		int numStrings = failedRecord.size();

		while (columnCount < (numStrings)) {
			stringBuilder.append(failedRecord.get(columnCount));

			// this is to write the commas in, except the last one
			if (columnCount != numStrings) {
				stringBuilder.append(',');
			}

			columnCount++;
		}
		stringBuilder.append('\n');
	}
	
	public static void closeCSV() throws FileNotFoundException
    {
        printWriter.close();
    }	
}
