package routes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Routes {

   public static String base_url="https://petstore.swagger.io/v2" ;
//    public static Properties prop;

 //     try {
//        prop = new Properties();
//        FileInputStream ip = new FileInputStream(
//                System.getProperty("user.dir") + "\\src\\Configuration\\Config.properties");
//        prop.load(ip);
//    } catch ( IOException e) {
//        System.out.println("Error: " + e.getMessage());
//    }



    //User
    //We can test very simple, CRUD ( create read update delete ), simple test

    public static String user_post_url=base_url+"/user";
    public static String user_get_url=base_url+"/user/{username}";
    public static String user_update_url=base_url+"/user/{username}";
    public static String user_delete_url=base_url+"/user/{username}";

    //Store
    //On Store section we can also test with CRUD
    public static String store_post_url= base_url + "/store/order";
    public static String store_get_url= base_url + "/store/order/{orderId}";
    public static String store_delete_url= base_url + "/store/order/{orderId}";

    //Pet
   public static String pet_post_url = base_url + "/pet";
   public  static String pet_get_url = base_url + "/pet/{petId}";
   public static String pet_update_url = base_url + "/pet";
   public static String pet_delete_url = base_url  + "/pet/{petId}";



}
