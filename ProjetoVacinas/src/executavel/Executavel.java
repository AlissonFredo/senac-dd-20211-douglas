package executavel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.bo.PessoaBO;
import model.vo.PessoaVO;

public class Executavel {

	public static void main(String[] args) {
		
		DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		PessoaBO pessoaBO = new PessoaBO();
		PessoaVO pessoa1 = new PessoaVO("maria", "feminino", "44444444444", LocalDate.parse("12/02/1999", dataFormatter), 0, null);
		
		pessoaBO.cadastrarPessoaBO(pessoa1);
		
	}

}
