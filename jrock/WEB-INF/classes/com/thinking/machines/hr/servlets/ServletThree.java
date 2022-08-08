package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.google.gson.*;

public class ServletThree extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
try
{
BufferedReader br=request.getReader();
StringBuffer sb=new StringBuffer();
String g;
while(true)
{
g=br.readLine();
if(g==null) break;
sb.append(g);
}
String jsonString=sb.toString();
pw=response.getWriter();
Gson gson=new Gson();
Customer c=gson.fromJson(jsonString,Customer.class);
response.setContentType("text/json");
response.setCharacterEncoding("utf-8");
pw.print(gson.toJson(c));
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
