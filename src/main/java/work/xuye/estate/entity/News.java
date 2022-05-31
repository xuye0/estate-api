package work.xuye.estate.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author xuye
 * @since 2022-02-22
 */
@Getter
@Setter
@ApiModel(value = "News对象", description = "")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotEmpty(message = "标题不能为空")
    @ApiModelProperty("标题")
    private String title;

    @NotEmpty(message = "描述不能为空")
    @ApiModelProperty("描述")
    private String description;

    @NotEmpty(message = "内容不能为空")
    @ApiModelProperty("内容")
    private String html;

    @ApiModelProperty("日期")
    private LocalDate date;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("版本号")
    @Version
    private Integer version;

    @ApiModelProperty("伪删除")
    @TableLogic
    private Integer deleted;


}
