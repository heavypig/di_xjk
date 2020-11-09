package com.ruoyi.project.system.spNotice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.UUIDUtils;
import com.ruoyi.project.system.activity.domain.SpActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.spNotice.mapper.SpNoticeMapper;
import com.ruoyi.project.system.spNotice.domain.SpNotice;
import com.ruoyi.project.system.spNotice.service.ISpNoticeService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 新街口公告Service业务层处理
 * 
 * @author xingmc
 * @date 2020-11-09
 */
@Service
public class SpNoticeServiceImpl implements ISpNoticeService 
{
    @Autowired
    private SpNoticeMapper spNoticeMapper;

    /**
     * 查询新街口公告
     * 
     * @param noticeId 新街口公告ID
     * @return 新街口公告
     */
    @Override
    public SpNotice selectSpNoticeById(String noticeId)
    {
        return spNoticeMapper.selectSpNoticeById(noticeId);
    }

    /**
     * 查询新街口公告列表
     * 
     * @param spNotice 新街口公告
     * @return 新街口公告
     */
    @Override
    public List<SpNotice> selectSpNoticeList(SpNotice spNotice)
    {
        return spNoticeMapper.selectSpNoticeList(spNotice);
    }

    /**
     * 新增新街口公告
     * 
     * @param spNotice 新街口公告
     * @return 结果
     */
    @Override
    public int insertSpNotice(SpNotice spNotice)
    {
        spNotice.setNoticeId(UUIDUtils.getUUID());
        spNotice.setCreateTime(DateUtils.getNowDate());
        return spNoticeMapper.insertSpNotice(spNotice);
    }

    /**
     * 修改新街口公告
     * 
     * @param spNotice 新街口公告
     * @return 结果
     */
    @Override
    public int updateSpNotice(SpNotice spNotice)
    {
        return spNoticeMapper.updateSpNotice(spNotice);
    }

    /**
     * 删除新街口公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSpNoticeByIds(String ids)
    {
        return spNoticeMapper.deleteSpNoticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除新街口公告信息
     * 
     * @param noticeId 新街口公告ID
     * @return 结果
     */
    @Override
    public int deleteSpNoticeById(String noticeId)
    {
        return spNoticeMapper.deleteSpNoticeById(noticeId);
    }

    /**
     * 查询新街口公告列表
     * @param spNotice
     * @return
     */
    @Override
    public Map<String, Object> getSpNoticeList(SpNotice spNotice) {
        List<SpNotice> noticeList = spNoticeMapper.selectSpNoticeList(spNotice);
        Map<String, Object> map = new HashMap<>();
        map.put("noticeList",noticeList);
        map.put("code","200");
        return map;
    }
}
