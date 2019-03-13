 package calculadora;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hermanyo
 */
public class TabelaDeSimbolos {
    private final int SIZE =  255;
    private final int SHIFT = 4;
     //HashMap<[0,1,2,3,],tipo>
     //HashMap<[Variavel,categoria, definido, escopo], tipo> 
    private final HashMap<Integer,ArrayList<String>> symbolTable = new HashMap<>(); 
    
    public HashMap<Integer,ArrayList<String>> getSymbolTable(){
       return this.symbolTable;
    }
    public int hash(String key){
        int temp = 0;
        int i = 0; 
        while (key.charAt(i) != '\0'){
            temp = ((temp << this.SHIFT) + key.charAt(i)) % this.SIZE;
            ++i;
            if(i>=key.length()) break;
        }
        return temp;
    }
    //HashMap<[Variavel,categoria, definido, escopo], tipo>
    public boolean verify(int key, ArrayList<String>columns){//verifica se um variável de mesmo nome já foi declarada no mesmo escopo 
           return this.symbolTable.containsKey(key) && this.symbolTable.get(key).get(2).equals(columns.get(2)); 
    }
    public boolean insert(String id,String categ,String def,String scope, String type){
        int checksum = this.hash(id);
        ArrayList<String>columns = new ArrayList<>();
            columns.add(categ);
            columns.add(def);
            columns.add(scope);
            columns.add(type); 
            
        if(!this.verify(checksum, columns)){ //Se não existir insira e retorne true 
            this.symbolTable.put(checksum,columns); 
            return true;
        } 
        return false; //caso contrário retorne false  
    }
    
}
