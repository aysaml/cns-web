package cn.edu.lnpu.cnsweb.web.controller;

import cn.edu.lnpu.cnsweb.common.ConstantState;
import cn.edu.lnpu.cnsweb.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传controller
 *
 * @author wangning113
 * @since 2018/5/28
 */
@Controller
public class FileUploadController {
  /**
   * 文件上传实现方法（单文件上传）
   *
   * @param file
   * @return
   */
  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  @ResponseBody
  public JsonResult upload(@RequestParam("file") MultipartFile file) {
    JsonResult result = new JsonResult();
    if (!file.isEmpty()) {
      try {
        BufferedOutputStream out =
            new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
        out.write(file.getBytes());
        out.flush();
        out.close();
        result.setState(ConstantState.UPLOAD_FILE_SUCCESS.getCode());
        result.setMessage(ConstantState.UPLOAD_FILE_SUCCESS.getMessage());
        result.setData("/file/" + file.getName());
      } catch (Exception e) {
        e.printStackTrace();
        result.setState(ConstantState.UPLOAD_FILE_FAILED.getCode());
        result.setMessage(ConstantState.UPLOAD_FILE_FAILED.getMessage());
        result.setData(null);
        return result;
      }
      return result;
    } else {
      result.setState(ConstantState.UPLOAD_FILE_EMPTY.getCode());
      result.setMessage(ConstantState.UPLOAD_FILE_EMPTY.getMessage());
      result.setData(null);
      return result;
    }
  }

  /**
   * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
   *
   * @param request
   * @return
   */
  @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
  public @ResponseBody JsonResult batchUpload(HttpServletRequest request) {
    JsonResult result = new JsonResult();
    List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
    MultipartFile file = null;
    BufferedOutputStream stream = null;
    /**用于存放多个文件的路径*/
    List<String> fileNameList = new ArrayList<>(i);
    for (int i = 0; i < files.size(); ++i) {
      file = files.get(i);
      if (!file.isEmpty()) {
        try {
          byte[] bytes = file.getBytes();
          stream =
              new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
          stream.write(bytes);
          stream.close();
          fileNameList.add("/file/"+file.getName());
        } catch (Exception e) {
          stream = null;
          result.setState(ConstantState.UPLOAD_FILE_PART_FAILED.getCode());
          result.setMessage(ConstantState.UPLOAD_FILE_PART_FAILED.getMessage());
          result.setData("文件:" + files.get(i).getName() + "上传失败！");
          return result;
        }
      } else {
        result.setState(ConstantState.UPLOAD_FILE_EMPTY.getCode());
        result.setMessage(ConstantState.UPLOAD_FILE_EMPTY.getMessage());
        result.setData(null);
        return result;
      }
    }
      result.setState(ConstantState.UPLOAD_FILE_SUCCESS.getCode());
      result.setMessage(ConstantState.UPLOAD_FILE_SUCCESS.getMessage());
      result.setData(fileNameList);
    return result;
  }
}
