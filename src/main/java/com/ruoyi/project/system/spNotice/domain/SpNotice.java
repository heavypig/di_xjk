package com.ruoyi.project.system.spNotice.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 新街口公告对象 sp_notice
 * 
 * @author xingmc
 * @date 2020-11-09
 */
public class SpNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告id */
    private String noticeId;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String noTitle;

    /** 公告副标题 */
    @Excel(name = "公告副标题")
    private String noFtitle;

    /** 公告内容 */
    @Excel(name = "公告内容")
    private String noContent;

    /** 头像 */
    @Excel(name = "头像")
    private String headImage;

    public void setNoticeId(String noticeId) 
    {
        this.noticeId = noticeId;
    }

    public String getNoticeId() 
    {
        return noticeId;
    }
    public void setNoTitle(String noTitle) 
    {
        this.noTitle = noTitle;
    }

    public String getNoTitle() 
    {
        return noTitle;
    }
    public void setNoFtitle(String noFtitle) 
    {
        this.noFtitle = noFtitle;
    }

    public String getNoFtitle() 
    {
        return noFtitle;
    }
    public void setNoContent(String noContent) 
    {
        this.noContent = noContent;
    }

    public String getNoContent() 
    {
        return noContent;
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
            .append("noticeId", getNoticeId())
            .append("noTitle", getNoTitle())
            .append("noFtitle", getNoFtitle())
            .append("noContent", getNoContent())
            .append("createTime", getCreateTime())
            .append("headImage", getHeadImage())
            .toString();
    }
}
