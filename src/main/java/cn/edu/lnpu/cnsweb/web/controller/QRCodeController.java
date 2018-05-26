package cn.edu.lnpu.cnsweb.web.controller;

import cn.edu.lnpu.cnsweb.common.ConstantState;
import cn.edu.lnpu.cnsweb.common.JsonResult;
import cn.edu.lnpu.cnsweb.common.QRGenUtils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * 二维码controller
 *
 * @author wangning113
 * @since 2018/5/26
 */
@Controller
@RequestMapping("/spot")
public class QRCodeController {

    private Logger logger = LoggerFactory.getLogger(QRCodeController.class);

    @Value("${QR_URL}")
    private String url;

    /**
     * 根据所给内容生成二维码base64图片字符串
     * @param id 地点id
     * @return
     */
    private String gennerateQRCodeBase64(String id) throws Exception{
        String content = url + id;
        BufferedImage qrImageBuffer = QRGenUtils.createQRImageBuffer(content, 200, 200);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(qrImageBuffer, "png", os);
        Base64 base64 = new Base64();
        String base64Img = new String(base64.encode(os.toByteArray()));
        return base64Img;
    }

    @RequestMapping(value = "/getQRcode" ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getQRCode(@RequestParam("id") String id){
        JsonResult result = new JsonResult();
        try{
            String imgStr = gennerateQRCodeBase64(id);
            result.setState(ConstantState.SUCCESS.getCode());
            result.setMessage(ConstantState.SUCCESS.getMessage());
            result.setData(imgStr);
        }catch (Exception e){
            result.setState(ConstantState.RUNTIME_ERROR.getCode());
            result.setMessage(ConstantState.RUNTIME_ERROR.getMessage());
            result.setData(null);
            logger.error("生成二维码失败：",e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
