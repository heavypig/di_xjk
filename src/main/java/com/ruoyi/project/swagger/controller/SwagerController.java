package com.ruoyi.project.swagger.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.activity.domain.SpActivity;
import com.ruoyi.project.system.activity.service.ISpActivityService;
import com.ruoyi.project.system.article.domain.SpArticle;
import com.ruoyi.project.system.article.service.ISpArticleService;
import com.ruoyi.project.system.cultrue.domain.SpCultrue;
import com.ruoyi.project.system.cultrue.service.ISpCultrueService;
import com.ruoyi.project.system.file.domain.SpFile;
import com.ruoyi.project.system.file.service.ISpFileService;
import com.ruoyi.project.system.serialport.domain.XjkSerialport;
import com.ruoyi.project.system.serialport.service.IXjkSerialportService;
import com.ruoyi.project.system.spNotice.domain.SpNotice;
import com.ruoyi.project.system.spNotice.service.ISpNoticeService;
import gnu.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ruoyi")
@CrossOrigin
public class SwagerController extends BaseController {

    @Autowired
    private IXjkSerialportService xjkSerialportService;
    @Autowired
    private ISpFileService spFileService;
    @Autowired
    private ISpArticleService spArticleService;
    @Autowired
    private ISpCultrueService spCultrueService;
    @Autowired
    private ISpActivityService spActivityService;
    @Autowired
    private ISpNoticeService spNoticeService;

    /**
     * 查询街区视频列表
     */
    @PostMapping("/getFiles")
    @ResponseBody
    public Map<String, Object> getFiles(SpFile spFile)
    {
        return spFileService.getSpFileList(spFile);
    }


    /**
     * 查询文章内容列表
     */
    @PostMapping("/getArticles")
    @ResponseBody
    public Map<String, Object> getArticles(SpArticle spArticle)
    {
        return spArticleService.getArticles(spArticle);
    }

    /**
     * 查询历史文化列表
     */
    @PostMapping("/getCultrues")
    @ResponseBody
    public Map<String, Object> getCultrues(SpCultrue spCultrue)
    {
        return spCultrueService.getSpCultrueList(spCultrue);
    }

    /**
     * 查询视频串口列表
     */
    @PostMapping("/Serialportlist")
    @ResponseBody
    public List<XjkSerialport> list(XjkSerialport xjkSerialport)
    {
        List<XjkSerialport> list = xjkSerialportService.selectXjkSerialportList(xjkSerialport);
        return list;
    }

    /**
     * 查询活动报名列表
     */
    @PostMapping("/getActivitys")
    @ResponseBody
    public Map<String, Object> getActivitys(SpActivity spActivity)
    {
        return spActivityService.getSpActivityList(spActivity);
    }

    /**
     * 查询新街口公告列表
     */
    @PostMapping("/getNotices")
    @ResponseBody
    public Map<String, Object> getNotices(SpNotice spNotice)
    {
        return spNoticeService.getSpNoticeList(spNotice);
    }

    /**
     * 获取COM
     */
    @PostMapping("/getport")
    @ResponseBody
    public List getport()
    {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(SerialComm.getSystemPort());
        return objects;
    }


    /**
     * 发送沙盘指令
     */
    @PostMapping("/openSerial")
    @ResponseBody
    public HashMap<String, String> openSerial(String articleId, String Serial, String port)
    {
        String[] strArr = Serial.split(" ");
        HashMap<String, String> map = new HashMap<>();
        SpArticle spArticle = spArticleService.selectSpArticleById(articleId);
        if (spArticle != null) {
            if (spArticle.getArticleCode().equals("1")) {
                spArticle.setArticleId(articleId);
                for(int i = 0; i < strArr.length; ++i){
                    this.sendSerials(strArr[i], port);
                    map.put(articleId,"开启成功");
                }
                spArticle.setArticleCode("0");//开灯状态
                spArticleService.updateSpArticle(spArticle);
            }else if (spArticle.getArticleCode().equals("0")) {
                this.sendSerials("66ff00000000FFFFFFFF88", port);
                spArticle.setArticleId(articleId);
                spArticle.setArticleCode("1");//关灯状态
                spArticleService.updateSpArticle(spArticle);
            }
        }else {
            this.sendSerials(Serial, port);
        }
        return map;
    }

    private void sendSerials(String Serial, String port){
            //开启端口
            final SerialPort serialPort = SerialComm.openSerialPort(port, 9600);
            //启动一个线程，每2s 向串口发送数据，发送1000次 hello
            byte[] bytes =new byte[2];
            SerialComm.sendData(serialPort, HexUtils.hex2Bytes(Serial));
            //设置串口的listener
            SerialComm.setListenerToSerialPort(serialPort, new SerialPortEventListener() {
                @Override
                public void serialEvent(SerialPortEvent serialPortEvent) {
                    if (serialPortEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) { //数据通知
                        byte[] bytes = SerialComm.readData(serialPort);
                        System.out.println("收到的数据长度： " + bytes.length);
                        System.out.println("收到的数据：" + new String(bytes));
                    }
                }
            });
            SerialComm.closeSerialPort(serialPort);
    }

}
