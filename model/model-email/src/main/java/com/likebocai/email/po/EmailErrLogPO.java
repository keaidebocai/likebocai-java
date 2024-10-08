package com.likebocai.email.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @TableName email_err_log
 */
@TableName(value ="email_err_log")
@Data
@Schema(name = "EmailErrLog对象",description = "email-错误日志表")
public class EmailErrLogPO implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    @Schema(description = "主键")
    private String id;

    /**
     * 邮件id
     */
    @TableField(value = "email_id")
    @Schema(description = "邮件id")
    private String emailId;

    /**
     * 失败原因
     */
    @TableField(value = "err_reason")
    @Schema(description = "失败原因")
    private String errReason;

    /**
     * 是否处理
     */
    @TableField(value = "is_handle")
    @Schema(description = "是否处理")
    private String isHandle;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EmailErrLogPO other = (EmailErrLogPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmailId() == null ? other.getEmailId() == null : this.getEmailId().equals(other.getEmailId()))
            && (this.getErrReason() == null ? other.getErrReason() == null : this.getErrReason().equals(other.getErrReason()))
            && (this.getIsHandle() == null ? other.getIsHandle() == null : this.getIsHandle().equals(other.getIsHandle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmailId() == null) ? 0 : getEmailId().hashCode());
        result = prime * result + ((getErrReason() == null) ? 0 : getErrReason().hashCode());
        result = prime * result + ((getIsHandle() == null) ? 0 : getIsHandle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", emailId=").append(emailId);
        sb.append(", errReason=").append(errReason);
        sb.append(", isHandle=").append(isHandle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}