package tests;

import configs.ConfigReader;
import endpoints.UsersApiClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest {

    @Test
    public void getUser(){
        System.out.println(System.getProperty("browser"));
        System.out.println(System.getProperty("env"));
        System.out.println(System.getProperty("group"));
//        UsersApiClient usersApiClient = new UsersApiClient();
//        Response user = usersApiClient.getUser(1);
//        Assert.assertEquals(user.getStatusCode(), 200);
//        Assert.assertEquals(user.jsonPath().getString("name"), "Leanne Graham");
    }
}
