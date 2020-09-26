package com.ruoyi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ContTest {
	private static long count=0;
	private static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		File f=new File("D:\\test\\di_xjkh\\di_xjk\\src\\main\\java\\com\\ruoyi\\project\\swgger");
		go(f);
		System.out.println(count);
	}

	private static void go(File f) throws Exception {
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			if (files!=null) {
				for (File file : files) {
					go(file);
				}
			}
		}else {
			if (f.getName().endsWith(".java")) {
				br=new BufferedReader(new FileReader(f));
				while (br.readLine()!=null) {
					count++;
				}
			}
		}
	}

}
