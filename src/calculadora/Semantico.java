package calculadora;

import calculadora.analysis.*;
import calculadora.node.*; 
import java.util.LinkedList; 

public class Semantico extends DepthFirstAdapter { 
        private final TokenMapper tm;
        public  int escopo=0;
        private final TabelaDeSimbolos symbolTable;
        
    Semantico(TokenMapper tm) { 
        this.symbolTable = new TabelaDeSimbolos();
        this.tm = tm;
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
                System.out.print(id); 
                for(PMultiId e : copy) System.out.print(e.toString());    
                
                  System.out.println();
                  System.out.println("Ações a serem tomadas na tabela de símbolos:"); 
                    
               
              if(symbolTable.insert(id, "var", "nao", (escopo+""), Stipo))
                  System.out.println("-->Inserir ( "+ id +", " + "var" + ", " +"sim"+", " + escopo + ", " + Stipo +")"); 
              else 
                  System.out.println("\nErro: variável \"" + id.trim() + "\" na linha " +  tm.getLine(node) + " já foi declarada.");


              for(PMultiId e : copy) {
                 if(symbolTable.insert(e.toString(), "var", "nao", (escopo+""), Stipo))
                  System.out.println("-->Inserir ( "+ e.toString() +", " + "var" + ", " +"sim"+", " + escopo + ", " + Stipo +")"); 
              else 
                  System.out.println("\nmulti Erro: variável \"" + e.toString().trim() + "\" na linha " +  tm.getLine(node) + " já foi declarada.");
              }
          }
          else{ 
              System.out.println(id.trim() + " é um vector do tipo " + tipoSplited[0].trim() + " de " + tipoSplited[1].trim() + " posições.");
              System.out.println();
              if(symbolTable.insert(id.trim(), "var", "nao", (escopo+""), Stipo))
                  System.out.println("-->Inserir ( "+ id.trim() +", " + "var" + ", " +"sim"+", " + escopo + ", " + Stipo +")"); 
               else 
                System.out.println("Erro: variável \"" + id.trim() + "\" na linha " +  tm.getLine(node) + " já foi declarada.");  
          } 
        }   
        else
             System.out.println("\""+ Stipo.trim() + "\"" + " na linha "+ tm.getLine(node) +" não é um tipo existente.");
    }   
}