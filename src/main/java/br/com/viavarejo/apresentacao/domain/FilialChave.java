package br.com.viavarejo.apresentacao.domain;

import java.io.Serializable;

public class FilialChave implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer empresa;
    private Integer filial;
    private String tipoDeAtividade;

    public FilialChave() {
    }

    public FilialChave(Integer empresa, Integer filial, String tipoDeAtividade) {
        this.empresa = empresa;
        this.filial = filial;
        this.tipoDeAtividade = tipoDeAtividade;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilialChave that = (FilialChave) o;

        if (!empresa.equals(that.empresa)) return false;
        if (!filial.equals(that.filial)) return false;
        return tipoDeAtividade.equals(that.tipoDeAtividade);
    }

    @Override
    public int hashCode() {
        int result = empresa.hashCode();
        result = 31 * result + filial.hashCode();
        result = 31 * result + tipoDeAtividade.hashCode();
        return result;
    }
}
