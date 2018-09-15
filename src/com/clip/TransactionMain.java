package com.clip;

import com.clip.Controller.TransactionController;

public class TransactionMain {


    /**
     * @param args 
     * ADD TRANSACTION <user_id> add <transaction_json>
     * SHOW TRANSACTION <user_id> <transaction_id>
     * LIST TRANSACTIONS <user_id> list
     * SUM TRANSACTIONS <user_id> sum
     */
    public static void main(String[] args) {


        if (args.length >= 2) {

            Integer id_user = Integer.valueOf(args[0]);
            String action = args[1];

            StringBuffer trans_json = new StringBuffer();
            
            if (args.length >= 3) {
                
                for(int i=2; i<args.length;i++)
                    trans_json.append(args[i]+" ");
            }
            TransactionController tc = new TransactionController();
            
            System.out.println(trans_json.toString());
           
            switch (action) {
            case "add":
                tc.addTransaction(id_user, trans_json.toString());
                break;
            case "list":
                tc.listTransactions(id_user);
                break;
            case "sum":
                tc.sumTransactions(id_user);
                break;
            default:
                tc.showTransaction(id_user,action);
                break;
            }
        }
    }
}
