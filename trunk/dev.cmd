@echo off
SETLOCAL

cls

set INTEGRO_HOME=C:/dev/trunk
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_192
set ANT_HOME=C:\dev\apache-ant-1.10.5
set TOMCAT_HOME=C:\dev\apache-tomcat-8.5.71
set CATALINA_OPTS=-Xms96m -Xmx512m -XX:MaxPermSize=128m
set BUILD_FILE=build.xml

if "%~1" == "tomcat" goto :tomcat
goto :antbuild

:tomcat
call :antbuild compile deploy

echo ------------------------------------------------------------------------
echo Starting Tomcat Server in a separate window...
echo.
echo TOMCAT_HOME: [%TOMCAT_HOME%]
echo JAVA_HOME: [%JAVA_HOME%]
REM echo CATALINA_BASE: [%CATALINA_BASE%]
echo ------------------------------------------------------------------------

set CATALINA_HOME=%TOMCAT_HOME%

pushd %TOMCAT_HOME%
call .\bin\startup.bat
popd
goto :end

:antbuild
echo ------------------------------------------------------------------------
echo Accessing Development Package  : %INTEGRO_HOME%
echo ------------------------------------------------------------------------
echo.
echo Development Time [%DATE% - %TIME%]
echo ANT_HOME: %ANT_HOME%
echo JAVA_HOME: %JAVA_HOME%
echo ------------------------------------------------------------------------
echo.

"%JAVA_HOME%/bin/java" -cp %ANT_HOME%/lib/ant.jar;%ANT_HOME%/lib/ant-launcher.jar;%ANT_HOME%/lib/ant-trax.jar;%ANT_HOME%/lib/ant-junit.jar;%ANT_HOME%/lib/ant-nodeps.jar;"%JAVA_HOME%/lib/tools.jar" org.apache.tools.ant.Main -buildfile %BUILD_FILE% %*

:end
echo.
echo.
ENDLOCAL
:finish