package br.com.viavarejo.apresentacao.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(FilialChave.class)
public class Filial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer empresa;
	@Id
	private Integer filial;
	@Id
	private String tipoDeAtividade;
	private String cnpj;
	private String descricaoFilial;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private Integer empresaAbastecimento;
	private Integer filialAbastecimento;
	private String tipoDeAtividadeAbastecimento;

	public Filial() {
	}

	public Filial(Integer empresa, Integer filial, String tipoDeAtividade, String cnpj, String descricaoFilial, String endereco, Integer numero, String bairro, String cidade, String uf, String cep, Integer empresaAbastecimento, Integer filialAbastecimento, String tipoDeAtividadeAbastecimento) {
		this.empresa = empresa;
		this.filial = filial;
		this.tipoDeAtividade = tipoDeAtividade;
		this.cnpj = cnpj;
		this.descricaoFilial = descricaoFilial;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.empresaAbastecimento = empresaAbastecimento;
		this.filialAbastecimento = filialAbastecimento;
		this.tipoDeAtividadeAbastecimento = tipoDeAtividadeAbastecimento;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Integer getFilial() {
		return filial;
	}

	public void setFilial(Integer filial) {
		this.filial = filial;
	}

	public String getTipoDeAtividade() {
		return tipoDeAtividade;
	}

	public void setTipoDeAtividade(String tipoDeAtividade) {
		this.tipoDeAtividade = tipoDeAtividade;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricaoFilial() {
		return descricaoFilial;
	}

	public void setDescricaoFilial(String descricaoFilial) {
		this.descricaoFilial = descricaoFilial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getEmpresaAbastecimento() {
		return empresaAbastecimento;
	}

	public void setEmpresaAbastecimento(Integer empresaAbastecimento) {
		this.empresaAbastecimento = empresaAbastecimento;
	}

	public Integer getFilialAbastecimento() {
		return filialAbastecimento;
	}

	public void setFilialAbastecimento(Integer filialAbastecimento) {
		this.filialAbastecimento = filialAbastecimento;
	}

	public String getTipoDeAtividadeAbastecimento() {
		return tipoDeAtividadeAbastecimento;
	}

	public void setTipoDeAtividadeAbastecimento(String tipoDeAtividadeAbastecimento) {
		this.tipoDeAtividadeAbastecimento = tipoDeAtividadeAbastecimento;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Filial filial1 = (Filial) o;

		if (!empresa.equals(filial1.empresa)) return false;
		if (!filial.equals(filial1.filial)) return false;
		return tipoDeAtividade.equals(filial1.tipoDeAtividade);
	}

	@Override
	public int hashCode() {
		int result = empresa.hashCode();
		result = 31 * result + filial.hashCode();
		result = 31 * result + tipoDeAtividade.hashCode();
		return result;
	}
}