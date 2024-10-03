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
 * @TableName blog_article
 */
@TableName(value ="blog_article")
@Data
@Schema(name = "BlogArticle对象",description = "blog-文章表")
public class BlogArticle implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    @Schema(description = "主键")
    private String id;

    /**
     * user表的id
     */
    @TableField(value = "user_id")
    @Schema(description = "user表的id")
    private String userId;

    /**
     * 标题
     */
    @TableField(value = "title")
    @Schema(description = "标题")
    private String title;

    /**
     * 美化地址栏所设置的url
     */
    @TableField(value = "url")
    @Schema(description = "美化地址栏所设置的url")
    private String url;

    /**
     * 文章摘要
     */
    @TableField(value = "summary")
    @Schema(description = "文章摘要")
    private String summary;

    /**
     * 文章内容
     */
    @TableField(value = "content")
    @Schema(description = "文章内容")
    private String content;

    /**
     * blog_category分类表id
     */
    @TableField(value = "blog_category_id")
    @Schema(description = "blog_category分类表id")
    private String blogCategoryId;

    /**
     * 缩略图
     */
    @TableField(value = "thumbnail")
    @Schema(description = "缩略图")
    private String thumbnail;

    /**
     * 是否置顶(0:否,1:是)
     */
    @TableField(value = "is_top")
    @Schema(description = "是否置顶(0:否,1:是)")
    private Integer isTop;

    /**
     * 浏览量
     */
    @TableField(value = "view_count")
    @Schema(description = "浏览量")
    private Long viewCount;

    /**
     * 是否评论(0:否,1:是)
     */
    @TableField(value = "is_commont")
    @Schema(description = "是否评论(0:否,1:是)")
    private String isCommont;

    /**
     * 是否发布(0:否,1:是)
     */
    @TableField(value = "status")
    @Schema(description = "是否发布(0:否,1:是)")
    private String status;

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
     * 修改时间
     */
    @TableField(value = "update_time")
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

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
        BlogArticle other = (BlogArticle) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getBlogCategoryId() == null ? other.getBlogCategoryId() == null : this.getBlogCategoryId().equals(other.getBlogCategoryId()))
            && (this.getThumbnail() == null ? other.getThumbnail() == null : this.getThumbnail().equals(other.getThumbnail()))
            && (this.getIsTop() == null ? other.getIsTop() == null : this.getIsTop().equals(other.getIsTop()))
            && (this.getViewCount() == null ? other.getViewCount() == null : this.getViewCount().equals(other.getViewCount()))
            && (this.getIsCommont() == null ? other.getIsCommont() == null : this.getIsCommont().equals(other.getIsCommont()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getBlogCategoryId() == null) ? 0 : getBlogCategoryId().hashCode());
        result = prime * result + ((getThumbnail() == null) ? 0 : getThumbnail().hashCode());
        result = prime * result + ((getIsTop() == null) ? 0 : getIsTop().hashCode());
        result = prime * result + ((getViewCount() == null) ? 0 : getViewCount().hashCode());
        result = prime * result + ((getIsCommont() == null) ? 0 : getIsCommont().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
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
        sb.append(", url=").append(url);
        sb.append(", summary=").append(summary);
        sb.append(", content=").append(content);
        sb.append(", blogCategoryId=").append(blogCategoryId);
        sb.append(", thumbnail=").append(thumbnail);
        sb.append(", isTop=").append(isTop);
        sb.append(", viewCount=").append(viewCount);
        sb.append(", isCommont=").append(isCommont);
        sb.append(", status=").append(status);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}