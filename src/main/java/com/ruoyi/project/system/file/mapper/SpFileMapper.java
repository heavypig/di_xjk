package com.ruoyi.project.system.file.mapper;

import com.ruoyi.project.system.file.domain.SpFile;
import java.util.List;
import java.util.Map;

/**
 * 沙盘文件Mapper接口
 * 
 * @author xingmc
 * @date 2020-09-26
 */
public interface SpFileMapper 
{
    /**
     * 查询沙盘文件
     * 
     * @param fileId 沙盘文件ID
     * @return 沙盘文件
     */
    public SpFile selectSpFileById(String fileId);

    /**
     * 查询沙盘文件列表
     * 
     * @param spFile 沙盘文件
     * @return 沙盘文件集合
     */
    public List<SpFile> selectSpFileList(SpFile spFile);

    /**
     * 新增沙盘文件
     * 
     * @param spFile 沙盘文件
     * @return 结果
     */
    public int insertSpFile(SpFile spFile);

    /**
     * 修改沙盘文件
     * 
     * @param spFile 沙盘文件
     * @return 结果
     */
    public int updateSpFile(SpFile spFile);

    /**
     * 删除沙盘文件
     * 
     * @param fileId 沙盘文件ID
     * @return 结果
     */
    public int deleteSpFileById(String fileId);

    /**
     * 批量删除沙盘文件
     * 
     * @param fileIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSpFileByIds(String[] fileIds);

}
