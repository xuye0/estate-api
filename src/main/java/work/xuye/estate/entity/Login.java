package work.xuye.estate.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author xuye
 * @since 2021-12-04
 */
@Getter
@Setter
@ApiModel(value = "Login对象", description = "")
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("角色")
    private String role;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("伪删除")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("版本号")
    @Version
    private Integer version;


}
