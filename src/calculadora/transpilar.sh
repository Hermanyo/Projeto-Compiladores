java -jar java2delphi.jar Main.java
java -jar java2delphi.jar Semantico.java
java -jar java2delphi.jar TabelaDeSimbolos.java
java -jar java2delphi.jar ASTPrinter.java
java -jar java2delphi.jar ASTDisplay.java
java -jar java2delphi.jar TokenMapper.java
java -jar java2delphi.jar TreeDumper.java

locar_dir = "/home/hermanyo/NetBeansProjects/projeto_compiladores/src"
local_dest = "/home/hermanyo/NetBeansProjects/projeto_compiladores/src/tesauro_to_pascal/"

main="$local_dir""/Main.pas"
ASTDisplay="$local_arq""/ASTDisplay.pas"
ASTPrinter="$local_arq""/ASTPrinter.pas"
TokenMapper="$local_arq""/TokenMapper.pas"
Semantico="$local_arq""/Semantico.pas"
TabelaDeSimbolos="$local_arq""/TabelaDeSimbolos.pas"
TreeDumper="$local_arq""/TreeDumper.pas"

if [ -d  $main ] || [ -d $ASTDisplay ] || [ -d  $ASTPrinter ] 
|| [ -d $TokenMapper ] || [ -d $Semantico ] || [ -d $TabelaDeSimbolos ] || [ -d $TreeDumper ]; then 
  rm -r $main
  rm -r $ASTDisplay
  rm -r $ASTPrinter
  rm -r $TokenMapper
  rm -r $Semantico 
  rm -r $TabelaDeSimbolos
  rm -r $TreeDumper   
fi 

if [ -d  $main ] || [ -d $ASTDisplay ] || [ -d  $ASTPrinter ] 
|| [ -d $TokenMapper ] || [ -d $Semantico ] || [ -d $TabelaDeSimbolos ] || [ -d $TreeDumper ]; then  
  mv $main $dest
  mv $ASTDisplay $dest
  mv $ASTPrinter $dest
  mv $TokenMapper $dest
  mv $Semantico $dest
  mv $TabelaDeSimbolos $dest
  mv $TreeDumper $dest 
fi

  
