package com.ruoyi.project.swagger.controller;

import com.ruoyi.framework.web.controller.BaseController;
import gnu.io.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ruoyi")
@CrossOrigin
public class SwagerController extends BaseController {

   /* @Autowired
    private IArticleService articleService;*/

    /**
     * 查询文章添加列表
     */
    /*@PostMapping("/list")
    @ResponseBody
    public List<Article> list(Article article)
    {
        List<Article> list = articleService.selectArticleList(article);
        return list;
    }*/

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
