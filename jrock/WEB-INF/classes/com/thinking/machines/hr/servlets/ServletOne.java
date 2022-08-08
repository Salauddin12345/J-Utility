package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.google.gson.*;

public class ServletOne extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
Gson gson=new Gson();
PrintWriter pw=response.getWriter();
response.setContentType("application/json");
response.setCharacterEncoding("utf-8");
DesignationDAO designationDAO=new DesignationDAO();
List<DesignationDTO> list=designationDAO.getAll();
String jsonString=gson.toJson(list);
pw.print(jsonString);
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

public void doPost(HttpServletRequest request,HttpServletResponse response)
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
