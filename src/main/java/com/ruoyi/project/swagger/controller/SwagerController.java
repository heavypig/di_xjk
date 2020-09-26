package com.ruoyi.project.swagger.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.swagger.domain.Subject;
import com.ruoyi.project.swagger.service.SubjectService;
import com.ruoyi.project.system.article.domain.Article;
import com.ruoyi.project.system.article.service.IArticleService;
import gnu.io.*;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.serial.SerialAddress;
import org.apache.mina.transport.serial.SerialConnector;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/ruoyi")
@CrossOrigin
public class SwagerController extends BaseController {

    @Autowired
    private IArticleService articleService;

    /**
     * 查询文章添加列表
     */

    @PostMapping("/list")
    @ResponseBody
    public List<Article> list(Article article)
    {
        List<Article> list = articleService.selectArticleList(article);
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


    /*@PostMapping("/getchuankou")
    @ResponseBody
    public void getchuankou(String command,String port)
    {
        if (StringUtils.isNotBlank(command)) {
            IoBuffer buffer = IoBuffer.wrap(command.getBytes());
            IoSession session = null;
            try {
                //创建串口连接
                SerialConnector connector = new SerialConnector();
                //绑定处理handler
                connector.setHandler(new IoHandlerAdapter());
                //设置过滤器
                connector.getFilterChain().addLast("logger", new LoggingFilter());
                //配置串口连接
                SerialAddress address = new SerialAddress(port, 9600, SerialAddress.DataBits.DATABITS_8, SerialAddress.StopBits.BITS_1 , SerialAddress.Parity.NONE, SerialAddress.FlowControl.NONE);
                ConnectFuture future = connector.connect(address);
                future.await();
                session = future.getSession();
                session.write(buffer);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null) {
                    session.close(true);
                }
            }
        }
    }

    *//*
     *获取串口连接
     *//*
    @PostMapping("/getSerial")
    @ResponseBody
    public ArrayList<String> getSerial()
    {
        //1.获取本地所有的端口并输出其名称：
        //1.1.用于标识端口的变量
        CommPortIdentifier portIdentifier = null;
        //1.2.记录所有端口的变量
        Enumeration<?> allPorts = CommPortIdentifier.getPortIdentifiers();
        //1.3.输出每一个端口
        ArrayList<String> objects = new ArrayList<>();
        while(allPorts.hasMoreElements()){
            portIdentifier = (CommPortIdentifier) allPorts.nextElement();
            System.out.println("串口：" + portIdentifier.getName());
            objects.add(portIdentifier.getName());
        }
        return objects;
    }

    *//*
     *打开串口连接
     *//*
    @PostMapping("/openSerial")
    @ResponseBody
    public void openSerial(String Serial)
    {

        //2.打开COM11和COM21端口
        //2.1.获取两个端口
        CommPortIdentifier com = null;
        try {
            com = CommPortIdentifier.getPortIdentifier(Serial);
        } catch (NoSuchPortException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //2.2.打开两个端口，但是什么都没干
        SerialPort serialCom = null;

        try {
            //open方法的第1个参数表示串口被打开后的所有者名称，
            //第2个参数表示如果串口被占用的时候本程序的最长等待时间，以毫秒为单位。
            serialCom = (SerialPort)com.open("OpenerAndCloser", 1000);


        } catch (Exception e) {
            //要打开的端口被占用时抛出该异常
            e.printStackTrace();
        }
        //2.3.设置两个端口的参数
        try {
            serialCom.setSerialPortParams(
                    9600, //波特率
                    SerialPort.DATABITS_8,//数据位数
                    SerialPort.STOPBITS_1,//停止位
                    SerialPort.PARITY_NONE//奇偶位
            );
            serialCom.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.关闭COM端口
        //关闭端口的方法在SerialPort类中
        serialCom.close();
    }*/


}
