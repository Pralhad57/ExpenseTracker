package com.spring.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Entity.Expense;
import com.spring.Repository.ExpenseRepository;

@Service
public class ExpenseServiceImp implements ExpenseService {

	@Autowired
	private ExpenseRepository ExpenseRepository;

	@Override
	public Integer Save(Expense expense) {

		return ExpenseRepository.save(expense).getEid();
	}

	@Override
	public Expense findByid(Integer eid) {

		Optional<Expense> expen = ExpenseRepository.findById(eid);
		return expen.get();
	}

	@Override
	public String updateExpense(Expense expense) {
		Expense exp1 = findByid(expense.getEid());
		exp1.setAmount(expense.getAmount());
		exp1.setDesciption(expense.getDesciption());
		exp1.setName(expense.getName());
		ExpenseRepository.save(exp1);

		return "Updated Successfully";
	}

	@Override
	public String Delete(Integer sid) {

		Optional<Expense> exp2 = ExpenseRepository.findById(sid);

		ExpenseRepository.delete(exp2.get());

		return "Expense deleted Successfully";
	}

}
