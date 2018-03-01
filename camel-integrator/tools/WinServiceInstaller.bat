set SERVICE_NAME=IntegratorService
set PR_INSTALL=%~dp0%SERVICE_NAME%.exe
set BASEDIR=%~dp0..\

%PR_INSTALL% install %SERVICE_NAME% ^
 --DisplayName="Integrator Service" ^
 --StartPath=%BASEDIR% ^
 --LogPath=%BASEDIR%\logs ^
 --LogPrefix=%SERVICE_NAME% ^
 --LogLevel=Info ^
 --Classpath=%~dp0..\lib\*;%~dp0..\conf ^
 --Startup=auto ^
 --StartMode=jvm ^
 --StartClass=org.eclipse.iot.unide.integrators.IntegratorMain ^
 --StartParams=start ^
 --StopMode=jvm ^
 --StopClass=org.eclipse.iot.unide.integrators.IntegratorMain ^
 --StopParams=stop ^
 --JvmOptions=-Dlog4j.configuration=file:"%BASEDIR%/conf/log4j.properties" ^
 ++JvmOptions=-Dlog.root="%BASEDIR%"/logs
