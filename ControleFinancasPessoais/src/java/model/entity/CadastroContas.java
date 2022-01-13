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
@Table(name = "CadastroContas")
@NamedQueries({
    @NamedQuery(name = "CadastroContas.findALL", query = "SELECT C FROM  CadastroContas C")
})
public class CadastroContas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private Double saldo;

    @Column
    private String tipoConta;

    @Column
    private String instituicaoFinanceira;

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
     * @return the instituicaoFinanceira
     */
    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    /**
     * @param instituicaoFinanceira the instituicaoFinanceira to set
     */
    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
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
