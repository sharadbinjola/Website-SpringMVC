call ant build
call ant deploywar
java -Xdebug -Xrunjdwp:transport=dt_socket,address=8080,server=y -jar target\dependency\webapp-runner.jar Website-SpringMVC.war 