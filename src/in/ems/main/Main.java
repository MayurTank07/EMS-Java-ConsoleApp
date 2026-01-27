package in.ems.main;

// NEW CODE BELOW WITH CONSOLE UI

// EMS -> 

// DB CONNECTION
// MYSQL CONNECTOR JAR FILE ADD
// EMS MAIN CLASS
// CRUD OPERATIONS -> CREATE, READ, UPDATE, DELETE OPERATIONS ON EMPLOYEES
// PACKAGES --> 
	// 1. AUTH PKG -> REGISTRATION AND LOGIN 
	// 2. DB PKG -> DB CONNECTION BUILDING, LOGIN AND REGISTRATION WITH DB CREDS
	// 3. EMP PKG -> WHERE WE HAVE CREATED SCHEMA FOR AN EMPLOYEE 
	// 4. MAIN PKG -> MAIN CLASS CODE
	// 5. UI PKG -> DEFINES CONSOLE UI



import java.util.Scanner;

import in.ems.Db.DBLogin;
import in.ems.Db.DBRegistration;
import in.ems.auth.Login;
import in.ems.auth.Registration;
import in.ems.ui.ConsoleUI;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean appRunning = true;

        while (appRunning) {

            ConsoleUI.header("EMPLOYEE MANAGEMENT SYSTEM");

            ConsoleUI.menuItem(1, "Login");
            ConsoleUI.menuItem(2, "Register");
            ConsoleUI.menuItem(3, "Exit");

            ConsoleUI.line();
            System.out.print(" Enter choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    ConsoleUI.subHeader("LOGIN");

                    System.out.print(" Username : ");
                    String username = sc.nextLine();

                    System.out.print(" Password : ");
                    String password = sc.nextLine();

                    Login login = new Login(username, password);

                    if (!login.validateLogin()) {
                        ConsoleUI.error("Invalid username or password");
                        break;
                    }

                    ConsoleUI.success("Login successful");
                    boolean loggedIn = true;

                    while (loggedIn) {

                        ConsoleUI.header("DASHBOARD - " + username);

                        ConsoleUI.menuItem(1, "Add Employee");
                        ConsoleUI.menuItem(2, "Update Employee");
                        ConsoleUI.menuItem(3, "Delete Employee");
                        ConsoleUI.menuItem(4, "View Employees");
                        ConsoleUI.menuItem(5, "Logout");

                        ConsoleUI.line();
                        System.out.print(" Enter choice : ");
                        int dashChoice = sc.nextInt();
                        sc.nextLine();

                        switch (dashChoice) {

                            case 1:
                                ConsoleUI.subHeader("ADD EMPLOYEE");

                                System.out.print(" Employee ID     : ");
                                int eid = sc.nextInt();
                                sc.nextLine();

                                System.out.print(" Employee Name   : ");
                                String ename = sc.nextLine();

                                System.out.print(" Salary          : ");
                                double esal = sc.nextDouble();
                                sc.nextLine();

                                System.out.print(" Address         : ");
                                String address = sc.nextLine();

                                System.out.print(" Company         : ");
                                String company = sc.nextLine();

                                if (DBLogin.addEmployee(eid, ename, esal, address, company))
                                    ConsoleUI.success("Employee added successfully");
                                else
                                    ConsoleUI.error("Failed to add employee");

                                break;

                            case 2:
                                ConsoleUI.subHeader("UPDATE EMPLOYEE");

                                System.out.print(" Employee ID     : ");
                                int upId = sc.nextInt();

                                System.out.print(" New Salary      : ");
                                double upSal = sc.nextDouble();
                                sc.nextLine();

                                System.out.print(" New Name        : ");
                                String upName = sc.nextLine();

                                System.out.print(" New Address     : ");
                                String upAddr = sc.nextLine();

                                System.out.print(" New Company     : ");
                                String upComp = sc.nextLine();

                                if (DBLogin.updateEmployee(upId, upName, upSal, upAddr, upComp))
                                    ConsoleUI.success("Employee updated successfully");
                                else
                                    ConsoleUI.error("Employee not found");

                                break;

                            case 3:
                                ConsoleUI.subHeader("DELETE EMPLOYEE");

                                System.out.print(" Employee ID : ");
                                int delId = sc.nextInt();

                                System.out.print(" Confirm (Y/N) : ");
                                char confirm = sc.next().charAt(0);

                                if (confirm == 'Y' || confirm == 'y') {
                                    if (DBLogin.deleteEmployee(delId))
                                        ConsoleUI.success("Employee deleted");
                                    else
                                        ConsoleUI.error("Employee not found");
                                } else {
                                    ConsoleUI.info("Delete operation cancelled");
                                }

                                break;

                            case 4:
                                ConsoleUI.subHeader("EMPLOYEE LIST");
                                DBLogin.viewEmployees();
                                break;

                            case 5:
                                loggedIn = false;
                                ConsoleUI.info("Logged out successfully");
                                break;

                            default:
                                ConsoleUI.error("Invalid option");
                        }
                    }
                    break;

                case 2:
                    ConsoleUI.subHeader("REGISTRATION");

                    System.out.print(" Name     : ");
                    String name = sc.nextLine();

                    System.out.print(" Username : ");
                    String regUser = sc.nextLine();

                    System.out.print(" Email    : ");
                    String email = sc.nextLine();

                    System.out.print(" Password : ");
                    String regPass = sc.nextLine();

                    Registration reg = new Registration(name, regUser, email, regPass);
                    DBRegistration.insertReg(reg);

                    ConsoleUI.success("Registration completed");
                    break;

                case 3:
                    appRunning = false;
                    ConsoleUI.info("Application closed");
                    break;

                default:
                    ConsoleUI.error("Invalid choice");
            }
        }
        sc.close();
    }
}









