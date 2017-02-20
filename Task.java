package DesignPatterns;

import java.util.*;

/**
 * Created by zemoso on 20/2/17.
 */

abstract class SocNet {
    String u_name,pass;
    abstract SocNet createProduct();
}

class Facebook extends SocNet {

    public Facebook(){
        u_name="fb"; pass="123";
    }
    Facebook createProduct(){
        return new Facebook();
    }
}

class LinkedIn extends SocNet {

    public LinkedIn(){
        u_name="in"; pass="123";
    }
    LinkedIn createProduct(){
        return new LinkedIn();
    }
}

class Twitter extends SocNet {

    public Twitter(){
        u_name="twi"; pass="123";
    }
    Twitter createProduct(){
        return new Twitter();
    }
}

class Google extends SocNet {

    public Google(){
        u_name="google"; pass="123";
    }
    Google createProduct(){
        return new Google();
    }
}

class All_networks {
    static HashMap m_RegisteredProducts = new HashMap();
    static All_networks singleton;

    private All_networks(){
        
    }

    static All_networks instance(){
        if(singleton==null) {
            singleton=new All_networks();
        }
        return singleton;
    }

    static void registerProduct(String productID, SocNet p){
        m_RegisteredProducts.put(productID,p);
    }
    static SocNet createProduct(String productID){
        return ((SocNet)m_RegisteredProducts.get(productID)).createProduct();
    }
}

public class Task {

    static {
       All_networks ob = All_networks.instance();
       ob.registerProduct("ID4",new Google());
       ob.registerProduct("ID3",new Twitter());
       ob.registerProduct("ID2",new LinkedIn());
       ob.registerProduct("ID1",new Facebook());
    }

    public static SocNet login(String social_network){
        if(social_network.equals("Facebook")){return All_networks.createProduct("ID1");}
        else if(social_network.equals("LinkedIn")){return All_networks.createProduct("ID2");}
        else if(social_network.equals("Twitter")){return All_networks.createProduct("ID3");}
        else {
            return All_networks.createProduct("ID4");
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter choice of social network for logging in:");
        String social_network = scan.next();
        SocNet locked= login(social_network);

        System.out.println("Enter your user name:");
        String uname = scan.next();

        System.out.println("Enter your password");
        String pass= scan.next();

        if(locked.u_name.equals(uname)&& locked.pass.equals(pass)) System.out.println("Login successful");
        else System.out.println("Login Failed");

    }
}
