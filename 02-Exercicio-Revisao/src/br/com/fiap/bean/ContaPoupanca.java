package br.com.fiap.bean;

import java.util.Calendar;

public class ContaPoupanca extends Conta 
							implements ContaInvestimento{

	private float taxa;
	//f=float se não ele acha que é double
	public static final float RENDIMENTO = 0.005f;
	
	@Override
	public double calculaRetornoInvestimento() {
		
		return saldo*RENDIMENTO;
	}

	@Override
	public double retirar(double valor) throws Exception {
		if(valor + taxa > saldo) {
			throw new Exception("Saldo insuficiente");
		}
		return saldo-=valor + taxa;
	}
	
	public ContaPoupanca() {
		
	}
	
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}
	
	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
