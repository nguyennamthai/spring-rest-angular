package thai.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Profile {
    private String fullName;

    @Size(max = 5000, message = "The information is too long")
    private String info;

    @Size(max = 255, message = "The file name is too long")
    private String imagePath;
}
