package it.polito.tdp.numero.model;

import java.security.InvalidParameterException;

public class NumeroModel {
	
	private final int NMAX = 100;
	private final int TMAX = 8;

	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;

	
	public int getTMAX() {
		return TMAX;
	}

	public int getSegreto() {
		return segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public boolean isInGioco() {
		return inGioco;
	}

	public NumeroModel() {
	this.inGioco=false;
	}

	public void newGame() {
		
		this.segreto = (int) (Math.random() * NMAX) + 1;
		this.tentativiFatti = 0;
		inGioco=true;
	
	}
	
	
	public int tentativo(int t) {
		//controllo se la partita è in corso
		if(!inGioco) {
			throw new IllegalStateException("La partita è terminata");
		}
		//controllo se input è valido
		if(!tentativoValido(t)) {
			throw new InvalidParameterException(String.format("Devi inserire un numero tra %d e %d", 1,NMAX));
		}
		//gestisci tentativo
		this.tentativiFatti++;
		
		if(this.tentativiFatti==TMAX) {
			//partita finita xke ho esaurito i tentativi
			this.inGioco=false;
		}
		if(t== this.segreto) {
			//ho indovinato
			this.inGioco=false;
			return 0;
		}
		if(t > this.segreto) {
			return 1;
		}
		
		
			return -1;
		}
		
	
	
	public boolean tentativoValido(int t) {
		//tentativo corretto?
		if(t<1 || t>NMAX ) {
			return false;
		}
		else {
			return true;
		}
		
		
	}
}
