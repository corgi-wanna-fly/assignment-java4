package com.java.dao;

import com.java.model.Account;
import com.java.model.Customer;

public class AccountDAO {
	// hàm xác thực tài khoản
	public boolean isValidate(Account account) {
		CustomerDAO customerDAO = new CustomerDAO();

		Customer customer = customerDAO.getCustomer(account.getEmail(), account.getPassword());

		if (customer == null)
			return false;
		return true;
	}
}
