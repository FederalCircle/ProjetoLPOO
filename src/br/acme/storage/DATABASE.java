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
	
	private static void gravarDados(Object obj , int id){
		try{
			arqGrv = new FileOutputStream("db/"+geraNome(obj, id));
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
    	DATABASE.gravarDados(rep, rep.getId());
	}
	/*public static void salvarEstado(IRepositorio<Solicitante> repSolic){
		DATABASE.gravarDados(repSolic, repSolic.getId());
	}
	public static void salvarEstado(IRepositorio<Viagem> repViagem){
		DATABASE.gravarDados(repViagem, repViagem.getId());
	}*/
	public static void salvarEstado(Gerente gerente){
		DATABASE.gravarDados(gerente, (int)gerente.getId());
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
	
	public static RepositorioSolicitante lerBaseSolicitante(int id){
		return (RepositorioSolicitante) lerDados("db/RepositorioSolicitante-"+id);
	}
	public static RepositorioMotorista lerBaseMotorista(int id){
		return (RepositorioMotorista) lerDados("db/RepositorioMotorista-"+id);
	}
	public static RepositorioViagem lerBaseViagem(int id){
		return (RepositorioViagem) lerDados("db/RepositorioViagem-"+id);
	}
	public static Gerente lerBaseGerente(int id){
		return (Gerente) lerDados("db/Gerente-"+id);
	}
	
}
