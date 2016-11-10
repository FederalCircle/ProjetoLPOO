package br.acme.storage;
import br.acme.users.*;
import br.acme.storage.*;
import java.io.*;

public class DATABASE {
	static String nomeIRepMotor= "repMotor";
	static String nomeIRepViagem= "repViagem";
	static String nomeIRepSolic= "repSolic";
	static String nomeArqGerente= "gerente";
	static FileOutputStream arquivoGrav;
	static ObjectOutputStream objGravar;
	static FileInputStream arquivoLeitura;
	static ObjectInputStream objLeitura;


	public DATABASE(String nome)throws Exception{
		arquivoGrav = new FileOutputStream(nomeIRepMotor);
		objGravar = new ObjectOutputStream(arquivoGrav);
		arquivoGrav = new FileOutputStream(nomeArqGerente);
		objGravar = new ObjectOutputStream(arquivoGrav);
		
		arquivoLeitura = new FileInputStream(nome);
		objLeitura= new ObjectInputStream(arquivoLeitura);		

	}
	
	public static void salvarEstado(IRepositorioMotorista repMotor , String nomeIRepMotor)throws IOException{

     try{   
    	arquivoGrav = new FileOutputStream(nomeIRepMotor+"-"+Integer.toString(repMotor.getId()));
    	objGravar = new ObjectOutputStream(arquivoGrav);
        objGravar.writeObject(repMotor);
         
        objGravar.flush();
        
        objGravar.close();
        
        arquivoGrav.flush();
        
        arquivoGrav.close();
        System.out.println("Repositorio gravado com sucesso!");
	}   catch( Exception e ){

            e.printStackTrace( );

    }


	}
	public static void salvarEstado(IRepositorioSolicitante repSolic, String nomeIRepSolic){
	     try{
	    	arquivoGrav = new FileOutputStream(nomeIRepSolic);
	 		objGravar = new ObjectOutputStream(arquivoGrav);
	        
	 		objGravar.writeObject(repSolic);
	         
	        objGravar.flush();
	        
	        objGravar.close();
	        
	        arquivoGrav.flush();
	        
	        arquivoGrav.close();
	        System.out.println("Repositorio gravado com sucesso!");
		}   catch( Exception e ){

	            e.printStackTrace( );

	    }	
	}
	public static void salvarEstado(IRepositorioViagem repViagem, String nomeIRepViagem){
	     try{
	    	arquivoGrav = new FileOutputStream(nomeIRepViagem);
	 		objGravar = new ObjectOutputStream(arquivoGrav);
	        objGravar.writeObject(repViagem);
	         
	        objGravar.flush();
	        
	        objGravar.close();
	        
	        arquivoGrav.flush();
	        
	        arquivoGrav.close();
	        System.out.println("Gerente gravado com sucesso!");
		}   catch( Exception e ){

	            e.printStackTrace( );

	    }
	}
	public static void salvarEstado(Gerente gerente, String nomeArqGerente){
	     try{
	    	arquivoGrav = new FileOutputStream(nomeArqGerente);
	 		objGravar = new ObjectOutputStream(arquivoGrav);
	 		
	    	 
	        objGravar.writeObject(gerente);
	         
	        objGravar.flush();
	        
	        objGravar.close();
	        
	        arquivoGrav.flush();
	        
	        arquivoGrav.close();
	        System.out.println("Repositorio gravado com sucesso!");
		}   catch( Exception e ){

	            e.printStackTrace( );

	    }
	}
	public static RepositorioSolicitante lerBaseSolicitante(){
		 try

	        { 
	            System.out.println(objLeitura.toString());

	            objLeitura.close();

	            arquivoLeitura.close();

	        }catch( Exception e ){

                e.printStackTrace( );

        }
		return null;
	}
	public static IRepositorioMotorista lerBaseMotorista(String nomeArq){
		try
        { 	
			objLeitura = new ObjectInputStream(new FileInputStream(nomeArq));
			System.out.println("ola");
			return (IRepositorioMotorista)objLeitura.readObject();
            
        }catch( Exception e ){
            e.printStackTrace( );
        }
		return null;
	}
	public static RepositorioViagem lerBaseViagem(){
		return null;
	}
	public static Gerente lerBaseGerente(){
		return null;
	}
	
}
