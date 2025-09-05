package com.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
