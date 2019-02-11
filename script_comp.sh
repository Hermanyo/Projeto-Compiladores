#!/bin/sh 

#local_arq => caminho onde a main se encontra
local_arq="/home/hermanyo/NetBeansProjects/calculadora/src/calculadora" 
#local_sable => caminho onde o .sable ou .scc se encontra 
local_sable="/home/hermanyo/NetBeansProjects/calculadora/src" 
#dest => o destino é o caminho onde a main se encontra
dest=local_arq

analysis="$local_arq""/analysis"
lexer="$local_arq""/lexer"
node="$local_arq""/node"
parser="$local_arq""/parser"

#Remover
if [ -d  $analysis ] || [ -d $lexer ] || [ -d  $node ] || [ -d $parser ]; then 
  rm -r $analysis
  rm -r $lexer
  rm -r $node
  rm -r $parser 
  echo 'diretórios removidos com sucesso'  
fi 

analysis="$local_sable""/analysis"
lexer="$local_sable""/lexer"
node="$local_sable""/node"
parser="$local_sable""/parser"
 
#Mover 
if [ -d  $analysis ] || [ -d $lexer ] || [ -d  $node ] || [ -d $parser ]; then 
  mv $analysis $dest
  mv $lexer $dest
  mv $node $dest
  mv $parser $dest
  echo 'diretórios movidos com sucesso' 
fi

