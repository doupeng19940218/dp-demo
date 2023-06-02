package org.example.ocr;

import lombok.SneakyThrows;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author walker.dou
 */
@RestController("/pic")
public class PicControlller {

    @SneakyThrows
    @RequestMapping("/sn")
    public void newsImage(@RequestParam("file") MultipartFile multipartFile) {

    }

    @SneakyThrows
    public static void main(String[] args) {
        final File file = new File("C:\\Users\\walker.dou\\Desktop\\SN8.png");
        final BufferedImage read = ImageIO.read(file);
        //识别图片的文字
        String result = doOCR(read);
        //再结合敏感词过滤算法，审核图片中的文字是否包含敏感词
//        boolean isSensitive = sensitiveScan(result);
        System.out.println(result);
    }
    // 入参：图片流
    public static String doOCR(BufferedImage image) throws TesseractException {
        //创建Tesseract对象
        ITesseract tesseract = new Tesseract();
        //设置中文字体库路径
        tesseract.setDatapath("D:\\tessdata2");
        //中文识别`
            tesseract.setLanguage("eng");
//        tesseract.setTessVariable("debug_file", "/dev/null");


        //执行ocr识别
        String result = tesseract.doOCR(image);
        //替换回车和tal键  使结果为一行
        result = result.replaceAll("\\r|\\n", "-").replaceAll(" ", "");
        return result;
    }

}
