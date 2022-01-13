package managedBean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Família Zunino
 */
@Named(value = "trocaPaginaMB")
@RequestScoped
public class TrocaPaginaMB {

    /**
     * Creates a new instance of TrocaPaginaMB
     */
    public TrocaPaginaMB() {
    }

    public String getTelaInicial() {
        return "index";
    }

    public String getReceitas() {
        return "receitas";
    }

    public String getDespesas() {
        return "despesas";
    }

    public String getContas() {
        return "contas";
    }

}
