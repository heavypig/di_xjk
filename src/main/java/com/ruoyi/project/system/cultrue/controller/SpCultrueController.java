package com.ruoyi.project.system.cultrue.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.baidu.ueditor.ActionEnter;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.cultrue.domain.SpCultrue;
import com.ruoyi.project.system.cultrue.service.ISpCultrueService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 历史文化Controller
 * 
 * @author xingmc
 * @date 2020-10-12
 */
@Controller
@RequestMapping("/system/cultrue")
public class SpCultrueController extends BaseController
{
    private String prefix = "system/cultrue";

    @Autowired
    private ISpCultrueService spCultrueService;

    @RequiresPermissions("system:cultrue:view")
    @GetMapping()
    public String cultrue()
    {
        return prefix + "/cultrue";
    }

    /**
     * 查询历史文化列表
     */
    @RequiresPermissions("system:cultrue:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SpCultrue spCultrue)
    {
        startPage();
        List<SpCultrue> list = spCultrueService.selectSpCultrueList(spCultrue);
        return getDataTable(list);
    }

    /**
     * 导出历史文化列表
     */
    @RequiresPermissions("system:cultrue:export")
    @Log(title = "历史文化", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpCultrue spCultrue)
    {
        List<SpCultrue> list = spCultrueService.selectSpCultrueList(spCultrue);
        ExcelUtil<SpCultrue> util = new ExcelUtil<SpCultrue>(SpCultrue.class);
        return util.exportExcel(list, "cultrue");
    }

    /**
     * 新增历史文化
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存历史文化
     */
    @RequiresPermissions("system:cultrue:add")
    @Log(title = "历史文化", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SpCultrue spCultrue,HttpServletRequest request)
    {
        String culContent = request.getParameter("culContent");
        spCultrue.setCulContent(culContent);
        return toAjax(spCultrueService.insertSpCultrue(spCultrue));
    }

    /**
     * 修改历史文化
     */
    @GetMapping("/edit/{cultureId}")
    public String edit(@PathVariable("cultureId") String cultureId, ModelMap mmap)
    {
        SpCultrue spCultrue = spCultrueService.selectSpCultrueById(cultureId);
        mmap.put("spCultrue", spCultrue);
        return prefix + "/edit";
    }

    /**
     * 修改保存历史文化
     */
    @RequiresPermissions("system:cultrue:edit")
    @Log(title = "历史文化", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SpCultrue spCultrue, HttpServletRequest request)
    {
        String culContent = request.getParameter("culContent");
        spCultrue.setCulContent(culContent);
        return toAjax(spCultrueService.updateSpCultrue(spCultrue));
    }

    /**
     * 删除历史文化
     */
    @RequiresPermissions("system:cultrue:remove")
    @Log(title = "历史文化", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(spCultrueService.deleteSpCultrueByIds(ids));
    }

    /**
     * 头像上传
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
            String url = "http://192.168.1.27:8080/uploadPath" + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("headImage", url);
            return ajax;
        }
        catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
