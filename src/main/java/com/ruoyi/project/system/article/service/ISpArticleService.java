package com.ruoyi.project.system.article.service;

import com.ruoyi.project.system.article.domain.SpArticle;
import java.util.List;
import java.util.Map;

/**
 * 文章内容Service接口
 * 
 * @author xingmc
 * @date 2020-09-27
 */
public interface ISpArticleService 
{
    /**
     * 查询文章内容
     * 
     * @param articleId 文章内容ID
     * @return 文章内容
     */
    public SpArticle selectSpArticleById(String articleId);

    /**
     * 查询文章内容列表
     * 
     * @param spArticle 文章内容
     * @return 文章内容集合
     */
    public List<SpArticle> selectSpArticleList(SpArticle spArticle);

    /**
     * 新增文章内容
     * 
     * @param spArticle 文章内容
     * @return 结果
     */
    public int insertSpArticle(SpArticle spArticle);

    /**
     * 修改文章内容
     * 
     * @param spArticle 文章内容
     * @return 结果
     */
    public int updateSpArticle(SpArticle spArticle);

    /**
     * 批量删除文章内容
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSpArticleByIds(String ids);

    /**
     * 删除文章内容信息
     * 
     * @param articleId 文章内容ID
     * @return 结果
     */
    public int deleteSpArticleById(String articleId);

    /**
     * 查询文章内容信息
     * @param spArticle
     * @return
     */
    Map<String, Object> getArticles(SpArticle spArticle);

}
