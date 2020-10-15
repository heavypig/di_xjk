package com.ruoyi.project.system.serialport.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.UUIDUtils;
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
import com.ruoyi.project.system.serialport.domain.XjkSerialport;
import com.ruoyi.project.system.serialport.service.IXjkSerialportService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 串口Controller
 * 
 * @author duanxm
 * @date 2020-09-26
 */
@Controller
@RequestMapping("/system/serialport")
public class XjkSerialportController extends BaseController
{
    private String prefix = "system/serialport";

    @Autowired
    private IXjkSerialportService xjkSerialportService;

    @RequiresPermissions("system:serialport:view")
    @GetMapping()
    public String serialport()
    {
        return prefix + "/serialport";
    }

    /**
     * 查询串口列表
     */
    @RequiresPermissions("system:serialport:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XjkSerialport xjkSerialport)
    {
        startPage();
        List<XjkSerialport> list = xjkSerialportService.selectXjkSerialportList(xjkSerialport);
        return getDataTable(list);
    }

    /**
     * 导出串口列表
     */
    @RequiresPermissions("system:serialport:export")
    @Log(title = "串口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XjkSerialport xjkSerialport)
    {
        List<XjkSerialport> list = xjkSerialportService.selectXjkSerialportList(xjkSerialport);
        ExcelUtil<XjkSerialport> util = new ExcelUtil<XjkSerialport>(XjkSerialport.class);
        return util.exportExcel(list, "serialport");
    }

    /**
     * 新增串口
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存串口
     */
    @RequiresPermissions("system:serialport:add")
    @Log(title = "串口", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XjkSerialport xjkSerialport)
    {
        xjkSerialport.setCreatetime(new Date());
        xjkSerialport.setSerialportId(UUIDUtils.getUUID());
        return toAjax(xjkSerialportService.insertXjkSerialport(xjkSerialport));
    }

    /**
     * 修改串口
     */
    @GetMapping("/edit/{serialportId}")
    public String edit(@PathVariable("serialportId") String serialportId, ModelMap mmap)
    {
        XjkSerialport xjkSerialport = xjkSerialportService.selectXjkSerialportById(serialportId);
        mmap.put("xjkSerialport", xjkSerialport);
        return prefix + "/edit";
    }

    /**
     * 修改保存串口
     */
    @RequiresPermissions("system:serialport:edit")
    @Log(title = "串口", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XjkSerialport xjkSerialport)
    {
        return toAjax(xjkSerialportService.updateXjkSerialport(xjkSerialport));
    }

    /**
     * 删除串口
     */
    @RequiresPermissions("system:serialport:remove")
    @Log(title = "串口", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xjkSerialportService.deleteXjkSerialportByIds(ids));
    }
}
