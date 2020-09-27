package com.ruoyi.project.swagger.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.article.domain.SpArticle;
import com.ruoyi.project.system.article.service.ISpArticleService;
import com.ruoyi.project.system.file.domain.SpFile;
import com.ruoyi.project.system.file.service.ISpFileService;
import com.ruoyi.project.system.serialport.domain.XjkSerialport;
import com.ruoyi.project.system.serialport.service.IXjkSerialportService;
import gnu.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
     * 查询街区视频列表
     */
    @PostMapping("/getArticles")
    @ResponseBody
    public Map<String, Object> getArticles(SpArticle spArticle)
    {
        return spArticleService.getArticles(spArticle);
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
    public String openSerial(String Serial,String port)
    {
        try {
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
            return "开启成功";
        }catch (Exception e){
            return "开启失败";
        }
    }

}
