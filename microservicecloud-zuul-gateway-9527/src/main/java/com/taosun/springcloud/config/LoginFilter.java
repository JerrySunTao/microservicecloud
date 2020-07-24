package com.taosun.springcloud.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *  编辑ZuulFilter自定义过滤器，用于校验登录
 *  重写zuulFilter类，有四个重要的方法
 *  1.- `shouldFilter`：返回一个`Boolean`值，判断该过滤器是否需要执行。返回true执行，返回false不执行。
 *  2.- `run`：过滤器的具体业务逻辑。
 *  3.- `filterType`：返回字符串，代表过滤器的类型。包含以下4种：
 *      - `pre`：请求在被路由之前执行
 *      - `routing`：在路由请求时调用
 *      - `post`：在routing和errror过滤器之后调用
 *      - `error`：处理请求时发生错误调用
 *  4.- `filterOrder`：通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高
 *
 *
 */
@Component
public class LoginFilter extends ZuulFilter {

    @Override
    public Object run() {
        // 登录校验逻辑
        // 1）获取zuul提供的请求上下文对象（即是请求全部内容）
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 2) 从上下文中获取request对象
        HttpServletRequest request = currentContext.getRequest();
        // 3) 从请求中获取token
        String token = request.getParameter("access-token");
        // 4) 判断（如果没有token，认为用户还没有登录，返回401状态码）
        if(token == null || "".equals(token.trim())){
            // 没有token，认为登录校验失败，进行拦截
            currentContext.setSendZuulResponse(false);
            // 返回401状态码。也可以考虑重定向到登录页
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            currentContext.setResponseBody("111111");
        }

        // 如果校验通过，可以考虑吧用户信息放入上下文，继续向后执行
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

}
