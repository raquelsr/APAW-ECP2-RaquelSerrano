#echo off
export workspace=/Users/Raquel/Documents/Workspace/Eclipse/APAW-ECP2-RaquelSerrano
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home/jre
export M2_HOME=/Users/Raquel/Desktop/Master/Software/apache-maven-3.5.0

echo -----------------------------------------
echo ".(C) MIW"
echo -----------------------------------------
echo .
echo Workspace --- $workspace
echo JAVA_HOME -- $JAVA_HOME
echo PATH -- $PATH
echo M2_HOME = $M2_HOME

echo .
cd $workspace
echo "============ mvn clean test (profile: develop) ======================================================="
echo .
mvn clean test --settings settings.xml