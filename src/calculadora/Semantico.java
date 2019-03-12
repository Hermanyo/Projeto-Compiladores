package calculadora;

import calculadora.analysis.*;
import calculadora.node.*; 
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList; 
import java.util.Spliterator;
 
public class Semantico extends DepthFirstAdapter {
        //HashMap<[0,1,2,3,],tipo>
        //HashMap<[Variavel,categoria, definido, escopo], tipo>
        private final  HashMap<String,String[]> symbolTable = new HashMap<>(); 
        private final TokenMapper tm;
        public  int escopo=0;
            
    Semantico(TokenMapper tm) { 
       this.tm = tm;
    } 
       
    public HashMap<String,String[]> getSymbolTable(){
        return symbolTable;
    }
            
    @Override
    public void inStart(Start node)
        {
               System.out.println("-------------------------------------------------");
               System.out.println("Iniciando análise semântica...");
        }

     @Override
     public void outStart(Start node){
            System.out.println("-------------------------------------------------");
            System.out.println("Fim da análise semântica");
            System.out.println("-------------------------------------------------");

    }

    @Override
    public void inABlocoBloco(ABlocoBloco node){
        escopo++;
    }
    @Override 
    public void outATipoDeclaracao(ATipoDeclaracao node){  		 
        System.out.println("-------------------------------------------------"); 
        PTipo tipo = node.getTipo(); 
        String Stipo = tipo.toString(); 
         
        String[] tipoSplited = Stipo.split(" ");   
        LinkedList<PMultiId> copy =  node.getMultiId();
        String id = node.getId().toString();
        
        if(tipoSplited[0].trim().equals("integer") || tipoSplited[0].trim().equals("real") || tipoSplited[0].trim().equals("symbol")){
             
          if(tipoSplited.length < 2){
                
                System.out.println("O tipo desta declaração é " + node.getTipo());
                System.out.print("Variáveis: ");
                System.out.println(id); 
              for(PMultiId e : copy) System.out.print(e.toString());  
                 
                
                String[] columns = new String[] {"var","sim",(escopo+"").trim(),Stipo};
                 
              if(!symbolTable.containsKey(id)){
                  System.out.println();
                  System.out.println("Ações a serem tomadas na tabela de símbolos:"); 
                  System.out.println("-->Inserir ( "+ id +", " + "var" + ", " +"sim"+", " + escopo + ", " +node.getTipo()+")");
                  symbolTable.put(id,columns); 
                }
              else
                  System.out.println("\nErro: variável \"" + id.trim() + "\" na linha: " +  tm.getLine(node) + " já foi declarada.");


              for(PMultiId e : copy) {
                  if(!symbolTable.containsKey(e.toString())){ 
                   System.out.println();
                   System.out.println("Ações a serem tomadas na tabela de símbolos:"); 
                   System.out.println("-->Inserir ( "+ e.toString() +", " + "var" + ", " +"sim"+", " + escopo + ", " +node.getTipo()+")"); 
                   symbolTable.put(e.toString(),columns); 
                  }
                  else 
                   System.out.println("\nErro: variável \"" + e.toString().trim() + "\" na linha: " +  tm.getLine(node) + " já foi declarada.");

              }
          }
          else{ 
              System.out.println(id.trim() + " é um vector do tipo " + tipoSplited[0].trim() + " de " + tipoSplited[1].trim() + " posições.");
              System.out.println();
               if(!symbolTable.containsKey(id)){ 
                  System.out.println("Ações a serem tomadas na tabela de símbolos:");
                  System.out.println("-->Inserir ( "+ id +", " + "var" + ", " +"sim"+", " + escopo + ", " +node.getTipo()+")"); 
                  String[] columns = new String[] {"var","sim",escopo+"",Stipo};
                  symbolTable.put(id,columns);
               }
               else 
                System.out.println("Erro: variável \"" + id.trim() + "\" na linha: " +  tm.getLine(node) + " já foi declarada."); 
          } 
        }   
        else
             System.out.println("\""+ Stipo.trim() + "\"" + " na linha: "+ tm.getLine(node) +" não é um tipo existente.");


    }


	 
}