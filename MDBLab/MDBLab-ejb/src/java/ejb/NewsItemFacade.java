/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author micha
 */
@Stateless
public class NewsItemFacade implements NewsItemFacadeLocal {

    @PersistenceContext
    private EntityManager em;
    
    /**
     *
     * @return
     */
    @Override
    public List<NewsItem> getAllNewsItems() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<NewsItem> cq = cb.createQuery(NewsItem.class);
    Root<NewsItem> rootEntry = cq.from(NewsItem.class);
    CriteriaQuery<NewsItem> ct = cq.select(rootEntry);
    TypedQuery<NewsItem> allNewsItemsQuery = em.createQuery(ct);
    return allNewsItemsQuery.getResultList();
}

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
