package cdweb.sellstories.sellstories.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoLoginDTO {
    private UserDTO info;
    private String mess;
}
