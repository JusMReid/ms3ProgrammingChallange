package ms3ProgrammingChallenge;
import java.io.*;
import java.util.*;

public class Parser {
	int totalRecords = 10;
	int successfulRecords;
	int failedRecords;
	
	//Constructor no-arg
	public Parser() {
		
	}
	
	public void parse() throws FileNotFoundException{
		//BadCSVGen badCSV = new BadCSVGen();
		
		//Generate .csv file to write bad data to
		try {
			BadCSVGen.createCSV();
		}catch(FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
		
	}
}
