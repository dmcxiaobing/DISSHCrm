package com.david.disshcrm.common.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.david.disshcrm.utils.LogUtils;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//通过RequestAware, SessionAware, ApplicationAware实行接口获得request,session,application对象，action中就可直接调用
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class BaseAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware {
    private static Logger log = Logger.getLogger(BaseAction.class);

    private static final long serialVersionUID = 1L;

    protected Map<String, Object> request;
    protected Map<String, Object> session;
    protected Map<String, Object> application;

    public Map<String, Object> getRequest() {
        return request;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Map<String, Object> getApplication() {
        return application;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    /**
     * 获取request对象
     */
    public HttpServletRequest getHttpServletRequest() {
        return ServletActionContext.getRequest();
    }

    /**
     * 获取response对象
     */
    public HttpServletResponse getHttpServletResponse() {
        return ServletActionContext.getResponse();
    }

    /**
     * 向客户端响应数据
     *
     * @param msg 响应的内容
     * @throws IOException
     */
    public void responseWrite(String msg) throws IOException {
        HttpServletResponse response = this.getHttpServletResponse();
        response.setContentType("text/html;charset=UTF-8");
        // 获取输出流
        PrintWriter writer = response.getWriter();
        writer.print(msg);

    }

    /**
     * 将对象放入值栈的栈顶  操作对象
     */
    public void push(Object obj) {
        ActionContext.getContext().getValueStack().push(obj);
    }

    /**
     * 将key-value对放入值栈的 context中
     * 操作集合
     */
    public void put(String key, Object value) {
        ActionContext.getContext().put(key, value);
    }
}
