package com.likebocai.email.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @TableName email_content
 */
@TableName(value ="email_content")
@Data
@Schema(name = "EmailContent对象",description = "email-邮件内容表")
public class EmailContentPO implements Serializable {
    /**
     * 16位字符串的主键
     */
    @TableId(value = "id")
    @Schema(description = "主键")
    private String id;

    /**
     * 可以是空
     */
    @TableField(value = "user_id")
    @Schema(description = "userId可以是空")
    private String userId;

    /**
     * 邮件标题
     */
    @TableField(value = "title")
    @Schema(description = "邮件标题")
    private String title;

    /**
     * 发送者邮箱
     */
    @TableField(value = "sender_email")
    @Schema(description = "发送者邮箱")
    private String senderEmail;

    /**
     * 收信者邮箱
     */
    @TableField(value = "recipient_email")
    @Schema(description = "收信者邮箱")
    private String recipientEmail;

    /**
     * Y 已投递 N 未投递
     */
    @TableField(value = "is_delivery")
    @Schema(description = "Y 已投递 N 未投递")
    private String isDelivery;

    /**
     * Y 即刻公开 W 寄达公开 N 不公开
     */
    @TableField(value = "is_public")
    @Schema(description = "Y 即刻公开 W 寄达公开 N 不公开")
    private String isPublic;

    /**
     * 信件内容
     */
    @TableField(value = "content")
    @Schema(description = "信件内容")
    private String content;

    /**
     * 写信时间
     */
    @TableField(value = "writing_email_time")
    @Schema(description = "写信时间")
    private LocalDateTime writingEmailTime;

    /**
     * 投递时间
     */
    @TableField(value = "delivery_time")
    @Schema(description = "投递时间")
    private LocalDateTime deliveryTime;

    /**
     * 点赞数
     */
    @TableField(value = "like_count")
    @Schema(description = "点赞数")
    private Long likeCount;

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
        EmailContentPO other = (EmailContentPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSenderEmail() == null ? other.getSenderEmail() == null : this.getSenderEmail().equals(other.getSenderEmail()))
            && (this.getRecipientEmail() == null ? other.getRecipientEmail() == null : this.getRecipientEmail().equals(other.getRecipientEmail()))
            && (this.getIsDelivery() == null ? other.getIsDelivery() == null : this.getIsDelivery().equals(other.getIsDelivery()))
            && (this.getIsPublic() == null ? other.getIsPublic() == null : this.getIsPublic().equals(other.getIsPublic()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getWritingEmailTime() == null ? other.getWritingEmailTime() == null : this.getWritingEmailTime().equals(other.getWritingEmailTime()))
            && (this.getDeliveryTime() == null ? other.getDeliveryTime() == null : this.getDeliveryTime().equals(other.getDeliveryTime()))
            && (this.getLikeCount() == null ? other.getLikeCount() == null : this.getLikeCount().equals(other.getLikeCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSenderEmail() == null) ? 0 : getSenderEmail().hashCode());
        result = prime * result + ((getRecipientEmail() == null) ? 0 : getRecipientEmail().hashCode());
        result = prime * result + ((getIsDelivery() == null) ? 0 : getIsDelivery().hashCode());
        result = prime * result + ((getIsPublic() == null) ? 0 : getIsPublic().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getWritingEmailTime() == null) ? 0 : getWritingEmailTime().hashCode());
        result = prime * result + ((getDeliveryTime() == null) ? 0 : getDeliveryTime().hashCode());
        result = prime * result + ((getLikeCount() == null) ? 0 : getLikeCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", title=").append(title);
        sb.append(", senderEmail=").append(senderEmail);
        sb.append(", recipientEmail=").append(recipientEmail);
        sb.append(", isDelivery=").append(isDelivery);
        sb.append(", isPublic=").append(isPublic);
        sb.append(", content=").append(content);
        sb.append(", writingEmailTime=").append(writingEmailTime);
        sb.append(", deliveryTime=").append(deliveryTime);
        sb.append(", likeCount=").append(likeCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}