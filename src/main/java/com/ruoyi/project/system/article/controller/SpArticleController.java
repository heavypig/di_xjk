package com.ruoyi.project.system.article.controller;

import java.util.List;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
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
import com.ruoyi.project.system.article.domain.SpArticle;
import com.ruoyi.project.system.article.service.ISpArticleService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文章内容Controller
 * 
 * @author xingmc
 * @date 2020-09-27
 */
@Controller
@RequestMapping("/system/article")
public class SpArticleController extends BaseController
{
    private String prefix = "system/article";

    @Autowired
    private ISpArticleService spArticleService;

    @RequiresPermissions("system:article:view")
    @GetMapping()
    public String article()
    {
        return prefix + "/article";
    }

    /**
     * 查询文章内容列表
     */
    @RequiresPermissions("system:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SpArticle spArticle)
    {
        startPage();
        List<SpArticle> list = spArticleService.selectSpArticleList(spArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章内容列表
     */
    @RequiresPermissions("system:article:export")
    @Log(title = "文章内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpArticle spArticle)
    {
        List<SpArticle> list = spArticleService.selectSpArticleList(spArticle);
        ExcelUtil<SpArticle> util = new ExcelUtil<SpArticle>(SpArticle.class);
        return util.exportExcel(list, "article");
    }

    /**
     * 新增文章内容
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章内容
     */
    @RequiresPermissions("system:article:add")
    @Log(title = "文章内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SpArticle spArticle)
    {
        return toAjax(spArticleService.insertSpArticle(spArticle));
    }

    /**
     * 修改文章内容
     */
    @GetMapping("/edit/{articleId}")
    public String edit(@PathVariable("articleId") String articleId, ModelMap mmap)
    {
        SpArticle spArticle = spArticleService.selectSpArticleById(articleId);
        mmap.put("spArticle", spArticle);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章内容
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "文章内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SpArticle spArticle)
    {
        return toAjax(spArticleService.updateSpArticle(spArticle));
    }

    /**
     * 删除文章内容
     */
    @RequiresPermissions("system:article:remove")
    @Log(title = "文章内容", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(spArticleService.deleteSpArticleByIds(ids));
    }

    /**
     * 上传文章头图
     * @param file
     * @return
     */
    @PostMapping("/uploads")
    @ResponseBody
    public AjaxResult uploadFiles(MultipartFile file) {
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = "http://192.168.1.27:8080/uploadPath" + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileAddress", url);
            return ajax;
        }
        catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
