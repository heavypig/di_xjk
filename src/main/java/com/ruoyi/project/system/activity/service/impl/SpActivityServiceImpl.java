package com.ruoyi.project.system.activity.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.UUIDUtils;
import com.ruoyi.project.system.cultrue.domain.SpCultrue;
import com.ruoyi.project.system.dict.domain.DictData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.activity.mapper.SpActivityMapper;
import com.ruoyi.project.system.activity.domain.SpActivity;
import com.ruoyi.project.system.activity.service.ISpActivityService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 活动报名Service业务层处理
 * 
 * @author xingmc
 * @date 2020-11-09
 */
@Service
public class SpActivityServiceImpl implements ISpActivityService 
{
    @Autowired
    private SpActivityMapper spActivityMapper;

    /**
     * 查询活动报名
     * 
     * @param activityId 活动报名ID
     * @return 活动报名
     */
    @Override
    public SpActivity selectSpActivityById(String activityId)
    {
        return spActivityMapper.selectSpActivityById(activityId);
    }

    /**
     * 查询活动报名列表
     * 
     * @param spActivity 活动报名
     * @return 活动报名
     */
    @Override
    public List<SpActivity> selectSpActivityList(SpActivity spActivity)
    {
        return spActivityMapper.selectSpActivityList(spActivity);
    }

    /**
     * 新增活动报名
     * 
     * @param spActivity 活动报名
     * @return 结果
     */
    @Override
    public int insertSpActivity(SpActivity spActivity)
    {
        spActivity.setActivityId(UUIDUtils.getUUID());
        spActivity.setCreateTime(DateUtils.getNowDate());
        return spActivityMapper.insertSpActivity(spActivity);
    }

    /**
     * 修改活动报名
     * 
     * @param spActivity 活动报名
     * @return 结果
     */
    @Override
    public int updateSpActivity(SpActivity spActivity)
    {
        return spActivityMapper.updateSpActivity(spActivity);
    }

    /**
     * 删除活动报名对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSpActivityByIds(String ids)
    {
        return spActivityMapper.deleteSpActivityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除活动报名信息
     * 
     * @param activityId 活动报名ID
     * @return 结果
     */
    @Override
    public int deleteSpActivityById(String activityId)
    {
        return spActivityMapper.deleteSpActivityById(activityId);
    }

    /**
     * 查询活动报名列表
     * @param spActivity
     * @return
     */
    @Override
    public Map<String, Object> getSpActivityList(SpActivity spActivity) {
        List<SpActivity> activityList = spActivityMapper.selectSpActivityList(spActivity);
        Map<String, Object> map = new HashMap<>();
        map.put("activityList",activityList);
        map.put("code","200");
        return map;
    }
}
