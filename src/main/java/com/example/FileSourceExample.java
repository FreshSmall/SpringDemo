package com.example;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by yinchao on 2018/3/8.
 */
public class FileSourceExample {

    public static void main(String[] args) throws IOException {
        String filePath = "I:/网络资源/Idea--space/SpringDemo/src/main/resources/test_input.txt";
        //使用系统文件路径方式加载文件
        WritableResource res1 = new PathResource(filePath);
        //使用类路径方式加载文件
        Resource res2 = new ClassPathResource("test_input.txt");
        //使用WritableResurce接口写资源文件
        OutputStream stream1 = res1.getOutputStream();
        stream1.write("欢迎光临\n小春论坛".getBytes());
        stream1.close();
        //使用Resource接口读资源文件
        InputStream in1 = res1.getInputStream();
        //InputStream in2 = res2.getInputStream();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        int i;
        while((i=in1.read())!=-1){
            baos.write(i);
        }
        System.out.println("res1:"+res1.getFilename()+res1.getInputStream());
        System.out.println("res2:"+res2.getFilename()+res2.getInputStream());
    }
}
