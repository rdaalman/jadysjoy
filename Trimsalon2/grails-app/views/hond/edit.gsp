

<%@ page import="com.dabis.trimsalon.model.Hond" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hond.label', default: 'Hond')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link action="logout">Logout</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${hondInstance}">
            <div class="errors">
                <g:renderErrors bean="${hondInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${hondInstance?.id}" />
                <g:hiddenField name="version" value="${hondInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="naam"><g:message code="hond.naam.label" default="Naam" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'naam', 'errors')}">
                                    <g:textField name="naam" value="${hondInstance?.naam}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="ras"><g:message code="hond.ras.label" default="Ras" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'ras', 'errors')}">
                                    <g:textField name="ras" value="${hondInstance?.ras}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="geslacht"><g:message code="hond.geslacht.label" default="Geslacht" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'geslacht', 'errors')}">
                                    <g:select name="geslacht" from="${hondInstance.constraints.geslacht.inList}" value="${hondInstance?.geslacht}" valueMessagePrefix="hond.geslacht"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="gecastreerd"><g:message code="hond.gecastreerd.label" default="Gecastreerd" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'gecastreerd', 'errors')}">
                                    <g:select name="gecastreerd" from="${hondInstance.constraints.gecastreerd.inList}" value="${hondInstance?.gecastreerd}" valueMessagePrefix="hond.gecastreerd"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="kleur"><g:message code="hond.kleur.label" default="Kleur" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'kleur', 'errors')}">
                                    <g:textField name="kleur" value="${hondInstance?.kleur}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="leeftijd"><g:message code="hond.leeftijd.label" default="Leeftijd" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'leeftijd', 'errors')}">
                                    <g:textField name="leeftijd" value="${fieldValue(bean: hondInstance, field: 'leeftijd')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="klant"><g:message code="hond.klant.label" default="Klant" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'klant', 'errors')}">
                                    <g:select name="klant.id" from="${com.dabis.trimsalon.model.Klant.list()}" optionKey="id" value="${hondInstance?.klant?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="afspraken"><g:message code="hond.afspraken.label" default="Afspraken" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'afspraken', 'errors')}">
                                    
<ul>
<g:each in="${hondInstance?.afspraken?}" var="a">
    <li><g:link controller="afspraak" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="afspraak" action="create" params="['hond.id': hondInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'afspraak.label', default: 'Afspraak')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="opmerkingen"><g:message code="hond.opmerkingen.label" default="Opmerkingen" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'opmerkingen', 'errors')}">
                                    
<ul>
<g:each in="${hondInstance?.opmerkingen?}" var="o">
    <li><g:link controller="opmerking" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="opmerking" action="create" params="['hond.id': hondInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'opmerking.label', default: 'Opmerking')])}</g:link>

                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Weet je zeker dat je dit wilt verwijderen?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
