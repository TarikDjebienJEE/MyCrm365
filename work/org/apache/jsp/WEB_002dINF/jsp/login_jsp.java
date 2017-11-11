package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


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

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');

	String authentificationFailed = (String) request.getAttribute("errorLogin");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "head.jsp", out, false);
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div id=\"main_wrapper\">\n");
      out.write("\t");
      out.write("\n");
      out.write("\t<header>\n");
      out.write("\t\t<h1>CRM 365 Authentification</h1>\n");
      out.write("\t</header>\n");
      out.write("\n");
      out.write("\t");
      out.write("\n");
      out.write("\t<section id=\"sectionLogin\">\n");
      out.write("\t\n");
      out.write("\t\t");
      out.write("\n");
      out.write("\t\t<form action=\"j_spring_security_check\" method=\"post\">\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"align\">\n");
      out.write("\t\t\t\t<label for=\"j_username\">Login</label> \n");
      out.write("\t\t\t\t<input id=\"j_username\" name=\"j_username\" size=\"20\" maxlength=\"50\" type=\"text\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"align\">\n");
      out.write("\t\t\t\t<label for=\"j_password\">Password</label> \n");
      out.write("\t\t\t\t<input id=\"j_password\" name=\"j_password\" size=\"20\" maxlength=\"50\" type=\"password\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"loginFormButton\" class=\"alignButton\">\n");
      out.write("\t\t\t\t<input id=\"login_button\" class=\"crmButton loginButton\" value=\"login\" type=\"submit\" /> \n");
      out.write("\t\t\t\t<input value=\"reset\" class=\"crmButton loginButton\" type=\"reset\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</form>\n");
      out.write("\t\t");

			if (authentificationFailed != null) {
		
      out.write("\n");
      out.write("\t\t\t<p id=\"loginInvalidMessage\" class=\"ui-state-error\">");
      out.print(authentificationFailed);
      out.write("</p>\n");
      out.write("\t\t");

			}
		
      out.write("\n");
      out.write("\t</section>\n");
      out.write("\n");
      out.write("\t");
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
