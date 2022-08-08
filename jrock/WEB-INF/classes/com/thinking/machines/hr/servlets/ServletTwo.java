package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.google.gson.*;

public class ServletTwo extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
try
{
pw=response.getWriter();
int code=Integer.parseInt(request.getParameter("code"));
Gson gson=new Gson();
response.setContentType("text/plain");
response.setCharacterEncoding("utf-8");
DesignationDAO designationDAO=new DesignationDAO();
DesignationDTO designation=designationDAO.getByCode(code);
String newString=designation.getCode()+","+designation.getTitle();
pw.print(newString);
pw.flush();
}catch(Exception exception)
{
try
{
pw.print("invalid");
pw.flush();
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(Exception exc)
{
// do nothing
}
}
}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
System.out.println("tool");
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(Exception exception)
{
// do nothing
}
}

}
