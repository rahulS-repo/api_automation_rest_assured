package builders;

import lombok.Builder;

@Builder
public class UserBuilder {
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
}
