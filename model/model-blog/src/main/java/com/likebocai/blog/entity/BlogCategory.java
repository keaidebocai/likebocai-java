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
 * @TableName blog_category
 */
@TableName(value ="blog_category")
@Data
@Schema(name = "BlogCategory对象",description = "blog-文章分类表")
public class BlogCategory implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    @Schema(description = "主键")
    private String id;

    /**
     * 分类名
     */
    @TableField(value = "category_name")
    @Schema(description = "分类名")
    private String categoryName;

    /**
     * 分类url
     */
    @TableField(value = "category_url")
    @Schema(description = "分类url")
    private String categoryUrl;

    /**
     * 
     */
    @TableField(value = "category_icon_url")
    @Schema(description = "categoryIconUrl")
    private String categoryIconUrl;

    /**
     * 描述
     */
    @TableField(value = "description")
    @Schema(description = "描述")
    private String description;

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
        BlogCategory other = (BlogCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getCategoryUrl() == null ? other.getCategoryUrl() == null : this.getCategoryUrl().equals(other.getCategoryUrl()))
            && (this.getCategoryIconUrl() == null ? other.getCategoryIconUrl() == null : this.getCategoryIconUrl().equals(other.getCategoryIconUrl()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getCategoryUrl() == null) ? 0 : getCategoryUrl().hashCode());
        result = prime * result + ((getCategoryIconUrl() == null) ? 0 : getCategoryIconUrl().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
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
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryUrl=").append(categoryUrl);
        sb.append(", categoryIconUrl=").append(categoryIconUrl);
        sb.append(", description=").append(description);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}