package thai.service.dto;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String username;
    private String role;
    private ProfileDto profile;
}
