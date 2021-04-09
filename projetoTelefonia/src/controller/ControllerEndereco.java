package controller;

import model.bo.EnderecoBO;
import model.entity.Endereco;

public class ControllerEndereco {
	
	EnderecoBO enderecoBO = new EnderecoBO();

	public String cadastrarEnderecoController(Endereco endereco) {
		return enderecoBO.cadastrarEnderecoBO(endereco);
	}

}
