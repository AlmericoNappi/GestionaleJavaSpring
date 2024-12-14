package com.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Impiegato;
import com.repository.ImpiegatoRepository;

	@Controller
	@RequestMapping("impiegato")
	public class ImpiegatoCtr {
		
//		@Autowired
		private ImpiegatoRepository empRep;
		
		@GetMapping("/findImpiegatoById")
		public String findImpiegatoById(Model m, Integer matricola){
		Impiegato e = empRep.findById(matricola).get();
		m.addAttribute("impiegato", e);
		return "risultatoFindImpiegatoById";
		}
		
		@GetMapping("/showfindImpiegatoForm")
		public String showfindImpiegatoForm(Model model) {
		model.addAttribute("impiegato", new Impiegato());
			return "findImpiegatoById";
		}
		
		@GetMapping("/addImpiegato")
		public String addImpiegato(Model model) {
		model.addAttribute("impiegato", new Impiegato());
			return "addImpiegato";
		}
		
		@PostMapping("/saveImpiegato")
		public String saveImpiegato(@ModelAttribute Impiegato impiegato) {
			System.out.println(impiegato);
			empRep.save(impiegato);
			
			return "addImpiegatoOk";
		}
		
		
//		@GetMapping
//		public String findAll(Model m){
//			System.out.println("dentro findAll");
//			List<Impiegato> res = new ArrayList<>();
//			Impiegato e = new Impiegato();
//			e.setCognome("Nappi");
//			e.setNome("Almerico");
//			e.setMatricola(1);
//			res.add(e);
//			
//			Impiegato e1 = new Impiegato();
//			e1.setCognome("Nappi");
//			e1.setNome("Francesco");
//			e1.setMatricola(2);
//			res.add(e1);
//			
//			m.addAttribute("elencoImpiegati", res);
//			
//			return "risultatoRicercaImpiegato";
//			
//		}
}
