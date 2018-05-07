package com.example;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * Created by yinchao on 2018/3/8.
 */
public class EncodeResourceExample {

    public static void main(String[] args) throws IOException {
        //当系统加载时默认采用系统编码读取资源内容，如果资源采用特殊的编码格式可以通过EncodedResource对资源进行编码，以保证资源内容操作的正确性
        String filePath = "I:/网络资源/Idea--space/SpringDemo/src/main/resources/test_input.txt";
        //使用系统文件路径方式加载文件
        WritableResource res1 = new PathResource(filePath);
        Resource res = new ClassPathResource("test_input.txt");
        EncodedResource encRes=new EncodedResource(res,"utf-8");
        String content= FileCopyUtils.copyToString(encRes.getReader());
        System.out.println(content);
    }
}
