package com.ruoyi.project.system.article.mapper;

import com.ruoyi.project.system.article.domain.Article;
import java.util.List;

/**
 * 文章添加Mapper接口
 * 
 * @author sunym
 * @date 2020-09-12
 */
public interface ArticleMapper 
{
    /**
     * 查询文章添加
     * 
     * @param id 文章添加ID
     * @return 文章添加
     */
    public Article selectArticleById(String id);

    /**
     * 查询文章添加列表
     * 
     * @param article 文章添加
     * @return 文章添加集合
     */
    public List<Article> selectArticleList(Article article);

    /**
     * 新增文章添加
     * 
     * @param article 文章添加
     * @return 结果
     */
    public int insertArticle(Article article);

    /**
     * 修改文章添加
     * 
     * @param article 文章添加
     * @return 结果
     */
    public int updateArticle(Article article);

    /**
     * 删除文章添加
     * 
     * @param id 文章添加ID
     * @return 结果
     */
    public int deleteArticleById(String id);

    /**
     * 批量删除文章添加
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteArticleByIds(String[] ids);
}
