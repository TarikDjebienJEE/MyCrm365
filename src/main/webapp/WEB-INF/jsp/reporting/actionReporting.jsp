<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="java.util.Map" %>

<%-- Variables --%>
<%
	Map<String, Integer> dayData = (Map<String, Integer>) request.getAttribute("dayData");
	
	Map<String, Integer> repartitionData = (Map<String, Integer>) request.getAttribute("repartitionData");
%>

<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#dayReport">Action evolution</a></li>
		<li><a href="#repartitionReport">Action repartition</a></li>
	</ul>
<section>

	<input id="loadReport" type="button" value="Load reporting" /> 

	<div id="hiddenDayData" visibility="hidden">
		<%
		for (Map.Entry<String, Integer> entry : dayData.entrySet()) {
    	%>
	    	<input type="hidden" name="key"   value="<%= entry.getKey()   %>" />
	    	<input type="hidden" name="value" value="<%= entry.getValue() %>" />
		<%
		}
		%>
	</div>

	<div id="dayReport">			
	</div>
	
	<div id="hiddenRepartitionData" visibility="hidden">
		<%
		for (Map.Entry<String, Integer> entry : repartitionData.entrySet()) {
    	%>
	    	<input type="hidden" name="key"   value="<%= entry.getKey()   %>" />
	    	<input type="hidden" name="value" value="<%= entry.getValue() %>" />
		<%
		}
		%>
	</div>
	
	<div id="repartitionReport">
	</div>
	
</section>
</div>

<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">
	
$('#loadReport').click(function() {

	/*
	 * EVENT EVOLUTION
	 */
  	var data = [[]];
	
	$('#hiddenDayData input[name="key"]').each( function() {
		data[0].push( [$(this).val(), $(this).next().val()] );
	});
	
	if (data[0].length > 0) {
	
		$.jqplot(
		'dayReport',
		data, 
		{ 
			axes:{ 
				xaxis: { 
					renderer:$.jqplot.DateAxisRenderer,
					tickOptions:{formatString:'%b %#d, %y'}
				}
			},
			title: 'Number of actions integrated by day',
			seriesDefaults: { 
        		pointLabels: { show: true }
      		},
      		gridPadding:{ left:30, right:30 }
		} 	
		).replot();
		
	}
	
	/*
	 * REPARTITION
	 */
  	var repartitionData = [[]];
	
	$('#hiddenRepartitionData input[name="key"]').each( function() {
		repartitionData[0].push( [$(this).val(), $(this).next().val()] );
	});
  
  	if (data[0].length > 0) {
  	
  		$.jqplot (
  			'repartitionReport', 
  			repartitionData, 
	    	{ 	
	      	title: 'Action type repartition - all time',
	      	seriesDefaults: {
	        	renderer: $.jqplot.PieRenderer, 
	        	rendererOptions: {
	          		showDataLabels: true,
	          		diameter: 200
	        	}
	      	}, 
	      	legend: { show:true, location: 'w' }
	    	}
  		).replot();
  
  	}
  
	
});

</script>