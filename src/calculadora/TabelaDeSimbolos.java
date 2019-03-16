 package calculadora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author hermanyo
 */
public class TabelaDeSimbolos {
    private final int SIZE = 1023;
    private final int SHIFT = 4;  
    private final HashMap<Integer,List<Object>> symbolTable = new HashMap<>(); 
     
    public HashMap<Integer, List<Object>> getSymbolTable(){
        return this.symbolTable;
    }
     
    public int hash(String id){
        String key = id.trim();
        int temp = 0;
        int i = 0; 
        while (true){
            temp = ((temp << this.SHIFT) + key.charAt(i++)) % this.SIZE; 
            if(i>=key.length()) break;
        }
        return temp; 
    } 
    public boolean verify(String id){//verifica se um variável de mesmo nome já foi declarada no mesmo escopo  
        return this.symbolTable.containsKey(this.hash(id));
    }
    public List<Object> findElement(String id){
        return this.symbolTable.get(this.hash(id.trim()));
    }
    //HashMap<[Variavel,categoria, definido, escopo], tipo>
    public boolean insert(String id,Object value,String categ,int scope, String type, boolean verify){
         
         List<Object> columns = new ArrayList<>();
         int checksum = this.hash(id);
         columns.add(id); 
         columns.add(value); 
         columns.add(categ);
         columns.add(scope);
         columns.add(type);  
         if(!verify){
            this.symbolTable.put(checksum,columns); 
            return true;
        } 
        else if(!this.symbolTable.containsKey(checksum)){ //Se não existir insira e retorne true  
            this.symbolTable.put(checksum,columns); 
            return true;
        }
         
        return false; //caso contrário retorne false  
    } 
}
