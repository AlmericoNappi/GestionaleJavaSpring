package dao;

import java.util.List;

import org.hibernate.query.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modeljpa.Storico;

public class StoricoDaoJpaImpl {
	
	EntityManagerFactory emf ;
	EntityManager em;
	
	public StoricoDaoJpaImpl() {
		 emf = Persistence.createEntityManagerFactory("Hib4PU");
		 em = emf.createEntityManager();

	}
	

	public Storico ricercaPerId(String id) {
		em.getTransaction().begin();
		
		Storico u = em.find(Storico.class, id);
	
		
		em.getTransaction().commit();
		return u;
	}


	public void inserisci(Storico i) {
	em.getTransaction().begin();

	em.persist(i);

	em.getTransaction().commit();
	
}


public boolean aggiorna(Storico st2) {
	em.getTransaction().begin();

	em.merge(st2);

	em.getTransaction().commit();
	return true;
}


public boolean elimina(String id) {
	
	em.getTransaction().begin();

	Storico u = em.find(Storico.class, id);
	em.remove(u);

	em.getTransaction().commit();
	return true;
}


public List<Storico> ricercaPerMatricola(int matricola) {
	Query q1 = (Query) em.createQuery("from Storico s where s.impiegato.matricola = :matricola");
	q1.setParameter("matricola", matricola);
	List<Storico> res = q1.getResultList();

	return res;
}

}
