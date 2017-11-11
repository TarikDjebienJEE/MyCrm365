package org.apache.jsp.WEB_002dINF.jsp.event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.miage.crm365.utils.DateUtil;
import java.util.List;
import java.util.Map;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.utils.CRM365Constants;

public final class eventForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');

	String createEventTypeStatus = (String) request.getAttribute("createEventTypeStatus");
	String errorEventTypeStatus = (String) request.getAttribute("errorEventTypeStatus");
	String createEventParameterStatus = (String) request.getAttribute("createEventParameterStatus");
	String infoUnsetParameters = (String) request.getAttribute("infoUnsetParameters");
  
	List<EventType> eventTypesAvailable = (List<EventType>) request.getAttribute("eventTypesAvailable");
	String eventTypesUnavailable = (String) request.getAttribute("eventTypesUnavailable");
	Map<EventType, List<EventParameter>> eventsConfiguration = (Map<EventType, List<EventParameter>>) request.getAttribute("eventsConfiguration");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<div id=\"articleTab\">\n");
      out.write("\t<ul>\n");
      out.write("\t\t<li><a href=\"#eventsConfiguration\">EVENT CONFIGURATION</a></li>\n");
      out.write("\t\t<li><a href=\"#createEventType\">EVENT_TYPE Creation</a></li>\n");
      out.write("\t\t<li><a href=\"#createEventParameter\">EVENT_PARAMETER Creation</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("<section id=\"eventsConfiguration\">\n");
      out.write("<h1>Configuration</h1>\n");
      out.write("\n");
      out.write("<table id=\"eventsConfigTable\" class=\"dataTables\">\n");
      out.write("<thead>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<th>Event type</th>\n");
      out.write("\t\t<th>Parameters</th>\n");
      out.write("\t</tr>\n");
      out.write("</thead>\n");
      out.write("<tbody>\n");

   if (eventsConfiguration != null) {
	for (Map.Entry<EventType, List<EventParameter>> entry : eventsConfiguration.entrySet()) {

      out.write("\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td>\n");
      out.write("\t\t\t");
      out.print( entry.getKey().getEventTypeName()   );
      out.write("\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td>\n");
      out.write("\t");
 
		if (entry.getValue().isEmpty()) {
	
      out.write("\n");
      out.write("\t\t\tAny parameters configured\n");
      out.write("\t");

		}
	
      out.write("\n");
      out.write("\t<ul>\n");
      out.write("\t");
 	
		for (EventParameter param : entry.getValue()) {
	
      out.write("\n");
      out.write("\t\t\t<li>\n");
      out.write("\t\t\t");
      out.print( param.getEventParameterName()		 	);
      out.write("\n");
      out.write("\t\t\t: \n");
      out.write("\t\t\t");
      out.print( param.getEventParameterDescription() 	);
      out.write("\n");
      out.write("\t\t\t</li>\n");
      out.write("\t");

		}
	
      out.write("\n");
      out.write("\t</ul>\n");
      out.write("\t\t</td>\n");
      out.write("\t</tr>\n");

	}
   }

      out.write("\n");
      out.write("</tbody>\n");
      out.write("</table>\n");
      out.write("</section>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("<section id=\"createEventType\">\n");
      out.write("<h1>EVENT_TYPE Creation</h1>\n");
if(createEventTypeStatus != null) { 
      out.write("\n");
      out.write("<p id=\"createEventTypeStatus\">");
      out.print(createEventTypeStatus );
      out.write("</p>\n");
}
      out.write('\n');
if(errorEventTypeStatus != null) { 
      out.write("\n");
      out.write("<p id=\"errorEventTypeStatus\">");
      out.print(errorEventTypeStatus );
      out.write("</p>\n");
}
      out.write("\n");
      out.write("\t<table>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td><label>Event :</label></td>\n");
      out.write("\t\t\t<td><input id=\"createEventTypeName\" type=\"text\" name=\"createEventTypeName\" size=\"25\" /></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td><label>Description : </label></td>\n");
      out.write("\t\t\t<td><input id=\"createEventTypeDescription\" type=\"text\" name=\"createEventTypeDescription\" size=\"50\" /></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t<input id=\"addEventType\" type=\"submit\" value=\"Add Event Type\" /> \n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</table>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("\n");
      out.write("<section id=\"createEventParameter\">\n");
      out.write("<h1>EVENT_PARAMETER Creation</h1>\n");
if(createEventParameterStatus != null &&  ! createEventParameterStatus.equals("") ) { 
      out.write("\n");
      out.write("<p id=\"createEventParameterStatus\">");
      out.print(createEventParameterStatus );
      out.write("</p>\n");
}
      out.write('\n');
if(infoUnsetParameters != null) { 
      out.write("\n");
      out.write("<p id=\"infoUnsetParameters\">");
      out.print(infoUnsetParameters );
      out.write("</p>\n");
}
      out.write("\n");
      out.write("\t<table id=\"addEventParameter\">\n");
      out.write("\t\t<thead>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><label>Event choice : </label></td>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t");
 if(eventTypesAvailable!=null && !eventTypesAvailable.isEmpty()) {
      out.write("\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t   <select id=\"eventChoice\" name=\"eventChoice\" size=\"1\">\n");
      out.write("\t\t\t\t    ");
 for(EventType eventType : eventTypesAvailable){ 
      out.write("\n");
      out.write("\t\t\t\t    <option>");
      out.print(eventType.getEventTypeName());
      out.write("</option>\n");
      out.write("\t\t\t\t    ");
} 
      out.write("\n");
      out.write("\t\t\t\t   </select>\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t\t");
} 
      out.write("\n");
      out.write("\t\t    </tr>\n");
      out.write("\t\t</thead>\n");
      out.write("\t\t");
 if(eventTypesAvailable!=null && !eventTypesAvailable.isEmpty()) {
      out.write("\n");
      out.write("\t\t<tbody>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th>Parameter Name</th>\n");
      out.write("\t\t\t\t<th>Parameter Description</th>\n");
      out.write("\t\t\t\t<th><input id=\"addParam\" type=\"button\" name=\"addParam\" value=\"Add row\" /></th>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"paramName\" size=\"25\" /></td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"paramValue\" size=\"25\" /></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</tbody>\n");
      out.write("\t\t<tfoot>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t  <input id=\"saveEventParameter\" type=\"submit\" name=\"submitButton\" value=\"saveEventParameter\" /> \n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</tfoot>\n");
      out.write("\t\t");
} 
      out.write("\n");
      out.write("\t</table>\n");
if(eventTypesUnavailable != null) { 
      out.write("\n");
      out.write("  <p id=\"eventTypesUnavailable\">");
      out.print(eventTypesUnavailable );
      out.write("</p>\n");
}
      out.write("\n");
      out.write("</section>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("$(document).ready(function(){\n");
      out.write("\t\n");
      out.write("\t/*\n");
      out.write("\t * Ajout dynamique d'une nouvelle ligne eventParameter\n");
      out.write("\t * @Author : tarik Djebien\n");
      out.write("\t */\n");
      out.write("\t var cpt = 1;\n");
      out.write("\t $(\"#addParam\").click( function() {\n");
      out.write("\t \t\t$('#addEventParameter > tbody:last')\n");
      out.write("\t\t\t\t.append(\"<tr><td><input type='text' name='paramName' size='25' /></td><td><input type='text' name='paramValue' size='25' /></td><td><input type='button' id='deleteParam' class='crmButton' value='Delete row' /></td></tr>\");\n");
      out.write("\t\t\t$(\".crmButton\").button();\n");
      out.write("\t });\n");
      out.write("\t \n");
      out.write("\t /*\n");
      out.write("\t  * Suppression dynamique d'une nouvelle ligne\n");
      out.write("\t  * avec propagation des evenements\n");
      out.write("\t  * @Author : tarik Djebien\n");
      out.write("\t  */\n");
      out.write("\t  $(\"#deleteParam\").live('click', function() {\n");
      out.write("\t\t $($(this).parent().parent()).remove();\n");
      out.write("\t  });\n");
      out.write("\t  \n");
      out.write("});\n");
      out.write("\n");
      out.write("/*\n");
      out.write(" * AJAX form call\n");
      out.write(" */\n");
      out.write("$(\"#addEventType\").click( function() {\n");
      out.write("\t$.ajax({\n");
      out.write("\t\ttype: \t\t'POST',\n");
      out.write("\t\turl:  \t\t\"createEventType.event\",\n");
      out.write("\t\tdata: \t\t{createEventTypeName: \t\t\t$(\"#createEventTypeName\").val(),\n");
      out.write("\t\t\t\t\t createEventTypeDescription:\t$(\"#createEventTypeDescription\").val()}\n");
      out.write("\t});\n");
      out.write("});\n");
      out.write("\t\n");
      out.write("$(\"#saveEventParameter\").click( function() {\n");
      out.write("\tvar paramNames = new Array();\n");
      out.write("\tvar paramValues = new Array();\n");
      out.write("\t\t\n");
      out.write("\t$('input[name=\"paramName\"]').each(function() {\n");
      out.write("    \t paramNames.push( $(this).val() );    \n");
      out.write(" \t});\n");
      out.write(" \t$('input[name=\"paramValue\"]').each(function() {\n");
      out.write("    \t paramValues.push( $(this).val() );    \n");
      out.write(" \t});\n");
      out.write("\n");
      out.write("\t$.ajax({\n");
      out.write("\t\ttype: \t\t'POST',\n");
      out.write("\t\turl:  \t\t\"saveEventParameter.event\",\n");
      out.write("\t\tdata: \t\t{\n");
      out.write("\t\t\t\t\teventChoice: \t\t\t$(\"#eventChoice\").val(),\n");
      out.write("\t\t\t\t\teventParameterName:\t\tparamNames,\n");
      out.write("\t\t\t\t\teventParameterValue:   \tparamValues\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t});\n");
      out.write("});\n");
      out.write("\n");
      out.write("$(\"#createEventTypeStatus\").addClass(\"ui-state-highlight\");\n");
      out.write("$(\"#createEventParameterStatus\").addClass(\"ui-state-highlight\");\n");
      out.write("$(\"#errorEventTypeStatus\").addClass(\"ui-state-error\");\n");
      out.write("$(\"#eventTypesUnavailable\").addClass(\"ui-state-error\");\n");
      out.write("$(\"#infoUnsetParameters\").addClass(\"ui-state-error\");\n");
      out.write("\n");
      out.write("$(document).ready(function() {\n");
      out.write("\t$('.dataTables').dataTable( { \"bJQueryUI\": true } );\n");
      out.write("} );\n");
      out.write("\n");
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
