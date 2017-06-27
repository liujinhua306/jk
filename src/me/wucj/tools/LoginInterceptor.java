package me.wucj.tools;



import me.wucj.Login.Action.LoginAction;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{  
	  
    @Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
        String result = "";  
            //因为要把这个拦截器设置成默认拦截器，所以如果是登陆的action则跳过。  
            if(LoginAction.class==invocation.getAction().getClass()){  
                return invocation.invoke();  
            }  
            //取session中的username，如果等于null则没有登陆，返回input跳转到登陆页面  
            ServletActionContext.getRequest().getSession().getAttribute("admin");
        if(ServletActionContext.getRequest().getSession().getAttribute("admin")==null){  
                return "input";  
            }  
        result = invocation.invoke();  
        return result;  
    }  
}
