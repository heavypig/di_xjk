package com.ruoyi.project.system.spNotice.controller;

import java.util.List;
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
import com.ruoyi.project.system.spNotice.domain.SpNotice;
import com.ruoyi.project.system.spNotice.service.ISpNoticeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 新街口公告Controller
 * 
 * @author xingmc
 * @date 2020-11-09
 */
@Controller
@RequestMapping("/system/spNotice")
public class SpNoticeController extends BaseController
{
    private String prefix = "system/spNotice";

    @Autowired
    private ISpNoticeService spNoticeService;

    @RequiresPermissions("system:spNotice:view")
    @GetMapping()
    public String spNotice()
    {
        return prefix + "/spNotice";
    }

    /**
     * 查询新街口公告列表
     */
    @RequiresPermissions("system:spNotice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SpNotice spNotice)
    {
        startPage();
        List<SpNotice> list = spNoticeService.selectSpNoticeList(spNotice);
        return getDataTable(list);
    }

    /**
     * 导出新街口公告列表
     */
    @RequiresPermissions("system:spNotice:export")
    @Log(title = "新街口公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpNotice spNotice)
    {
        List<SpNotice> list = spNoticeService.selectSpNoticeList(spNotice);
        ExcelUtil<SpNotice> util = new ExcelUtil<SpNotice>(SpNotice.class);
        return util.exportExcel(list, "spNotice");
    }

    /**
     * 新增新街口公告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存新街口公告
     */
    @RequiresPermissions("system:spNotice:add")
    @Log(title = "新街口公告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SpNotice spNotice, HttpServletRequest request)
    {
        String noContent = request.getParameter("noContent");
        spNotice.setNoContent(noContent);
        return toAjax(spNoticeService.insertSpNotice(spNotice));
    }

    /**
     * 修改新街口公告
     */
    @GetMapping("/edit/{noticeId}")
    public String edit(@PathVariable("noticeId") String noticeId, ModelMap mmap)
    {
        SpNotice spNotice = spNoticeService.selectSpNoticeById(noticeId);
        mmap.put("spNotice", spNotice);
        return prefix + "/edit";
    }

    /**
     * 修改保存新街口公告
     */
    @RequiresPermissions("system:spNotice:edit")
    @Log(title = "新街口公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SpNotice spNotice, HttpServletRequest request)
    {
        String noContent = request.getParameter("noContent");
        spNotice.setNoContent(noContent);
        return toAjax(spNoticeService.updateSpNotice(spNotice));
    }

    /**
     * 删除新街口公告
     */
    @RequiresPermissions("system:spNotice:remove")
    @Log(title = "新街口公告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(spNoticeService.deleteSpNoticeByIds(ids));
    }
}
