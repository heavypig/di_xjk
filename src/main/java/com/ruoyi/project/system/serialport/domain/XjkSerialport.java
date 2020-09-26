package com.ruoyi.project.system.serialport.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 串口对象 xjk_serialport
 * 
 * @author duanxm
 * @date 2020-09-26
 */
public class XjkSerialport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 串口表id */
    private String serialportId;

    /** 串口 */
    @Excel(name = "串口")
    private String serialport;

    /** 视频关联id */
    @Excel(name = "视频关联id")
    private String videoId;

    /** 视频时长 */
    @Excel(name = "视频时长")
    private String videoTime;

    /** 视频节点 */
    @Excel(name = "视频节点")
    private String videoNode;

    /** 视频节点 */
    @Excel(name = "视频节点")
    private Date createtime;

    public void setSerialportId(String serialportId) 
    {
        this.serialportId = serialportId;
    }

    public String getSerialportId() 
    {
        return serialportId;
    }
    public void setSerialport(String serialport) 
    {
        this.serialport = serialport;
    }

    public String getSerialport() 
    {
        return serialport;
    }
    public void setVideoId(String videoId) 
    {
        this.videoId = videoId;
    }

    public String getVideoId() 
    {
        return videoId;
    }
    public void setVideoTime(String videoTime) 
    {
        this.videoTime = videoTime;
    }

    public String getVideoTime() 
    {
        return videoTime;
    }
    public void setVideoNode(String videoNode) 
    {
        this.videoNode = videoNode;
    }

    public String getVideoNode() 
    {
        return videoNode;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("serialportId", getSerialportId())
            .append("serialport", getSerialport())
            .append("videoId", getVideoId())
            .append("videoTime", getVideoTime())
            .append("videoNode", getVideoNode())
            .append("createtime", getCreatetime())
            .toString();
    }
}
