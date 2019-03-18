package calculadora;
import calculadora.parser.*;
import calculadora.lexer.*;
import calculadora.node.*;
import java.io.*; 

public class Main
{
 public static void main(String[] args) throws FileNotFoundException, ParserException, UnsupportedEncodingException, IOException, LexerException
 {
   
  //String arquivo = "./src/test/expressao.calc";
  String arquivo = "/home/hermanyo/NetBeansProjects/projeto_compiladores/dist/expressao.calc";
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
   
   AnaliseSemantica.printSymbolTable();
   
   String fileName = "Tesaurus"; 

      Writer wout = new BufferedWriter( 
              new OutputStreamWriter(
              new FileOutputStream(fileName+".rex"),"UTF8")); 
          wout.append( createOutput(AnaliseSemantica, fileName));
          wout.close();
      
   
 }
  private static String createOutput(Semantico code, String fileName) {
        int size = code.getBlOCOS().size();
        return  ".bytecode 50.0\n"+
                ".class public "+fileName+"\n"+
                ".super java/lang/Object\n"+
                ".method public <init>()V\n"+
                    "\t.limit stack 1\n"+
                    "\t.limit locals 1\n"+
                    "\taload_0\n"+
                    "\tinvokespecial java/lang/Object/<init>()V\n"+
                    "\treturn\n"+
                    ".end method\n"+
                    "\t.method public static main([Ljava/lang/String;)V\n"+
                    "\t.limit stack "+ code.scope()+"\n"+  "asasdassaddsdquhe12y8h1u2h87g78hu8syd78" +    
                    "\t.limit locals "+size+"\n" +
                    "\treturn\n"+
                ".end method\n";
    }
}
