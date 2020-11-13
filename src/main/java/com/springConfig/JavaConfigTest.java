package com.springConfig;

import com.bean.Car;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.bmp.BmpHeaderDirectory;
import com.drew.metadata.gif.GifHeaderDirectory;
import com.drew.metadata.jpeg.JpegDirectory;
import com.drew.metadata.png.PngDirectory;
import com.drew.metadata.webp.WebpDirectory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by yinchao on 2018/4/11.
 */
public class JavaConfigTest {

    public void testMedia() throws IOException {
        long totalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long freeMemory = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        double value = totalMemory - freeMemory;
        System.out.println("总内存：" + totalMemory + ",空闲内存：" + freeMemory + ",已使用内存：" + value);
        File file = new File("/Users/yinchao/test.webp");
        /*BufferedImage image = ImageIO.read(new FileInputStream(file));
        int x = image.getWidth();
        int y = image.getHeight();*/
        int x = 0;
        int y = 0;
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("webp");
        if (readers.hasNext()) {
            ImageReader reader = (ImageReader) readers.next();
            try (ImageInputStream iis = ImageIO.createImageInputStream(file)) {
                reader.setInput(iis, true);
                x = reader.getWidth(0);
                y = reader.getHeight(0);
            }
        }


        System.out.println(x + "---" + y);
        long totalMemory1 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long freeMemory1 = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        double value1 = totalMemory1 - freeMemory1;
        System.out.println("总内存：" + totalMemory1 + ",空闲内存：" + freeMemory1 + ",已使用内存：" + value1);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConf.class);
        ctx.refresh();
        Car car1 = (Car) ctx.getBean("car");
        car1.introduce();
        car1.setBrand("宝马");

        //第二次从容器中获取car，直接从缓冲池中获取
        Car car2 = (Car) ctx.getBean("car");

        //查看car1和car2是否指向同一引用
        System.out.println("car1==car2:"+(car1==car2));

        System.out.println(car1.getBrand());
    }
}
