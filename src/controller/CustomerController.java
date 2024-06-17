package controller;

import model.dto.CreateCustomerDto;
import model.service.CustomerService;
import model.service.CustomerServiceImp;
import utils.CustomerTableModel;
import utils.DBException;
import view.RenderDataToTable;
import view.UI;

import java.util.Scanner;

public class CustomerController {
    static Scanner sc = new Scanner(System.in);
    static final CustomerService customerService = new CustomerServiceImp();
    public static void processOption() throws DBException {
        String option = "";
        while (!option.equalsIgnoreCase("exit")) {
            UI.customerServicesMenu();
            System.out.print("Insert option: ");
            option = sc.nextLine();
            switch (option) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    customerService.addNewCustomer(new CreateCustomerDto(
                            name, email, password
                    ));
                    break;
                case "2":
                    RenderDataToTable.getAllCustomersDataTable();
                    break;
                case "3":
                    System.out.println("Delete");
                    break;
                case "0":
                    System.out.println("0. Exit");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        }

    }
}
