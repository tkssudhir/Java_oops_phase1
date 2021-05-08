package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {														//class

		boolean exitmainmenu, exitsubmenu;	
		public static void main(String[] args) {
			Menu menu = new Menu();											//object of the class
			menu.runmenu();												    //call the method
		//	menu.printmenu();											    //call the method
		}
		
		public void runmenu() {
			prinheader();
			exitmainmenu = false;
			while(!exitmainmenu) {
				printmenu();
				int choice = getinput();
				performaction(choice);
			}
		}
		private void prinheader() {											//method
			System.out.println("+-------------------------+");
			System.out.println("+ Company Lockers Pvt.Ltd +");
			System.out.println("+  LockedMe Application   +");
			System.out.println("+-------------------------+");		
		}
		private void printmenu() {										    //method
			System.out.println("\n Make a selection");
			System.out.println(" 1. Display Directory      ");
			System.out.println(" 2. Perform an operation   ");
			System.out.println(" 3. Exit lockedme          ");		
		}
		
		//get the choice user entered 1,2,3 etc
		private int getinput() {
			Scanner kb = new Scanner(System.in);							//creating the object for scanner class
			int choice = -1;
			while(choice < 1 || choice > 4 ) {
				try {
					System.out.print("\n Enter your choice : ");	
					choice = Integer.parseInt(kb.nextLine());
				}
				catch(NumberFormatException e) {
					System.out.println("Invalid selection, please try again");
					
				}
			}
			return choice;
				
		}
		
		//perform action on menu#1
		private void performaction(int choice) {
			switch (choice) {
				case 1:
					displaydir();
					runsubmenu();
					break;
				case 2:
					runsubmenu();
					break;
				case 3:
					exitmainmenu = true;
					System.out.println("Thank you for using our application");
					break;
				default:
					System.out.println("An unknown error has occured");
			}
		}
		
		//Display files inside a the folder
		private void displaydir() {
			File f = new File ("C:\\Users\\Admin\\Desktop");
			String list[] = f.list();	
			System.out.println("List of files in folder");
			for (int i=0; i<list.length;i++)
			{
				System.out.println(list[i]);
			}
			
			
		}
		//When user selects option 2 on menu 1, Print submenu and get user choice 
		private void printsubmenu() {										//method
			System.out.println("\n Select operation on Directory");
			System.out.println(" 1. Add file      ");
			System.out.println(" 2. Delete file    ");
			System.out.println(" 3. Search for specific file by name           ");	
			System.out.println(" 4. Return to home page         ");
		}
		
		//Display sub-menu
		public void runsubmenu() {
			exitsubmenu = false;
			while(!exitsubmenu) {
				printsubmenu();
				int choice = getinput();
				performactionsm(choice);
			}
		}
		//perform action on sub-menu
		private void performactionsm(int choice) {
			switch (choice) {
				case 1:
					exitsubmenu = true;
					try {
						
						filecreate();
					} catch (IOException e) {
						System.out.println("file creation error-1");
					}
					break;
				case 2:
					exitsubmenu = false;
					deletefile();
					break;
				case 3:
					exitsubmenu = false;
					findfile();
					break;
				case 4:
					exitsubmenu = true;
					System.out.println("\n Returning to previous menu...");
					break;
				default:
					System.out.println("An unknown error has occured");
			}
		}
		
		//Add a file method
		private void filecreate() throws IOException {
			        
			Scanner input = new Scanner(System.in);
	        System.out.print("Enter the desired name of your file: ");
	        String fileName = input.nextLine();
	        fileName = fileName + ".txt";
	        
	        File dir = new File ("C:\\Users\\Admin\\Desktop");
	        
	        File newfile = new File (dir, fileName);
	        
	        
	        if(newfile.createNewFile()) {
				System.out.println("\n file created successfully");
					
			}else {
				System.out.println("file creation error-2");
			}
		}
		
		//Delete a file method
		private void deletefile() {
			
			Scanner input = new Scanner(System.in);
	        System.out.print("Enter the file name to delete: ");
	        String fileName = input.nextLine();
	        fileName = fileName + ".txt";
	        
	        File dir = new File ("C:\\Users\\Admin\\Desktop");
	        
	        File myfile = new File (dir, fileName);
			
			if(myfile.delete()) {
				System.out.println("file deleted successfully : "+myfile.getName());
					
			}else {
				System.out.println("file delete error");
			}
		}
		
		
		//Search a file method
		private void findfile() {
			
	        // Create an object of the File class
	        // Replace the file path with path of the directory
	        File directory = new File("C:\\Users\\Admin\\Desktop");
	  
	        // store all names with same name
	        // with/without extension
	        String[] flist = directory.list();
	        int flag = 0;
	        if (flist == null) {
	            System.out.println("Empty directory.");
	        }
	        else {
	        	Scanner input = new Scanner(System.in);
	            System.out.print("\n Enter the file name to be searched: ");
	            String searchFile = input.nextLine();
	            searchFile = searchFile + ".txt";
	       
	            
	            // Linear search in the array
	            for (int i = 0; i < flist.length; i++) {
	                String filename = flist[i];
	                if (filename.equals(searchFile)) {
	                    System.out.println(searchFile + " found");
	                    flag = 1;
	                }
	            }
	        }
	  
	        if (flag == 0) {
	            System.out.println("File Not Found");
	        }
		}
	}
