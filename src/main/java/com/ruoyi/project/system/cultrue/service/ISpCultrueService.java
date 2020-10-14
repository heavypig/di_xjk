package com.ruoyi.project.system.cultrue.service;

import com.ruoyi.project.system.cultrue.domain.SpCultrue;
import java.util.List;
import java.util.Map;

/**
 * 历史文化Service接口
 * 
 * @author xingmc
 * @date 2020-10-12
 */
public interface ISpCultrueService 
{
    /**
     * 查询历史文化
     * 
     * @param cultureId 历史文化ID
     * @return 历史文化
     */
    public SpCultrue selectSpCultrueById(String cultureId);

    /**
     * 查询历史文化列表
     * 
     * @param spCultrue 历史文化
     * @return 历史文化集合
     */
    public List<SpCultrue> selectSpCultrueList(SpCultrue spCultrue);

    /**
     * 新增历史文化
     * 
     * @param spCultrue 历史文化
     * @return 结果
     */
    public int insertSpCultrue(SpCultrue spCultrue);

    /**
     * 修改历史文化
     * 
     * @param spCultrue 历史文化
     * @return 结果
     */
    public int updateSpCultrue(SpCultrue spCultrue);

    /**
     * 批量删除历史文化
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSpCultrueByIds(String ids);

    /**
     * 删除历史文化信息
     * 
     * @param cultureId 历史文化ID
     * @return 结果
     */
    public int deleteSpCultrueById(String cultureId);

    /**
     * 查询历史文化列表
     * @param spCultrue
     * @return
     */
    Map<String, Object> getSpCultrueList(SpCultrue spCultrue);
}
