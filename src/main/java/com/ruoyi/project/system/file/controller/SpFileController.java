package com.ruoyi.project.system.file.controller;

import java.util.List;

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
import com.ruoyi.project.system.file.domain.SpFile;
import com.ruoyi.project.system.file.service.ISpFileService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 沙盘文件Controller
 * 
 * @author xingmc
 * @date 2020-09-26
 */
@Controller
@RequestMapping("/system/file")
public class SpFileController extends BaseController
{
    private String prefix = "system/file";

    @Autowired
    private ISpFileService spFileService;

    @RequiresPermissions("system:file:view")
    @GetMapping()
    public String file()
    {
        return prefix + "/file";
    }

    /**
     * 查询沙盘文件列表
     */
    @RequiresPermissions("system:file:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SpFile spFile)
    {
        startPage();
        List<SpFile> list = spFileService.selectSpFileList(spFile);
        return getDataTable(list);
    }

    /**
     * 导出沙盘文件列表
     */
    @RequiresPermissions("system:file:export")
    @Log(title = "沙盘文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpFile spFile)
    {
        List<SpFile> list = spFileService.selectSpFileList(spFile);
        ExcelUtil<SpFile> util = new ExcelUtil<SpFile>(SpFile.class);
        return util.exportExcel(list, "file");
    }

    /**
     * 新增沙盘文件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存沙盘文件
     */
    @RequiresPermissions("system:file:add")
    @Log(title = "沙盘文件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SpFile spFile)
    {
        return toAjax(spFileService.insertSpFile(spFile));
    }

    /**
     * 修改沙盘文件
     */
    @GetMapping("/edit/{fileId}")
    public String edit(@PathVariable("fileId") String fileId, ModelMap mmap)
    {
        SpFile spFile = spFileService.selectSpFileById(fileId);
        mmap.put("spFile", spFile);
        return prefix + "/edit";
    }

    /**
     * 修改保存沙盘文件
     */
    @RequiresPermissions("system:file:edit")
    @Log(title = "沙盘文件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SpFile spFile)
    {
        return toAjax(spFileService.updateSpFile(spFile));
    }

    /**
     * 删除沙盘文件
     */
    @RequiresPermissions("system:file:remove")
    @Log(title = "沙盘文件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(spFileService.deleteSpFileByIds(ids));
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
