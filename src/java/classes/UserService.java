/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author 728918
 */
public class UserService implements Serializable {
    private String username;
    private String password;
    
    public UserService() {
    }

    public UserService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public UserService login(String uname, String psswrd){
    
        switch(uname){
            case "adam":
            case "Adam":
                if (psswrd.equals("password")){
                    UserService thisuser = new UserService(uname,"password");
                    return thisuser;
                }
                else return null;
                         
            case "betty":
            case "Betty":
                if (psswrd.equals("password")){
                    UserService thisuser = new UserService(uname,"password");
                    return thisuser;
                }
                else return null;
        }
        
        return null;
}
    
    
}
