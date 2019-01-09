package thai.portal.service.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDto {
    private String id;
    private String userId;
    private String content;
    private Date modified;
    private boolean editable;
}
