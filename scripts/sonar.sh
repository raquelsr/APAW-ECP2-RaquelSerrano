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
echo ============ mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent verify --settings settings.xml ... ==================
echo . Se prepara cobertura
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent verify --settings settings.xml

echo ============ mvn sonar:sonar ... =======================================================
echo . Se analiza y sube a sonar cloud
mvn sonar:sonar \
  -Dsonar.organization=raquelsr-github \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.login=8f831d0a395b1588beaa8ce79694caba1b5befbe --settings settings.xml
