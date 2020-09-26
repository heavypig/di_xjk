package com.ruoyi.project.system.file.service;

import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.file.domain.SpFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 沙盘文件Service接口
 * 
 * @author xingmc
 * @date 2020-09-26
 */
public interface ISpFileService 
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
     * 批量删除沙盘文件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSpFileByIds(String ids);

    /**
     * 删除沙盘文件信息
     * 
     * @param fileId 沙盘文件ID
     * @return 结果
     */
    public int deleteSpFileById(String fileId);

    Map<String, Object> getSpFileList(SpFile spFile);
}
