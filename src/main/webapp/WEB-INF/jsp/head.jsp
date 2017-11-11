<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title><spring:message code="title" /></title>
		<link type="text/css" href="<%=request.getContextPath()%>/CharteGraphiqueCRM365/jqueryui/css/custom-theme/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
		<link type="text/css" href="<%=request.getContextPath()%>/CharteGraphiqueCRM365/css/crm365.css" rel="stylesheet" />	
		<script type="text/javascript" src="<%=request.getContextPath()%>/CharteGraphiqueCRM365/jqueryui/js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/CharteGraphiqueCRM365/jqueryui/js/jquery-ui-1.8.18.custom.min.js"></script>
		
		<link type="text/css" href="<%=request.getContextPath()%>/CharteGraphiqueCRM365/jqplot/jquery.jqplot.css" rel="stylesheet" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/CharteGraphiqueCRM365/jqplot/jquery.jqplot.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/CharteGraphiqueCRM365/jqplot/plugins/jqplot.dateAxisRenderer.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/CharteGraphiqueCRM365/jqplot/plugins/jqplot.pointLabels.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/CharteGraphiqueCRM365/jqplot/plugins/jqplot.pieRenderer.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/CharteGraphiqueCRM365/jqplot/plugins/jqplot.donutRenderer.min.js"></script>
		
		<script type="text/javascript" src="<%=request.getContextPath()%>/CharteGraphiqueCRM365/dataTables/js/jquery.dataTables.min.js"></script>
		<link type="text/css" href="<%=request.getContextPath()%>/CharteGraphiqueCRM365/dataTables/css/jquery.dataTables.css" rel="stylesheet" />
		
		<%-- COMPATIBILITE HTML5 Internet Exploxer pour CSS3 --%>
		
		<!--[if lt IE 9]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		
		<!--[if lte IE 7]>
			<link type="text/css" href="<%=request.getContextPath()%>/CharteGraphiqueCRM365/css/crm365_IE.css" rel="stylesheet" />	
		<![endif]-->
</head>
