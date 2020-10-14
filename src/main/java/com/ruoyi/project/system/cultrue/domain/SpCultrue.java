package com.ruoyi.project.system.cultrue.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 历史文化对象 sp_cultrue
 * 
 * @author xingmc
 * @date 2020-10-12
 */
public class SpCultrue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文化id */
    private String cultureId;

    /** 文化标题 */
    @Excel(name = "文化标题")
    private String culTitle;

    /** 文化副标题 */
    @Excel(name = "文化副标题")
    private String culFtitle;

    /** 文化内容 */
    @Excel(name = "文化内容")
    private String culContent;

    /** 文化栏目 */
    @Excel(name = "文化栏目")
    private String culColumn;

    /** 头像 */
    @Excel(name = "头像")
    private String headImage;

    public void setCultureId(String cultureId) 
    {
        this.cultureId = cultureId;
    }

    public String getCultureId() 
    {
        return cultureId;
    }
    public void setCulTitle(String culTitle)
    {
        this.culTitle = culTitle;
    }

    public String getCulTitle() 
    {
        return culTitle;
    }
    public void setCulFtitle(String culFtitle) 
    {
        this.culFtitle = culFtitle;
    }

    public String getCulFtitle() 
    {
        return culFtitle;
    }
    public void setCulContent(String culContent) 
    {
        this.culContent = culContent;
    }

    public String getCulContent() 
    {
        return culContent;
    }

    public void setCulColumn(String culColumn)
    {
        this.culColumn = culColumn;
    }

    public String getCulColumn()
    {
        return culColumn;
    }

    public void setHeadImage(String headImage)
    {
        this.headImage = headImage;
    }

    public String getHeadImage()
    {
        return headImage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("cultureId", getCultureId())
                .append("culColumn", getCulColumn())
                .append("culTitle", getCulTitle())
                .append("culFtitle", getCulFtitle())
                .append("culContent", getCulContent())
                .append("createTime", getCreateTime())
                .append("headImage", getHeadImage())
                .toString();
    }
}
