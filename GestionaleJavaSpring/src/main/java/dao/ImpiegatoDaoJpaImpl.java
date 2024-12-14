package dao;

import java.util.List;

import org.hibernate.query.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modeljpa.Impiegato;


public class ImpiegatoDaoJpaImpl  {

	EntityManagerFactory emf;
	EntityManager em;

	public ImpiegatoDaoJpaImpl() {
		emf = Persistence.createEntityManagerFactory("Hib4PU");
		em = emf.createEntityManager();

	}


	public Impiegato ricercaPerCodiceFiscale(String codiceFiscale) {
		Query q1 = (Query) em.createQuery("from Impiegato c where c.codicefiscale = :codicefiscale");
		q1.setParameter("codicefiscale", codiceFiscale);
		Impiegato res = (Impiegato) q1.getSingleResult();

		return res;
	}


	public List<Impiegato> ricercaPerCognome(String cognome) {
		Query q1 = (Query) em.createQuery("from Impiegato c where c.cognome = :cognome");
		q1.setParameter("cognome", cognome);
		List<Impiegato> res = q1.getResultList();

		return res;
	}


	public void inserisci(Impiegato imp) {
		em.getTransaction().begin();

		em.persist(imp);

		em.getTransaction().commit();
	}


	public boolean aggiorna(Impiegato imp2) {
		em.getTransaction().begin();

		em.merge(imp2);

		em.getTransaction().commit();
		return true;
	}


	public boolean elimina(String codiceFiscale) {
		em.getTransaction().begin();

		Impiegato u = em.find(Impiegato.class, codiceFiscale);
		em.remove(u);

		em.getTransaction().commit();
		return true;
	}

}
