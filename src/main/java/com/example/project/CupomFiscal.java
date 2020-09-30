package com.example.project;

public class CupomFiscal {

	public static boolean isNullEmpty(String text) {
		try{
			int k = text.length();
		} catch (NullPointerException npe) {
			return true;
		}
		return text.isEmpty();
	}

	public static String dadosLojaObjeto(Loja loja) {
		
		if(isNullEmpty(loja.getNomeLoja()))
			throw new RuntimeException("O campo nome da loja é obrigatório");

		if(isNullEmpty(loja.getLogradouro()))
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		
		if(isNullEmpty(loja.getMunicipio()))
			throw new RuntimeException("O campo município do endereço é obrigatório");
		
		if(isNullEmpty(loja.getEstado()))
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		
		if(isNullEmpty(loja.getCnpj()))
			throw new RuntimeException("O campo cnpj da loja é obrigatório");
	
		if(isNullEmpty(loja.getInscricaoEstadual()))
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");

		String _logradouro = loja.getLogradouro() + ", ";
		
		String _numero = (loja.getNumero() <= 0)? "s/n" : String.format("%d", loja.getNumero());
		
		String _complemento = isNullEmpty(loja.getComplemento())? "" : " " + loja.getComplemento();
		
		String _bairro = isNullEmpty(loja.getBairro())? "" : loja.getBairro() + " - ";
		
		String _municipio = loja.getMunicipio() + " - ";
		
		String _cep = isNullEmpty(loja.getCep())? "" : "CEP:" + loja.getCep();

		String _telefone = isNullEmpty(loja.getTelefone())? "" : "Tel " + loja.getTelefone();
		_telefone = (!_telefone.isEmpty() && !_cep.isEmpty())? " " + _telefone : _telefone;
		
		String _observacao = isNullEmpty(loja.getObservacao())? "" : loja.getObservacao();
						
		String _cnpj = "CNPJ: " + loja.getCnpj();
		
		String _inscricao_estadual = "IE: " + loja.getInscricaoEstadual();

		String output = loja.getNomeLoja() + "\n";
		output += _logradouro + _numero + _complemento  + "\n";
		output += _bairro + _municipio + loja.getEstado() + "\n";
		output +=  _cep + _telefone + "\n";
		output +=  _observacao + "\n";
		output +=  _cnpj + "\n";
		output +=  _inscricao_estadual + "\n";

		return output.replace("\n", System.lineSeparator());
	}
}
