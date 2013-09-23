docrepo
=======

DMS dev site

1. Setup dev env.
 - Recemonded IDE is Netbeans. 
 - Recemonded dev app server is JBOSS, Tomcat, Glassfish.
 - Recemonded general editor is brackets.
 - Please avoid Microsoft Windows for dev.
 
 - Download source that is lib folder, src, web folders.
 - lib folder contains all the necessary dependencies. Please publish any other than this if used.
 - src folder contains Java sources like Rest classes, Models ets.
 - web folder (doesnt have much to do) contains hibernate.cfg.xml in Web-Inf/classes and persistance.xml in Meta-Inf No web page 
   should be there for any reason. (That is incorporated for documentation later.)
   
 Download the sources setup a project in Netbeans or any other api. 
 -Note: build.xml is only useful if Netbeans is your IDE else ignore that file.
 
 Project Name must be "api" and deployable must be "api.war"

