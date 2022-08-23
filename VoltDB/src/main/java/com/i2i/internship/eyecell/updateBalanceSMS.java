package com.i2i.internship.eyecell;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class updateBalanceSMS extends VoltProcedure {

    public final SQLStmt SMSUpdate = new SQLStmt("UPDATE BALANCE \n" +
            "    SET BAL_LVL_SMS = BAL_LVL_SMS+? \n" +
            "    WHERE SUBSC_ID = ?;");

    public final SQLStmt updatePrice = new SQLStmt(
            "UPDATE BALANCE\n" +
                    "    SET PRICE=PRICE +? \n" +
                    "    WHERE SUBSC_ID= ? ;");


    public VoltTable[] run( int SUBSC_ID,long BAL_LVL_SMS,String packageName ,int PRICE)
            throws VoltAbortException {
        voltQueueSQL(SMSUpdate, BAL_LVL_SMS,SUBSC_ID);
        voltQueueSQL(updatePrice, PRICE,SUBSC_ID);
        return voltExecuteSQL();
    }
}


