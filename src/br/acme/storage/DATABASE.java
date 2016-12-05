package br.acme.storage;
import br.acme.users.*;
import java.io.*;
import br.acme.location.*;

public class DATABASE {
	static String nomeIRepMotor= "repMotor";
	static String nomeIRepViagem= "repViagem";
	static String nomeIRepSolic= "repSolic";
	static String nomeArqGerente= "gerente";
	static FileOutputStream arqGrv;
	static ObjectOutputStream objGrv;
	static FileInputStream arqLer;
	static ObjectInputStream objLer;

	private static String geraNome(Object obj, int id){
		return obj.getClass().getSimpleName()+"-"+id;
	}
	
	private static void gravarDados(Object obj){
		try{
			arqGrv = new FileOutputStream("db/db_"+obj.getClass().getSimpleName());
	    	objGrv = new ObjectOutputStream(arqGrv);
	        objGrv.writeObject(obj);	         
	        objGrv.flush(); objGrv.close();	        
	        arqGrv.flush(); arqGrv.close();
	        System.out.println("Repositório salvo com sucesso!");
		} catch(IOException e){
			System.out.println("Erro ao tentar salvar o Repositório.");
		}
	}
	
	public static void salvarEstado(IRepositorio rep){
    	DATABASE.gravarDados(rep);
	}
	/*public static void salvarEstado(IRepositorio<Solicitante> repSolic){
		DATABASE.gravarDados(repSolic, repSolic.getId());
	}
	public static void salvarEstado(IRepositorio<Viagem> repViagem){
		DATABASE.gravarDados(repViagem, repViagem.getId());
	}*/
	public static void salvarEstado(Gerente gerente){
		DATABASE.gravarDados(gerente);
	}
	
	// -------------------------------------------------------
	
	private static Object lerDados(String nomeArq){
		try
        { 	
			objLer = new ObjectInputStream(new FileInputStream(nomeArq));
			return objLer.readObject();
        }catch( Exception e ){
            e.printStackTrace( );
            return null;
        }
	}
	
	public static RepositorioSolicitante lerBaseSolicitante(){
		return (RepositorioSolicitante) lerDados("db/db_RepositorioSolicitante");
	}
	public static RepositorioMotorista lerBaseMotorista(){
		return (RepositorioMotorista) lerDados("db/db_RepositorioMotorista");
	}
	public static RepositorioViagem lerBaseViagem(){
		return (RepositorioViagem) lerDados("db/db_RepositorioViagem");
	}
	public static Gerente lerBaseGerente(){
		return (Gerente) lerDados("db/db_Gerente");
	}
	
}
