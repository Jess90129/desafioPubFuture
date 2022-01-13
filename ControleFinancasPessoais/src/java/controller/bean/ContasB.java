/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.dao.CadastroContasDAO;
import model.entity.CadastroContas;

/**
 *
 * @author Família Zunino
 */
@Named(value = "contasB")
@RequestScoped
public class ContasB {

    @Inject
    private CadastroContasDAO cadastroContasDAO;

    private Double saldo;
    private String tipoConta;
    private String instituicaoFinaceira;

    public ContasB() {
    }

    public String salvarConta() {
        CadastroContas c = new CadastroContas();
        c.setInstituicaoFinanceira(getInstituicaoFinaceira());
        c.setSaldo(getSaldo());
        c.setTipoConta(getTipoConta());

        cadastroContasDAO.salvar(c);

        return "contas?faces-redirect=true";

    }

    public List<CadastroContas> getTodasContas() {
        return cadastroContasDAO.getTodosResultadosC();
    }

    /**
     * @return the cadastroContasDAO
     */
    public CadastroContasDAO getCadastroContasDAO() {
        return cadastroContasDAO;
    }

    /**
     * @param cadastroContasDAO the cadastroContasDAO to set
     */
    public void setCadastroContasDAO(CadastroContasDAO cadastroContasDAO) {
        this.cadastroContasDAO = cadastroContasDAO;
    }

    /**
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the instituicaoFinaceira
     */
    public String getInstituicaoFinaceira() {
        return instituicaoFinaceira;
    }

    /**
     * @param instituicaoFinaceira the instituicaoFinaceira to set
     */
    public void setInstituicaoFinaceira(String instituicaoFinaceira) {
        this.instituicaoFinaceira = instituicaoFinaceira;
    }

    /**
     * @return the tipoConta
     */
    public String getTipoConta() {
        return tipoConta;
    }

    /**
     * @param tipoConta the tipoConta to set
     */
    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

}
