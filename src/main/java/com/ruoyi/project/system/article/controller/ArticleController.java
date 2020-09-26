package com.ruoyi.project.system.article.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.UUIDUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.config.ServerConfig;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.article.domain.Article;
import com.ruoyi.project.system.article.service.IArticleService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文章添加Controller
 * 
 * @author duanduan
 * @date 2020-09-12
 */
@Controller
@RequestMapping("/system/article")
public class ArticleController extends BaseController
{
    private String prefix = "system/article";

    @Autowired
    private IArticleService articleService;
    @Autowired
    private ServerConfig serverConfig;

    @RequiresPermissions("system:article:view")
    @GetMapping()
    public String article()
    {
        return prefix + "/article";
    }

    /**
     * 查询文章添加列表
     */
    @RequiresPermissions("system:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Article article)
    {
        startPage();
        List<Article> list = articleService.selectArticleList(article);
        return getDataTable(list);
    }

    /**
     * 导出文章添加列表
     */
    @RequiresPermissions("system:article:export")
    @Log(title = "文章添加", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Article article)
    {

        List<Article> list = articleService.selectArticleList(article);
        ExcelUtil<Article> util = new ExcelUtil<Article>(Article.class);
        return util.exportExcel(list, "article");
    }

    /**
     * 新增文章
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章添加
     */
    @RequiresPermissions("system:article:add")
    @Log(title = "文章添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Article article)
    {
        article.setId(UUIDUtils.getUUID());
        article.setCreateTime(new Date());
        return toAjax(articleService.insertArticle(article));
    }

    /**
     * 修改文章
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Article article = articleService.selectArticleById(id);
        mmap.put("article", article);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "文章添加", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Article article)
    {
        return toAjax(articleService.updateArticle(article));
    }

    /**
     * 删除文章添加
     */
    @RequiresPermissions("system:article:remove")
    @Log(title = "文章添加", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(articleService.deleteArticleByIds(ids));
    }

    /**
     * 办理/退回 -- 上传图片
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/uploads")
    @ResponseBody
    public AjaxResult uploadFiles(MultipartFile file) throws Exception{
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String name = fileName.substring(15);
            String url = "http://192.168.1.15:8080/uploadPath" + fileName;
            AjaxResult ajax = AjaxResult.success();
            String formatName = fileName.split("\\.")[1];
            if (formatName.equals("png") || formatName.equals("jpg") || formatName.equals("jpeg")) {
                Thumbnails.of(filePath + name).size(2560, 2048).toFile(filePath + name);
            }
            ajax.put("vdioUrl", url);
            ajax.put("imagesUrl", file.getOriginalFilename());
            return ajax;
        }
        catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
