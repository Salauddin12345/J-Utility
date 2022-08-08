package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.google.gson.*;

public class ServletFour extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
try
{
pw=response.getWriter();
String firstName=request.getParameter("firstName");
String lastName=request.getParameter("lastName");
int age=Integer.parseInt(request.getParameter("age"));
response.setContentType("text/plain");
response.setCharacterEncoding("utf-8");
String newString=firstName+","+lastName+","+age;
pw.print(newString);
pw.flush();
}catch(Exception exception)
{
try
{
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(Exception exc)
{
// do nothing
}
}
}

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(Exception exception)
{
// do nothing
}
}

}
