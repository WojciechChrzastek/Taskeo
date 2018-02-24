call runcrud
if "%ERRORLEVEL%" == "0" goto runchrome
echo.
echo RUNCRUD has errors - breaking work
goto fail

:runchrome
start chrome "http://localhost:8080/crud/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto stoptomcat
echo Cannot run Chrome
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.