package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @param <T>
 */
public class BaseDAO<T> {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory("ControleFinancasPessoaisPU").createEntityManager();
        }
        return entityManager;
    }

    public T salvar(T objeto) {
        try {
            getEntityManager().getTransaction().begin();
            objeto = getEntityManager().merge(objeto);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getLocalizedMessage());
            getEntityManager().getTransaction().rollback();
            return null;
        }
        return objeto;
    }

    public List<T> getTodosResultadosR() {
        return getEntityManager().createNamedQuery("CadastroReceitas.findALL").getResultList();
    }

    public List<T> getTodosResultadosD() {
        return getEntityManager().createNamedQuery("CadastroDespesas.findALL").getResultList();
    }

    public List<T> getTodosResultadosC() {
        return getEntityManager().createNamedQuery("CadastroContas.findALL").getResultList();
    }
}
