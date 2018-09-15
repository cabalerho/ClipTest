package com.clip.util;

import com.clip.Dto.Transaction;
import com.google.gson.Gson;

public class Util {
    
    public static Transaction stringJsonToTransaction(String json){
        Transaction transaction = null;
        try {
                       
            Gson gson = new Gson();
            transaction = gson.fromJson(json, Transaction.class);
                                  
        }catch(Exception e){
            System.out.println("Error parsing Json");
        }        
        return transaction;
    }    
}
