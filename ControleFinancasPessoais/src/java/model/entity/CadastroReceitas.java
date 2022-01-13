package model.entity;

/**
 *
 * @author Família Zunino
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CadastroReceitas")
@NamedQueries({
    @NamedQuery(name = "CadastroReceitas.findALL", query = "SELECT R FROM CadastroReceitas R")
})
public class CadastroReceitas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Double valor;

    @Column
    private String dataRecebimento;

    @Column
    private String dataRecebimentoEsperado;

    @Column
    private String descricao;

    @Column
    private Integer conta;

    @Column
    private String tipoReceita;

    private LocalDate getDate() {
        LocalDate now = LocalDate.now();
        long randomDay = ThreadLocalRandom.current().nextLong(now.minusDays(30).toEpochDay(), now.toEpochDay());
        return LocalDate.ofEpochDay(randomDay);
    }

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

}
