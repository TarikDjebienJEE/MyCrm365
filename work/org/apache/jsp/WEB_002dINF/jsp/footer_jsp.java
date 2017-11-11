package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.DateUtil;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody.release();
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<footer>\n");
      out.write("  <p id=\"copyright\">© Copyright CRM365 - ");
      out.print(DateUtil.todayToString(CRM365Constants.DATE_FORMAT_FR));
      out.write("</p>\n");
      out.write("  <p id=\"appVersion\">Version : 3.0 </p>\n");
      out.write("  <p id=\"languages\">");
      if (_jspx_meth_spring_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("\t\n");
      out.write("\t/* Utililsees pour remettre l'onglet selectionne apres rafrichissement ajax */\n");
      out.write("\tvar articleTab;\n");
      out.write("\tvar selectedBeforeAjax;\n");
      out.write("\n");
      out.write("\t$(\".crmButton\").button();\n");
      out.write("\t\n");
      out.write("\t$(\"article, aside\").ajaxSend(function() {\n");
      out.write("\t\t$(this).fadeOut();\n");
      out.write("\t\t\n");
      out.write("\t\tselectedBeforeAjax = $(\"article #articleTab\").tabs('option', 'selected');\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t/*\n");
      out.write("\t * Recupération réponse et affichage article\n");
      out.write("\t */\n");
      out.write("\t$(\"article, aside\").ajaxSuccess(function(e, xhr, settings) {\n");
      out.write("\t\tif ( (settings.url == 'search.customer') || (settings.url == 'searchForm.customer') || (settings.url == 'customerDetail.customer') || (settings.url == 'updateFreeValCustomerRow.customer'))\n");
      out.write("\t\t\t$(\"aside\").html(xhr.responseText);\n");
      out.write("\t\telse \n");
      out.write("\t\t\t$(\"article\").html(xhr.responseText);\t\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t/*\n");
      out.write("\t * Code execute apres reponse requete ajax recue\n");
      out.write("\t * Rafraichissement des boutons pour style\n");
      out.write("\t */\n");
      out.write("\t$(\"article, aside\").ajaxComplete(function() {\n");
      out.write("\t\t$(this).fadeIn();\n");
      out.write("\t\t\n");
      out.write("\t\t$('input[type=\"submit\"], input[type=\"button\"]').addClass(\"crmButton\");\t\t\n");
      out.write("\t\t$(\".crmButton\").button();\n");
      out.write("\t\t\n");
      out.write("\t\tarticleTab = $(\"article #articleTab\").tabs();\n");
      out.write("\t\t$(\"aside #articleTab\").tabs();\n");
      out.write("\t\t\n");
      out.write("\t\tarticleTab.tabs('select', selectedBeforeAjax); \n");
      out.write("\t\t\n");
      out.write("\t\t$(\".infoNotification\").addClass(\"ui-state-highlight\");\n");
      out.write("\t\t$(\".errorNotification\").addClass(\"ui-state-error\");\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t/*\n");
      out.write("\t * Affichage message access interdit si pas les droits\n");
      out.write("\t */\n");
      out.write("\t$(\"article, aside\").ajaxError(function(e, xhr, settings, exception) {\n");
      out.write("\t\tif (xhr.status == 403)\n");
      out.write("\t\t\t$(this).html(\"<div id='articleTab'><ul><li><a href='#secureTab'>SECURE PAGE</a></li></ul><section id='secureTab'><p id='infoError'>You cannot access to this page</p></section></div>\");\n");
      out.write("\t\telse\n");
      out.write("\t\t\t$(this).html(\"<div id='articleTab'><ul><li><a href='#errorTab'>ERROR</a></li></ul><section id='errorTab'><p id='infoError'>Internal application error</p></section></div>\");\n");
      out.write("\t\t\t\n");
      out.write("\t\t$(\"#infoError\").addClass(\"ui-state-error\");\n");
      out.write("\t\tarticleTab = $(\"#articleTab\").tabs();\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t/*\n");
      out.write("\t * Notifications de succes ou de failure\n");
      out.write("\t */\n");
      out.write("\t$(\".infoNotification\").addClass(\"ui-state-highlight\");\n");
      out.write("\t$(\".errorNotification\").addClass(\"ui-state-error\");\n");
      out.write("</script>");
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

  private boolean _jspx_meth_spring_005fmessage_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f0.setParent(null);
    // /WEB-INF/jsp/footer.jsp(15,20) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setCode("test.language");
    int[] _jspx_push_body_count_spring_005fmessage_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f0 = _jspx_th_spring_005fmessage_005f0.doStartTag();
      if (_jspx_th_spring_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f0);
    }
    return false;
  }
}
