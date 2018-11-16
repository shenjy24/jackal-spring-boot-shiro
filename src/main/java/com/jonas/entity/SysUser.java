package com.jonas.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jonas
 * @since 2018-11-09
 */
@Data
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.ID_WORKER)
    private Long userId;

    @TableField("user_name")
    private String userName;

    @TableField("full_name")
    private String fullName;

    @TableField("password")
    private String password;

    @TableField("salt")
    private String salt;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
