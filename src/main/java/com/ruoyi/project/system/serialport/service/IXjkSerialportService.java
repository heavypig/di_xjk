package com.ruoyi.project.system.serialport.service;

import com.ruoyi.project.system.serialport.domain.XjkSerialport;
import java.util.List;

/**
 * 串口Service接口
 * 
 * @author duanxm
 * @date 2020-09-26
 */
public interface IXjkSerialportService 
{
    /**
     * 查询串口
     * 
     * @param serialportId 串口ID
     * @return 串口
     */
    public XjkSerialport selectXjkSerialportById(String serialportId);

    /**
     * 查询串口列表
     * 
     * @param xjkSerialport 串口
     * @return 串口集合
     */
    public List<XjkSerialport> selectXjkSerialportList(XjkSerialport xjkSerialport);

    /**
     * 新增串口
     * 
     * @param xjkSerialport 串口
     * @return 结果
     */
    public int insertXjkSerialport(XjkSerialport xjkSerialport);

    /**
     * 修改串口
     * 
     * @param xjkSerialport 串口
     * @return 结果
     */
    public int updateXjkSerialport(XjkSerialport xjkSerialport);

    /**
     * 批量删除串口
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXjkSerialportByIds(String ids);

    /**
     * 删除串口信息
     * 
     * @param serialportId 串口ID
     * @return 结果
     */
    public int deleteXjkSerialportById(String serialportId);
}
