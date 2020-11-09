package com.ruoyi.project.system.activity.controller;

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
import com.ruoyi.project.system.activity.domain.SpActivity;
import com.ruoyi.project.system.activity.service.ISpActivityService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 活动报名Controller
 * 
 * @author xingmc
 * @date 2020-11-09
 */
@Controller
@RequestMapping("/system/activity")
public class SpActivityController extends BaseController
{
    private String prefix = "system/activity";

    @Autowired
    private ISpActivityService spActivityService;

    @RequiresPermissions("system:activity:view")
    @GetMapping()
    public String activity()
    {
        return prefix + "/activity";
    }

    /**
     * 查询活动报名列表
     */
    @RequiresPermissions("system:activity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SpActivity spActivity)
    {
        startPage();
        List<SpActivity> list = spActivityService.selectSpActivityList(spActivity);
        return getDataTable(list);
    }

    /**
     * 导出活动报名列表
     */
    @RequiresPermissions("system:activity:export")
    @Log(title = "活动报名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpActivity spActivity)
    {
        List<SpActivity> list = spActivityService.selectSpActivityList(spActivity);
        ExcelUtil<SpActivity> util = new ExcelUtil<SpActivity>(SpActivity.class);
        return util.exportExcel(list, "activity");
    }

    /**
     * 新增活动报名
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存活动报名
     */
    @RequiresPermissions("system:activity:add")
    @Log(title = "活动报名", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SpActivity spActivity, HttpServletRequest request)
    {
        String actContent = request.getParameter("actContent");
        spActivity.setActContent(actContent);
        return toAjax(spActivityService.insertSpActivity(spActivity));
    }

    /**
     * 修改活动报名
     */
    @GetMapping("/edit/{activityId}")
    public String edit(@PathVariable("activityId") String activityId, ModelMap mmap)
    {
        SpActivity spActivity = spActivityService.selectSpActivityById(activityId);
        mmap.put("spActivity", spActivity);
        return prefix + "/edit";
    }

    /**
     * 修改保存活动报名
     */
    @RequiresPermissions("system:activity:edit")
    @Log(title = "活动报名", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SpActivity spActivity, HttpServletRequest request)
    {
        String actContent = request.getParameter("actContent");
        spActivity.setActContent(actContent);
        return toAjax(spActivityService.updateSpActivity(spActivity));
    }

    /**
     * 删除活动报名
     */
    @RequiresPermissions("system:activity:remove")
    @Log(title = "活动报名", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(spActivityService.deleteSpActivityByIds(ids));
    }
}
