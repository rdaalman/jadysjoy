<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <g:sortableColumn property="id" title="${message(code: 'user.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="login" title="${message(code: 'user.login.label', default: 'Login')}" />
                        
                            <g:sortableColumn property="password" title="${message(code: 'user.password.label', default: 'Password')}" />
                        
                        	<g:sortableColumn property="naam" title="${message(code: 'user.naam.label', default: 'Naam')}" />                        	
                        
                            <g:sortableColumn property="role" title="${message(code: 'user.role.label', default: 'Role')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                  
                            <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "id")}</g:link></td>
                    
                            <td>${fieldValue(bean: userInstance, field: "login")}</td>
                        
                            <td>********</td>
                            
                            <td>${fieldValue(bean: userInstance, field: "naam")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "role")}</td>
                        
                        </tr>
                    </g:each>               
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
