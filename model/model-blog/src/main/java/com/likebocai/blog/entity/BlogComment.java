package com.likebocai.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @TableName blog_comment
 */
@TableName(value ="blog_comment")
@Data
@Schema(name = "BlogComment对象",description = "blog-评论类表")
public class BlogComment implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    @Schema(description = "主键")
    private String id;

    /**
     * 0:文章,1友链,2about
     */
    @TableField(value = "type")
    @Schema(description = "0:文章,1友链,2about")
    private String type;

    /**
     * blog_article表id
     */
    @TableField(value = "blog_article_id")
    @Schema(description = "blog_article表id")
    private String blogArticleId;

    /**
     * 父评论(0为根评论)
     */
    @TableField(value = "parent_id")
    @Schema(description = "父评论(0为根评论)")
    private String parentId;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    @Schema(description = "评论内容")
    private String content;

    /**
     * 这是谁发出的评论
     */
    @TableField(value = "to_comment_user_id")
    @Schema(description = "这是谁发出的评论")
    private String toCommentUserId;

    /**
     * 点赞
     */
    @TableField(value = "comment_like_count")
    @Schema(description = "点赞")
    private Integer commentLikeCount;

    /**
     * 给谁回复的(不写就是层主)
     */
    @TableField(value = "to_comment_id")
    @Schema(description = "给谁回复的(不写就是层主)")
    private String toCommentId;

    /**
     * 逻辑删除
     */
    @TableField(value = "is_deleted")
    @Schema(description = "逻辑删除")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    /**
     * 评论的地点
     */
    @TableField(value = "address")
    @Schema(description = "评论的地点")
    private String address;

    /**
     * 回复评论的id
     */
    @TableField(value = "reply_comment_id")
    @Schema(description = "回复评论的id")
    private String replyCommentId;

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
        BlogComment other = (BlogComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getBlogArticleId() == null ? other.getBlogArticleId() == null : this.getBlogArticleId().equals(other.getBlogArticleId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getToCommentUserId() == null ? other.getToCommentUserId() == null : this.getToCommentUserId().equals(other.getToCommentUserId()))
            && (this.getCommentLikeCount() == null ? other.getCommentLikeCount() == null : this.getCommentLikeCount().equals(other.getCommentLikeCount()))
            && (this.getToCommentId() == null ? other.getToCommentId() == null : this.getToCommentId().equals(other.getToCommentId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getReplyCommentId() == null ? other.getReplyCommentId() == null : this.getReplyCommentId().equals(other.getReplyCommentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getBlogArticleId() == null) ? 0 : getBlogArticleId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getToCommentUserId() == null) ? 0 : getToCommentUserId().hashCode());
        result = prime * result + ((getCommentLikeCount() == null) ? 0 : getCommentLikeCount().hashCode());
        result = prime * result + ((getToCommentId() == null) ? 0 : getToCommentId().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getReplyCommentId() == null) ? 0 : getReplyCommentId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", blogArticleId=").append(blogArticleId);
        sb.append(", parentId=").append(parentId);
        sb.append(", content=").append(content);
        sb.append(", toCommentUserId=").append(toCommentUserId);
        sb.append(", commentLikeCount=").append(commentLikeCount);
        sb.append(", toCommentId=").append(toCommentId);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", address=").append(address);
        sb.append(", replyCommentId=").append(replyCommentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}