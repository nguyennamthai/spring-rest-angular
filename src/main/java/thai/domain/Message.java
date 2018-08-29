package thai.domain;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Size;
import java.util.Date;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

@Data
public class Message {
    private String id;

    @Size(min = 5, max = 255, message = "Enter between {min} and {max} characters")
    private String content;

    @Indexed(direction = DESCENDING)
    @LastModifiedDate
    private Date modified;
}
