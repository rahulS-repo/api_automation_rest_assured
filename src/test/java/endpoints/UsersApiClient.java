package endpoints;

import builders.UserBuilder;
import configs.ConfigReader;
import io.restassured.response.Response;

public class UsersApiClient extends ApiClient{
    private final String USER_PATH;
    public UsersApiClient(){
        USER_PATH = ConfigReader.getProperty("USER_BASE_PATH");
        System.out.println("User Path: " + USER_PATH);
    }

    public int createUser(UserBuilder user){
        return post(USER_PATH, user).jsonPath().getInt("id");
    }
    public Response getUser(int id){
        return get(USER_PATH+"/"+id);
    }
}
