<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'poot.gif')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
        <div id="grailsLogo"><a href="http://www.jadysjoy.nl"><img src="${resource(dir:'images',file:'Logo.png')}" alt="Grails" border="0" /></a></div>
		<g:render template="/layouts/header" />
		<g:layoutBody />		
		<g:render template="/layouts/footer" />
    </body>
</html>