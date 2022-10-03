package com.example.springbootsecurity.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;

    @TableId
    private Long id;
    private String userName;
    private String nickName;
    private String password;
    /**
     * 账号状态 0正常 1停用
     */
    private String status;
    private String email;
    private String phoneNumber;
    /**
     * 性别 0男 1女 2未知
     */
    private String sex;
    String avatar;
    /**
     * 用户类别 0男 1女 2未知
     */
    private String userType;

    /**
     * 创建人用户id
     */
    private String createBy;
    private Date createTime;
    private Date updateTime;
    /**
     * 删除标识 0标识未删除，1标识已删除
     */
    private Integer delFlag;
}
