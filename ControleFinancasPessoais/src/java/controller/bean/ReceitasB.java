package controller.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.dao.CadastroReceitasDAO;
import model.entity.CadastroReceitas;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.MatchMode;

/**
 *
 * @author Família Zunino
 */
@Named(value = "receitasB")
@RequestScoped
public class ReceitasB {

    @Inject
    private CadastroReceitasDAO cadastroReceitasDAO;

    private Double valor;
    private String dataRecebimento;
    private String dataRecebimentoEsperado;
    private String descricao;
    private Integer conta;
    private String tipoReceita;
    private CadastroReceitas receita;

    private List<FilterMeta> filterBy;
    private List<CadastroReceitas> receitasFiltro;

    public ReceitasB() {
    }

    public String salvarReceita() {
        CadastroReceitas r = new CadastroReceitas();
        r.setConta(conta);
        r.setDataRecebimento(dataRecebimento);
        r.setDataRecebimentoEsperado(dataRecebimentoEsperado);
        r.setDescricao(descricao);
        r.setId(conta);
        r.setTipoReceita(tipoReceita);
        r.setValor(valor);

        cadastroReceitasDAO.salvar(r);

        return "receitas?faces-redirect=true";

    }

    public List<CadastroReceitas> getTodasReceitas() {
        return cadastroReceitasDAO.getTodosResultadosR();
    }

    public void init() {

        filterBy = new ArrayList<>();

        filterBy.add(FilterMeta.builder()
                .field("tipoReeita")
                .filterValue(tipoReceita)
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

    /**
     * @return the cadastroReceitasDAO
     */
    public CadastroReceitasDAO getCadastroReceitasDAO() {
        return cadastroReceitasDAO;
    }

    /**
     * @param cadastroReceitasDAO the cadastroReceitasDAO to set
     */
    public void setCadastroReceitasDAO(CadastroReceitasDAO cadastroReceitasDAO) {
        this.cadastroReceitasDAO = cadastroReceitasDAO;
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
     * @return the dataRecebimento
     */
    public String getDataRecebimento() {
        return dataRecebimento;
    }

    /**
     * @param dataRecebimento the dataRecebimento to set
     */
    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    /**
     * @return the dataRecebimentoEsperado
     */
    public String getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    /**
     * @param dataRecebimentoEsperado the dataRecebimentoEsperado to set
     */
    public void setDataRecebimentoEsperado(String dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
     * @return the tipoReceita
     */
    public String getTipoReceita() {
        return tipoReceita;
    }

    /**
     * @param tipoReceita the tipoReceita to set
     */
    public void setTipoReceita(String tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    /**
     * @return the receitasFiltro
     */
    public List<CadastroReceitas> getReceitasFiltro() {
        return receitasFiltro;
    }

    /**
     * @param receitasFiltro the receitasFiltro to set
     */
    public void setReceitasFiltro(List<CadastroReceitas> receitasFiltro) {
        this.receitasFiltro = receitasFiltro;
    }

    /**
     * @return the receita
     */
    public CadastroReceitas getReceita() {
        return receita;
    }

    /**
     * @param receita the receita to set
     */
    public void setReceita(CadastroReceitas receita) {
        this.receita = receita;
    }

}
