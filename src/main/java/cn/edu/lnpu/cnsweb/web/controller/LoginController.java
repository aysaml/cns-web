package cn.edu.lnpu.cnsweb.web.controller;

import cn.edu.lnpu.cnsweb.common.ConstantState;
import cn.edu.lnpu.cnsweb.common.JsonResult;
import cn.edu.lnpu.cnsweb.web.model.User;
import cn.edu.lnpu.cnsweb.web.model.UserVo;
import cn.edu.lnpu.cnsweb.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录注册控制器
 *
 * @author wangning113
 * @since 2018/5/12
 */
@Controller
public class LoginController {

  private Logger logger = LoggerFactory.getLogger(LoginController.class);

  @Autowired private UserService userService;

  /**
   * 登录页
   *
   * @return
   */
  @RequestMapping(value = "/login")
  public String login() {
    return "login";
  }

  @RequestMapping("/doLogin")
  @ResponseBody
  public JsonResult doLogin(
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      HttpSession session) {
    JsonResult result = new JsonResult();
    try {
      User user = userService.getUserByNameAndPassword(username, password);
      if (user != null) {
        result.setState(ConstantState.LOGIN_SUCCESS.getCode());
        result.setMessage(ConstantState.LOGIN_SUCCESS.getMessage());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("id", user.getId());
        session.setAttribute("name",user.getName());
        session.setMaxInactiveInterval(3600);
        result.setData("登录成功！");
        return result;
      } else {
        result.setState(ConstantState.LOGIN_FAIL.getCode());
        result.setMessage(ConstantState.LOGIN_FAIL.getMessage());
        result.setData("用户名或密码错误！");
        return result;
      }
    } catch (Exception e) {
      result.setState(ConstantState.RUNTIME_ERROR.getCode());
      result.setMessage(ConstantState.RUNTIME_ERROR.getMessage());
      result.setData("登录错误，请重试！");
      e.printStackTrace();
      logger.error("登录验证异常：", e.getMessage());
      return result;
    }
  }

  /**
   * 用户注销
   *
   * @param request
   * @return
   */
  @SuppressWarnings("unused")
  @RequestMapping(value = "/logout")
  public ModelAndView logout(HttpServletRequest request) {
    ModelAndView result = new ModelAndView("/login");
    HttpSession session = request.getSession();
    if (session != null) {
      String username = (String)session.getAttribute("username");
      session.invalidate();
    }
    return result;
  }

  /**
   * 注册页面
   * @return
   */
  @RequestMapping("/register")
  public String register(){
    return "register";
  }

  /**
   * 注册
   * @param user
   * @return
   */
  @RequestMapping(value="/doRegister",
          produces = "application/json")
  @ResponseBody
  public JsonResult doRegister(@RequestBody UserVo user){
    JsonResult result = new JsonResult();
    if(user == null){
      result.setState(ConstantState.PARAMETER_ERROR.getCode());
      result.setMessage(ConstantState.PARAMETER_ERROR.getMessage());
      result.setData("注册用户信息不能为空！");
      return result;
    }
    try{
      User user1 = userService.getUserByUsername(user.getUsername());
      if(user1 != null){
        result.setState(ConstantState.USER_EXIST.getCode());
        result.setMessage(ConstantState.USER_EXIST.getMessage());
        result.setData("用户名已存在！");
        return result;
      }else{
        int count = userService.addUser(user);
        if(count == 1){
          result.setState(ConstantState.SUCCESS.getCode());
          result.setMessage(ConstantState.SUCCESS.getMessage());
          result.setData("恭喜您，注册成功！");
          return result;
        }else {
          result.setState(ConstantState.RUNTIME_ERROR.getCode());
          result.setMessage(ConstantState.RUNTIME_ERROR.getMessage());
          result.setData("注册失败，请重试！");
          return result;
        }
      }
    }catch (Exception e){
      result.setState(ConstantState.RUNTIME_ERROR.getCode());
      result.setMessage(ConstantState.RUNTIME_ERROR.getMessage());
      result.setData("注册失败，请重试！");
      e.printStackTrace();
      logger.error("插入数据异常：", e.getMessage());
      return result;
    }
  }
}
