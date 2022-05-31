package work.xuye.estate.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author xuye
 * @since 2021-12-06
 */
@Getter
@Setter
@ApiModel(value = "User对象", description = "")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("user_id")
    private String userId;

    @NotEmpty(message = "姓名不能为空")
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("岗位")
    private String position;

    @ApiModelProperty("手机号1")
    private String phone;

    @ApiModelProperty("手机号1")
    private String secondaryPhone;

    @Email
    @ApiModelProperty("私人邮件地址")
    private String personalEmail;
    
    @Email
    @ApiModelProperty("公司邮件地址")
    private String companyEmail;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("网站url")
    private String websiteUrl;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("版本号")
    @Version
    private Integer version;

    @ApiModelProperty("伪删除")
    @TableLogic
    private Integer deleted;


}
