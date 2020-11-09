package com.ruoyi.project.system.activity.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 活动报名对象 sp_activity
 * 
 * @author xingmc
 * @date 2020-11-09
 */
public class SpActivity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动id */
    private String activityId;

    /** 活动标题 */
    @Excel(name = "活动标题")
    private String actTitle;

    /** 活动副标题 */
    @Excel(name = "活动副标题")
    private String actFtitle;

    /** 活动内容 */
    @Excel(name = "活动内容")
    private String actContent;

    /** 头像 */
    @Excel(name = "头像")
    private String headImage;

    public void setActivityId(String activityId) 
    {
        this.activityId = activityId;
    }

    public String getActivityId() 
    {
        return activityId;
    }
    public void setActTitle(String actTitle) 
    {
        this.actTitle = actTitle;
    }

    public String getActTitle() 
    {
        return actTitle;
    }
    public void setActFtitle(String actFtitle) 
    {
        this.actFtitle = actFtitle;
    }

    public String getActFtitle() 
    {
        return actFtitle;
    }
    public void setActContent(String actContent) 
    {
        this.actContent = actContent;
    }

    public String getActContent() 
    {
        return actContent;
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
            .append("activityId", getActivityId())
            .append("actTitle", getActTitle())
            .append("actFtitle", getActFtitle())
            .append("actContent", getActContent())
            .append("createTime", getCreateTime())
            .append("headImage", getHeadImage())
            .toString();
    }
}
