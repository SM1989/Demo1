package main.java.coreFunctions.users;


import main.java.coreFunctions.users.triggers.impl.FunctionsImpl;
import main.java.coreFunctions.users.triggers.userInterfaces;

public class userCoreFunctions {

// Keep Only the user Service Interfaces

    public userInterfaces getUserInterfaces(){
        return new FunctionsImpl();
    }
}
