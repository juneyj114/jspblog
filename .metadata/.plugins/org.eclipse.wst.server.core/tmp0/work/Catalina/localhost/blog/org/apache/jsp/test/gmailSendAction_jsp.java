/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.46
 * Generated at: 2019-11-08 01:39:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import java.io.PrintWriter;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import com.cos.util.Gmail;
import javax.mail.Authenticator;
import java.util.Properties;
import com.cos.util.SHA256;

public final class gmailSendAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("javax.mail.Message");
    _jspx_imports_classes.add("javax.mail.internet.InternetAddress");
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("javax.mail.Address");
    _jspx_imports_classes.add("com.cos.util.SHA256");
    _jspx_imports_classes.add("java.util.Properties");
    _jspx_imports_classes.add("javax.mail.Transport");
    _jspx_imports_classes.add("com.cos.util.Gmail");
    _jspx_imports_classes.add("javax.mail.Session");
    _jspx_imports_classes.add("javax.mail.internet.MimeMessage");
    _jspx_imports_classes.add("javax.mail.Authenticator");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
	// 메일 전송
	String to = request.getParameter("email"); // (1) 이메일 받기
 	String from = "acto2001@gmail.com";
 	String code = SHA256.getEncrypt(to, "cos"); // (2) code hash하기
 	
 	// (3) 사용자에게 보낼 메시지
 	String subject = "이메일 인증용 이메일입니다.";
 	StringBuffer sb = new StringBuffer();
 	sb.append("다음 링크에 접속하여 이메일 인증을 진행해주세요.");
 	sb.append("<a href = 'http://localhost:8000/blog/test/gmailCheckAction.jsp?code="+code+"'>");
 	sb.append("이메일 인증하기</a>");
 	String content = sb.toString();
 	
 	// 설정 값
 	Properties p = new Properties();
 	p.put("mail.smtp.user", from); // (4) from
	p.put("mail.smtp.host", "smtp.googlemail.com");
	p.put("mail.smtp.port", "465"); //TLS 587, SSL 465
	p.put("mail.smtp.starttls.enable", "true");
	p.put("mail.smtp.auth", "true");
	p.put("mail.smtp.debug", "true");
	p.put("mail.smtp.socketFactory.port", "465"); 
	p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	p.put("mail.smtp.sockerFactory.fallback", "false");
 	
	// 이메일 전송
	try {
		Authenticator auth = new Gmail(); // (5) 내가 설정한 아이디, 비번 들고오기
		Session ses = Session.getInstance(p, auth);
		ses.setDebug(true);
		MimeMessage msg = new MimeMessage(ses);
		msg.setSubject(subject);
		Address fromAddr = new InternetAddress(from);
		msg.setFrom(fromAddr);
		Address toAddr = new InternetAddress(to);
		msg.addRecipient(Message.RecipientType.TO, toAddr);
		msg.setContent(content, "text/html; charset=UTF8");
		Transport.send(msg);
		// 정상 = 가만히. 비정상 = Back()
	} catch (Exception e) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이메일 인증 오류')");
		script.println("history.back();");
		script.println("</script>");
	}
	
	
 	

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>인증메일이 전송되었습니다.</h1>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
