package jana60.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import jana60.model.Degree;
import jana60.model.Insegnanti;
import jana60.model.University;
import jana60.repository.DegreeRepository;
import jana60.repository.InsegnantiRepository;
import jana60.repository.UniversityRepository;


@Controller
@RequestMapping("/")
public class UniversityController {
	
	@Autowired 
	private UniversityRepository repo;
	@Autowired 
	private DegreeRepository dep;
	@Autowired 
	private InsegnantiRepository ins;

	@GetMapping
	public String home(Model model) {
		List<University> DepartmentsList =(List<University>)repo.findAll();
		model.addAttribute("DepartmentsList" ,DepartmentsList);
		return "home";
	}
	
		@GetMapping("/home")
		public String corso(Model model) {
			List<University> DepartmentsList = (List<University>)repo.findAll();
			model.addAttribute("DepartmentsList" ,DepartmentsList);
			return "home";
		}
		
		@GetMapping("/degrees")
		public String dipartimenti(Model model) {
			List<Degree> DegreeList = (List<Degree>)dep.findAll();
			model.addAttribute("DegreeList" ,DegreeList);
			return "degrees";
		}
		
		@GetMapping("/degrees/{id}")                                             //departmentsPrimaryKey e' l'id salvato su variabile (degrees/{id})
		public String degrees(@PathVariable(name = "id") Integer departmentsPrimaryKey, Model model) {
			Optional <University> currentDepartment = repo.findById(departmentsPrimaryKey);
			if (currentDepartment.isPresent()) {
			University CurDep =repo.findById(departmentsPrimaryKey).get();
			model.addAttribute("degreeDetail" , CurDep);
			return "details";
		} else {
			throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Pagina non trovata");
		}
		}
		@GetMapping("/teachers")
		public String insegnanti(Model model) {
			List<Insegnanti> ListaInsegnanti = (List<Insegnanti>)ins.findAll();
			model.addAttribute("Insegnanti" ,ListaInsegnanti);
			return "insegnanti";
		}
		
		@GetMapping("/teachers/{id}")                                             //departmentsPrimaryKey e' l'id salvato su variabile (degrees/{id})
	    public String insegnanti(@PathVariable(name = "id") Integer teachersPrimaryKey, Model model) {
		Optional <Insegnanti> queryResult = ins.findById(teachersPrimaryKey);
		if   (queryResult.isPresent()) {
			Insegnanti curDep = ins.findById(teachersPrimaryKey).get();
			model.addAttribute("teacher", curDep);
			return "dettagli";
	    } else {
		throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Pagina non trovata");
	}
		}
		
		
	}
