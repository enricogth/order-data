package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 
		// Client data
		System.out.println("Enter client data: ");
		System.out.println("Name: ");
		String name = input.nextLine();
		System.out.println("Email: ");
		String email = input.next();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(input.next());
		// Transfer all these information to class Client
		Client client = new Client(name, email, birthDate);
		
		// Order data
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		//use valueOf to tranform a String > enum value
		OrderStatus status = OrderStatus.valueOf(input.next());
		
		//import class Order to put all values there
		Order order = new Order(new Date(), status, client);
		
		// Read the order now
		System.out.println("How many itens to this order: ");
		int n = input.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.println("Product name: ");
			input.next();
			String productName = input.nextLine();	
			System.out.println("Product price: ");
			Double productPrice = input.nextDouble();
			
			// Transfer productName value to name(Product), namePrice as well
			Product product = new Product(productName, productPrice);
		
			System.out.println("Quantity: ");
			int quantity = input.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			// increase Item value, to count how many itens the client want
			order.addItem(orderItem);
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
		input.close();		
	}

}
