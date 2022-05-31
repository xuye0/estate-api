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
 * 房产信息
 * </p>
 *
 * @author xuye
 * @since 2022-03-08
 */
@Getter
@Setter
@ApiModel(value = "Estate对象", description = "房产信息")
public class EstateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("房产名称")
    private String name;

    @ApiModelProperty("城市")
    private Integer cityId;

    @ApiModelProperty("城市")
    private String cityName;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("价格")
    private Double price;

    @ApiModelProperty("网站url")
    private String websiteUrl;

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
