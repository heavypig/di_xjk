package com.ruoyi.project.system.articles.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.List;

/**
 * 文章内容对象 sp_article
 * 
 * @author duanxm
 * @date 2020-09-26
 */
public class SpArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章id */
    private String articleId;

    /** 栏目名称 */
    @Excel(name = "栏目名称")
    private String columnes;

    /** 文章名称 */
    @Excel(name = "文章名称")
    private String title;

    /** 头图 */
    @Excel(name = "头图")
    private String banner;

    /** 副标题 */
    @Excel(name = "副标题")
    private String subtitle;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getColumnes() {
        return columnes;
    }

    public void setColumnes(String columnes) {
        this.columnes = columnes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("articleId", getArticleId())
            .append("columnes", getColumnes())
            .append("title", getTitle())
            .append("banner", getBanner())
            .append("subtitle", getSubtitle())
            .append("createTime", getCreateTime())
            .append("content", getContent())
            .toString();
    }
}
