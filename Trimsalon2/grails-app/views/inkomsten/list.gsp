
<%@ page import="com.dabis.trimsalon.model.Inkomsten" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'inkomsten.label', default: 'Inkomsten')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="user" action="logout">Logout</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'inkomsten.id.label', default: 'Id')}" />
                        
                            <th><g:message code="inkomsten.afspraak.label" default="Afspraak" /></th>
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'inkomsten.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="betaald" title="${message(code: 'inkomsten.betaald.label', default: 'Betaald')}" />
                            
                            <g:sortableColumn property="prijsExbtw" title="${message(code: 'inkomsten.prijsExbtw.label', default: 'Prijs exbtw')}" />
                            
                            <g:sortableColumn property="prijs" title="${message(code: 'inkomsten.prijs.label', default: 'Prijs')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${inkomstenInstanceList}" status="i" var="inkomstenInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${inkomstenInstance.id}">${fieldValue(bean: inkomstenInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: inkomstenInstance, field: "afspraak")}</td>
                        
                            <td><g:formatDate date="${inkomstenInstance.dateCreated}" /></td>
                        
                            <td><g:formatBoolean boolean="${inkomstenInstance.betaald}" /></td>
                        	
                        	<td>€<g:formatNumber number="${inkomstenInstance?.afspraak?.producten?.prijsExbtw}" format="##0.00"/></td>               	                                                    	
                        	
                        	<td>€<g:formatNumber number="${inkomstenInstance?.afspraak?.producten.prijs}" format="##0.00"/></td>
                        	
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${inkomstenInstanceTotal}" />
            </div>
        </div>
    </body>
</html>