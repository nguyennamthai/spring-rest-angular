package thai.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class Message {
    private String id;

    @Indexed
    private String userId;

    @NonNull
    @Size(min = 5, max = 255, message = "Enter between {min} and {max} characters")
    private String content;

    @LastModifiedDate
    private Date modified;
}
