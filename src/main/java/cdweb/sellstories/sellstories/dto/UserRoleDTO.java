package cdweb.sellstories.sellstories.dto;

import cdweb.sellstories.sellstories.entity.Role;
import cdweb.sellstories.sellstories.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO {
    private Long idUser;
    private Long idRole;
}

