@echo off
echo [INFO] create mybatis files config in /src/main/resources/mybatis-generator/generatorConfig.xml

cd %~dp0
cd ..
call mvn mybatis-generator:generate
cd bin
pause