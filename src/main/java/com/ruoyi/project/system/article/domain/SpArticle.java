package com.ruoyi.project.system.article.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 文章内容对象 sp_article
 * 
 * @author xingmc
 * @date 2020-09-27
 */
public class SpArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章id */
    private String articleId;

    /** 栏目名称 */
    @Excel(name = "栏目名称")
    private String columnName;

    /** 文章名称 */
    @Excel(name = "文章名称")
    private String articleName;

    /** 头图 */
    @Excel(name = "头图")
    private String headImage;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String fileAddress;

    /** 副标题 */
    @Excel(name = "副标题")
    private String viceTitle;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    public void setArticleId(String articleId) 
    {
        this.articleId = articleId;
    }

    public String getArticleId() 
    {
        return articleId;
    }
    public void setColumnName(String columnName) 
    {
        this.columnName = columnName;
    }

    public String getColumnName() 
    {
        return columnName;
    }
    public void setArticleName(String articleName) 
    {
        this.articleName = articleName;
    }

    public String getArticleName() 
    {
        return articleName;
    }
    public void setHeadImage(String headImage) 
    {
        this.headImage = headImage;
    }

    public String getHeadImage() 
    {
        return headImage;
    }
    public void setFileAddress(String fileAddress) 
    {
        this.fileAddress = fileAddress;
    }

    public String getFileAddress() 
    {
        return fileAddress;
    }
    public void setViceTitle(String viceTitle) 
    {
        this.viceTitle = viceTitle;
    }

    public String getViceTitle() 
    {
        return viceTitle;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("articleId", getArticleId())
            .append("columnName", getColumnName())
            .append("articleName", getArticleName())
            .append("headImage", getHeadImage())
            .append("fileAddress", getFileAddress())
            .append("viceTitle", getViceTitle())
            .append("createTime", getCreateTime())
            .append("content", getContent())
            .toString();
    }
}
