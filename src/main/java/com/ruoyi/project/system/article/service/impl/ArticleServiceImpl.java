package com.ruoyi.project.system.article.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.article.mapper.ArticleMapper;
import com.ruoyi.project.system.article.domain.Article;
import com.ruoyi.project.system.article.service.IArticleService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 文章添加Service业务层处理
 * 
 * @author sunym
 * @date 2020-09-12
 */
@Service
public class ArticleServiceImpl implements IArticleService 
{
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询文章添加
     * 
     * @param id 文章添加ID
     * @return 文章添加
     */
    @Override
    public Article selectArticleById(String id)
    {
        return articleMapper.selectArticleById(id);
    }

    /**
     * 查询文章添加列表
     * 
     * @param article 文章添加
     * @return 文章添加
     */
    @Override
    public List<Article> selectArticleList(Article article)
    {
        return articleMapper.selectArticleList(article);
    }

    /**
     * 新增文章添加
     * 
     * @param article 文章添加
     * @return 结果
     */
    @Override
    public int insertArticle(Article article)
    {
        return articleMapper.insertArticle(article);
    }

    /**
     * 修改文章添加
     * 
     * @param article 文章添加
     * @return 结果
     */
    @Override
    public int updateArticle(Article article)
    {
        return articleMapper.updateArticle(article);
    }

    /**
     * 删除文章添加对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteArticleByIds(String ids)
    {
        return articleMapper.deleteArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章添加信息
     * 
     * @param id 文章添加ID
     * @return 结果
     */
    @Override
    public int deleteArticleById(String id)
    {
        return articleMapper.deleteArticleById(id);
    }

    /*@Override
    public List<Article> selectMofaqaong(Article article) {
        List<Article> articles = articleMapper.selectArticleList(article);

        for (Article ar : articles) {
            if(!"".equals(ar.getXaxis())&&null != ar.getXaxis()){
                for (Article ars : articles) {
                    if(ar.getXaxis().equals(ars.getXaxis())&&ar.getYaxis().equals(ars.getYaxis())&&!ars.getId().equals(ar.getId())){
                        ArrayList<Article> list = new ArrayList<>();
                        Article article1 = new Article();
                        article1.setColumnName(ars.getColumnName());
                        article1.setVdioUrl(ars.getVdioUrl());
                        article1.setImagesUrl(ar.getVdioUrl());
                        article1.setContent(ars.getContent());
                        article1.setTitle(ars.getTitle());
                        article1.setXaxis(ars.getXaxis());
                        article1.setYaxis(ars.getYaxis());

                    }
                }
            }
        }

        return list;
    }*/
}
