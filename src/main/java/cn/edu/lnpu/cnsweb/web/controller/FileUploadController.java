package cn.edu.lnpu.cnsweb.web.controller;


import cn.edu.lnpu.cnsweb.common.AliOSSUtil;
import cn.edu.lnpu.cnsweb.common.ConstantState;
import cn.edu.lnpu.cnsweb.common.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件上传controller(上传至阿里云oss)
 *
 * @author wangning113
 * @since 2018/5/28
 */
@RestController
public class FileUploadController {

  private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
  /**
   * 本地存放目录
   */
  private static String uoloadPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "upload/";

  @PostMapping("/upload")
  public JsonResult imageUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
    JsonResult result = new JsonResult();
    if (!file.isEmpty()) {
      try {
        // 上传文件信息
        logger.info("OriginalFilename：" + file.getOriginalFilename());
        logger.info("ContentType：" + file.getContentType());
        logger.info("Name：" + file.getName());
        logger.info("Size：" + file.getSize());
        //TODO:文件大小、名称、类型检查的业务处理

        // 检查上传目录
        File targetFile = new File(uoloadPath);
        if (!targetFile.exists()) {
          targetFile.mkdirs();
        }

        // 实例化输出流
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(uoloadPath + file.getOriginalFilename()));
        out.write(file.getBytes());
        out.flush();
        out.close();

        // 上传到OSS
        String url = AliOSSUtil.uploadLocalFile(new File(uoloadPath + file.getOriginalFilename()), "/upload/avatar/");
        if (url == null) {
          result.setState(ConstantState.UPLOAD_FILE_FAILED.getCode());
          result.setData(ConstantState.UPLOAD_FILE_FAILED.getMessage());
          result.setData(null);
          return result;
        }
        logger.info("上传完毕,访问地址:"+url);
        result.setState(ConstantState.UPLOAD_FILE_SUCCESS.getCode());
        result.setData(ConstantState.UPLOAD_FILE_SUCCESS.getMessage());
        result.setData("https://"+url);
        return result;
      } catch (IOException e) {
        e.printStackTrace();
        result.setState(ConstantState.UPLOAD_FILE_FAILED.getCode());
        result.setData(ConstantState.UPLOAD_FILE_FAILED.getMessage());
        result.setData(null);
        return result;
      }
    }
    result.setState(ConstantState.UPLOAD_FILE_EMPTY.getCode());
    result.setData(ConstantState.UPLOAD_FILE_EMPTY.getMessage());
    result.setData(null);
    return result;
  }
}
