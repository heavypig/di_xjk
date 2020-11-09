package com.ruoyi.project.system.spNotice.service;

import com.ruoyi.project.system.spNotice.domain.SpNotice;
import java.util.List;
import java.util.Map;

/**
 * 新街口公告Service接口
 * 
 * @author xingmc
 * @date 2020-11-09
 */
public interface ISpNoticeService 
{
    /**
     * 查询新街口公告
     * 
     * @param noticeId 新街口公告ID
     * @return 新街口公告
     */
    public SpNotice selectSpNoticeById(String noticeId);

    /**
     * 查询新街口公告列表
     * 
     * @param spNotice 新街口公告
     * @return 新街口公告集合
     */
    public List<SpNotice> selectSpNoticeList(SpNotice spNotice);

    /**
     * 新增新街口公告
     * 
     * @param spNotice 新街口公告
     * @return 结果
     */
    public int insertSpNotice(SpNotice spNotice);

    /**
     * 修改新街口公告
     * 
     * @param spNotice 新街口公告
     * @return 结果
     */
    public int updateSpNotice(SpNotice spNotice);

    /**
     * 批量删除新街口公告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSpNoticeByIds(String ids);

    /**
     * 删除新街口公告信息
     * 
     * @param noticeId 新街口公告ID
     * @return 结果
     */
    public int deleteSpNoticeById(String noticeId);

    /**
     * 查询新街口公告列表
     * @param spNotice
     * @return
     */
    Map<String, Object> getSpNoticeList(SpNotice spNotice);
}
