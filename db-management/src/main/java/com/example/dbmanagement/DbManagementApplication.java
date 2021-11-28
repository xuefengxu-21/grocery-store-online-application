package com.example.dbmanagement;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class DbManagementApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(DbManagementApplication.class);



	public static void main(String[] args) {

		SpringApplication.run(DbManagementApplication.class, args);
	}



	@Autowired
	private CustomerRepository customerRepository ;

	@Autowired
	private OrdersRepository ordersRepository ;

	@Autowired 
	private InventoryRepository inventoryRepository ;



	@Override
  	public void run(String... strings) throws Exception {
  		log.info("Creating tables") ;

  		preloadData();


  		testCases();

  
 	}



  	private void testCases() {

  		/* Task 1 Methods Tests*/
   		
  		// Long newCustomerId = newCustomer("Snow", "12343");
  		// log.info("Add new customer with id: " + newCustomerId) ;

  		// Long findCustomerId = loginCheck("Snow", "12343");
  		// log.info("Find Snow id: " + findCustomerId) ;

  		// Long findNoPersonId = loginCheck("Snosw", "12343");
  		// log.info("Find No person id: " + findNoPersonId) ;

  		// Long findNoPasswordId = loginCheck("Snow", "33");
  		// log.info("Find No password id: " + findNoPasswordId) ;



  		/* Task 2 Methods Tests */

  		// String newOrderDetails = "Broccoli * 3; Soda * 2";
  		// String newBadOrderDetails = "Broccoli * 3; Soda * 5" ;
  		// String newNoSuchItemOrderDetails = "Car * 2; Airplane * 3" ;

  		//log.info("test createNewOrder: " + "newOrderId: " + createNewOrder("asda"));

  		/* Task 3 Methods Tests */
  		// Long id = new Long(2);	// 2 or 50
  		
  		// log.info("Find order: " + findOrderById(id));

  		// Long id = new Long(3);
  		// Customer updatedCustomer = findCustomerById(id);
  		// updatedCustomer.setName("JOKER");
  		// boolean updateSuccess = false;
  		// updateSuccess = updateCustomerInfo(id, updatedCustomer);
  		// log.info("Update: " + updateSuccess + " " + findCustomerById(id));

  	  	

  	  	/* Task 4 Methods Tests */	

  	  	// View all customers
  	  	// List<Customer> customers = viewAllCustomers();

  	  	// for (Customer c:customers){
  	  	// 	log.info("Customer: " + c.getId() + " " + c.getName() + "...");
  	  	// }

  	  	// search customer by Id:
  	  	// Long id = new Long(2);
  	  	// log.info("Find Customer: " + findCustomerById(id));

  	  	// Change password:
  	  	// Long id = new Long(2) ; 
  	  	// boolean updateSuccess = updateCustomerPassword(id,"000000");
  	  	// log.info("Update password: " + updateSuccess);

  	  	// View ALl Orders:
  	  	// List<Orders> allOrders = viewAllOrders();
  	  	// for (Orders o:allOrders){
  	  	// 	log.info("All Orders: " + " " + o.getId() + o.getDetails() + " " + o.getAmount()); 
  	  	// }

  	  	// Updata Order Status:
  	  	// Long id = new Long(70);
  	  	// boolean updateSuccess = false;
  	  	// updateSuccess = updateOrderStatus(id, "DELIVERED");
  	  	// log.info("update: " + updateSuccess + "   " + findOrderById(id));

  	  	// View All inventory:
  	  	// List<Inventory> allInventory = viewAllInventory();
  	  	// for(Inventory i:allInventory) {
  	  	// 	log.info("Inventory: " + i.getId() + " " + i.getItemname() + " " + i.getDescription() + " " 
  	  	// 			+ i.getStorage() + " " + i.getUnitprice());
  	  	// }

  	  	// // Find Inventory by Id:
  	  	// Long id = new Long(2);
  	  	// log.info("Inventory:" + id + ": " + findInventoryById(id)) ;

  	  	// // Update inventory:
  	  	// Inventory updatedInventory = findInventoryById(id);
  	  	// updatedInventory.setUnitprice("9999.00");
  	  	// updateInventory(id,updatedInventory);
  	  	// log.info("Updated Inventory:" + id + ": " + findInventoryById(id)) ;

  	}


	private void preloadData() {

		Customer customer1 = new Customer("Jason Kidd", "123534");
		Customer customer2 = new Customer("Tim Ducan", "66666");
		Customer customer3 = new Customer("Larry Bird", "431123");

		customerRepository.save(customer1) ;
		customerRepository.save(customer2) ;
		customerRepository.save(customer3) ;

		
		Orders order1 = new Orders("Broccoli * 1; Apple * 2", 50.00, "PENDING");
		Orders order2 = new Orders("Milk * 1; Soda * 2", 60.00, "PENDING");
		Orders order3 = new Orders("Soap * 1; Bacon * 2", 90.00, "PENDING");

		ordersRepository.save(order1) ;
		ordersRepository.save(order2) ;
		ordersRepository.save(order3) ;


		Inventory item1 = new Inventory ("Broccoli", "Organic", 5, 1.00) ;
		Inventory item2 = new Inventory ("Bacon", "Organic",5, 3.99) ;
		Inventory item3 = new Inventory ("Milk", "Organic", 5, 4.99) ;
		Inventory item4 = new Inventory ("Soda", "Diet, 12 Cans", 5, 6.99) ;
		Inventory item5 = new Inventory ("Soap", "Mint", 5, 1.99) ;


		inventoryRepository.save(item1) ;
		inventoryRepository.save(item2) ;
		inventoryRepository.save(item3) ;
		inventoryRepository.save(item4) ;
		inventoryRepository.save(item5) ;
		

	}

	


	/* Query Methods */

	// Task 1:
	private Long newCustomer(String name, String password) {
		Customer newcustomer = new Customer(name, password);
		customerRepository.save(newcustomer);

		return customerRepository.count();
	}

	private Long loginCheck(String name, String password) {
		return customerRepository.loginCheck(name,password);
	}

	// Task 2:
	private Long createNewOrder(String details) {

		// details should be in form of "itemname quantity, itemname quantity, ..."

		boolean available = true;

		// check quantity
			// for item: details 
				//available = checkOrderWithInventory(itemname, quantity)

			// if available = yes: 
				//calculate amount, 
				//create order(details, amount, status)
				// update inventory, 
		return ordersRepository.count();


			// no: return null
		

	}

	private boolean checkOrderWithInventory(String itemName, Integer quantity){

		return true;
	}

	private void updateOrderToInventory(String itemName, Integer quantity) {

	}


	// Task 3:
	private Orders findOrderById(Long id) {

		if (ordersRepository.existsById(id)){
			Optional<Orders> orderResponse = ordersRepository.findById(id);
			Orders order = orderResponse.get() ;

			return order;
		
		} else {
		
			return null;
		
		}	

	}

	private boolean updateCustomerInfo(Long id, Customer updatedCustomer){

		if ( !customerRepository.existsById(id)) return false;

		customerRepository.updateCustomer(updatedCustomer.getName(), updatedCustomer.getPassword(),
										  updatedCustomer.getAddress(), updatedCustomer.getCity(),
										  updatedCustomer.getState(), updatedCustomer.getZip(),
										  updatedCustomer.getPhone(), updatedCustomer.getCardNumber(),
										  updatedCustomer.getExpMonth(), updatedCustomer.getExpYear(),
										  updatedCustomer.getCvv(), updatedCustomer.getEmail(),
										  updatedCustomer.getNotes(), id);


		return true;
	
	}


	// Task 4:

	private List<Customer> viewAllCustomers(){

		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;

	}

	private Customer findCustomerById(Long id) {

		if (customerRepository.existsById(id)) {
			Optional<Customer> customerResponse = customerRepository.findById(id);
			Customer costomer = customerResponse.get();

			return costomer;
		} 

		return null;
	
	}

	private boolean updateCustomerPassword (Long id, String newPassword){
		if (findCustomerById(id) == null) return false;
		customerRepository.updatePassword(newPassword,id);
		return true;

	}


	private	List<Orders> viewAllOrders() {

		List<Orders> allOrders = new ArrayList<>();
		ordersRepository.findAll().forEach(allOrders::add);
		return allOrders;

	}

	private boolean updateOrderStatus(Long id, String newStatus){

		if (!ordersRepository.existsById(id)) return false;
		ordersRepository.updateStatus( newStatus, id);
		return true;

	}

	private List<Inventory> viewAllInventory() {

		List<Inventory> allIventory = new ArrayList<>();
		inventoryRepository.findAll().forEach(allIventory::add);
		return allIventory;

	}

	private Inventory findInventoryById(Long id) {

		if (!inventoryRepository.existsById(id)) return null;
		Optional<Inventory> inventoryResponse = inventoryRepository.findById(id);
		Inventory inventory = inventoryResponse.get();
		return  inventory;

	}

	private boolean updateInventory(Long id, Inventory updatedItem){

		if(!inventoryRepository.existsById(id)) return false;

		 inventoryRepository.updateInventory(updatedItem.getItemname(), 
		 									updatedItem.getDescription(), 
		 									updatedItem.getStorage(), 
		 									updatedItem.getUnitprice(), 
		 									updatedItem.getId() ) ;
		return true;

	}

}



























