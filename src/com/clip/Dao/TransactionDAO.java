package com.clip.Dao;

import com.clip.Dto.Transaction;

import java.io.IOException;

import java.util.List;

public interface TransactionDAO {    
   public void addTransaction(Transaction trans) throws IOException;
   public List<Transaction> geTransactions();
   public List<Transaction> geTransactions(Integer user_id);
   public Transaction getTransaction(String trans_id);
}
