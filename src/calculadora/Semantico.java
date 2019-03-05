package calculadora;

import java.util.ArrayList;
import java.util.List;

import calculadora.analysis.*;
import calculadora.node.*;
import java.util.LinkedList; 

public class Semantico extends DepthFirstAdapter {

	@Override
	public void inStart(Start node)
	    {
		   System.out.println("-------------------------------------------------");
		   System.out.println("Iniciando análise semântica...");
	    }
	
	 @Override
	 public void outStart(Start node)
	    {
		System.out.println("-------------------------------------------------");
	        System.out.println("Fim da análise semântica");
	        System.out.println("-------------------------------------------------");
			  
	    }  
         public void outAProgramaPrograma(AProgramaPrograma node)
             {
                   System.out.println("-------------------------------------------------");
                   System.out.println(node.getBloco().toString());
                   System.out.println("-------------------------------------------------");
             }
         
        @Override
	 public void outATipoDeclaracao(ATipoDeclaracao node)
	    {
		 		 
		  System.out.println("-------------------------------------------------");
		  System.out.println("O tipo desta declaração é " + node.getTipo()); 
		  System.out.print("Variáveis: ");
		  LinkedList<PMultiId> copy = node.getMultiId();
          for(PMultiId e : copy){ 
              System.out.print(e.toString());
          } 
          System.out.println(node.getId().toString());
          System.out.println();
          System.out.println("Ações a serem tomadas na tabela de símbolos:");
          for(PMultiId e : copy){
              System.out.println("-->Inserir ( "+ e.toString()+", " +node.getTipo()+")");
          }
          System.out.println("-->Inserir ( "+ node.getId().toString()+", " +node.getTipo()+")");
	    }
        @Override
	 public void outAUnaltDeclaracao(AUnaltDeclaracao node)
	    {
		 		 
		  System.out.println("-------------------------------------------------");
		  System.out.println("O tipo desta declaração é " + node.getTipo()); 
		  System.out.print("Variáveis: ");
		  TId copy = node.getId(); 
          if(" ".equals(node.getInicialize().toString())) 
              System.out.print(copy.toString());
          else System.out.print(copy.toString() + "= " + node.getInicialize().toString());
          
          System.out.println();
          System.out.println("Ações a serem tomadas na tabela de símbolos:"); 
          System.out.println("-->Inserir ( "+ copy.toString()+", " +node.getTipo()+")");  
	 
           }
}