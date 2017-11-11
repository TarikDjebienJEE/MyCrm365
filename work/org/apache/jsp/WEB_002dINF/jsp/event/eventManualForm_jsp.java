package org.apache.jsp.WEB_002dINF.jsp.event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.DateUtil;
import java.util.List;
import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.entity.EventParameter;

public final class eventManualForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');

// liste des clients existant en base
List<Customer> customers = (List<Customer>) request.getAttribute("customers");
// liste des event type existant en base
List<EventType> eventTypes = (List<EventType>) request.getAttribute("eventTypes");
//liste des eventParameter existant en base et correspondant à l'eventType choisi
List<EventParameter> eventParameters = (List<EventParameter>) request.getAttribute("eventParameters");
String customerSelected = (String) request.getAttribute("customerSelected");
String eventTypeSelected = (String) request.getAttribute("eventTypeSelected");

// messages de retour
String infoCustomersNotExisting = (String) request.getAttribute("infoCustomersNotExisting");
String infoEventTypeNotExisting = (String) request.getAttribute("infoEventTypeNotExisting");
String infoEventParametersNotExisting = (String) request.getAttribute("infoEventParametersNotExisting");
String infoUnsetParameters = (String) request.getAttribute("infoUnsetParameters");

String createEventStatus = (String) request.getAttribute("createEventStatus");

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<div id=\"articleTab\">\n");
      out.write("\t<ul>\n");
      out.write("\t\t<li><a href=\"#createEventByManualAction\">EVENT_MANUAL Creation</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("<section id=\"createEventByManualAction\">\n");
      out.write("<h1>EVENT_MANUAL Creation</h1>\n");
if(createEventStatus != null) { 
      out.write("\n");
      out.write("<p id=\"createEventTypeStatus\">");
      out.print(createEventStatus );
      out.write("</p>\n");
}
      out.write("\n");
      out.write("\t<table>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td><label>Date :</label></td>\n");
      out.write("\t\t\t<td><input id=\"createEventManualDate\" type=\"text\" name=\"createEventManualDate\" size=\"15\" value=\"");
      out.print(DateUtil.todayToString(CRM365Constants.DATE_FORMAT_FR));
      out.write("\" /></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t\t<td><label>Customer select : </label></td>\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t");
 if(customers!=null && !customers.isEmpty()) { 
      out.write("\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t   <select id=\"customerChoice\" name=\"customerChoice\" size=\"1\">\n");
      out.write("\t\t\t\t    ");
 
				    Customer customerSeleted=null;
				      if (customerSelected != null) {
				    	
				    
      out.write("\n");
      out.write("\t\t\t\t    \t<!-- recuperer le customer par rapport à son id renvoyé -->\n");
      out.write("\t\t\t\t    \t");
  for(Customer customer : customers) { 
				    		if(customer.getCustomerId()==Long.parseLong(customerSelected)){
				    			customerSeleted=customer;
				    			}  
				    		}
      out.write("\n");
      out.write("\t\t\t\t    \t\t\n");
      out.write("\t\t\t\t    \t<option value=\"");
      out.print(customerSeleted.getCustomerId());
      out.write('"');
      out.write('>');
      out.print(customerSeleted.getLastName() + " " + customerSeleted.getFirstName());
      out.write("</option>\n");
      out.write("\t\t\t\t    \t\t\t\n");
      out.write("\t\t\t\t    ");

				      }
				      for(Customer customer : customers) { 
				    
      out.write("\n");
      out.write("\t\t\t\t    ");
 String customerCurrent = customer.getLastName() + " " + customer.getFirstName(); 
      out.write("\n");
      out.write("\t\t\t\t  \t\t");
if (customerSeleted!=customer) {
      out.write("\n");
      out.write("\t\t\t\t    \t    <option value=\"");
      out.print(customer.getCustomerId());
      out.write('"');
      out.write('>');
      out.print(customerCurrent);
      out.write("</option>\n");
      out.write("\t\t\t\t    \t ");
} 
      out.write("\n");
      out.write("\t\t\t\t    \t   \n");
      out.write("\t\t\t\t   ");
 }  
      out.write("\n");
      out.write("\t\t\t\t  </select>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t  \n");
      out.write("\t\t\t    </td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t\t\t");
 if(infoCustomersNotExisting != null) { 
      out.write("\n");
      out.write("  \t\t\t\t\t<p id=\"infoCustomersNotExisting\">");
      out.print(infoCustomersNotExisting );
      out.write("</p>\n");
      out.write("\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td><label>Event type select : </label></td>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t");
      out.write("\n");
      out.write("\t\t\t");
 if(eventTypes!=null && !eventTypes.isEmpty()) {
      out.write("\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t<select id=\"eventTypeChoice\" name=\"eventTypeChoice\"  size=\"1\">\n");
      out.write("\t\t\t\t");

					if (eventTypeSelected != null) {
				
      out.write("\n");
      out.write("\t\t\t\t\t\t<option>");
      out.print(eventTypeSelected );
      out.write("</option>\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\n");
      out.write("\t\t\t\t ");
 for(EventType eventType : eventTypes){ 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<option>");
      out.print(eventType.getEventTypeName() );
      out.write("</option>\n");
      out.write("\t\t\t\t ");
 } 
      out.write("\n");
      out.write("\t\t\t\t</select>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t<i>Choose your event to feed parameters</i>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\n");
      out.write("\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t\t");
if(infoEventTypeNotExisting != null) { 
      out.write("\n");
      out.write("  \t\t\t\t<p id=\"infoEventTypeNotExisting\">");
      out.print(infoEventTypeNotExisting );
      out.write("</p>\n");
      out.write("\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t");
      out.write("\n");
      out.write("\t\t\t");
 if(eventParameters!=null && !eventParameters.isEmpty()) {
      out.write("\t\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t\t<td><label>Event Parameters</label></td>\n");
      out.write("\t\t\t\t<td><label>Event Parameters Value</label></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t<table id=\"event_param\" >\n");
      out.write("\t\t    ");
 int i=0;
			  for(EventParameter eventParameter : eventParameters) { 
      out.write("\n");
      out.write("\t\t\t\t <tr>\n");
      out.write("\t\t\t\t\t\t<input id=\"eventParameterName\" name=\"paramName\"\t\ttype=\"hidden\" value=");
      out.print(eventParameter.getEventParameterName() + i);
      out.write("/>\n");
      out.write("\t\t\t\t\t\t<td><label>");
      out.print(eventParameter.getEventParameterName());
      out.write("</label></td>\n");
      out.write("\t\t\t\t\t\t<td><input id=\"eventParameterValue\" name=\"paramValue\" type=\"text\" size=\"40\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t ");
i++;
			  } 
      out.write("\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<input id=\"createEventManual\" name=\"createEventManual\" type=\"submit\" value=\"Save event\"/> \n");
      out.write("\t\t   ");
 } 
		  
			
			if(infoEventParametersNotExisting != null) { 
      out.write("\n");
      out.write("  \t\t\t\t<p id=\"infoEventParametersNotExisting\">");
      out.print(infoEventParametersNotExisting );
      out.write("</p>\n");
      out.write("\t\t\t");
 } 
      out.write("\n");
      out.write("\t</table>\n");
      out.write("</section>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\t\n");
      out.write("\t$(\"#createEventManualDate\").datepicker();\n");
      out.write("\t\n");
      out.write("    /*\n");
      out.write("     * AJAX calls\n");
      out.write("     */\n");
      out.write("    $(\"#eventTypeChoice\").change( function() {\n");
      out.write("\t\t$.ajax({\n");
      out.write("\t\t\ttype: \t\t'POST',\n");
      out.write("\t\t\turl:  \t\t\"loadEventParameters.manualEvent\",\n");
      out.write("\t\t\tdata: \t\t{\n");
      out.write("\t\t\t\t\t\teventTypeChoice: \t\t$(\"#eventTypeChoice\").val(),\n");
      out.write("\t\t\t\t\t\tcustomerChoice:\t\t\t$(\"#customerChoice\").val()\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t$(\"#createEventManual\").click( function() {\n");
      out.write("\t\tvar paramNames = new Array();\n");
      out.write("\t\tvar paramValues = new Array();\n");
      out.write("\t\tvar customerSelected = $(\"#customerChoice\").val();\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t$('input[name=\"paramName\"]').each(function() {\n");
      out.write("    \t\t paramNames.push( $(this).val() );    \n");
      out.write(" \t\t});\n");
      out.write(" \t\t$('input[name=\"paramValue\"]').each(function() {\n");
      out.write("    \t\t paramValues.push( $(this).val() );    \n");
      out.write(" \t\t});\n");
      out.write("\t\n");
      out.write("\t\t$.ajax({\n");
      out.write("\t\t\ttype: \t\t'POST',\n");
      out.write("\t\t\turl:  \t\t\"createEventManual.manualEvent\",\n");
      out.write("\t\t\tdata: \t\t{\n");
      out.write("\t\t\t\t\t\t eventTypeChoice: \t\t$(\"#eventTypeChoice\").val(),\n");
      out.write("\t\t\t\t\t\t customerId: customerSelected,\n");
      out.write("\t\t\t\t\t\t eventParameterName:\tparamNames,\n");
      out.write("\t\t\t\t\t\t eventParameterValue:   paramValues\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t$(\"#createEventTypeStatus\").addClass(\"ui-state-highlight\");\n");
      out.write("    $(\"#infoCustomersNotExisting\").addClass(\"ui-state-error\");\n");
      out.write("    $(\"#infoEventTypeNotExisting\").addClass(\"ui-state-error\");\n");
      out.write("    $(\"#infoEventParametersNotExisting\").addClass(\"ui-state-error\");\n");
      out.write("    \n");
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
