package com.ruoyi.project.system.cultrue.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ServersController {

    /*@RequestMapping("/ueditor")
    public void ueditor(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进来了");
        try {
            request.setCharacterEncoding( "utf-8" );
            response.setHeader("Content-Type" , "text/html");
            response.setContentType("application/json");
            // 去加载config.json文件
            String rootPath = request.getSession().getServletContext().getRealPath("/");
            PrintWriter out = response.getWriter();
            String exec = new ActionEnter( request, rootPath ).exec();
            System.out.println(rootPath+"\n"+exec);
            out.write( exec );
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
    @RequestMapping("/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/ueditor/jsp";
        try {
            response.setCharacterEncoding("UTF-8");
            String exec = new ActionEnter(request, rootPath).exec();
            System.out.println(exec);
            PrintWriter writer = response.getWriter();
            writer.write(new ActionEnter( request, rootPath ).exec());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
