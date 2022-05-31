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
 * 系统字典
 * </p>
 *
 * @author xuye
 * @since 2022-03-08
 */
@Getter
@Setter
@TableName("sys_dict")
@ApiModel(value = "SysDict对象", description = "系统字典")
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("键")
    private String dictKey;

    @ApiModelProperty("值")
    private String dictValue;

    @ApiModelProperty("启用")
    private Integer isEnabled;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime deleteTime;

    @ApiModelProperty("版本号")
    @Version
    private Integer version;

    @ApiModelProperty("伪删除")
    @TableLogic
    private Integer deleted;


}
