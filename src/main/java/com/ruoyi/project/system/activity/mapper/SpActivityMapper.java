package com.ruoyi.project.system.activity.mapper;

import com.ruoyi.project.system.activity.domain.SpActivity;
import java.util.List;

/**
 * 活动报名Mapper接口
 * 
 * @author xingmc
 * @date 2020-11-09
 */
public interface SpActivityMapper 
{
    /**
     * 查询活动报名
     * 
     * @param activityId 活动报名ID
     * @return 活动报名
     */
    public SpActivity selectSpActivityById(String activityId);

    /**
     * 查询活动报名列表
     * 
     * @param spActivity 活动报名
     * @return 活动报名集合
     */
    public List<SpActivity> selectSpActivityList(SpActivity spActivity);

    /**
     * 新增活动报名
     * 
     * @param spActivity 活动报名
     * @return 结果
     */
    public int insertSpActivity(SpActivity spActivity);

    /**
     * 修改活动报名
     * 
     * @param spActivity 活动报名
     * @return 结果
     */
    public int updateSpActivity(SpActivity spActivity);

    /**
     * 删除活动报名
     * 
     * @param activityId 活动报名ID
     * @return 结果
     */
    public int deleteSpActivityById(String activityId);

    /**
     * 批量删除活动报名
     * 
     * @param activityIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSpActivityByIds(String[] activityIds);
}
