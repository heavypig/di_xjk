package com.ruoyi.project.system.file.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 沙盘文件对象 sp_file
 * 
 * @author xingmc
 * @date 2020-09-26
 */
public class SpFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件id */
    private String fileId;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String fileAddress;

    /** 街区id */
    @Excel(name = "街区id")
    private Date operaDate;

    /** 街区id */
    @Excel(name = "街区id")
    private String deptId;

    //关联字段
    /** 街区名称 */
    private String deptName;

    public void setFileId(String fileId) 
    {
        this.fileId = fileId;
    }

    public String getFileId() 
    {
        return fileId;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFileAddress(String fileAddress)
    {
        this.fileAddress = fileAddress;
    }

    public String getFileAddress()
    {
        return fileAddress;
    }

    public Date getOperaDate() {
        return operaDate;
    }

    public void setOperaDate(Date operaDate) {
        this.operaDate = operaDate;
    }

    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }

    public String getDeptId() 
    {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fileId", getFileId())
            .append("fileName", getFileName())
            .append("fileAddress", getFileAddress())
            .append("operaDate", getOperaDate())
            .append("deptId", getDeptId())
            .toString();
    }
}
