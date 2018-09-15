package com.clip.Controller;

import com.clip.Dao.TransactionDAOImpl;
import com.clip.Dto.Transaction;
import com.clip.util.Util;

import java.io.IOException;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TransactionController {

    public void addTransaction(Integer user_id, String trans_json) {
        System.out.println("addTransaction");
        TransactionDAOImpl transactionDAO = new TransactionDAOImpl();
        Transaction transaction = Util.stringJsonToTransaction(trans_json);
       
        try {
            if (transaction.getTransaction_id() == null)
                transaction.setTransaction_id(UUID.randomUUID().toString());
            if (transaction.getUser_id() == null)
                transaction.setUser_id(user_id);
            transactionDAO.addTransaction(transaction);
        } catch (IOException e) {
            System.out.println("Error addTransaction");
        }
        System.out.println(transaction.toJsonString());
    }

    public void listTransactions(Integer user_id) {
        
        System.out.println("listTransactions");
        TransactionDAOImpl transactionDAO = new TransactionDAOImpl();
        List<Transaction> listTransactions = transactionDAO.geTransactions(user_id);
        Collections.sort(listTransactions);
       
        if (listTransactions != null && !listTransactions.isEmpty()) {

            for (Transaction transaction : listTransactions)
            {
                System.out.println(transaction.toJsonString());
            }
        } else
            System.out.println("[]");
    }

    public void sumTransactions(Integer user_id) {

        System.out.println("sumTransactions");
        TransactionDAOImpl transactionDAO = new TransactionDAOImpl();
        Float sum = Float.valueOf(0);

        List<Transaction> listTransactions =
            transactionDAO.geTransactions(user_id);

        if (listTransactions != null && !listTransactions.isEmpty()) {

            for (Transaction transaction : listTransactions)
                sum += transaction.getAmount();
        }

        System.out.println("{\"user\":" + user_id + ", \"sum\": " + sum + "}");
    }

    public void showTransaction(Integer user_id,String trans_id) {

        System.out.println("showTransaction");
        TransactionDAOImpl transactionDAO = new TransactionDAOImpl();

        Transaction transaction = transactionDAO.getTransaction(trans_id);
        if (transaction != null && transaction.getUser_id().equals(user_id))
            System.out.println(transaction.toJsonString());
        else
            System.out.println("Transaction not found");
    }
}
