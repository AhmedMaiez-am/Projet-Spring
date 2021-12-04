package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.RayonService;


@RestController
@RequestMapping("/rayon")
@Api(tags = "rayon management")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class RayonRestController {

	
	@Autowired
	RayonService rayonService;

	// http://localhost:8089/SpringMVC/rayon/retrieve-all-rayons
	@GetMapping("/retrieve-all-rayons")
	@ApiOperation(value = "Récupérer la liste des rayons")
	@ResponseBody
	public List<Rayon> listRayons() {
		return rayonService.retriveAll();
	}

	// http://localhost:8089/SpringMVC/rayon/add-rayon
	@PostMapping("/add-rayon")
	@ApiOperation(value = "ajouter rayon")
	@ResponseBody
	public Rayon addRayon(@RequestBody Rayon r) {
		Rayon rayon = rayonService.addRayon(r);
		return rayon;
	}
	
	// http://localhost:8089/SpringMVC/rayon/modify-rayon
		@PutMapping("/modify-rayon")
		@ApiOperation(value = "modifier rayon")
		@ResponseBody
		public Rayon modifyRayon(@RequestBody Rayon Rayon) {
			return rayonService.addRayon(Rayon);
		}

	

	// http://localhost:8089/SpringMVC/rayon/retrieve-rayon/1
	@GetMapping("/retrieve-rayon/{rayon-id}")
	@ApiOperation(value = "Récupérer rayon par id")
	@ResponseBody
	public Rayon retrieveRayon(@PathVariable("rayon-id") Long rayonId) {
		return rayonService.retrieveRayon(rayonId);
	}

	// http://localhost:8089/SpringMVC/rayon/remove-rayon/{rayon-id}
	@DeleteMapping("/remove-rayon/{rayon-id}")
	@ApiOperation(value = "supprimer rayon")
	@ResponseBody
	public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
		rayonService.deleteRayon(rayonId);
	}
	
	@GetMapping("/recherche/{string}")
	@ResponseBody
	public List<Rayon> rechercheRayon(@PathVariable("string") String rech) {
		List<Rayon> r = rayonService.rechercheAvancee(rech);
		return r;
	}
	
	// http://localhost:8089/SpringMVC/rayon/rayon-sortASC

	@GetMapping("/rayon-sortASC")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> getRayonsSortedASC(){
		List<Rayon> allRayons = rayonService.retrieveAllRayonsASC();
		return allRayons;
	}
	@GetMapping("/rayon-sortDESC")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> getRayonsSortedDESC(){
		List<Rayon> allRayons = rayonService.retrieveAllRayonsDESC();
		return allRayons;
	}
}
