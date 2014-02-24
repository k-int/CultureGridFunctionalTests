echo running all functional tests for Culture Grid, it is assumed that 
echo GRAILS_HOME is set pointing at a 2.3.5 installation and its bin directory is on the path

grails test-app -echoOut functional: MenuSpec DataSpec "*"

target/test-reports/html/all.html
