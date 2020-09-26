package com.ruoyi.common.utils;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Test {

    public static void main(String agsp[]){
        testWord("C:\\Users\\10178\\Desktop\\11.docx");
    }

    public static void testWord(String filePath){
        try{
            FileInputStream in = new FileInputStream(filePath);//载入文档 //如果是office2007  docx格式
            if(filePath.toLowerCase().endsWith("docx")){
                //word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
                XWPFDocument xwpf = new XWPFDocument(in);//得到word文档的信息
                //List<XWPFParagraph> listParagraphs = xwpf.getParagraphs();//得到段落信息
                Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格

                while(it.hasNext()){

                    XWPFTable table = it.next();
                    //表头
                    String nameTable = table.getRow(0).getTableCells().get(0).getParagraphs().get(0).getRuns().get(0).toString();
                    System.out.println(nameTable);
                    List<XWPFTableRow> rows=table.getRows();
                    //读取每一行数据
                    for (int i = 1; i < rows.size(); i++) {
                        XWPFTableRow row = rows.get(i);
                        //读取每一列数据
                        List<XWPFTableCell> cells = row.getTableCells();
                        for (int j = 0; j < cells.size(); j++) {

                            XWPFTableCell cell=cells.get(j);
                            //输出当前的单元格的数据
                            System.out.println(cell.getText());
                        }
                    }
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
