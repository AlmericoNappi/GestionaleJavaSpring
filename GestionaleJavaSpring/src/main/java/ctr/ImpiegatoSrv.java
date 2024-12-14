package ctr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ImpiegatoDao;
import dao.ImpiegatoDaoJdbcImpl;
import dao.ImpiegatoDaoJpaImpl;
import dao.StoricoDao;
import dao.StoricoDaoJdbcImpl;
import dao.StoricoDaoJpaImpl;
//import model.Impiegato;
//import model.Storico;
import modeljpa.Impiegato;
import modeljpa.Storico;
/**
 * Servlet implementation class ImpiegatoSrv
 */
@WebServlet("/ImpiegatoSrv")
public class ImpiegatoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//si può usare questa annotation per inizializzare l'Em
	//evitando nel dao di inizializzare l'emf e l'em
	//PersistenceContext(unitName ="Hib4PU")
	//private EntityManager em;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImpiegatoSrv() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("sono dentro");

		ImpiegatoDaoJpaImpl ImpDao = new ImpiegatoDaoJpaImpl();

		String operazione = request.getParameter("operazione");
		System.out.println("operazione =" + operazione);
//		ImpiegatoDao ImpDao = new ImpiegatoDaoJdbcImpl();

		if (operazione != null && operazione.equals("inserisci")) {

			String cf = request.getParameter("codiceFiscale");
			String cognome = request.getParameter("cognome");
			String nome = request.getParameter("nome");
			String matr = request.getParameter("matricola");
			int matricola = Integer.parseInt(matr);

			Impiegato imp = new Impiegato();
			
			imp.setCodiceFiscale(cf);
			imp.setCognome(cognome);
			//imp.setMatricola(matricola);
			imp.setNome(nome);

			ImpDao.inserisci(imp);
			
			request.getRequestDispatcher("/inserimentoImpiegatoOK.jsp").forward(request,response);	

		}
		if (operazione != null && operazione.equals("aggiorna")) {

			String codiceFiscale = request.getParameter("codiceFiscale");
			String cognome = request.getParameter("cognome");
			String nome = request.getParameter("nome");
			String matr = request.getParameter("matricola");
			int matricola = Integer.parseInt(matr);

			Impiegato imp = new Impiegato();

			imp.setCodiceFiscale(codiceFiscale);
			imp.setCognome(cognome);
			imp.setMatricola(matricola);
			imp.setNome(nome);

			ImpDao.aggiorna(imp);
			
			request.getRequestDispatcher("/aggiornaImpiegatoOK.jsp").forward(request,response);	

			
		}
			if (operazione != null && operazione.equals("elimina")) {

				String codiceFiscale = request.getParameter("codiceFiscale");
				String cognome = request.getParameter("cognome");
				String matr = request.getParameter("matr");
				Integer matricola = Integer.parseInt(matr);
				
//				StoricoDao sDao = new StoricoDaoJdbcImpl();
				StoricoDaoJpaImpl sDao = new StoricoDaoJpaImpl();

				List<Storico> res = sDao.ricercaPerMatricola(matricola);

				if(res != null && res.size()> 0)
				for (Storico storico : res) {
					sDao.elimina(storico.getIdStorico());
					
				}
				ImpDao.elimina(codiceFiscale);
				List<Impiegato> imp = ImpDao.ricercaPerCognome(cognome);
				if(imp != null && imp.size() > 0) {
					System.out.println("impiegati trovati: " + imp.size());
					request.getSession().setAttribute("impiegatiTrovati", imp);
					request.getRequestDispatcher("/risultatiRicercaImpiegatoPerCognome.jsp").forward(request, response);
				
				}else
					request.getRequestDispatcher("/ricercaImpiegatiPerCognomeKO.jsp").forward(request, response);

			}
			
			if (operazione != null && operazione.equals("ricerca")) {
				
				String codiceFiscale = request.getParameter("codiceFiscale");

				Impiegato imp = ImpDao.ricercaPerCodiceFiscale(codiceFiscale);
				
				if (imp != null) {
					System.out.println("impiegato trovato:" + imp.getMatricola());
					request.getSession().setAttribute("impiegatoTrovato", imp);
					request.getRequestDispatcher("/aggiornaImpiegato.jsp").forward(request, response);
				} else
					request.getRequestDispatcher("/ricercaImpiegatoKO.jsp").forward(request, response);
	}
		
	//inzio nuovo metodo ricercaImpiegatoPerCognome
	
		if (operazione != null && operazione.equals("ricercaImpiegatoPerCognome")) {
		String cf = request.getParameter("Cognome");

//		List<Impiegato> imp = ImpDao.ricercaImpiegatoPerCognome(cf);
		List<Impiegato> imp = ImpDao.ricercaPerCognome(cf);

		if (imp != null && imp.size() > 0) {
			System.out.println("impiegati trovati:" + imp.size());
			request.getSession().setAttribute("impiegatiTrovati", imp);
			request.getRequestDispatcher("/risultatiRicercaImpiegatoPerCognome.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("/ricercaImpiegatiPerCognomeKO.jsp").forward(request, response);
}
}
	//fine modifiche

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
