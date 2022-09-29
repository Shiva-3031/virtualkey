package com.virtualkey;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class BusinessLevelOperations {
	//Creating a static scanner object
	static Scanner in = new Scanner(System.in);
	
	public static void addFileToDir(String path){
		//Asking use to enter the file name that need to be created
		System.out.print("Enter the new File Name: ");
		String newFileName = in.nextLine();
		
		try {
			//Creating a file with the new file name in the directory
			File fileObj = new File(path+"/"+newFileName);
			//Checking if the new file is created or not
			if(fileObj.createNewFile()) {
				//Displaying the success message after creating a file
				System.out.println("\nFile is created successfully");
				return;
			}
			else {
				//Displaying the file already exist in the directory
				System.out.println("\nFile already exist in the directory");
			}
		} catch (IOException e) {
			//If there is any error while creating a file in the directory
			System.out.println("\nAn Error Occurred during the file creation process");
		}
	}
	
	public static void delFileToDir(String path){
		
		try {
			//Asking the use to enter the file name that need to be deleted in the directory
			System.out.print("Enter the file name that need to be deleted: ");
			String fileName = in.nextLine();
			//Deleting the file from the directory
			Files.delete(Paths.get(path+"/"+fileName));
			//Showing the file deleted successful message 
			System.out.println("\nFile deleted successfully !!!");
		}
		catch(NoSuchFileException e) {
			//If no file exist then the message is displayed
			System.out.println("\nFile does not exist");
		}
		catch(DirectoryNotEmptyException e) {
			//Displaying the error message
			System.out.println("\nFile is an directory and it is not empty");
		}
		catch(IOException e) {
			//Displaying the error if an error occur during the deletion process
			System.out.println("\nAn Error Occurred during the deletion process");
		}
		
	}
	
	public static void searchFileInDir(String path) {
		//Asking the user to the enter the file name that need to be searched in the directory
		System.out.print("Enter the file name that need to be searched: ");
		String fileName = in.nextLine();
		//Extracting all the files in the directory
		File[] allFiles = new File(path).listFiles();
		//Iterating through all the files
		for(File file:allFiles) {
			//Checking the file name whether it matches with the entered file name that to be searched
			if(fileName.equals(file.getName())) {
				//Displaying the file exists
				System.out.println("\nFile exists");
				return;
			}
		}
		//Displaying the fill does not exist after the linear search
		System.out.println("/nFile does not exists");
		return;
		
	}
	
	public static void businessLevelOperations() {
		//Declaring a path variable
		String path;
		
		do {
			//Displaying and asking the user for a directory
			System.out.println("-----------------------------");
			System.out.println("In the Business Unit");
			System.out.print("Enter the Directory path: ");
			path = in.nextLine();
			//Checking whether the directory exists or not
			if(new File(path).isDirectory()) {
				//Displaying the business level operations and asking user for the option
				System.out.println("-----------------------------");
				System.out.println("Business Level Operations: ");
				System.out.println("1 - Add a file");
				System.out.println("2 - Delete a file");
				System.out.println("3 - Search for a file");
				System.out.println("4 - Exit to the Main menu");
				System.out.print("Choose the option: ");
				//Using switch for the options navigation
				switch(Integer.parseInt(in.nextLine())) {
				case 1 :
						//For adding a new file to the directory calling the method addFileToDir
						System.out.println("-----------------------------");
						addFileToDir(path);
						break;
				case 2:
						//For deleting a file from the directory calling the method delFileToDir
						System.out.println("-----------------------------");
						delFileToDir(path);
						break;
				case 3:
					//For searching a file in the directory calling the method searchFileInDir
						System.out.println("-----------------------------");
						searchFileInDir(path);
						break;
				case 4:
						return;
				default:
						System.out.println("Entered the wrong options");
				}
			}
			else {
				System.out.println("\nInvalid directory path");
			}
		}while(true);
		
		
	}

}
