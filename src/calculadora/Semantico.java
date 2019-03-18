package calculadora;

import calculadora.analysis.*;
import calculadora.node.*;
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
             if(!symbolTable1.getSymbolTable().entrySet().isEmpty()) System.out.println("Escopo: " + i++);
             symbolTable1.getSymbolTable().entrySet().forEach(System.out::println); 
        }
    }
    public ArrayList<TabelaDeSimbolos>getBlOCOS(){
        return this.BLOCOS;
    }
    public int scope (){
        return this.escopo;
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
        if(exp.trim().matches("[0-9]+") || exp.trim().matches("-[0-9]+"))
            return "integer";
        else if(exp.trim().matches("[0-9]+.[0-9]+"))
            return "real";
        
            return "symbol";
    }
    public void printError(String error, String id_ou_tipo, String exp,Node node){
        for(int i = 0; i < 80*300; i++)  System.out.print("\b"); 
             id_ou_tipo = id_ou_tipo.split(" ")[0];
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
            case "soma":
                System.err.println("Erro: não foi possível realiza a soma na linha " + tm.getLine(node));
            break;
            case "subtr":
                System.err.println("Erro: não foi possível realiza a subtração na linha " + tm.getLine(node));
            break;
            case "div":
                System.err.println("Erro: não foi possível realiza a divisão na linha " + tm.getLine(node));
            break;
            case "byZero":
                System.err.println("Erro: não foi possível realiza a divisão na linha " + tm.getLine(node) + " (Divisão por zero)");
            break;
            case "multi":
                System.err.println("Erro: não foi possível realiza a multiplicação na linha " + tm.getLine(node));
            break;
            case "unComp":
                System.err.println("Erro: a expressão na linha " + tm.getLine(node) + " tem tipos imcompatíveis para comparação.");
            break; 
            default:
                System.err.println("Erro: linha " + tm.getLine(node));
        }
        System.exit(0);
    }
     public void printWarn(String warning, String id_ou_tipo, String exp,Node node){
        switch(warning){
            case "conversao":
                 System.err.println("Aviso: a variável " + id_ou_tipo + " na linha " + tm.getLine(node) + " pode conter erros de conversão.");
            break; 
        }
    }
    @Override
    public void inStart(Start node){  
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
        System.out.println("-------------------------------------------------"); 
        PTipo tipo = node.getTipo();   
        String[] tipoSplited = tipo.toString().split(" ");   
        LinkedList<TId> copy = node.getIdList();  
        System.out.println(tipo.toString());
        if(tipoSplited[0].trim().equals("integer") || tipoSplited[0].trim().equals("real") || tipoSplited[0].trim().equals("symbol")){
                
            System.out.println("O tipo desta declaração é " + node.getTipo());
            System.out.print("Variáveis: "); 
            for(TId e : copy) System.out.print(e.toString());    
                
            System.out.println();
            System.out.println("Ações a serem tomadas na tabela de símbolos:");  
              
             LinkedList<TId>ids  = node.getIdList();
             for(TId e : ids){
               if(tipoSplited.length > 1){
                   int size = Integer.parseInt(tipoSplited[1].trim());
                   boolean flagError = false;
                   if(!this.BLOCOS.get(escopo).verify(e.toString().trim())){ 
                   for(int k=1;k<size+1;k++){
                       if(this.BLOCOS.get(escopo).insert(e.toString().trim() + " "+k, "0", "vet", escopo, tipoSplited[0], true)){
                             System.out.println("-->Inserir ( "+ e.toString().trim() + " "+ k +", " + "0" + ", " +"vet"+", " + (this.escopo+1) + ", " + tipoSplited[0] +")");      flagError = false;
                       }
                       else flagError = true;
                   }
                  }
                   else flagError = true;
                   
                    if(flagError){  
                        this.printError("declaracao", e.toString().trim(), null, node);  
                    }
               }
               else if(this.BLOCOS.get(escopo).insert(e.toString().trim(), "0",  "var", escopo, tipoSplited[0], true)){
                   System.out.println("-->Inserir ( "+ e.toString().trim() +", " + "0" + ", " +"var"+", " + (this.escopo+1) + ", " + tipoSplited[0] +")"); 
               }
               else this.printError("declaracao", e.toString().trim(), null, node);
             }
               
         System.out.println();
        }   
        else this.printError("semTipo", tipo.toString(), null, node); 
    }  
    
    @Override
    public void outAUnaltDeclaracao(AUnaltDeclaracao node){
        System.out.println("-------------------------------------------------");
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
        
         
        String val = (node.getInicialize() != null ? node.getInicialize().toString().trim() : "0");
         String vet = "unalt var";
               if(tipoSplited.length > 1){
                   System.out.println(id.trim() + " é um vector do tipo " + tipoSplited[0].trim() + " de " + tipoSplited[1].trim() + " posições.");
                   vet = "unalt vet";
               } 
               
        if(node.getInicialize() != null && !tipoSplited[0].trim().equals(getType(node.getInicialize().toString().trim()))){
             String inicialize = node.getInicialize().toString().trim();
              
               boolean defIni = false; 
               int j = findScopeVar(inicialize.trim());
               
               defIni = j > -1;
               
               List<Object> getIniInTable = null; 
               String valueInicialize = null;
               String getTypeInTable = null;
               String getCategInTable = null;
               
               if(j > -1){
                   getIniInTable = this.BLOCOS.get(j).findElement(inicialize.trim());   
                   valueInicialize = getIniInTable.get(1).toString() + " ";
                   getTypeInTable = getIniInTable.get(4) + " ";
                   getCategInTable =  getIniInTable.get(2) + " ";
               }  
              if(defIni){  
                     if(node.getTipo().toString().equals(getTypeInTable)){ 
                        
                         this.BLOCOS.get(escopo).insert(id, valueInicialize, getCategInTable.trim(), (this.escopo+1),getTypeInTable, false); 
                         System.out.println("-->Inserir ( "+ id.trim() +", " +  valueInicialize + ", " +getCategInTable+", " + (this.escopo+1) + ", " + getTypeInTable +")"); 
                     }
                     else if(getTypeInTable.equals("integer")){
                         
                         this.BLOCOS.get(escopo).insert(id, inicialize.split(".[0-9]+")[0], getCategInTable, (this.escopo+1), getTypeInTable, false);
                         System.out.println("-->Inserir ( "+ id +", " +  inicialize.split(".[0-9]+")[0] + ", " +getCategInTable+", " + (this.escopo+1) + ", " + getTypeInTable +")"); 
                     }
                     else if(getTypeInTable.equals("real")){
                            String value =  valueInicialize.contains(".") ? valueInicialize : valueInicialize + ".0"; 
                          this.BLOCOS.get(escopo).insert(id.trim(),value,getCategInTable, (this.escopo+1), getTypeInTable, false);
                           System.out.println("-->Inserir ( "+ id.trim() +", " + value + ", " + getCategInTable+", " + (this.escopo+1) + ", " +  getTypeInTable +")"); 
                     }
                     else this.printError("tipo", id, inicialize, node); 
              }
              else if(node.getInicialize() instanceof PValor){    
                    if(getType(inicialize).equals("integer") || getType(inicialize).equals("real")){ 
                        if(null == tipo.toString().trim()) this.printError("tipo", id, inicialize, node); 
                        else switch (tipo.toString().trim()) { 
                            case "integer":
                                { 
                                    this.BLOCOS.get(escopo).insert(id,inicialize.split(".[0-9]+")[0],vet, (this.escopo+1),tipo.toString(), false);
                                    System.out.println("-->Inserir ( "+ id.trim() +", " +  inicialize.split(".[0-9]+")[0] + ", " +vet+", " + (this.escopo+1) + ", " + tipo.toString().trim() +")");
                                    break;
                                }
                            case "real":
                                {
                                    String value = inicialize.contains(".") ? inicialize : inicialize + ".0";
                                    this.BLOCOS.get(escopo).insert(id,value , vet, (this.escopo+1),tipo.toString(), false);
                                    System.out.println("-->Inserir ( "+ id.trim() +", " + value + ", " + vet+", " + (this.escopo+1) + ", " + tipo.toString().trim() +")");
                                    break;
                                }
                            default: 
                                this.printError("tipo", id, inicialize, node);
                                break;
                        } 
                   } 
                   else if(getType(inicialize).equals("symbol") && ("integer".equals(tipo.toString().trim()) || "real".equals(tipo.toString().trim()))){
                        this.BLOCOS.get(escopo).insert(id.trim(),node.getInicialize().toString().trim(), vet, (this.escopo+1),tipo.toString().trim(), false);
                        System.out.println("-->Inserir ( "+ id.trim() +", " +  node.getInicialize().toString().trim() + ", " +vet+", " + (this.escopo+1) + ", " + tipo.toString() +")"); 
                        this.printWarn("conversao", id.trim(), null, node);
                   }
                    else { 
                       this.printError("tipo", id, inicialize, node); 
                   }
                        
              }
               else this.printError("tipo", id, inicialize, node);  
        } 
        else if(this.BLOCOS.get(escopo).insert(id.trim(), val , vet.trim(), (this.escopo+1), tipo.toString().trim(), true)){
           System.out.println("-->Inserir ( "+ id.trim() +", " +  val + ", " +vet+", " + (this.escopo+1) + ", " + tipo.toString() +")");  
           this.printWarn("conversao", id.trim(), null, node);
        }
        else printError("declaracao",id,null,node); 
        
             System.out.println();
      }
     else this.printError("semTipo", tipo.toString(), null, node);
       
   }

    
    @Override  
    public void outACpyCmd(ACpyCmd node){
      System.out.println("-------------------------------------------------");
      String var = node.getVar().toString().trim(); 
      String exp = node.getExp().toString().trim(); 
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
               String getVarCategInTable = null;
               String getVarTypeInTable = null;
               String getExpTypeInTable = null;
               String getExpValueInTable = "0";
               
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
                         this.BLOCOS.get(i).insert(var.trim(), getExpValueInTable, getVarCategInTable, (this.escopo+1), getVarTypeInTable , false); 
                         System.out.println("-->Inserir ( "+ var.trim() +", " +  getExpValueInTable + ", " +getVarCategInTable+", " + (this.escopo+1) + ", " + getVarTypeInTable  +")"); 
                     }
                     else if(getVarTypeInTable.equals("integer") && getExpTypeInTable.equals("real")){  
                             String value = " "; 
                            for(int pos=0;pos<getExpValueInTable.length();pos++){
                                 if(getExpValueInTable.charAt(pos) == '.') break;
                                 value += getExpValueInTable.charAt(pos);
                             }
                         this.BLOCOS.get(i).insert(var.trim(), value.trim(), getVarCategInTable, (this.escopo+1), getVarTypeInTable , false);
                        // System.out.println("-->Inserir ( "+ var.trim() +", " +  value.trim() + ", " +getVarCategInTable+", " + (this.escopo+1) + ", " + getVarTypeInTable  +")"); 
                     }
                     else if(getVarTypeInTable.equals("real") && getExpTypeInTable.equals("integer")){ 
                            String value = getExpValueInTable.contains(".") ? getExpValueInTable : (getExpValueInTable + ".0").trim(); 
                          this.BLOCOS.get(i).insert(var.trim(),value,getVarCategInTable, (this.escopo+1), getVarTypeInTable , false);
                          //System.out.println("-->Inserir ( "+ var.trim() +", " + value + ", " +getVarCategInTable+", " + (this.escopo+1) + ", " +  getVarTypeInTable  +")"); 
                     }
                     else this.printError("tipo",var, exp, node);
              }
              else if(node.getExp() instanceof AValorExp){ 
                    if(getType(exp).equals(getVarTypeInTable)){ 
                        this.BLOCOS.get(i).insert(var.trim(), exp.trim(), getVarCategInTable, escopo,getVarTypeInTable, false);
                    }
                    else if(getType(exp).equals("integer") || getType(exp).equals("real")){ 
                        if(null == getVarTypeInTable)this.printError("tipo",var, exp, node);
                        else switch (getVarTypeInTable) {
                            case "integer":
                                {
                                    String value = " ";
                                    for(int pos=0;pos<exp.length();pos++){
                                        if(exp.charAt(pos) == '.') break;
                                        value += exp.charAt(pos);
                                    }      this.BLOCOS.get(i).insert(var.trim(),value.trim(),getVarCategInTable, (this.escopo+1),getVarTypeInTable, false);
                                    System.out.println("-->Inserir ( "+ var.trim() +", " +  value.trim() + ", " +"var"+", " + (this.escopo+1) + ", " + getVarTypeInTable +")");
                                    break;
                                }
                            case "real":
                                {
                                    String value = exp.contains(".") ? exp : (exp + ".0").trim();
                                    this.BLOCOS.get(i).insert(var.trim(), value , getVarCategInTable, (this.escopo+1),getVarTypeInTable, false);
                                    System.out.println("-->Inserir ( "+ var.trim() +", " + value + ", " + getVarCategInTable+", " + (this.escopo+1) + ", " + getVarTypeInTable +")");
                                    break;
                                }
                            default:
                                this.printError("tipo",var, exp, node);
                                break;
                        }
                   } 
                    else this.printError("tipo",var, exp, node);
              } 
                
               
     }  
     
  }    
    @Override
    public void outAConstCmd(AConstCmd node){
        String unalt = node.getUnalt().toString();
        String exp = node.getExp().toString();
        
        
    }
     @Override
     public void outACaptureCmd(ACaptureCmd node) {
         System.out.println("-------------------------------------------------");
        LinkedList<PVar> var = node.getMultiVar();
            for(PVar e : var){
                int i = findScopeVar(e.toString());
                if(i == -1)
                    this.printError("semDeclaracao", e.toString(), null, node); 
                else{
                     List<Object> getVarInTable = this.BLOCOS.get(i).findElement(e.toString());
                    Scanner scanner = new Scanner (System.in);  
                    Object input = scanner.next();
                    if(getType(input.toString()).equals(getVarInTable.get(4).toString().trim()) ){
                        this.BLOCOS.get(i).insert(getVarInTable.get(0).toString().trim(),input,getVarInTable.get(2).toString().trim(),i+1, getVarInTable.get(4).toString().trim(), false);
                         System.out.println("-->Inserir ( "+ getVarInTable.get(0).toString().trim() +", " + input + ", " + getVarInTable.get(2).toString().trim()+", " + (i+1) + ", " + getVarInTable.get(4).toString().trim() +")");
                    }
                    else 
                        this.printError("tipo", e.toString(), input.toString(), node);
                    
                }
            } 
    }
        @Override
    public void outAShowCmd(AShowCmd node){ 
        for(PExp e : node.getMultiExp()){
            if(e instanceof AValorExp ){  
                    for(int k=0;k<e.toString().length();k++){
                       if(e.toString().charAt(k) != '"')
                           System.out.print(e.toString().charAt(k));
                    }
            } 
            else if(e instanceof AVarExp){
                int i = findScopeVar(e.toString()); 
               if(i == -1) this.printError("semDeclaracao", e.toString(), null, node);   
               else System.out.print(this.BLOCOS.get(i).findElement(e.toString().trim()).get(1));  
            }
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
            if (i != -1){  
                 List<Object> element = this.BLOCOS.get(i).findElement(node.toString());
                 tipo = element.get(4).toString();
                 if(element.get(1) == null || element.get(1).toString().equals("null")){
                     System.err.print("Erro: não é possível negativar \"" + exp.toString().trim() + "\" na linha " + tm.getLine(node));
                     System.err.println(": O valor de \"" + exp.toString().trim() + "\" é null");
                 }
                 else if(tipo.equals("integer")){ 
                     Integer negElem = -Integer.parseInt(element.get(1).toString().trim()); 
                     this.BLOCOS.get(i).insert(node.toString().trim(), negElem, element.get(2).toString(), escopo+1,element.get(4).toString(), false);
                     System.out.println("-->Inserir ( "+ element.get(0).toString().trim() +", " + negElem + ", " + element.get(2).toString() +", " + (this.escopo+1) + ", " + element.get(4).toString().trim() +")");
                 }
                 else if(tipo.equals("real")){
                     Double negElem = -Double.parseDouble(element.get(1).toString().trim()); 
                     this.BLOCOS.get(i).insert(node.toString().trim(), negElem, element.get(2).toString(), escopo+1,element.get(4).toString(), false);   
                     System.out.println("-->Inserir ( "+ element.get(0).toString().trim() +", " + negElem + ", " + element.get(2).toString() +", " + (this.escopo+1) + ", " + element.get(4).toString().trim() +")");
                 } 
            } 
            else this.printError("semDeclaracao", exp.toString(),null, node);
        }
        else if(node.getRight() instanceof AValorExp){
                tipo = getType(exp.toString().trim());
             switch (tipo) {
                 case "integer":
                     {
                         Integer negElem = -Integer.parseInt(exp.toString().trim());
                         this.BLOCOS.get(escopo).insert(node.toString().trim(), negElem, "val", escopo+1,tipo, true);
                         System.out.println("-->Inserir ( "+ exp.toString().trim() +", " + negElem + ", " +  "val" +", " + (this.escopo+1) + ", " + tipo +")");
                         break;
                     }
                 case "real":
                     {
                         Double negElem = -Double.parseDouble(exp.toString().trim());
                         this.BLOCOS.get(escopo).insert(node.toString().trim(), negElem, "val", escopo+1,tipo, true);
                          System.out.println("-->Inserir ( "+ exp.toString().trim() +", " + negElem + ", " +  "val" +", " + (this.escopo+1) + ", " + tipo +")");
                         break;
                     }
                 default:
                     System.err.println("Erro: não é possível negativar \"" + exp.toString().trim() + "\" na linha " + tm.getLine(node));
                     break;
             }
        }
        
    }
        @Override
    public void outASomaExp(ASomaExp node){ 
        this.GenericOperations("soma",node,node.getLeft(), node.getRight());
    }
        @Override
    public void outASubtrExp(ASubtrExp node){
        this.GenericOperations("subtr",node,node.getLeft(), node.getRight());
    }
        @Override
    public void outAMultiExp(AMultiExp node){
        this.GenericOperations("multi",node,node.getLeft(), node.getRight());
    }
        @Override
    public void outADivExp(ADivExp node){
        this.GenericOperations("div",node,node.getLeft(), node.getRight());
    }
        @Override
    public void outAOuExp(AOuExp node){
         checkTypeBeforeCompare(node.getLeft(),node.getRight(),node);
    } 
        @Override
    public void outAXouExp(AXouExp node){
        checkTypeBeforeCompare(node.getLeft(),node.getRight(),node);
    }
        @Override
    public void outAEExp(AEExp node){
        checkTypeBeforeCompare(node.getLeft(),node.getRight(),node);
    }
        @Override
    public void outAMaiorExp(AMaiorExp node){
        checkTypeBeforeCompare(node.getLeft(),node.getRight(),node);
    }
        @Override
    public void outAMenorExp(AMenorExp node){
        checkTypeBeforeCompare(node.getLeft(),node.getRight(),node);
    }
        @Override
    public void outAIgualExp(AIgualExp node){
        checkTypeBeforeCompare(node.getLeft(),node.getRight(),node);
    }
        @Override
    public void outAMaiorOuIgualExp(AMaiorOuIgualExp node){
        checkTypeBeforeCompare(node.getLeft(),node.getRight(),node);
    }
        @Override
    public void outAMenorOuIgualExp(AMenorOuIgualExp node){
        checkTypeBeforeCompare(node.getLeft(),node.getRight(),node);
    }
        @Override
    public void outADiffExp(ADiffExp node){
        checkTypeBeforeCompare(node.getLeft(),node.getRight(),node);
    }
    public void checkTypeBeforeCompare(PExp getLeft, PExp getRight, Node node){
         String left = getLeft.toString().trim();
         String right = getRight.toString().trim();
         
        if(getLeft instanceof AValorExp && getRight instanceof AValorExp){
             String tipoLeft = getType(left);
             String tipoRight = getType(right);
             
              couldComp(tipoLeft,tipoRight,node); 
        }
        else if(getLeft instanceof AVarExp && getRight instanceof AValorExp){
            int i = findScopeVar(left);
            if(i !=-1){
             List<Object>getLeftInTable = this.BLOCOS.get(i).findElement(left);
             couldComp(getLeftInTable.get(4).toString(),getType(getRight.toString().trim()),node); 
            }
            else this.printError("semDeclaracao", left, null, node);
        }
        else if(getLeft instanceof AValorExp && getRight instanceof AVarExp){
            int i = findScopeVar(right);
            if(i != -1){
            List<Object>getRightInTable = this.BLOCOS.get(i).findElement(right);
            couldComp(getType(getLeft.toString().trim()),getRightInTable.get(4).toString(),node);
            }
             else this.printError("semDeclaracao", right, null, node); 
        }
        else if(getLeft instanceof AVarExp && getRight instanceof AVarExp){
            int i = findScopeVar(left);
            int j = findScopeVar(right);
            if(i != -1 && j!=-1){
                List<Object>getLeftInTable = this.BLOCOS.get(i).findElement(left);
                List<Object>getRightInTable = this.BLOCOS.get(j).findElement(right);
                couldComp(getLeftInTable.get(4).toString(),getRightInTable.get(4).toString(),node);
            }
            else if(i==-1) this.printError("semDeclaracao", left, null, node); 
            else this.printError("semDeclaracao", right, null, node); 
        }
    }
    public void couldComp(String tipoLeft, String tipoRight, Node node){ 
        if(tipoLeft.trim().equals("integer") && tipoRight.trim().equals("symbol") || tipoLeft.trim().equals("real") && tipoRight.trim().equals("symbol") ||
                 tipoLeft.equals("symbol") && tipoRight.trim().equals("integer") || tipoLeft.trim().equals("symbol") && tipoRight.trim().equals("real")){ 
                    this.printError("unComp", null, null, node);
              } 
    }
    public void GenericOperations(String op, Node node, PExp getLeft, PExp getRight){ 
        String left = getLeft.toString().trim();
        String right = getRight.toString().trim(); 
         
        if(getLeft instanceof AValorExp && getRight instanceof AValorExp){
            String tipoLeft = getType(getLeft.toString().trim());
            String tipoRight = getType(getRight.toString().trim());
            
            if(tipoLeft.equals(tipoRight)){
                switch (tipoLeft) {
                    case "integer":
                        {
                           switch(op){
                               case "multi":
                                   {
                                        Integer result = Integer.parseInt(left) * Integer.parseInt(right);
                                        this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                        System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                        break;
                                   }
                               case "div":
                                   {
                                        Double dividendo = Double.parseDouble(right);
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node); 
                                                 break;
                                            } 
                                        Double result = Double.parseDouble(left) / dividendo;
                                        this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                         System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                        break;
                                   }
                               case "soma":
                                   {   
                                        Integer result = Integer.parseInt(left) + Integer.parseInt(right);
                                        this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                        System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                        break;
                                   }
                               case "subtr":
                                   {
                                        Integer result = Integer.parseInt(left) - Integer.parseInt(right);
                                        this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                        System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                        break;  
                                   }
                           }
                           break;
                        }
                    case "real":
                        {
                            switch(op){
                                case "multi":
                                    {
                                       Double result = Double.parseDouble(left) * Double.parseDouble(right);
                                       this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                       System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");  
                                       break;
                                    }
                                case "div":
                                    {
                                        Double dividendo = Double.parseDouble(right);
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            } 
                                        
                                       Double result = Double.parseDouble(left) / dividendo;
                                       this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                       System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");  
                                       break;
                                    }
                                case "soma":
                                    {
                                       Double result = Double.parseDouble(left) + Double.parseDouble(right);
                                       this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                       System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");  
                                       break;
                                    }
                                case "subtr":
                                    {
                                       Double result = Double.parseDouble(left) - Double.parseDouble(right);
                                       this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                       System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");  
                                       break;
                                    }
                            }
                            break;
                        }
                    default:
                        this.printError(op,null,null, node);
                        break;
                }
            }
            else if(tipoLeft.equals("integer") && tipoRight.equals("real")){
                switch(op){
                    case "multi":
                        {
                            Double result = Integer.parseInt(left) * Double.parseDouble(right);
                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                            break; 
                        }
                    case "div":
                        {
                            Double dividendo = Double.parseDouble(right);
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            } 
                            Double result = Integer.parseInt(left) / dividendo;
                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                            break;  
                        }
                    case "soma":
                        {
                            Double result = Integer.parseInt(left) + Double.parseDouble(right);
                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                            break;  
                        }
                    case "subtr":
                        {
                            Double result = Integer.parseInt(left) - Double.parseDouble(right);
                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                            break;  
                        }
                    default:
                        this.printError(op,null,null, node);
                        break;
                } 
            }
            else if(tipoLeft.equals("real") && tipoRight.equals("integer")){
                switch(op){
                    case "multi":
                        {
                            Double result = Double.parseDouble(left) * Integer.parseInt(right);
                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                            break; 
                        }
                    case "div":
                        {
                            Integer dividendo = Integer.parseInt(right);
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            } 
                            Double result = Double.parseDouble(left) / dividendo;
                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " + op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                            break;  
                        }
                    case "soma":
                        {
                            Double result = Double.parseDouble(left) + Integer.parseInt(right);
                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                            break;  
                        }
                    case "subtr":
                        {
                            Double result = Double.parseDouble(left) - Integer.parseInt(right);
                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                            break;   
                        }
                    default:
                        this.printError(op,null,null, node);
                        break;
                        
                } 
            }
            else this.printError(op,null,null, node);
        }
        else if((  getLeft instanceof AVarExp 
                || getLeft instanceof AMultiExp 
                || getLeft instanceof ADivExp 
                || getLeft instanceof ASomaExp 
                || getLeft instanceof ASubtrExp ) && getRight instanceof AValorExp 
               )
        {
            int k = findScopeVar(left);
            if(k != -1){
                List<Object> getVarInTable = this.BLOCOS.get(k).findElement(left);
                if(getVarInTable.get(4).equals("integer")){
                    switch (getType(right)) {
                        case "integer":
                            {
                                switch(op){
                                    case "multi":
                                        {
                                            Integer result = Integer.parseInt(getVarInTable.get(1).toString().trim()) * Integer.parseInt(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break; 
                                        }
                                    case "div":
                                        {   
                                            Integer dividendo = Integer.parseInt(right);
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Integer result = Integer.parseInt(getVarInTable.get(1).toString().trim()) / dividendo;
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break; 
                                        }
                                    case "soma":
                                        {
                                            Integer result = Integer.parseInt(getVarInTable.get(1).toString().trim()) + Integer.parseInt(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break; 
                                        }
                                    case "subtr":
                                        {
                                            Integer result = Integer.parseInt(getVarInTable.get(1).toString().trim()) - Integer.parseInt(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break; 
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            }
                        case "real":
                            {
                                switch(op){
                                    case "multi":
                                        {
                                            Double result = Integer.parseInt(getVarInTable.get(1).toString().trim()) * Double.parseDouble(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break; 
                                        }
                                    case "div":
                                        {
                                            Double dividendo = Double.parseDouble(right);
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            } 
                                            Double result = Integer.parseInt(getVarInTable.get(1).toString().trim()) / dividendo;
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break; 
                                        }
                                    case "soma":
                                        {
                                            Double result = Integer.parseInt(getVarInTable.get(1).toString().trim()) + Double.parseDouble(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break; 
                                        }
                                    case "subtr":
                                        {
                                            Double result = Integer.parseInt(getVarInTable.get(1).toString().trim()) - Double.parseDouble(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break; 
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            } 
                        default:
                            this.printError(op,null,null, node);
                            break;
                    }
                }
                else if(getVarInTable.get(4).equals("real")){
                    switch (getType(right)) {
                        case "integer": 
                            {
                                switch(op){
                                    case "multi":
                                        {
                                            Double result = Double.parseDouble(getVarInTable.get(1).toString().trim()) * Integer.parseInt(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "div":
                                        {
                                            Integer dividendo = Integer.parseInt(right);
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Double result = Double.parseDouble(getVarInTable.get(1).toString().trim()) / dividendo;
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " + op +", " + (this.escopo+1) + ", " + getType(result.toString()) +")");
                                            break;
                                        }
                                    case "soma":
                                        {
                                            Double result = Double.parseDouble(getVarInTable.get(1).toString().trim()) + Integer.parseInt(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " + op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "subtr":
                                        {
                                            Double result = Double.parseDouble(getVarInTable.get(1).toString().trim()) - Integer.parseInt(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " + op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            }  
                        case "real":
                            {
                                switch(op){
                                    case "multi":
                                        {
                                            Double result = Double.parseDouble(getVarInTable.get(1).toString().trim()) * Double.parseDouble(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "div":
                                        {
                                            Double dividendo = Double.parseDouble(right);
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Double result = Double.parseDouble(getVarInTable.get(1).toString().trim()) / dividendo;
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "soma":
                                        {
                                            Double result = Double.parseDouble(getVarInTable.get(1).toString().trim()) + Double.parseDouble(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "subtr":
                                        {
                                            Double result = Double.parseDouble(getVarInTable.get(1).toString().trim()) - Double.parseDouble(right);
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            } 
                        default:
                            this.printError(op,null,null, node);
                            break;
                    }
                } else this.printError(op,null,null, node);
            }
            else this.printError("semDeclaracao", left, null, node);
            
        }
        else if(getLeft instanceof AValorExp && (  
               getRight instanceof AVarExp 
            || getRight instanceof AMultiExp 
            || getRight instanceof ADivExp 
            || getRight instanceof ASomaExp 
            || getRight instanceof ASubtrExp ))
        { 
             int k = findScopeVar(right);  
            if(k != -1){
                 List<Object> getVarInTable = this.BLOCOS.get(k).findElement(right);
                 if(getVarInTable.get(4).equals("integer")){
                     switch (getType(left)) {
                         case "integer":
                             { 
                                switch(op){
                                    case "multi":
                                        {  
                                            Integer result =  Integer.parseInt(left) * Integer.parseInt(getVarInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ("+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "div":
                                        {
                                            Integer dividendo = Integer.parseInt(getVarInTable.get(1).toString().trim());
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Integer result =  Integer.parseInt(left) / dividendo;
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ("+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "soma": 
                                        {  
                                            Integer result =  Integer.parseInt(left) + Integer.parseInt(getVarInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, "integer", true);
                                             System.out.println("-->Inserir ("+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + "integer" +")");
                                            break;
                                        }
                                    case "subtr":
                                        {
                                            Integer result =  Integer.parseInt(left) - Integer.parseInt(getVarInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                             System.out.println("-->Inserir ("+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            } 
                         case "real":
                             {
                                switch(op){
                                    case "multi":
                                        {
                                            Double result = Double.parseDouble(left) * Integer.parseInt(getVarInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "div":
                                        {
                                            Integer dividendo = Integer.parseInt(getVarInTable.get(1).toString().trim());
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Double result = Double.parseDouble(left) / dividendo;
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "soma":
                                        {
                                            Double result = Double.parseDouble(left) + Integer.parseInt(getVarInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) + ")");
                                            break;
                                        }
                                    case "subtr":
                                        {
                                            Double result = Double.parseDouble(left) - Integer.parseInt(getVarInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            } 
                         default: 
                             this.printError(op, null, null, node);
                             break;
                     }
                 }
                 else if(getVarInTable.get(4).equals("real")){
                     switch (getType(left)) {
                         case "integer":
                             {
                                switch(op){
                                    case "multi":
                                        {
                                            Double result =  Integer.parseInt(left) * Double.parseDouble(getVarInTable.get(1).toString());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "div":
                                        {
                                            Double dividendo = Double.parseDouble(getVarInTable.get(1).toString());
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Double result =  Integer.parseInt(left) / dividendo;
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "soma":
                                        {
                                            Double result =  Integer.parseInt(left) + Double.parseDouble(getVarInTable.get(1).toString());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "subtr":
                                        {
                                            Double result =  Integer.parseInt(left) - Double.parseDouble(getVarInTable.get(1).toString());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            } 
                         case "real":
                             {
                                switch(op){
                                    case "multi":
                                        {
                                            Double result =  Double.parseDouble(left) * Double.parseDouble(getVarInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "div":
                                       {
                                            Double dividendo = Double.parseDouble(getVarInTable.get(1).toString().trim());
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Double result =  Double.parseDouble(left) / dividendo;
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "soma":
                                        {
                                            Double result =  Double.parseDouble(left) + Double.parseDouble(getVarInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "subtr":
                                        {
                                            Double result =  Double.parseDouble(left) - Double.parseDouble(getVarInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            } 
                         default:
                             this.printError(op, null, null, node);
                             break;
                     }
                 }
            }
            else this.printError("semDeclaracao", right, null, node); 
        }
        else if((  
                   getLeft instanceof AVarExp 
                || getLeft instanceof AMultiExp 
                || getLeft instanceof ADivExp 
                || getLeft instanceof ASomaExp 
                || getLeft instanceof ASubtrExp )
                && 
                ( getRight instanceof AVarExp 
                || getRight instanceof AMultiExp 
                || getRight instanceof ADivExp 
                || getRight instanceof ASomaExp 
                || getRight instanceof ASubtrExp ))
        {
            int i = findScopeVar(left);
            int j = findScopeVar(right);
            
            if(i != -1 && j !=-1){
                List<Object> getLeftInTable = this.BLOCOS.get(i).findElement(left);
                List<Object> getRightInTable = this.BLOCOS.get(j).findElement(right);
               
               if(getLeftInTable.get(4).equals("integer")){ 
                    switch (getRightInTable.get(4).toString().trim()) {
                        case "integer":
                            { 
                                switch(op){
                                    case "multi":
                                        {
                                            Integer result = Integer.parseInt(getLeftInTable.get(1).toString().trim()) * Integer.parseInt(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "div":
                                       {
                                            Integer dividendo = Integer.parseInt(getRightInTable.get(1).toString().trim());
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Integer result = Integer.parseInt(getLeftInTable.get(1).toString().trim()) / Integer.parseInt(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "soma":
                                        {
                                            Integer result = Integer.parseInt(getLeftInTable.get(1).toString().trim()) + Integer.parseInt(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "subtr":
                                        {
                                            Integer result = Integer.parseInt(getLeftInTable.get(1).toString().trim()) - Integer.parseInt(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            } 
                        case "real":
                            {
                                switch(op){
                                    case "multi":
                                        {
                                            Double result = Integer.parseInt(getLeftInTable.get(1).toString().trim()) * Double.parseDouble(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "div":
                                       {
                                           Double dividendo = Double.parseDouble(getRightInTable.get(1).toString().trim());
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Double result = Integer.parseInt(getLeftInTable.get(1).toString().trim()) / Double.parseDouble(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "soma":
                                        {
                                            Double result = Integer.parseInt(getLeftInTable.get(1).toString().trim()) + Double.parseDouble(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "subtr":
                                        {
                                            Double result = Integer.parseInt(getLeftInTable.get(1).toString().trim()) - Double.parseDouble(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            }  
                        default:
                            this.printError(op, null, null, node);
                            break;
                    }
               }
               else if(getLeftInTable.get(4).equals("real")){ 
                    switch (getRightInTable.get(4).toString().trim()) {
                        case "integer":
                            {
                                switch(op){
                                    case "multi":
                                        {
                                            Double result = Double.parseDouble(getLeftInTable.get(1).toString().trim()) * Integer.parseInt(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "div":
                                       {
                                            Integer dividendo = Integer.parseInt(getRightInTable.get(1).toString().trim());
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Double result = Double.parseDouble(getLeftInTable.get(1).toString().trim()) / dividendo;
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "soma":
                                        {
                                            Double result = Double.parseDouble(getLeftInTable.get(1).toString().trim()) + Integer.parseInt(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "subtr":
                                        {
                                            Double result = Double.parseDouble(getLeftInTable.get(1).toString().trim()) - Integer.parseInt(getRightInTable.get(1).toString().trim());
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            } 
                        case "real":
                            {
                                switch(op){
                                    case "multi":
                                        {
                                            Double result = Double.parseDouble(getLeftInTable.get(1).toString().trim()) * Double.parseDouble(getRightInTable.get(1).toString().trim()); 
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "div":
                                       {
                                             Double dividendo = Double.parseDouble(getRightInTable.get(1).toString().trim()); 
                                            if(dividendo == 0){
                                                 this.printError("byZero", null, null, node);
                                                
                                                break;
                                            }
                                            Double result = Double.parseDouble(getLeftInTable.get(1).toString().trim()) / dividendo; 
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    case "soma":
                                        {
                                            Double result = Double.parseDouble(getLeftInTable.get(1).toString().trim()) + Double.parseDouble(getRightInTable.get(1).toString().trim()); 
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + "real" +")");
                                            break;
                                        }
                                    case "subtr":
                                        {
                                            Double result = Double.parseDouble(getLeftInTable.get(1).toString().trim()) - Double.parseDouble(getRightInTable.get(1).toString().trim()); 
                                            this.BLOCOS.get(escopo).insert(node.toString().trim(), result, op, escopo+1, getType(result.toString().trim()), true);
                                            System.out.println("-->Inserir ( "+ node.toString().trim() +", " + result + ", " +  op +", " + (this.escopo+1) + ", " + getType(result.toString().trim()) +")");
                                            break;
                                        }
                                    default:
                                            this.printError(op,null,null, node);
                                            break;
                                }
                               break;
                            } 
                        default:
                            this.printError(op, null, null, node);
                            break;
                    }
               }
            }
            else if(i == -1) this.printError("semDeclaracao", left, null, node); 
            else this.printError("semDeclaracao", right, null, node); 
        }
        else this.printError(op,null,null, node); 
    }
}