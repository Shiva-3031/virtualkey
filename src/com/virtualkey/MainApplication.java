package com.virtualkey;

import java.util.Scanner;

public class MainApplication {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		// Displaying the application name and Developer name.
		System.out.println("-----------------------------------------------------");
		System.out.println("          Virtual Key for your Repositories          ");
		System.out.println("       Application Developer: Shiva Kumar Dusa       ");
		System.out.println("-----------------------------------------------------");
		
		//Declaration of the variables.
		int mainOption;
		
		//Starting of the application
		do {
			
			//Displaying the Options to the user
			System.out.println("---------------------------------------------------");
			System.out.println("Main Menu :");
			System.out.println("1 - Retrieving the file names in an ascending order");
			System.out.println("2 - Business level operations");
			System.out.println("3 - Close the Application");
			System.out.print("Choose the option: ");
			//User Entering the Option
			mainOption = in.nextInt();
			System.out.println("---------------------------------------------------");
			
			//Using the switch to navigate between the options
			switch(mainOption) {
			
			case 1: //Calling the retrievingFileNamesAscendingOrder in the RetrievingFilesNamesAsc class file
					RetrievingFileNamesAsc.retrievingFileNamesAscendingOrder();
					break;
				
			case 2: // Calling the businessLevelOperations in the BusinessLevelOperations class file for next business operations
					BusinessLevelOperations.businessLevelOperations();
					break;
				
			case 3:
					//Closing the Scanner object
					in.close();
					System.out.println("Thanks");
					//Exiting from the Application
					System.exit(0);
					break;
			}
			
		}while(true);
		

	}

}
