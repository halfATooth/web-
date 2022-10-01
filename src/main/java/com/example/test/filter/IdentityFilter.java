package com.example.test.filter;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.test.util.JwtUitls;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
@Component
public class IdentityFilter implements Filter {
    private JwtUitls jwtUitls = new JwtUitls();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Map<String, String> map = new HashMap<>();
        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        if (url != null) {
            //登录请求直接放行
            if ("/login".equals(url) || "/signup".equals(url)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            //其他请求验证token
            String token = ((HttpServletRequest) servletRequest).getHeader("token");
            if (StringUtils.isNotBlank(token)) {
                //token验证结果
                int verify = jwtUitls.verify(token);
                if (verify != 1 && verify != 11) {
                    //验证失败
                    if (verify == 2) {
                        map.put("errorMsg", "token已过期");
                        map.put("code", "1");
                    } else if (verify == 0) {
                        map.put("errorMsg", "用户信息验证失败");
                        map.put("code", "2");
                    }
                }else if("/course/addCourse".equals(url) && verify != 11){
                    map.put("errorMsg", "非管理员身份");
                    map.put("code", "4");
                }
                else {
                    //验证成功，放行
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            } else {
                //token为空的返回
                map.put("errorMsg", "未携带token信息");
                map.put("code", "3");
            }
            JSONObject jsonObject = new JSONObject(map);
            servletResponse.setContentType("application/json");
            //设置响应的编码
            servletResponse.setCharacterEncoding("utf-8");
            //响应
            PrintWriter pw = servletResponse.getWriter();
            pw.write(jsonObject.toString());
            pw.flush();
            pw.close();
        }
    }
}
