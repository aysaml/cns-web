package cn.edu.lnpu.cnsweb.common;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;



/**
 * 二维码生成工具类
 *
 * @author wangning113
 * @since 2018/5/26
 */
public class QRGenUtils {
    private static final int black = 0xFF000000;
    private static final int white = 0xFFFFFFFF;

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? black : white);
            }
        }
        return image;
    }


    public static void writeToFile(BitMatrix matrix, String format, File file)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        ImageIO.write(image, format, file);
    }

    public static void createQRImage(String content, int width, int height, String path, String fileName) throws Exception {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        if (StringUtils.isNotEmpty(path)) {
            if (!path.endsWith("/")) {
                path = path + "/";
            }
        } else {
            path = "";
        }
        String suffix = "jpg";
        if (fileName.indexOf(".") <= -1) {
            fileName = fileName + "." + suffix;
        } else {
            suffix = fileName.split("[.]")[1];
        }
        fileName = path + fileName;
        File file = new File(fileName);
        writeToFile(bitMatrix, suffix, file);
    }


    public static BufferedImage createQRImageBuffer(String content, int width, int height) throws  Exception{
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        BufferedImage image = toBufferedImage(bitMatrix);
        return image;
    }
}
