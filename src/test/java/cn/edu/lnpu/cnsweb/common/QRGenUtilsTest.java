package cn.edu.lnpu.cnsweb.common;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

/**
 * 二维码生成工具类测试
 *
 * @author wangning113
 * @since 2018/5/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QRGenUtilsTest {

    @Test
  public void createQRImageTest() throws Exception {
    BufferedImage qrImageBuffer = QRGenUtils.createQRImageBuffer("http://www.baidu.com", 200, 200);
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    ImageIO.write(qrImageBuffer, "png", os);
    Base64 base64 = new Base64();
    String base64Img = new String(base64.encode(os.toByteArray()));
    System.out.println(base64Img);
  }
}
