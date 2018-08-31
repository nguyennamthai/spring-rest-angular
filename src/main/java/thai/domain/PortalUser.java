package thai.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;

@Data
@Document(collection = "user")
public class PortalUser {
    private String id;

    @NonNull
    @Indexed(unique = true)
    @Email(message = "Invalid email address")
    private String email;

    @NonNull
    private String password;

    @NonNull
    private Role role;

    private Profile profile;

    public enum Role {
        ADMIN, MEMBER
    }
}
