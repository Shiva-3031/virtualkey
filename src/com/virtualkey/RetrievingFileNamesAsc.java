package com.virtualkey;

import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RetrievingFileNamesAsc {
	
	public static void sortingFileNamesAsc(List<String> fileNames) {
		//Sorting the file names in the ascending order
		Collections.sort(fileNames, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return ((String) o1).compareTo((String)o2);
			}
			
		});
	}
	
	public static void retrievingFileNamesAscendingOrder() {
		Scanner in = new Scanner(System.in);
		
		//Taking the Directory as input from the user
		System.out.print("Enter the complete directory path: ");
		String pathDir = in.nextLine();
		
		File path = new File(pathDir);
		//Checking for the path is absolute and it is directory
		if(path.isAbsolute() && path.isDirectory()) {
			//Listing all the files in the directory including folders
			File[] fileNames = path.listFiles();
			//Extracting the file and folders names from the directory and storing in a list
			List<String> fileNameString = new ArrayList<String>();
			for(File file:fileNames) {
				fileNameString.add(file.getName());
			}
			//sorting the file and folders name in ascending order
			sortingFileNamesAsc(fileNameString);
			//Displaying the file and folders name in ascending order
			System.out.println("----------------------------------------");
			System.out.println("\nFiles and Folders in ascending order: ");
			for(String fileNameVal: fileNameString) {
				System.out.println(fileNameVal);
			}
			System.out.println("----------------------------------------");
			//Asking user to continue with another directory or exit
			System.out.print("Continue with another one (1/0): ");
			if(in.nextInt() == 1){
				retrievingFileNamesAscendingOrder();
			}
			else {
				return;
			}
			
		}
		else {
			//Displaying the incorrect path entered
			System.out.println("----------------------------------------");
			System.out.println("Entered the Wrong path");
			System.out.println("----------------------------------------");
			retrievingFileNamesAscendingOrder();
		}
	}
}
