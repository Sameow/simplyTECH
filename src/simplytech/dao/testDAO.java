package simplytech.dao;

import java.util.ArrayList;

import simplytech.entity.Customer;

public class testDAO {
	public static void main(String[] args){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers = CustomerDAO.retrieveAll("Customer");
		for (int i = 0; i < customers.size(); i ++){
			System.out.println(customers.get(i).getId() + ":" + customers.get(i).getUsername());
		}
	}
}
