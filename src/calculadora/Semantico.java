package calculadora;

import calculadora.analysis.*;
import calculadora.node.AAsLongAsCmd;
import calculadora.node.ABlocoBloco;
import calculadora.node.ACaptureCmd;
import calculadora.node.AConsideringCmd;
import calculadora.node.AConstCmd;
import calculadora.node.ACpyCmd;
import calculadora.node.ADeclaracaoDeclaracao; 
import calculadora.node.AIfComando;
import calculadora.node.ANegativoExp;
import calculadora.node.AProgramaPrograma;
import calculadora.node.AShowCmd;
import calculadora.node.AUnaltDeclaracao;
import calculadora.node.AValorExp;
import calculadora.node.AVarExp;
import calculadora.node.Node;
import calculadora.node.PExp;
import calculadora.node.PTipo;
import calculadora.node.PValor;
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
        int i=1;
        System.out.println("Tabela de Símbolos:");
        for (TabelaDeSimbolos symbolTable1 : this.BLOCOS) {
             System.out.println("Escopo: " + i++);
             symbolTable1.getSymbolTable().entrySet().forEach(System.out::println); 
        }
    }
    public int findScopeVar(String var) {  
          for(int i=escopo;i>=0;i--){ 
             if(this.BLOCOS.get(i).verify(var.trim())){ 
                 return i; 
            }
          }
          return -1;
    } 
    public String getType(String exp){
        if(exp.trim().matches("[0-9]+"))
            return "integer";
        else if(exp.trim().matches("[0-9]+.[0-9]+"))
            return "real";
        
            return "symbol";
    }
    public void printError(String error, String id_ou_tipo, String exp,Node node){
        switch(error){
            case "declaracao":
                System.err.println("Erro: variável \"" + id_ou_tipo.trim() + "\" na linha " +  tm.getLine(node) + " já foi declarada.");
            break;
            case "semDeclaracao":
                 System.err.println("Erro: variável \"" + id_ou_tipo.trim() + "\" na linha " +  tm.getLine(node) + " não foi declarada.");
            break;
            case "tipo":
                System.err.print("Erro: variável \"" + id_ou_tipo.trim() + "\" na linha " + tm.getLine(node) + " não pode receber \"" + exp.trim() + "\""); 
                System.err.println(" (o tipo de  \"" + id_ou_tipo.trim() + "\" é diferente de \"" + exp.trim() +"\" ).");
            break;
            case "semTipo":
                System.err.println("\""+ id_ou_tipo.trim() + "\"" + " na linha "+ tm.getLine(node) +" não é um tipo existente.");
            break;
            case "constante":
                System.err.println("Erro: variável \"" + id_ou_tipo.trim() + "\" na linha " + tm.getLine(node) + " é \"unalterable.\"");
            break;
            case "expressao":
                System.err.println("Erro: a expressão na linha " + tm.getLine(node) + " não é válida.");
            break;
            default:
              System.err.println("Erro: ");
        }
    }
    @Override
    public void inStart(Start node){  
//               System.out.println("-------------------------------------------------");
//               System.out.println("Iniciando análise semântica...");
        }

     @Override
     public void outStart(Start node){ 
//            System.out.println("-------------------------------------------------");
//            System.out.println("Fim da análise semântica");
//            System.out.println("-------------------------------------------------");

    }
        @Override
    public void outAProgramaPrograma(AProgramaPrograma node){
         if(node.getName() == null){
             System.err.println("Erro: nome do programa é inválido");
         }
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
        //System.out.println("-------------------------------------------------"); 
        PTipo tipo = node.getTipo();   
        String[] tipoSplited = tipo.toString().split(" ");   
        LinkedList<TId> copy = node.getIdList();  
        
        if(tipoSplited[0].trim().equals("integer") || tipoSplited[0].trim().equals("real") || tipoSplited[0].trim().equals("symbol")){
               
             //   System.out.println("O tipo desta declaração é " + node.getTipo());
             //   System.out.print("Variáveis: "); 
               // for(TId e : copy) System.out.print(e.toString());    
                
             //     System.out.println();
            //      System.out.println("Ações a serem tomadas na tabela de símbolos:"); 
               for(TId e : copy) {     
               String vet = "var";
               if(tipoSplited.length > 1){
                //   System.out.println(e.toString() + " é um vector do tipo " + tipoSplited[0].trim() + " de " + tipoSplited[1].trim() + " posições.");
                   vet = "vet";
               }  
              
                 if(this.BLOCOS.get(escopo).insert(e.toString().trim(), null, vet, (this.escopo+1), tipo.toString().trim(), true)){
          //        System.out.println("-->Inserir ( "+ e.toString() +", " + null + ", " +vet+", " + (this.escopo+1) + ", " + tipo.toString() +")"); 
                 }
                 else this.printError("declaracao", e.toString(), null, node); 
              }  
         //System.out.println();
        }   
        else this.printError("semTipo", tipo.toString(), null, node); 
    }  
    
    @Override
    public void outAUnaltDeclaracao(AUnaltDeclaracao node){
         String id = node.getId().toString().trim(); 
         PTipo tipo = node.getTipo();
         String[] tipoSplited = tipo.toString().trim().split(" ");  
     if(tipoSplited[0].trim().equals("integer") || tipoSplited[0].trim().equals("real") || tipoSplited[0].trim().equals("symbol")){  
         
       //  System.out.println("O tipo desta declaração é " + node.getTipo());
       //  System.out.print("Variáveis: ");
       //  if(node.getInicialize() != null) System.out.print(id.trim() + " := " + node.getInicialize().toString().trim());
        // else  System.out.print(id);
        
        
       // System.out.println();
      //  System.out.println("Ações a serem tomadas na tabela de símbolos:"); 
        
         
        String val = (node.getInicialize() != null ? node.getInicialize().toString().trim() : null);
         String vet = "unalt var";
               if(tipoSplited.length > 1){
                  // System.out.println(id.trim() + " é um vector do tipo " + tipoSplited[0].trim() + " de " + tipoSplited[1].trim() + " posições.");
                   vet = "unalt vet";
               }
        
        if(node.getInicialize() != null && !tipoSplited[0].trim().equals(getType(node.getInicialize().toString()))){
             String inicialize = node.getInicialize().toString().trim();
              boolean printTypeError = false;
                      
               boolean defIni = false; 
               int j = findScopeVar(inicialize.trim());
               
               defIni = j > -1;
               
               List<Object> getIniInTable = null;
               String expValue = null;
               String valueInicialize = null;
               String getTypeInTable = null;
               String getCategInTable = null;
               
               if(j > -1){
                   getIniInTable = this.BLOCOS.get(j).findElement(inicialize.trim()); //.get(4).toString().trim(); 
                   valueInicialize = getIniInTable.get(1).toString() + " ";
                   getTypeInTable = getIniInTable.get(4) + " ";
                   getCategInTable =  getIniInTable.get(2) + " ";
               }  
              if(defIni){     
                     if(node.getTipo().toString().equals(getTypeInTable)){ 
                        
                         this.BLOCOS.get(escopo).insert(id, valueInicialize, node.getTipo().toString().trim(), (this.escopo+1),getTypeInTable, false); 
                    //     System.out.println("-->Inserir ( "+ id +", " +  exp + ", " +getCategInTable+", " + (this.escopo+1) + ", " + getTypeInTable +")"); 
                     }
                     else if(getTypeInTable.equals("integer") && getTypeInTable.equals("real")){
                         
                         this.BLOCOS.get(escopo).insert(id, inicialize.split(".[0-9]+")[0], getCategInTable, (this.escopo+1), getTypeInTable, false);
                         // System.out.println("-->Inserir ( "+ id +", " +  inicialize.split(".[0-9]+")[0] + ", " +getCategInTable+", " + (this.escopo+1) + ", " + getTypeInTable +")"); 
                     }
                     else if(getTypeInTable.equals("real") && getTypeInTable.equals("integer")){
                            String value =  valueInicialize.contains(".") ? valueInicialize : valueInicialize + ".0"; 
                          this.BLOCOS.get(escopo).insert(id.trim(),value,getCategInTable, (this.escopo+1), getTypeInTable, false);
                         //System.out.println("-->Inserir ( "+ id +", " + value + ", " + getCategInTable+", " + (this.escopo+1) + ", " +  getTypeInTable +")"); 
                     }
                     else this.printError("tipo", id, inicialize, node); 
              }
              else if(node.getInicialize() instanceof PValor){  
                  // System.out.println("Ações a serem tomadas na tabela de símbolos:");  
                    if(getType(inicialize).equals("integer") || getType(inicialize).equals("real")){
                        if("integer".equals(tipo.toString())){ 
                            this.BLOCOS.get(escopo).insert(id,inicialize.split(".[0-9]+")[0],vet, (this.escopo+1),tipo.toString(), false);
                            //System.out.println("-->Inserir ( "+ var.trim() +", " +  exp.split(".[0-9]+")[0] + ", " +"var"+", " + (this.escopo+1) + ", " + getVarInTable.toString().trim() +")");
                        } 
                        else if("real".equals(tipo.toString())){ 
                             String value = inicialize.contains(".") ? inicialize : inicialize + ".0"; 
                             this.BLOCOS.get(escopo).insert(id,value , vet, (this.escopo+1),tipo.toString(), false);
                            // System.out.println("-->Inserir ( "+ var.trim() +", " + value + ", " + getVarCategInTable+", " + (this.escopo+1) + ", " + getVarInTable.toString().trim() +")");
                        }
                         else this.printError("tipo", id, inicialize, node); 
                   }
                   else if(getType(inicialize).equals("symbol") && "symbol".equals(tipo.toString())){
                       
                        this.BLOCOS.get(escopo).insert(id,node.getInicialize(), vet, (this.escopo+1),tipo.toString(), false);
                   }
                     else this.printError("tipo", id, inicialize, node); 
              }
               else this.printError("tipo", id, inicialize, node); 
               
        } 
        else if(this.BLOCOS.get(escopo).insert(id.trim(), val , vet.trim(), (this.escopo+1), tipo.toString().trim(), true)){
        //     System.out.println("-->Inserir ( "+ id +", " +  val + ", " +vet+", " + (this.escopo+1) + ", " + tipo.toString() +")"); 
        }
        else printError("declaracao",id,null,node); 
        
             System.out.println();
      }
     else this.printError("semTipo", tipo.toString(), null, node);
     
     
     
   }
    
    @Override  
    public void outACpyCmd(ACpyCmd node){
        
      String var = node.getVar().toString().trim(); 
      String exp = node.getExp().toString().trim();
      //System.out.println("Ações a serem tomadas na tabela de símbolos:");  
      boolean defVar; 
      boolean printError = false;
      int i = findScopeVar(var);      
      defVar = i > -1;
     
      String[] categ = null;
      if(defVar) categ = this.BLOCOS.get(i).findElement(var).get(2).toString().split(" ");

     if(!defVar) 
         this.printError("semDeclaracao", var, null, node); 
     else if("unalt".equals(categ[0]))
         this.printError("constante", var, null, node);  
     else{
         
               boolean defExp = false; 
               int j = findScopeVar(exp);
               
               defExp = j > -1;
               
               List<Object> getVarInTable = null;
               List<Object> getExpInTable = null;
               String expValue = null;
               String getVarCategInTable = null;
               String getVarTypeInTable = null;
               String getExpTypeInTable = null;
               String getExpValueInTable = null;
               
               if(defVar){ 
                   getVarInTable = this.BLOCOS.get(i).findElement(var);
                   getVarCategInTable = (getVarInTable.get(2) + " ").trim();
                   getVarTypeInTable = (getVarInTable.get(4) + " ").trim(); 
               }  
               if(defExp){
                    getExpInTable = this.BLOCOS.get(j).findElement(exp);
                    getExpTypeInTable = (getExpInTable.get(4) + " ").trim();
                    getExpValueInTable = (getExpInTable.get(1) + " ").trim();
               } 
               
              if(defExp){ 
                     if(getExpTypeInTable.equals(getVarTypeInTable)){  
                         this.BLOCOS.get(escopo).insert(var.trim(), getExpValueInTable, getVarCategInTable, (this.escopo+1), getVarTypeInTable , false); 
                    //     System.out.println("-->Inserir ( "+ var.trim() +", " +  exp + ", " +getVarCategInTable+", " + (this.escopo+1) + ", " + getVarTypeInTable  +")"); 
                     }
                     else if(getVarTypeInTable.equals("integer") && getExpTypeInTable.equals("real")){ 
                         this.BLOCOS.get(escopo).insert(var.trim(), getExpValueInTable.split(".[0-9]+")[0].trim(), getVarCategInTable, (this.escopo+1), getVarTypeInTable , false);
                         // System.out.println("-->Inserir ( "+ var.trim() +", " +  getExpValueInTable.split(".[0-9]+")[0].trim() + ", " +getVarCategInTable+", " + (this.escopo+1) + ", " + getVarTypeInTable  +")"); 
                     }
                     else if(getVarTypeInTable.equals("real") && getExpTypeInTable.equals("integer")){
                            String value = getExpValueInTable.contains(".") ? getExpValueInTable : (getExpValueInTable + ".0").trim(); 
                          this.BLOCOS.get(escopo).insert(var.trim(),value,getVarCategInTable, (this.escopo+1), getVarTypeInTable , false);
                         //System.out.println("-->Inserir ( "+ var.trim() +", " + value + ", " +"getVarCategInTable+", " + (this.escopo+1) + ", " +  getVarTypeInTable  +")"); 
                     }
                     else this.printError("tipo",var, exp, node);
              }
              else if(node.getExp() instanceof AValorExp){  
                  // System.out.println("Ações a serem tomadas na tabela de símbolos:"); 
                    if(getType(exp).equals(getVarTypeInTable)){
                        this.BLOCOS.get(escopo).insert(var.trim(), exp.trim(), getVarCategInTable, escopo,getVarTypeInTable, false);
                    }
                    else if(getType(exp).equals("integer") || getType(exp).equals("real")){ 
                        if("integer".equals(getVarTypeInTable)){  
                            this.BLOCOS.get(escopo).insert(var.trim(),(exp.split(".[0-9]+")[0] + " ").trim(),getVarCategInTable, (this.escopo+1),getVarTypeInTable, false);
                            //System.out.println("-->Inserir ( "+ var.trim() +", " +  (exp.split(".[0-9]+")[0] + " ").trim() + ", " +"var"+", " + (this.escopo+1) + ", " + getVarTypeInTable +")");
                        }
                        else if("real".equals(getVarTypeInTable)){ 
                             String value = exp.contains(".") ? exp : (exp + ".0").trim(); 
                             this.BLOCOS.get(escopo).insert(var.trim(), value , getVarCategInTable, (this.escopo+1),getVarTypeInTable, false);
                            // System.out.println("-->Inserir ( "+ var.trim() +", " + value + ", " + getVarCategInTable+", " + (this.escopo+1) + ", " + getVarTypeInTable +")");
                        }
                        else this.printError("tipo",var, exp, node);
                   } 
                    else this.printError("tipo",var, exp, node);
              } 
               //else this.printError("tipo",var, exp, node);
               
     }  
     
  }    
    @Override
    public void outAConstCmd(AConstCmd node){
        String unalt = node.getUnalt().toString();
        String exp = node.getExp().toString();
        
        
    }
     @Override
     public void outACaptureCmd(ACaptureCmd node) {
        LinkedList<PVar> var = node.getMultiVar();
            for(PVar e : var){
                if(findScopeVar(e.toString()) == -1)
                    this.printError("declaracao", e.toString(), null, node);  
            } 
    }
        @Override
    public void outAShowCmd(AShowCmd node){ 
        for(PExp e : node.getMultiExp()){  
            int i = findScopeVar(e.toString()); 
               if(i == -1) this.printError("declaracao", e.toString(), null, node);   
               else System.out.print(this.BLOCOS.get(i).findElement(e.toString().trim()).get(1));    
         }
         System.out.println();
    }
    
     @Override
    public void outAIfComando(AIfComando node){
        if(!(node.getExp() instanceof PExp)){ 
            this.printError("expressao", null, null, node);  
        } 
    }  
   
     @Override
    public void outAAsLongAsCmd(AAsLongAsCmd node){
        if(!(node.getExp() instanceof PExp)){
            this.printError("expressao", null, null, node);  
        }
    } 
    
     
    @Override
    public void outAConsideringCmd(AConsideringCmd node){
        if(findScopeVar(node.getVar().toString()) == -1){ 
           this.printError("declaracao",node.getVar().toString(), null, node);
        }
        else if(!(node.getExp1() instanceof PExp) || !(node.getExp2() instanceof PExp) || !(node.getExp3() instanceof PExp)){ 
           this.printError("expressao", null, null, node);
        }
    }
    
     @Override
    public void outANegativoExp(ANegativoExp node){
         String tipo = null;
         PExp exp = node.getRight();
         
        if(node.getRight() instanceof AVarExp){ 
            int i = findScopeVar(exp.toString());
            if (i != -1){ //Se estiver na tabela 
                 List<Object> element = this.BLOCOS.get(i).findElement(node.toString());
                 tipo = element.get(4).toString();
                 if(element.get(1) == null || element.get(1).toString().equals("null")){
                     System.out.print("Erro: não é possível negativar \"" + exp.toString().trim() + "\" na linha " + tm.getLine(node));
                     System.out.println(": O valor de \"" + exp.toString().trim() + "\" é null");
                 }
                 else if(tipo.equals("integer")){ 
                     int negElem = -Integer.parseInt(element.get(1).toString().trim()); 
                     this.BLOCOS.get(i).insert(element.get(0).toString().trim(), negElem, element.get(2).toString(), escopo+1,element.get(4).toString(), false);
                     System.out.println("-->Inserir ( "+ element.get(0).toString().trim() +", " + negElem + ", " + element.get(2).toString() +", " + (this.escopo+1) + ", " + element.get(4).toString() +")");
                 }
                 else if(tipo.equals("real")){
                     float negElem = -Float.parseFloat(element.get(1).toString().trim()); 
                     this.BLOCOS.get(i).insert(element.get(0).toString().trim(), negElem, element.get(2).toString(), escopo+1,element.get(4).toString(), false);   
                     System.out.println("-->Inserir ( "+ element.get(0).toString().trim() +", " + negElem + ", " + element.get(2).toString() +", " + (this.escopo+1) + ", " + element.get(4).toString() +")");
                 } 
            } 
            else this.printError("semDeclaracao", exp.toString(),null, node);
        }
        else if(node.getRight() instanceof AValorExp){
                tipo = getType(exp.toString().trim());
            if(tipo.equals("integer")){ 
                     int negElem = -Integer.parseInt(exp.toString().trim()); 
                     this.BLOCOS.get(escopo).insert(exp.toString().trim(), negElem, "val", escopo+1,tipo, true);
                     System.out.println("-->Inserir ( "+ exp.toString().trim() +", " + negElem + ", " +  "val" +", " + (this.escopo+1) + ", " + tipo +")");
                 }
            else if(tipo.equals("real")){
                float negElem = -Float.parseFloat(exp.toString().trim()); 
                 this.BLOCOS.get(escopo).insert(exp.toString().trim(), negElem, "val", escopo+1,tipo, true); 
                 System.out.println("-->Inserir ( "+ exp.toString().trim() +", " + negElem + ", " +  "val" +", " + (this.escopo+1) + ", " + tipo +")");
            }
            else{ 
                System.out.println("Erro: não é possível negativar \"" + exp.toString().trim() + "\" na linha " + tm.getLine(node)); 
            }
        }
        
    }
    

    
}