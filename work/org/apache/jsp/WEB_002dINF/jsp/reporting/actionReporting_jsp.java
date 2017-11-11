package org.apache.jsp.WEB_002dINF.jsp.reporting;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;

public final class actionReporting_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');

	Map<String, Integer> dayData = (Map<String, Integer>) request.getAttribute("dayData");
	
	Map<String, Integer> repartitionData = (Map<String, Integer>) request.getAttribute("repartitionData");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<div id=\"articleTab\">\n");
      out.write("\t<ul>\n");
      out.write("\t\t<li><a href=\"#dayReport\">Action evolution</a></li>\n");
      out.write("\t\t<li><a href=\"#repartitionReport\">Action repartition</a></li>\n");
      out.write("\t</ul>\n");
      out.write("<section>\n");
      out.write("\n");
      out.write("\t<input id=\"loadReport\" type=\"button\" value=\"Load reporting\" /> \n");
      out.write("\n");
      out.write("\t<div id=\"hiddenDayData\" visibility=\"hidden\">\n");
      out.write("\t\t");

		for (Map.Entry<String, Integer> entry : dayData.entrySet()) {
    	
      out.write("\n");
      out.write("\t    \t<input type=\"hidden\" name=\"key\"   value=\"");
      out.print( entry.getKey()   );
      out.write("\" />\n");
      out.write("\t    \t<input type=\"hidden\" name=\"value\" value=\"");
      out.print( entry.getValue() );
      out.write("\" />\n");
      out.write("\t\t");

		}
		
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div id=\"dayReport\">\t\t\t\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div id=\"hiddenRepartitionData\" visibility=\"hidden\">\n");
      out.write("\t\t");

		for (Map.Entry<String, Integer> entry : repartitionData.entrySet()) {
    	
      out.write("\n");
      out.write("\t    \t<input type=\"hidden\" name=\"key\"   value=\"");
      out.print( entry.getKey()   );
      out.write("\" />\n");
      out.write("\t    \t<input type=\"hidden\" name=\"value\" value=\"");
      out.print( entry.getValue() );
      out.write("\" />\n");
      out.write("\t\t");

		}
		
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div id=\"repartitionReport\">\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("</section>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("\t\n");
      out.write("$('#loadReport').click(function() {\n");
      out.write("\n");
      out.write("\t/*\n");
      out.write("\t * EVENT EVOLUTION\n");
      out.write("\t */\n");
      out.write("  \tvar data = [[]];\n");
      out.write("\t\n");
      out.write("\t$('#hiddenDayData input[name=\"key\"]').each( function() {\n");
      out.write("\t\tdata[0].push( [$(this).val(), $(this).next().val()] );\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\tif (data[0].length > 0) {\n");
      out.write("\t\n");
      out.write("\t\t$.jqplot(\n");
      out.write("\t\t'dayReport',\n");
      out.write("\t\tdata, \n");
      out.write("\t\t{ \n");
      out.write("\t\t\taxes:{ \n");
      out.write("\t\t\t\txaxis: { \n");
      out.write("\t\t\t\t\trenderer:$.jqplot.DateAxisRenderer,\n");
      out.write("\t\t\t\t\ttickOptions:{formatString:'%b %#d, %y'}\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\ttitle: 'Number of actions integrated by day',\n");
      out.write("\t\t\tseriesDefaults: { \n");
      out.write("        \t\tpointLabels: { show: true }\n");
      out.write("      \t\t},\n");
      out.write("      \t\tgridPadding:{ left:30, right:30 }\n");
      out.write("\t\t} \t\n");
      out.write("\t\t).replot();\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t/*\n");
      out.write("\t * REPARTITION\n");
      out.write("\t */\n");
      out.write("  \tvar repartitionData = [[]];\n");
      out.write("\t\n");
      out.write("\t$('#hiddenRepartitionData input[name=\"key\"]').each( function() {\n");
      out.write("\t\trepartitionData[0].push( [$(this).val(), $(this).next().val()] );\n");
      out.write("\t});\n");
      out.write("  \n");
      out.write("  \tif (data[0].length > 0) {\n");
      out.write("  \t\n");
      out.write("  \t\t$.jqplot (\n");
      out.write("  \t\t\t'repartitionReport', \n");
      out.write("  \t\t\trepartitionData, \n");
      out.write("\t    \t{ \t\n");
      out.write("\t      \ttitle: 'Action type repartition - all time',\n");
      out.write("\t      \tseriesDefaults: {\n");
      out.write("\t        \trenderer: $.jqplot.PieRenderer, \n");
      out.write("\t        \trendererOptions: {\n");
      out.write("\t          \t\tshowDataLabels: true,\n");
      out.write("\t          \t\tdiameter: 200\n");
      out.write("\t        \t}\n");
      out.write("\t      \t}, \n");
      out.write("\t      \tlegend: { show:true, location: 'w' }\n");
      out.write("\t    \t}\n");
      out.write("  \t\t).replot();\n");
      out.write("  \n");
      out.write("  \t}\n");
      out.write("  \n");
      out.write("\t\n");
      out.write("});\n");
      out.write("\n");
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
}
