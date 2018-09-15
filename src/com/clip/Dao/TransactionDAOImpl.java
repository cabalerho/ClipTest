package com.clip.Dao;

import com.clip.Dto.Transaction;
import com.clip.util.Util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionDAOImpl implements TransactionDAO{
   
    private static final String file = "Transaction.dat";
    
    public void addTransaction(Transaction trans) throws IOException{
        FileWriter out = null;
        try {
            out = new FileWriter(file,true);
            out.append(trans.toJsonString()+"\n");
        }catch (Exception e) {
            System.out.println(e);
        }finally{
            out.close();
        }
    }
    
    public List<Transaction> geTransactions(){
            
        List<Transaction> listTransactions = new ArrayList<Transaction>();

        try {
            FileReader fileReader = new FileReader(file);
            Scanner data = new Scanner(fileReader);
            Transaction transaction = null;
            String line;
            while (data.hasNextLine()) {               
                line = data.nextLine(); 
                transaction = Util.stringJsonToTransaction(line);      
                listTransactions.add(transaction);
            }
        } catch (Exception e) {
            System.out.println("Does not exist data");
        }
        return listTransactions;
    }
    
    public List<Transaction> geTransactions(Integer user_id){
            
        List<Transaction> listTransactions = new ArrayList<Transaction>();

        try {
            FileReader fileReader = new FileReader(file);
            Scanner data = new Scanner(fileReader);            
   
            Transaction transaction = null;
            String line;
            while (data.hasNextLine()) {               
                line = data.nextLine();                
                transaction = Util.stringJsonToTransaction(line);                
                if(transaction.getUser_id().equals(user_id))
                    listTransactions.add(transaction);
            }
        } catch (Exception e) {
            System.out.println("Does not exist data");
        }
        return listTransactions;
    }
    
    
    public Transaction getTransaction(String trans_id){
        
        Transaction transaction = null;
        try {
            FileReader fileReader = new FileReader(file);
            Scanner data = new Scanner(fileReader);
            String line;
            while (data.hasNextLine()) {  
                line = data.nextLine(); 
                transaction = Util.stringJsonToTransaction(line);      
                if(transaction.getTransaction_id().equals(trans_id))
                    break;
            }
        } catch (Exception e) {
            System.out.println("Does not exist data");
        }        
        return transaction;
    }
}
