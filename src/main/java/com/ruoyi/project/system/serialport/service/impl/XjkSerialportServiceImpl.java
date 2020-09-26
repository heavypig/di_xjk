package com.ruoyi.project.system.serialport.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.serialport.mapper.XjkSerialportMapper;
import com.ruoyi.project.system.serialport.domain.XjkSerialport;
import com.ruoyi.project.system.serialport.service.IXjkSerialportService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 串口Service业务层处理
 * 
 * @author duanxm
 * @date 2020-09-26
 */
@Service
public class XjkSerialportServiceImpl implements IXjkSerialportService 
{
    @Autowired
    private XjkSerialportMapper xjkSerialportMapper;

    /**
     * 查询串口
     * 
     * @param serialportId 串口ID
     * @return 串口
     */
    @Override
    public XjkSerialport selectXjkSerialportById(String serialportId)
    {
        return xjkSerialportMapper.selectXjkSerialportById(serialportId);
    }

    /**
     * 查询串口列表
     * 
     * @param xjkSerialport 串口
     * @return 串口
     */
    @Override
    public List<XjkSerialport> selectXjkSerialportList(XjkSerialport xjkSerialport)
    {
        return xjkSerialportMapper.selectXjkSerialportList(xjkSerialport);
    }

    /**
     * 新增串口
     * 
     * @param xjkSerialport 串口
     * @return 结果
     */
    @Override
    public int insertXjkSerialport(XjkSerialport xjkSerialport)
    {
        return xjkSerialportMapper.insertXjkSerialport(xjkSerialport);
    }

    /**
     * 修改串口
     * 
     * @param xjkSerialport 串口
     * @return 结果
     */
    @Override
    public int updateXjkSerialport(XjkSerialport xjkSerialport)
    {
        return xjkSerialportMapper.updateXjkSerialport(xjkSerialport);
    }

    /**
     * 删除串口对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXjkSerialportByIds(String ids)
    {
        return xjkSerialportMapper.deleteXjkSerialportByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除串口信息
     * 
     * @param serialportId 串口ID
     * @return 结果
     */
    @Override
    public int deleteXjkSerialportById(String serialportId)
    {
        return xjkSerialportMapper.deleteXjkSerialportById(serialportId);
    }
}
