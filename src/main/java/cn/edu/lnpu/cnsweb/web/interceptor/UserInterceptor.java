package cn.edu.lnpu.cnsweb.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 用户访问拦截器
 *
 * @author wangning113
 * @since 2018/5/15
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

  private Logger logger = LoggerFactory.getLogger(UserInterceptor.class);

  /** 视图渲染之后的操作 */
  @Override
  public void afterCompletion(
      HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
      throws Exception {}

  /** 处理请求完成后视图渲染之前的处理操作 */
  @Override
  public void postHandle(
      HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
      throws Exception {}

  /** 进入controller层之前拦截请求 */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj)
      throws Exception {
    logger.info("getContextPath:" + request.getContextPath());
    logger.info("getServletPath:" + request.getServletPath());
    logger.info("getRequestURI:" + request.getRequestURI());
      //获取url地址
      String reqUrl=request.getRequestURI().replace(request.getContextPath(), "");
      //当url地址为登录的url的时候跳过拦截器
      if(reqUrl.contains("/login")){
          return true;
      }else if("/".equals(reqUrl)){
          response.sendRedirect("/home");
      } else{
          HttpSession session=request.getSession();
          Object object=session.getAttribute("username");
          if(object==null||"".equals(object.toString())){
              response.sendRedirect("/login");
          }
      }
      return true;
  }
}
