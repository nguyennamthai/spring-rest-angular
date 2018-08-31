package thai.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Data
@Document(collection = "user")
public class PortalUser {
    private String id;

    @Indexed(unique = true)
    @Email(message = "Invalid email address")
    private String email;

    @NotNull
    private String password;

    private Role role;

    private Profile profile;

    private List<String> messageIds;

    public PortalUser(String email, String password, Role role, Profile profile, String... messageIds) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.profile = profile;
        this.messageIds = Arrays.asList(messageIds);
    }

    public enum Role {
        ADMIN, MEMBER
    }
}
