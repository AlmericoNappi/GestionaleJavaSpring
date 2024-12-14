package ctr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StoricoDao;
import dao.StoricoDaoJdbcImpl;
import dao.StoricoDaoJpaImpl;
//import model.Storico;
import modeljpa.Storico;

/**
 * Servlet implementation class StoricoSrv
 */
@WebServlet("/StoricoSrv")
public class StoricoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoricoSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		StoricoDao StoDao = new StoricoDaoJdbcImpl();
		StoricoDaoJpaImpl StoDao = new StoricoDaoJpaImpl();
		String operazione = request.getParameter("operazione");

		if (operazione != null && operazione.equals("inserisci")) {

			String idSto = request.getParameter("idStorico");
			String idRuo = request.getParameter("idRuolo");
			String DataIniz = request.getParameter("dataInizio");
			String DataFin = request.getParameter("dataFine");
			String matr = request.getParameter("matricola");
			int matricola = Integer.parseInt(matr);

			Storico sto1 = new Storico();

			sto1.setIdStorico(idSto);
			sto1.setIdRuolo(idRuo);
			sto1.setDataInizio(DataIniz);
			sto1.setDataFine(DataFin);
			sto1.setMatricola(matricola);

			StoDao.inserisci(sto1);
			
			request.getRequestDispatcher("/inserisciStoricoOK.jsp").forward(request,response);			}
		
		if (operazione != null && operazione.equals("aggiorna")) {
			String idStorico = request.getParameter("idStorico");
			String idRuolo = request.getParameter("idRuolo");
			String DataInizio = request.getParameter("dataInizio");
			String DataFine = request.getParameter("dataFine");
			String matr = request.getParameter("matricola");
			int matricola = Integer.parseInt(matr);

			Storico sto = new Storico();

			sto.setIdStorico(idStorico);
			sto.setIdRuolo(idRuolo);
			sto.setDataInizio(DataInizio);
			sto.setDataFine(DataFine);
			sto.setMatricola(matricola);

			StoDao.aggiorna(sto);
			
			request.getRequestDispatcher("/aggiornaStoricoOK.jsp").forward(request,response);	

		}
		if (operazione != null && operazione.equals("elimina")) {

			String idStorico = request.getParameter("idStorico");
			String idRuolo = request.getParameter("idRuolo");
			String DataInizio = request.getParameter("dataInizio");
			String DataFine = request.getParameter("dataFine");
			String matr = request.getParameter("matricola");
			int matricola = Integer.parseInt(matr);

			Storico sto = new Storico();

			sto.setIdStorico(idStorico);
			sto.setIdRuolo(idRuolo);
			sto.setDataInizio(DataInizio);
			sto.setDataFine(DataFine);
			sto.setMatricola(matricola);

			StoDao.elimina(sto.getIdStorico());
		}

		if (operazione != null && operazione.equals("ricerca")) {

			String IdStorico = request.getParameter("idStorico");

//			Storico sto = StoDao.ricercaPerIdStorico(IdStorico);
			Storico sto = StoDao.ricercaPerId(IdStorico);

			if (sto != null) {
				System.out.println("storico trovato:" + sto.getMatricola());
				request.getSession().setAttribute("storicoTrovato", sto);
				request.getRequestDispatcher("/aggiornaStorico.jsp").forward(request, response);
				
				System.out.println(sto.getDataInizio() + sto.getDataFine());
			} else
				request.getRequestDispatcher("/ricercaStoricoKO.jsp").forward(request, response);
			}

	}

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
