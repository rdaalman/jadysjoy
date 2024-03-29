grails.project.class.dir = "web-app/WEB-INF/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
		
		// Details from docx4j Getting Started Guide at http://dev.plutext.org/svn/docx4j/trunk/docx4j/docs/Docx4j_GettingStarted.html
		mavenRepo "http://dev.plutext.org/svn/docx4j/trunk/docx4j/m2"
		mavenRepo "https://webdavclient4j.svn.sourceforge.net/svnroot/webdavclient4j/trunk/m2"
	}
	dependencies {
		compile 'org.docx4j:docx4j:2.7.0'
	    // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'
    }
}
