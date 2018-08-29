package thai.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PortalUser {
    private String id;

    // TODO Add unique constraint and trigger validation
    @NotNull
    @Email(message = "Invalid email address")
    private String email;

    @NotNull
    private String password;

    private Role role;

    private Profile profile;

    private List<Message> messages;

    enum Role {
        ADMIN, MEMBER
    }
}
