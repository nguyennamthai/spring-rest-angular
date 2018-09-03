package thai.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "user")
public class PortalUser {
    private String id;

    @NonNull
    @Indexed(unique = true)
    private String username;

    @NonNull
    private Role role;

    private Profile profile;

    public enum Role {
        ADMIN, MEMBER
    }
}
