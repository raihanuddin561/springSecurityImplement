<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 

        <title>
            <tiles:insertAttribute name="title" />
        </title>
        
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="body" />
            <tiles:insertAttribute name="footer" />
      