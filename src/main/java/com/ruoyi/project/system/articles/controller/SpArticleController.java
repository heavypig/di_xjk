package com.ruoyi.project.system.articles.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.UUIDUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
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
import com.ruoyi.project.system.articles.domain.SpArticle;
import com.ruoyi.project.system.articles.service.ISpArticleService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文章内容Controller
 *
 * @author duanxm
 * @date 2020-09-26
 */
@Controller
@RequestMapping("/system/articles")
public class SpArticleController extends BaseController
{
    private String prefix = "system/articles";

    @Autowired
    private ISpArticleService spArticleService;

    @RequiresPermissions("system:articles:view")
    @GetMapping()
    public String articles()
    {
        return prefix + "/articles";
    }

    /**
     * 查询文章内容列表
     */
    @RequiresPermissions("system:articles:list")
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
    @RequiresPermissions("system:articles:export")
    @Log(title = "文章内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpArticle spArticle)
    {
        List<SpArticle> list = spArticleService.selectSpArticleList(spArticle);
        ExcelUtil<SpArticle> util = new ExcelUtil<SpArticle>(SpArticle.class);
        return util.exportExcel(list, "articles");
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
    @RequiresPermissions("system:articles:add")
    @Log(title = "文章内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SpArticle spArticle)
    {
        spArticle.setArticleId(UUIDUtils.getUUID());
        spArticle.setCreateTime(new Date());
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
    @RequiresPermissions("system:articles:edit")
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
    @RequiresPermissions("system:articles:remove")
    @Log(title = "文章内容", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(spArticleService.deleteSpArticleByIds(ids));
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
            String url = "http://192.168.1.27:8080/uploadPath" + fileName;
            AjaxResult ajax = AjaxResult.success();
            String formatName = fileName.split("\\.")[1];
            if (formatName.equals("png") || formatName.equals("jpg") || formatName.equals("jpeg")) {
                Thumbnails.of(filePath + name).size(2560, 2048).toFile(filePath + name);
            }
            ajax.put("fileAddress", url);
            return ajax;
        }
        catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
