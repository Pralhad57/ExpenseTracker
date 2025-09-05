package com.spring.Service;

import com.spring.Entity.Expense;

public interface ExpenseService {

	Integer Save(Expense expense);

	Expense findByid(Integer eid);

	String updateExpense(Expense exp);

	String Delete(Integer sid);

}
