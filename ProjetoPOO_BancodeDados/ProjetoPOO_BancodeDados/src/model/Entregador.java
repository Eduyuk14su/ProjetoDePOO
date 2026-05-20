package model;

public class Entregador {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String veiculo;

    
    //Getters e Setters
    //ID
    public int getId() {
    	return id;
    }
    public void setId(int id) {
    	this.id = id;
    }
    
    //NOME
    public String getNome() {
    	return nome;
    }
    public void setNome(String nome) {
    	if (nome.length() <= 100) {
    		this.nome = nome;
    	} else {
    		System.out.println("Nome Longo Demais!");
    	}
    }
    
    //CPF
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
	 if (cpf.matches("\\d{11}")) {
		this.cpf = cpf;
	} else {
		System.out.println("CPF invalido!");
	}
}
	
	//TELEFONE
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if (telefone.matches("\\d{11}")) {
			this.telefone = telefone;
		}
		else {
			System.out.println("Telefone Invalido!");
		}
	}
	
	//VEICULOS
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		if (veiculo.length() <= 50) {
			this.veiculo = veiculo;
		} else {
			System.out.println("Descricao Longa De Veiculo");
		}
	}
}