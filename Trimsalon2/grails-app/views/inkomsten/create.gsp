

<%@ page import="com.dabis.trimsalon.model.Inkomsten" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'inkomsten.label', default: 'Inkomsten')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${inkomstenInstance}">
            <div class="errors">
                <g:renderErrors bean="${inkomstenInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="afspraak"><g:message code="inkomsten.afspraak.label" default="Afspraak" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: inkomstenInstance, field: 'afspraak', 'errors')}">
                                    <g:select name="afspraak.id" from="${com.dabis.trimsalon.model.Afspraak.list()}" optionKey="id" value="${inkomstenInstance?.afspraak?.id}"/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="betaald"><g:message code="inkomsten.betaald.label" default="Betaald" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: inkomstenInstance, field: 'betaald', 'errors')}">
                                    <g:checkBox name="betaald" value="${inkomstenInstance?.betaald}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
                </g:form>
        </div>
    </body>
</html>
