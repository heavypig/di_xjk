package com.ruoyi.project.system.file.service.impl;

import java.util.*;

import com.ruoyi.common.utils.UUIDUtils;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.dept.mapper.DeptMapper;
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

    @Autowired
    private DeptMapper deptMapper;

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

    @Override
    public Map<String, Object> getSpFileList(SpFile spFile) {
        List<Dept> menuList = new ArrayList<>();
        List<Dept> depts = deptMapper.getDeptList(new Dept());
        Map<String, Object> map = new HashMap<>();
        if (depts.size() > 0) {
            List<SpFile> spFiles = spFileMapper.selectSpFileList(spFile);
            for (int i = 0; i < depts.size(); i++ ){
                Dept dept = new Dept();
                List<SpFile> file = new ArrayList<>();
                for (int j = 0; j < spFiles.size(); j++ ){
                    if (spFiles.get(j).getDeptId().equals(depts.get(i).getDeptId().toString())){
                        file.add(spFiles.get(j));
                    }
                }
                dept.setDeptId(depts.get(i).getDeptId());
                dept.setDeptName(depts.get(i).getDeptName());
                dept.setSpFile(file);
                menuList.add(dept);
            }
        }
        map.put("code","200");
        map.put("menuList",menuList);
        return map;
    }
}
