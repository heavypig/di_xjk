package com.ruoyi.project.system.article.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 文章添加对象 xjk_exhibition
 * 
 * @author sunym
 * @date 2020-09-12
 */
public class Article extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章id */
    private String id;

    /** 栏目id */
    @Excel(name = "栏目id")
    private Long columnId;

    /** 栏目id */
    @Excel(name = "栏目名称")
    private String columnName;

    /** 视频方向 */
    @Excel(name = "视频方向")
    private Long direction;

    /** 视频方向 */
    @Excel(name = "视频方向")
    private String directionName;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** 视频路径 */
    @Excel(name = "视频路径")
    private String vdioUrl;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String imagesUrl;

    private String xaxis;

    private String yaxis;

    private Date createTime;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Long getDirection() {
        return direction;
    }

    public void setDirection(Long direction) {
        this.direction = direction;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVdioUrl() {
        return vdioUrl;
    }

    public void setVdioUrl(String vdioUrl) {
        this.vdioUrl = vdioUrl;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getXaxis() {
        return xaxis;
    }

    public void setXaxis(String xaxis) {
        this.xaxis = xaxis;
    }

    public String getYaxis() {
        return yaxis;
    }

    public void setYaxis(String yaxis) {
        this.yaxis = yaxis;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("columnId", getColumnId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("vdioUrl", getVdioUrl())
            .append("imagesUrl", getImagesUrl())
            .toString();
    }
}
