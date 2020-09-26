package com.ruoyi.project.system.file.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.file.mapper.SpFileMapper;
import com.ruoyi.project.system.file.domain.SpFile;
import com.ruoyi.project.system.file.service.ISpFileService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 沙盘文件Service业务层处理
 * 
 * @author xingmc
 * @date 2020-09-26
 */
@Service
public class SpFileServiceImpl implements ISpFileService 
{
    @Autowired
    private SpFileMapper spFileMapper;

    /**
     * 查询沙盘文件
     * 
     * @param fileId 沙盘文件ID
     * @return 沙盘文件
     */
    @Override
    public SpFile selectSpFileById(String fileId)
    {
        return spFileMapper.selectSpFileById(fileId);
    }

    /**
     * 查询沙盘文件列表
     * 
     * @param spFile 沙盘文件
     * @return 沙盘文件
     */
    @Override
    public List<SpFile> selectSpFileList(SpFile spFile)
    {
        return spFileMapper.selectSpFileList(spFile);
    }

    /**
     * 新增沙盘文件
     * 
     * @param spFile 沙盘文件
     * @return 结果
     */
    @Override
    public int insertSpFile(SpFile spFile)
    {
        spFile.setFileId(UUIDUtils.getUUID());
        spFile.setOperaDate(new Date());
        return spFileMapper.insertSpFile(spFile);
    }

    /**
     * 修改沙盘文件
     * 
     * @param spFile 沙盘文件
     * @return 结果
     */
    @Override
    public int updateSpFile(SpFile spFile)
    {
        return spFileMapper.updateSpFile(spFile);
    }

    /**
     * 删除沙盘文件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSpFileByIds(String ids)
    {
        return spFileMapper.deleteSpFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除沙盘文件信息
     * 
     * @param fileId 沙盘文件ID
     * @return 结果
     */
    @Override
    public int deleteSpFileById(String fileId)
    {
        return spFileMapper.deleteSpFileById(fileId);
    }
}
