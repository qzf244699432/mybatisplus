package com.wxr.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用户实体")
@TableName(value = "user")//用于指定数据库的表名
public class User {

    @TableId(value = "id",type= IdType.AUTO)//当为auto时数据库的相应字段需要配置主键自增
    @JSONField(name="ID")
    @ApiModelProperty("主键")
    private Long id;

    @JSONField(name="NAME")
    @ApiModelProperty("名字")
    private String name;
    @JSONField(name="AGE")
    @ApiModelProperty("年龄")
    private Integer age;
    @JSONField(name="EMAIL")
    private String email;
    @TableField(fill = FieldFill.INSERT)//自动填充可以新增时增加更新时间，需要配置处理器才能生效
    @JSONField(name = "CREATAE",format = "yyyy/MM/dd",ordinal = 1)
    private Date gmt_create;//自动填充可以新增或者更新时增加更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JSONField(name = "MODIFIED")
    private Date gmt_modified;
    @TableLogic
    //逻辑删除只需要加上注解就可以，不需要做配置
    @JSONField(name = "DELETED")
    private Integer deleted;

}
