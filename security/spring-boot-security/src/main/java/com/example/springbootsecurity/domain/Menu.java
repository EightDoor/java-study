package com.example.springbootsecurity.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoukai
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    private String menuName;
    private String path;
    private String component;
    /**
     * 菜单状态（0显示、1隐藏）
     */
    private String visible;
    /**
     * 菜单状态（0正常 1停用）
     */
    private String status;
    private String perm;
    private String icon;
    private Long createBy;
    private Date createTime;
    private Long updateBy;
    private Date updateTime;
    private Integer delFlag;
    private String remark;
}