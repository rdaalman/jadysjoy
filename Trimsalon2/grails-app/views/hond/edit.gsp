<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
             <span class="menuButton"><g:link action="logout">Logout</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${userInstance}">
            <div class="errors">
                <g:renderErrors bean="${userInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${userInstance?.id}" />
                <g:hiddenField name="version" value="${userInstance?.version}" />
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
                                    <g:textField name="geslacht" value="${hondInstance?.geslacht}" />
                                </td>                           
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="kleur"><g:message code="hond.kleur.label" default="Kleur" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: kleurhondInstance, field: 'kleur', 'errors')}">
                                    <g:textField name="kleur" value="${hondInstance?.btw}" />
                                </td>
                             </tr> 
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="gecastreerd"><g:message code="hond.gecastreerd.label" default="Gecastreerd" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'gecastreerd', 'errors')}">
                                    <g:textField name="gecastreerd" value="${hondInstance?.gecastreerd}" />
                                </td>
                             </tr> 
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="geboortedatum"><g:message code="hond.geboortedatum.label" default="Geboortedatum" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'geboortedatum', 'errors')}">
                                    <g:textField name="geboortedatum" value="${hondInstance?.geboortedatum}" />
                                </td>
                             </tr> 
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="klant"><g:message code="hond.klant.label" default="Klant" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: hondInstance, field: 'klant', 'errors')}">
                                    <g:textField name="klant" value="${hondInstance?.klant}" />
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