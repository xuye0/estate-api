package work.xuye.estate.dto;

import lombok.Data;

/**
 * @author xuye
 */
@Data
public class LoginInfo {

    private Integer id;

    private String loginId;

    private String password;

    private String role;

    private String userId;

    private String name;
}
