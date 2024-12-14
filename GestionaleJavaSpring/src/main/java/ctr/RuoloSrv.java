package ctr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RuoloDao;
import dao.RuoloDaoJdbcImpl;
import dao.RuoloDaoJpaImpl;
//import model.Ruolo;
import modeljpa.Ruolo;

/**
 * Servlet implementation class RuoloSrv
 */
@WebServlet("/RuoloSrv")
public class RuoloSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RuoloSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			System.out.println("sono dentro ruolo");

			String operazione = request.getParameter("operazione");

//			RuoloDao RuoDao = new RuoloDaoJdbcImpl();
			RuoloDaoJpaImpl RuoDao = new RuoloDaoJpaImpl();
			

			if (operazione != null && operazione.equals("inserisci")) {

				String idRuolo = request.getParameter("idRuolo");
				String descrizione = request.getParameter("descrizione");

				Ruolo ruo = new Ruolo();

				ruo.setIdRuolo(idRuolo);
				ruo.setDescrizione(descrizione);

				RuoDao.inserisci(ruo);
				
				request.getRequestDispatcher("/inserisciRuoloOK.jsp").forward(request,response);	

			}
			if (operazione != null && operazione.equals("aggiorna")) {

				String idR = request.getParameter("idRuolo");
				String descrizione = request.getParameter("descrizione");

				Ruolo ruo = new Ruolo();

				ruo.setIdRuolo(idR);
				ruo.setDescrizione(descrizione);

				RuoDao.aggiorna(ruo);
				request.getRequestDispatcher("/aggiornaRuoloOK.jsp").forward(request,response);
				
			}
				if (operazione != null && operazione.equals("elimina")) {

					String idR = request.getParameter("idRuolo");
					String descrizione = request.getParameter("descrizione");

					Ruolo ruo = new Ruolo();

					ruo.setIdRuolo(idR);
					ruo.setDescrizione(descrizione);

					RuoDao.elimina(ruo.getIdRuolo());
					
				}
				
				if (operazione != null && operazione.equals("ricerca")) {

					String idRuolo = request.getParameter("idRuolo");
					
					Ruolo ruo = RuoDao.ricercaPerId(idRuolo);

					if (ruo != null) {
						System.out.println("ruolo trovato:" + ruo.getDescrizione());
						request.getSession().setAttribute("ruoloTrovato", ruo);
						request.getRequestDispatcher("/aggiornaRuolo.jsp").forward(request, response);
						
						System.out.println(ruo.getDescrizione());
					} else
						request.getRequestDispatcher("/ricercaRuoloKO.jsp").forward(request, response);
				}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
