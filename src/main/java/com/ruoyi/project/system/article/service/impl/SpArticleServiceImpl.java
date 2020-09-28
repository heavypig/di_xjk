package com.ruoyi.project.system.article.service.impl;

import java.util.*;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.UUIDUtils;
import com.ruoyi.project.system.dict.domain.DictData;
import com.ruoyi.project.system.dict.service.IDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.article.mapper.SpArticleMapper;
import com.ruoyi.project.system.article.domain.SpArticle;
import com.ruoyi.project.system.article.service.ISpArticleService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 文章内容Service业务层处理
 * 
 * @author xingmc
 * @date 2020-09-27
 */
@Service
public class SpArticleServiceImpl implements ISpArticleService 
{
    @Autowired
    private SpArticleMapper spArticleMapper;
    @Autowired
    private IDictDataService dictDataService;

    /**
     * 查询文章内容
     * 
     * @param articleId 文章内容ID
     * @return 文章内容
     */
    @Override
    public SpArticle selectSpArticleById(String articleId)
    {
        return spArticleMapper.selectSpArticleById(articleId);
    }

    /**
     * 查询文章内容列表
     * 
     * @param spArticle 文章内容
     * @return 文章内容
     */
    @Override
    public List<SpArticle> selectSpArticleList(SpArticle spArticle)
    {
        return spArticleMapper.selectSpArticleList(spArticle);
    }

    /**
     * 新增文章内容
     * 
     * @param spArticle 文章内容
     * @return 结果
     */
    @Override
    public int insertSpArticle(SpArticle spArticle)
    {
        spArticle.setArticleId(UUIDUtils.getUUID());
        spArticle.setCreateTime(new Date());
        return spArticleMapper.insertSpArticle(spArticle);
    }

    /**
     * 修改文章内容
     * 
     * @param spArticle 文章内容
     * @return 结果
     */
    @Override
    public int updateSpArticle(SpArticle spArticle)
    {
        return spArticleMapper.updateSpArticle(spArticle);
    }

    /**
     * 删除文章内容对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSpArticleByIds(String ids)
    {
        return spArticleMapper.deleteSpArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章内容信息
     * 
     * @param articleId 文章内容ID
     * @return 结果
     */
    @Override
    public int deleteSpArticleById(String articleId)
    {
        return spArticleMapper.deleteSpArticleById(articleId);
    }

    @Override
    public Map<String, Object> getArticles(SpArticle spArticle) {
        DictData dictData = new DictData();
        dictData.setDictType("organization");
        List<DictData> dictlist = dictDataService.selectDictDataList(dictData);
        List<SpArticle> spArticles = spArticleMapper.selectSpArticleList(spArticle);
        Map<String, Object> map = new HashMap<>();
        List<DictData> sizeList = new ArrayList<>();
        if (spArticles.size() > 0) {
            for (int i = 0; i < dictlist.size(); i++ ){
                List<SpArticle> sizelist = new ArrayList<>();
                DictData sizedata = new DictData();
                for (int j = 0; j < spArticles.size(); j++ ){
                    if (dictlist.get(i).getDictValue().equals(spArticles.get(j).getColumnName())){
                        sizelist.add(spArticles.get(j));
                    }
                }
                if(sizelist.size() > 0 ){
                    sizedata.setDictLabel(dictlist.get(i).getDictLabel());
                    sizedata.setDictValue(dictlist.get(i).getDictValue());
                    sizedata.setSpArticleList(sizelist);
                    sizeList.add(sizedata);
                }
            }
        }

        map.put("sizelist",sizeList);
        map.put("code","200");
        return map;
    }

}
