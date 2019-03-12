package calculadora;
import calculadora.parser.*;
import calculadora.lexer.*;
import calculadora.node.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap; 
import java.util.Map;

public class Main
{
 public static void main(String[] args)
 {
  try
  {
  String arquivo = "./src/test/expressao.calc";
  
   Parser p =
    new Parser(
    new Lexer(
    new PushbackReader(  
    new FileReader(arquivo), 1024))); 
   
   Start tree = p.parse();
   
   //tree.apply(new ASTDisplay()); 
   
   TokenMapper tm = new TokenMapper();
    tree.apply(tm); 
    
   Semantico AnaliseSemantica = new Semantico(tm);
   
   tree.apply(AnaliseSemantica);
   
   for(Map.Entry<String,String[]> m :  AnaliseSemantica.getSymbolTable().entrySet()){ 
       System.out.println("Chave: " + m.getKey() +", " + Arrays.toString(m.getValue()));
   }
  
  }
  catch(LexerException | ParserException | IOException e)
  {
   System.out.println(e.getMessage());
  }
 }
}