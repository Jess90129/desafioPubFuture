package model.entity;

/**
 *
 * @author Família Zunino
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CadastroDespesas")
@NamedQueries({
    @NamedQuery(name = "CadastroDespesas.findALL", query = "SELECT D FROM CadastroDespesas D")
})
public class CadastroDespesas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Double valor;

    @Column
    private String dataPagamento;

    @Column
    private String dataPagamentoEsperado;

    @Column
    private Integer conta;

    @Column
    private String tipoDespesa;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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

}
