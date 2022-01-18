import java.util.Scanner;
import java.util.Stack;
public class main {
	//Global Declarations 
		int choice; 
		Scanner myScanner = new Scanner(System.in);
		Scanner enterScanner = new Scanner(System.in);
		String playerName;
		Stack<String> vaccEntry= new Stack<>();  
		Stack<String> hospital1= new Stack<>();  
		Stack<String> hospital2= new Stack<>();  
		Stack<String> hospital3= new Stack<>();  

		public static void main(String[] args) {
			main start;
			start = new main();
			start.playerSetUp(); //PlayerSetUpMethod
			start.townGate(); // Main Menu
			
		}

		public void playerSetUp() { //PlayerSetUpMethod
			
			//User Input for User's Name
			System.out.println("Please enter your name:");
			playerName = myScanner.nextLine();
			System.out.println("Hello " + playerName + ", Welcome to the Covid 19 DataBase"); 
		
			
			
		}

		public void townGate() { //Main Menu for DataBase

			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Astro City : Covid-19 Database");
			System.out.println("");
			System.out.println("What do you want to do?");
			System.out.println("");
			System.out.println("1: Check Hospital Capacity ");
			System.out.println("2: Reserve Vaccination Slot for Today");
			System.out.println("3: Access Data from Vaccination Database (ONLY FOR AUTHORIZED INDIVIDUALS) ");
			System.out.println("\n------------------------------------------------------------------\n");
			int choice = myScanner.nextInt();
// Based on the user's choice (variable "choice"), this will make a path towards where they want to go
			if (choice == 1) { //For Hospital Capacity
				hosp_CapacityMenu();
			}
			if (choice == 2) {
				
				if (vaccEntry.size() < 20 )  { // Condition if Vacc Reservation List is Full (Given Capacity: 20) 
				 // Continue to ask for User Input until they don't want to anymore 
						 Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
						 vacctracker vaxx = new vacctracker(); 
							vaxx.VaccUna();
							String the_Name= vaxx.userName;
							vaccEntry.push(the_Name); //Add to Reservation List 
						 townGate(); // Go back to main menu  
				}
				else { // Prompts if it is already full 
					System.out.println("The Vaccination Sites are currently full.");}
					townGate(); //Go Back to Main Menu 
				
			} 
			else if (choice == 3) { // Access Database
				authorizationPass autho = new authorizationPass();
				autho.authorizedOnly();  //method for Authorization : This contains a password needed to be entered 
				int allowed = autho.x; 
				
				if (allowed==1) // Password is correct 
				{
						 vacc_dataBase();  // Method for DataBase 
						 townGate(); //Go back to Main Menu 
					
				}
				else {
					townGate(); //Go back to Main Menu 
				}
			}else {
				townGate(); //Go back to Main Menu 
			}
		}
		public void vacc_dataBase() {
			dataB data_base = new dataB(); 
			data_base.dataBaseMenu(); // Method for Vaccination Database
			int choice1 = data_base.choice; // User Choice for DataBase
		
			if (choice1==1) { //Display all Vaccination Reservations
				int n = vaccEntry.size(); 
			      for (int i = 0; i < n; i++) { // Loop to Display Stack in Better Layout
			            System.out.println(i+1+"."+  vaccEntry.get(i));
			        }  
			      data_base.dataBaseMenu(); 
			}
			if (choice1==2) { //Add to Reservations 
				Scanner cin = new Scanner(System.in);
		        int ans = 1; // For loop to ask user input until they decide not to 
				 do { 
					 Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
					 vacctracker vaxx = new vacctracker(); 
						vaxx.VaccUna();
						String the_Name= vaxx.userName;
						vaccEntry.push(the_Name); 
					 System.out.print("Do you want to go on 1- Yes , 2- No, Go"); 
			
				 } while (cin.nextInt() == ans);
			      data_base.dataBaseMenu(); 
			}
			if (choice1==3) { //remove individual from reservation list
				if (vaccEntry.empty()==false) { //Display all reservations in the List
					int n = vaccEntry.size(); 
				      for (int i = 0; i < n; i++) {
				            System.out.println(i+1+"."+  vaccEntry.get(i));
				        }  
					System.out.println("Based from the stack. Which one do u want to remove?");
					int rem = myScanner.nextInt(); //Take user input on which they want to remove
					vaccEntry.remove(rem); //Remove vaccination reservation based on Position of stack
					System.out.println("Succesfully removed!");
				}
				else { // When the list is empty, it says that there is no way to remove. 
					System.out.println("There are no reservations present to remove");  
					data_base.dataBaseMenu(); // go back to menu
				}
				data_base.dataBaseMenu(); 
				
			}
			}
		
		
		public void hosp_CapacityMenu (){ //Main Hospital Capacity menu
			Scanner myScanner = new Scanner(System.in);
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Covid-19 Database");
			System.out.println("What do you want to do?");
			System.out.println("1: Check Hospital Capacity");
			System.out.println("2: Access Data from Database (ONLY FOR AUTHORIZED INDIVIDUALS) ");
			System.out.println("Any key : Go Back ");
			System.out.println("\n------------------------------------------------------------------\n");
			int choice = myScanner.nextInt(); // Ask user input 
			if (choice==1) // Display Hospital capacity 
			{
				System.out.println("Current Capacity in Hospital 1: " + hospital1.size());  
				System.out.println("Current Capacity in Hospital 2: " + hospital2.size()); 
				System.out.println("Current Capacity in Hospital 3: " + hospital2.size()); 
			}
			else if (choice==2){ //Access data base 
				authorizationPass autho1 = new authorizationPass(); 
				autho1.authorizedOnly(); // Authorization with password
				int allowed = autho1.x;
				if (allowed==1) // If password is correct, go to Hospital Data Base
				{
					
					dataBaseHosp(); // Direct to Hospital Data Base Method 
				}
				else {
					townGate(); // Return to Main Menu
				}
		
				
			}
			
			townGate();
		
				
		}
		
		public void dataBaseHosp(){
			//Hospital Database Menu
			Scanner myScanner = new Scanner(System.in);
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Covid-19 Database");
			System.out.println("What hospital would you like to Access?");
			System.out.println("1: Hospital 1");
			System.out.println("2: Hospital 2 ");
			System.out.println("3: Hospital 3 ");
			System.out.println("Any Key: Covid 19 Database Main Menu");
			System.out.println("\n------------------------------------------------------------------\n");
			//Choose hospital you want to access
			choice = myScanner.nextInt();
			if (choice==1) {
				dataBaseHosp1(); // Method for Hospital 1 
			}
			if (choice==2) {
				dataBaseHosp2(); // Method for Hospital 2
			}
			if (choice==3) {
				dataBaseHosp3(); // Method for Hospital 3
			}
			townGate(); 
		}
			
		public void dataBaseHosp1(){ // Database for Hospital 1 
			Scanner myScanner = new Scanner(System.in);
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Hospital 1 Database");
			System.out.println("What do you want to do?");
			System.out.println("1: Access All Patient Data");
			System.out.println("2: Add Patients ");
			System.out.println("3: Remove Patients ");
			System.out.println("Any Key: Go Back to Hospital Capacity Database");
			System.out.println("\n------------------------------------------------------------------\n");
			int choice1 = myScanner.nextInt();
			//Ask user input for choice of action 
			if (choice1==1) { //Print patients orderly manner
				int n = hospital1.size(); 
			      for (int i = 0; i < n; i++) {
			            System.out.println(i+1+"."+  hospital1.get(i));
			        } 
			      dataBaseHosp1();
			}
			if (choice1==2) { //Add patient 
				
				Scanner cin = new Scanner(System.in);
		        int ans = 1;
				 do { // Loop will go on until they don't want to 
					 Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
					 System.out.print("Enter patient name: ");  
					 String str= sc.nextLine();              //reads string   
					 hospital1.push(str); 
					 System.out.print("Do you want to go on 1- Yes , 2- No, Go Back"); 
			
				 } while (cin.nextInt() == ans);
				 dataBaseHosp1();
			}
			if (choice1==3) { //Remove patient 
				int n = hospital1.size(); //Display all patients
			      for (int i = 0; i < n; i++) {
			            System.out.println(i+1+"."+  hospital1.get(i));
			        } 
			      System.out.print("What do you want to Remove"); 
			      int remove2 = myScanner.nextInt();
			      hospital1.remove(remove2); // Remove based on given index
			      dataBaseHosp1();
			}
			
			else {
				dataBaseHosp(); // Go back to main menu 
			}

		
}
		public void dataBaseHosp2(){ // Database for Hospital 1 
			Scanner myScanner = new Scanner(System.in);
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Hospital 1 Database");
			System.out.println("What do you want to do?");
			System.out.println("1: Access All Patient Data");
			System.out.println("2: Add Patients ");
			System.out.println("3: Remove Patients ");
			System.out.println("Any Key: Go Back to Hospital Capacity Database");
			System.out.println("\n------------------------------------------------------------------\n");
			int choice2 = myScanner.nextInt();
			//Ask user input for choice of action 
			if (choice2==1) { //Print patients orderly manner
				int n = hospital2.size(); 
			      for (int i = 0; i < n; i++) {
			            System.out.println(i+1+"."+  hospital2.get(i));
			        } 
			      dataBaseHosp1();
			}
			if (choice2==2) { //Add patient 
				
				Scanner cin = new Scanner(System.in);
		        int ans = 1;
				 do { // Loop will go on until they don't want to 
					 Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
					 System.out.print("Enter patient name: ");  
					 String str= sc.nextLine();              //reads string   
					 hospital2.push(str); 
					 System.out.print("Do you want to go on 1- Yes , 2- No, Go Back"); 
			
				 } while (cin.nextInt() == ans);
				 dataBaseHosp2();
			}
			if (choice2==3) { //Remove patient 
				int n = hospital2.size(); //Display all patients
			      for (int i = 0; i < n; i++) {
			            System.out.println(i+1+"."+  hospital1.get(i));
			        } 
			      System.out.print("What do you want to Remove"); 
			      int remove2 = myScanner.nextInt();
			      hospital1.remove(remove2); // Remove based on given index
			      dataBaseHosp2();
			}
			
			else {
				dataBaseHosp2(); // Go back to main menu 
			}

		
}
		public void dataBaseHosp3(){ // Database for Hospital 1 
			Scanner myScanner = new Scanner(System.in);
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Hospital 1 Database");
			System.out.println("What do you want to do?");
			System.out.println("1: Access All Patient Data");
			System.out.println("2: Add Patients ");
			System.out.println("3: Remove Patients ");
			System.out.println("Any Key: Go Back to Hospital Capacity Database");
			System.out.println("\n------------------------------------------------------------------\n");
			int choice3 = myScanner.nextInt();
			//Ask user input for choice of action 
			if (choice3==1) { //Print patients orderly manner
				int n = hospital3.size(); 
			      for (int i = 0; i < n; i++) {
			            System.out.println(i+1+"."+  hospital3.get(i));
			        } 
			      dataBaseHosp1();
			}
			if (choice3==2) { //Add patient 
				
				Scanner cin = new Scanner(System.in);
		        int ans = 1;
				 do { // Loop will go on until they don't want to 
					 Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
					 System.out.print("Enter patient name: ");  
					 String str= sc.nextLine();              //reads string   
					 hospital2.push(str); 
					 System.out.print("Do you want to go on 1- Yes , 2- No, Go Back"); 
			
				 } while (cin.nextInt() == ans);
				 dataBaseHosp3();
			}
			if (choice3==3) { //Remove patient 
				int n = hospital3.size(); //Display all patients
			      for (int i = 0; i < n; i++) {
			            System.out.println(i+1+"."+  hospital1.get(i));
			        } 
			      System.out.print("What do you want to Remove"); 
			      int remove2 = myScanner.nextInt();
			      hospital3.remove(remove2); // Remove based on given index
			      dataBaseHosp3();
			}
			
			else {
				dataBaseHosp3(); // Go back to main menu 
			}

		
}}
