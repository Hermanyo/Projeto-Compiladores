package calculadora;

import calculadora.analysis.*;
import calculadora.node.AAsLongAsCmd;
import calculadora.node.ABlocoBloco;
import calculadora.node.ACaptureCmd;
import calculadora.node.AConstCmd;
import calculadora.node.ACpyCmd;
import calculadora.node.ADeclaracaoDeclaracao; 
import calculadora.node.AShowCmd;
import calculadora.node.AUnaltDeclaracao;
import calculadora.node.AValorExp;
import calculadora.node.PExp;
import calculadora.node.PTipo;
import calculadora.node.PVar;
import calculadora.node.Start;
import calculadora.node.TId;
import java.util.*;

public class Semantico extends DepthFirstAdapter { 
        private final TokenMapper tm;
        private int escopo; 
        private final ArrayList<TabelaDeSimbolos>BLOCOS;
        
    Semantico(TokenMapper tm) {   
        this.BLOCOS = new ArrayList<>();
        this.tm = tm;
        this.escopo = -1;
    } 
    public void printSymbolTable(){
        System.out.println("Columns: id val vet esc tipo");
            for (TabelaDeSimbolos symbolTable1 : this.BLOCOS) {
                System.out.println(symbolTable1.getSymbolTable().values()); 
            }
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
        this.BLOCOS.add(new TabelaDeSimbolos());
        this.escopo++;
    }
    @Override
    public void outABlocoBloco(ABlocoBloco node){
        this.escopo--;
    }
        @Override
    public void outADeclaracaoDeclaracao(ADeclaracaoDeclaracao node){ 		 
        System.out.println("-------------------------------------------------"); 
        PTipo tipo = node.getTipo();   
        String[] tipoSplited = tipo.toString().split(" ");   
        LinkedList<TId> copy = node.getIdList();  
        
        if(tipoSplited[0].trim().equals("integer") || tipoSplited[0].trim().equals("real") || tipoSplited[0].trim().equals("symbol")){
               
                System.out.println("O tipo desta declaração é " + node.getTipo());
                System.out.print("Variáveis: "); 
                for(TId e : copy) System.out.print(e.toString());    
                
                  System.out.println();
                  System.out.println("Ações a serem tomadas na tabela de símbolos:"); 
               for(TId e : copy) {     
               String vet = "var";
               if(tipoSplited.length > 1){
                   System.out.println(e.toString() + " é um vector do tipo " + tipoSplited[0].trim() + " de " + tipoSplited[1].trim() + " posições.");
                   vet = "vet";
               }  
              
                 if(this.BLOCOS.get(escopo).insert(e.toString().trim(), null, vet, (this.escopo+1), tipo.toString().trim(), true))
                  System.out.println("-->Inserir ( "+ e.toString() +", " + null + ", " +vet+", " + (this.escopo+1) + ", " + tipo.toString() +")"); 
              else 
                  System.out.println("\nmulti Erro: variável \"" + e.toString().trim() + "\" na linha " +  tm.getLine(node) + " já foi declarada.");
              }  
         System.out.println();
        }   
        else
             System.out.println("\""+ tipo.toString().trim() + "\"" + " na linha "+ tm.getLine(node) +" não é um tipo existente.");
    }  
    
    @Override
    public void outAUnaltDeclaracao(AUnaltDeclaracao node){
         String id = node.getId().toString().trim(); 
         PTipo tipo = node.getTipo();
         String[] tipoSplited = tipo.toString().trim().split(" ");  
     if(tipoSplited[0].trim().equals("integer") || tipoSplited[0].trim().equals("real") || tipoSplited[0].trim().equals("symbol")){  
         
         System.out.println("O tipo desta declaração é " + node.getTipo());
         System.out.print("Variáveis: ");
         if(node.getInicialize() != null) System.out.print(id.trim() + " := " + node.getInicialize().toString().trim());
         else  System.out.print(id);
         
        System.out.println();
        System.out.println("Ações a serem tomadas na tabela de símbolos:"); 
        
        String val = (node.getInicialize() != null ? node.getInicialize().toString().trim() : null);
         String vet = "unalt var";
               if(tipoSplited.length > 1){
                   System.out.println(id.trim() + " é um vector do tipo " + tipoSplited[0].trim() + " de " + tipoSplited[1].trim() + " posições.");
                   vet = "unalt vet";
               }
        
        if(this.BLOCOS.get(escopo).insert(id.trim(), val , vet.trim(), (this.escopo+1), tipo.toString().trim(), true))
             System.out.println("-->Inserir ( "+ id +", " +  val + ", " +vet+", " + (this.escopo+1) + ", " + tipo.toString() +")"); 
           else 
             System.out.println("\nErro: variável \"" + id.trim() + "\" na linha " +  tm.getLine(node) + " já foi declarada.");
          
        System.out.println();
     }
      else
         System.out.println("\""+ tipo.toString().trim() + "\"" + " na linha "+ tm.getLine(node) +" não é um tipo existente.");
   }
    
    @Override 
    public void outACpyCmd(ACpyCmd node){
      String var = node.getVar().toString(); 
      String exp = node.getExp().toString();
      
      boolean def = false;  
      int i=0;
      for(i=escopo;i>=0;i--){ 
          if(this.BLOCOS.get(i).verify(var.trim())){
              def = true;
              
              break;
          }
      }       
      String[] categ = null;
      if(i >-1) categ = this.BLOCOS.get(i).getSymbolTable().get(this.BLOCOS.get(i).hash(var)).get(2).toString().split(" ");

     if(!def) 
         System.out.println("Erro: variável \"" + var.trim() + "\" na linha " + tm.getLine(node) + " não foi declarada.");
     else if("unalt".equals(categ[0]))
         System.out.println("Erro: variável \"" + var.trim() + "\" na linha " + tm.getLine(node) + " é unalterable."); 
     else{
         
               def = false; 
               int j=0;
              for(j=escopo;j>=0;j--){ 
                  if(this.BLOCOS.get(j).verify(exp.trim())){
                      def = true; 
                      break;
                  }
              }
               String getTipoVar = null;
               String getTipoExp = null;
               String expValue = null;
               
               if(i > -1) getTipoVar = this.BLOCOS.get(i).getSymbolTable().get(this.BLOCOS.get(i).hash(var)).get(4).toString().trim();
               if(j > -1) getTipoExp = this.BLOCOS.get(j).getSymbolTable().get(this.BLOCOS.get(j).hash(exp)).get(4).toString().trim(); 
               
              if(def){    
                     if(getTipoExp.equals(getTipoVar) || getTipoExp.equals("integer") || getTipoExp.equals("real")){
                         System.out.println("Ações a serem tomadas na tabela de símbolos:");  
                         this.BLOCOS.get(escopo).insert(var.trim(), exp, "var", (this.escopo+1), getTipoVar.trim(), false); 
                         System.out.println("-->Inserir ( "+ var.trim() +", " +  exp + ", " +"var"+", " + (this.escopo+1) + ", " + getTipoVar.trim() +")"); 
                  }
                  else{
                      System.out.println("Erro: variável \"" + exp.trim() + "\" na linha " + tm.getLine(node) + " não pode ser atribuída a " + var.trim());
                      System.out.println("O tipo de " + var.trim() + " é diferente de " + exp.trim());
                  }
              }
              else if(node.getExp() instanceof AValorExp){  
                  System.out.println("Ações a serem tomadas na tabela de símbolos:"); 
                   this.BLOCOS.get(escopo).insert(var.trim(), exp, "var", (this.escopo+1), getTipoVar.trim(), false);
                   System.out.println("-->Inserir ( "+ var.trim() +", " +  exp + ", " +"var"+", " + (this.escopo+1) + ", " + getTipoVar.trim() +")"); 
              }
              else{
                   System.out.println("Erro: variável \"" + var.trim() + "\" na linha " + tm.getLine(node) + " não pode ser atribuída a " + exp); 
                   System.out.println("O tipo de " + var.trim() + " é diferente de " + exp.trim());
              }
           
     }  
     
  }    
    @Override
    public void outAConstCmd(AConstCmd node) {
        String unalt = node.getUnalt().toString();
        String exp = node.getExp().toString();
        
        
    }
    
      @Override
     public void outACaptureCmd(ACaptureCmd node) {
            LinkedList<PVar> var = node.getMultiVar();
            for(PVar e : var){
                boolean def = false; 
               int j=0;
              for(j=escopo;j>=0;j--){ 
                  if(this.BLOCOS.get(j).verify(e.toString().trim())){
                      def = true; 
                      break;
                  }
              }
               if(!def) System.out.println("Erro: variável \"" + e.toString().trim() + "\" na linha " + tm.getLine(node) + " não foi declarada. "); 
            } 
    } 
     
     @Override
    public void outAAsLongAsCmd(AAsLongAsCmd node){
        
    } 
}