package com.shopgenie.action.login;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.shopgenie.dao.AdminDao;
import com.shopgenie.entities.Admin;

@Results({@Result(name="success",location="/admin/AdminHome.jsp"),@Result(name="login",location="/admin/login.jsp")})
public class AdminAction extends ActionSupport
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    Admin admin=new Admin();
    @Action(value="/Adminlogin")
    public String execute()
    {
	AdminDao adminDao=new AdminDao();
	if(adminDao.getByName(name)==null)
	{
	    return LOGIN;
	}
	else
	{
	    admin=adminDao.getByName(name);
	    if(admin.getPassword().equals(password)){
		return SUCCESS;
	    }
	    return LOGIN;
	}
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}
