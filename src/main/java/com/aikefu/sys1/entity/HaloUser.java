package com.aikefu.sys1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author coldxiangyu
 * @since 2018-09-21
 */
@Data
@Accessors(chain = true)
@TableName("halo_user")
public class HaloUser{

    private static final long serialVersionUID = 1L;

    @TableField("login_enable")
    private String loginEnable;

    @TableField("login_error")
    private Integer loginError;

    @TableField("login_last")
    private LocalDateTime loginLast;

    @TableField("user_avatar")
    private String userAvatar;

    @TableField("user_desc")
    private String userDesc;

    @TableField("user_display_name")
    private String userDisplayName;

    @TableField("user_email")
    private String userEmail;

    @TableField("user_name")
    private String userName;

    @TableField("user_pass")
    private String userPass;


}
