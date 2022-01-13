/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.dao.CadastroDespesasDAO;
import model.entity.CadastroDespesas;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.MatchMode;

/**
 *
 * @author Família Zunino
 */
@Named(value = "despesasB")
@RequestScoped
public class DespesasB {

    @Inject
    private CadastroDespesasDAO cadastroDespesasDAO;

    private Double valor;
    private String dataPagamento;
    private String dataPagamentoEsperado;
    private Integer conta;
    private String tipoDespesa;

    private List<FilterMeta> filterBy;
    private List<CadastroDespesas> despesasFiltro;

    public DespesasB() {
    }

    public String salvarDespesa() {
        CadastroDespesas d = new CadastroDespesas();
        d.setConta(conta);
        d.setDataPagamento(dataPagamento);
        d.setDataPagamentoEsperado(dataPagamentoEsperado);
        d.setId(conta);
        d.setTipoDespesa(tipoDespesa);
        d.setValor(valor);

        cadastroDespesasDAO.salvar(d);

        return "despesas?faces-redirect=true";

    }

    public void init() {

        filterBy = new ArrayList<>();

        filterBy.add(FilterMeta.builder()
                .field("tipoDespesa")
                .filterValue(tipoDespesa)
                .matchMode(MatchMode.EQUALS)
                .build());

        filterBy.add(FilterMeta.builder()
                .field("date")
                .filterValue(new ArrayList<>(Arrays.asList(LocalDate.now().minusDays(28), LocalDate.now().plusDays(28))))
                .build());

    }

    public List<FilterMeta> getFilterBy() {
        return filterBy;
    }

    public List<CadastroDespesas> getTodasDespesas() {
        return cadastroDespesasDAO.getTodosResultadosD();
    }

    /**
     * @return the cadastroDespesasDAO
     */
    public CadastroDespesasDAO getCadastroDespesasDAO() {
        return cadastroDespesasDAO;
    }

    /**
     * @param cadastroDespesasDAO the cadastroDespesasDAO to set
     */
    public void setCadastroDespesasDAO(CadastroDespesasDAO cadastroDespesasDAO) {
        this.cadastroDespesasDAO = cadastroDespesasDAO;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the conta
     */
    public Integer getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Integer conta) {
        this.conta = conta;
    }

    /**
     * @return the tipoDespesa
     */
    public String getTipoDespesa() {
        return tipoDespesa;
    }

    /**
     * @param tipoDespesa the tipoDespesa to set
     */
    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    /**
     * @return the dataPagamento
     */
    public String getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * @return the dataPagamentoEsperado
     */
    public String getDataPagamentoEsperado() {
        return dataPagamentoEsperado;
    }

    /**
     * @param dataPagamentoEsperado the dataPagamentoEsperado to set
     */
    public void setDataPagamentoEsperado(String dataPagamentoEsperado) {
        this.dataPagamentoEsperado = dataPagamentoEsperado;
    }

    /**
     * @return the receitasFiltro
     */
    public List<CadastroDespesas> getDespesasFiltro() {
        return despesasFiltro;
    }

    /**
     * @param despesasFiltro the receitasFiltro to set
     */
    public void setDespesasFiltro(List<CadastroDespesas> despesasFiltro) {
        this.despesasFiltro = despesasFiltro;
    }

}
