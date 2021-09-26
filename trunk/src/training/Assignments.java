package training;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;

class Assignments {
	public static void main (String[] args) throws Exception {
		if (args == null || args.length != 2) {
			System.out.println("The number of arguments is wrong... ");
			return;
		}
			
		String filepath = args[0];
		String assignmentType = args[1];
		
		runTask(filepath, assignmentType);
	}
	
	public static List runTask (String filepath, String assignmentType) throws Exception {
		if (filepath == null || filepath.trim().length() == 0) {
			System.out.println("File path is mandatory... ");			
			return null;
		}
		
		if (assignmentType == null || assignmentType.trim().length() == 0) {
			System.out.println("Assignment type is mandatory... ");
			return null;
		}
		
		int type = Integer.parseInt(assignmentType);
		File dataFile = new File(filepath);
		
		switch (type) {
			case 1:
				return runTask01(dataFile);
			case 2:
				return runTask02(dataFile);
			case 3:
				return runTask03(dataFile);
			default:
				System.out.println("Invalid assignment type number: "+type);
				break;
		}
			
		return null;
	}
	
	private static List runTask01 (File dataFile) throws Exception {
		LineIterator itr = FileUtils.lineIterator(dataFile);
		try {
		} finally {
			LineIterator.closeQuietly(itr);
			while(itr.hasNext()) {
				// todo...
			}
		}
		return null;
	}
	
	private static List runTask02 (File dataFile) throws Exception {
		return null;
	}
	
	private static List runTask03 (File file) throws Exception {
		return null;
	}
}