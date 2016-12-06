package br.acme.gui;

public class eViagem {
	private Long id;
	private String motorista;
	private String origem;
	private String destino;
	public eViagem(Long id, String motorista, String origem, String destino) {
		this.id = id;
		this.motorista = motorista;
		this.origem = origem;
		this.destino = destino;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMotorista() {
		return motorista;
	}
	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
}
