package thai.portal.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Message {
    private String id;

    @Indexed
    private String userId;

    @NonNull
    @Size(min = 5, max = 255, message = "Enter between {min} and {max} characters")
    private String content;

    @Indexed
    @LastModifiedDate
    private Date modified;
}
