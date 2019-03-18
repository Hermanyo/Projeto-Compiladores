#Criar ByteCode e compilar código
cd
cd /home/hermanyo/NetBeansProjects/projeto_compiladores/ 
ant 
echo -e
echo -e 
echo -e 
echo -e 
echo -e 
echo -e "Projeto de Compiladores" 
echo -e
cd dist
cp -d /home/hermanyo/NetBeansProjects/projeto_compiladores/src/test/expressao.calc /home/hermanyo/NetBeansProjects/projeto_compiladores/dist/ 
java -jar "/home/hermanyo/NetBeansProjects/projeto_compiladores/dist/projeto_compiladores.jar"
