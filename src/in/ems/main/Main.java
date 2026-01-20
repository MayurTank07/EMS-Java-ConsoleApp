package in.ems.main;

import java.util.Scanner;

import in.ems.Db.DBLogin;
import in.ems.Db.DBRegistration;
import in.ems.auth.Login;
import in.ems.auth.Registration;

public class Main {

	public static void main(String[] args) {
		
		String check = "";
		int choice;
		
		do {
		System.out.println("\n\n\t-------------- EMPLOYEE MANAGEMENT SYSTEM --------------\n\n");
		
		System.out.println("\t\t\t SELECT ONE : \n");
		System.out.println("\t\t\t 1. Login");
		System.out.println("\t\t\t 2. Register");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n\t\t Enter your choice : ");
		choice = sc.nextInt();	
		sc.nextLine();
		
		switch(choice)
		{
			case 1 :  
				System.out.println("\n\n\t-------------- WELCOME TO EMS LOGIN --------------\n\n");
				
				System.out.print("\t\t\t ENTER YOUR USERNAME : ");
				String loginUsername = sc.nextLine();
				
				System.out.print("\t\t\t ENTER YOUR PASSWORD : ");
				String loginPassword = sc.nextLine();
				
				Login login = new Login(loginUsername, loginPassword);
				login.validateLogin();
				System.out.println("\n\tSuccessfully Logged in... ");
				
				
				
				
				System.out.println("\n\n\t-------------- WELCOME " + loginUsername + " TO EMS  --------------\n\n");
				
				System.out.println("\n\n\t 1. ADD EMPLOYEE");
				System.out.println("\n\n\t 2. UPDATE EMPLOYEE");
				System.out.println("\n\n\t 3. DELETE EMPLOYEE");
				System.out.println("\n\n\t 4. VIEW EMPLOYEE");
				System.out.println("\n\n\t 5. GO BACK");
				
				System.out.print("\n\t\t Enter your choice : ");
				int choiceAfterLogin = sc.nextInt();   // 1
				
				switch (choiceAfterLogin) 
				{
					case 1: 
						// ADD EMPLOYEE 
						
						System.out.println("\n\n\t-------------- ADD EMPLOYEES  --------------\n\n");
						
						sc.nextLine(); // ⭐ Clear buffer before reading name

						System.out.print("\t ENTER YOUR EMPLOYEE NAME : ");
						String ename = sc.nextLine();

						System.out.print("\t ENTER YOUR EMPLOYEE ID : ");
						int eid = sc.nextInt();

						System.out.print("\t ENTER YOUR EMPLOYEE SALARY : ");
						double esal = sc.nextDouble();
						sc.nextLine(); // consume newline

						System.out.print("\t ENTER YOUR EMPLOYEE ADDRESS : ");
						String address = sc.nextLine();

						System.out.print("\t ENTER YOUR EMPLOYEE COMPANY NAME : ");
						String company = sc.nextLine();


						
						 boolean status = DBLogin.addEmployee(eid, ename, esal, address, company);

						    if (status) {
						        System.out.println("\n\t Employee added successfully ✅");
						    } else {
						        System.out.println("\n\t Failed to add employee ❌");
						    }
						
					break;
					
					case 2: 
						// UPDATE EMPLOYEE
						 System.out.println("\n\n\t-------------- UPDATE EMPLOYEE --------------\n\n");

						    sc.nextLine(); // ⭐ clear buffer after menu choice

						    System.out.print("\t ENTER EMPLOYEE ID TO UPDATE : ");
						    int upId = sc.nextInt();

						    System.out.print("\t ENTER NEW EMPLOYEE SALARY : ");
						    double upSalary = sc.nextDouble();
						    sc.nextLine(); // consume newline

						    System.out.print("\t ENTER NEW EMPLOYEE NAME : ");
						    String upName = sc.nextLine();

						    System.out.print("\t ENTER NEW EMPLOYEE ADDRESS : ");
						    String upAddress = sc.nextLine();

						    System.out.print("\t ENTER NEW EMPLOYEE COMPANY NAME : ");
						    String upCompany = sc.nextLine();

						    boolean updated = DBLogin.updateEmployee(
						            upId, upName, upSalary, upAddress, upCompany
						    );

						    if (updated) {
						        System.out.println("\n\t Employee updated successfully ✅");
						    } else {
						        System.out.println("\n\t Employee ID not found ❌");
						    }
						
						
						
					break;
					
					case 3: 
						 // DELETE EMPLOYEE
					    System.out.println("\n\n\t-------------- DELETE EMPLOYEE --------------\n\n");

					    sc.nextLine(); // clear buffer after menu choice

					    System.out.print("\t ENTER EMPLOYEE ID TO DELETE : ");
					    int delId = sc.nextInt();

					    System.out.print("\n\t Are you sure you want to delete this employee? (Y/N): ");
					    char confirm = sc.next().charAt(0);

					    if (confirm == 'Y' || confirm == 'y') {

					        boolean deleted = DBLogin.deleteEmployee(delId);

					        if (deleted) {
					            System.out.println("\n\t Employee deleted successfully ✅");
					        } else {
					            System.out.println("\n\t Employee ID not found ❌");
					        }

					    } else {
					        System.out.println("\n\t Delete operation cancelled ❎");
					    }
					break;
					
					case 4: 
						  // VIEW EMPLOYEES
					    System.out.println("\n\n\t-------------- VIEW EMPLOYEES --------------\n\n");

					    DBLogin.viewEmployees();

					    System.out.println("\n\t Press Enter to continue...");
					    sc.nextLine();
					break;
					
					case 5: 
						//code
					break;
					
					default:
						//code
					
				}
				
			break;
			
			case 2:
				
				System.out.println("\n\n\t-------------- WELCOME TO EMS REGISTRATIUON --------------\n\n");
				
				System.out.print("\t\t\t ENTER YOUR NAME : \n");
				String name = sc.nextLine();
				
				System.out.print("\t\t\t ENTER YOUR USERNAME : \n");
				String username = sc.nextLine();
				
				System.out.print("\t\t\t ENTER YOUR EMAIL : \n");
				String email = sc.nextLine();
				
				System.out.print("\t\t\t ENTER YOUR PASSWORD : \n");
				String password = sc.nextLine();
				
				Registration res = new Registration(name, username, email, password);
				DBRegistration.insertReg(res);

				res.displayAll();
				
				
			break;
			
			default:
				System.out.println("Invalid choice");
		}
		
		System.out.print("\n\t\t Do you want to Logout (y/n) : ");
		check = sc.nextLine();  // y
		
		}while(check.equals("n"));
		
		
		
		
		System.out.println("\n\n\t-------------- FINISHED --------------\n\n");
	
	}

}
