package com.infosys_sol.sqlitedatabaseproject.database;

/**
 * Created by mac on 31/01/2018.
 */

public class DbModel {

    String userRollNumber;
    String userName;
    String userFName;
    String userPhone;
    String userAddress;

    public DbModel(String userRollNumber, String userName, String userFName, String userPhone, String userAddress) {
        this.userRollNumber = userRollNumber;
        this.userName = userName;
        this.userFName = userFName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }
}
