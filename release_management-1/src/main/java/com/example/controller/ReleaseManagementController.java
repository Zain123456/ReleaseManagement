package com.example.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.CustomerException;
import com.example.model.Item;
import com.example.model.Iteration;
import com.example.model.Release;
import com.example.service.ReleaseManagementService;
import com.example.service.ReleaseManagementServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ReleaseManagementController {
	
	@Autowired
	private ReleaseManagementService releaseService;
	
	@GetMapping("/releases")
	public List<Release> getReleases(){
		return releaseService.getReleases();
	}

	@GetMapping("/releases/id={id}")
	public Release getReleaseById(@PathVariable int id) throws CustomerException {
		Release release = releaseService.getReleaseById(id);
		if(release == null) {
			throw new CustomerException("Player with id "+id+" not found");
		}
		return release;
	}
	
	@GetMapping("/releases/type={type}")
	public List<Release> getReleaseByType(@PathVariable String type) throws CustomerException {
		List<Release> release = releaseService.getReleaseByType(type);
		if(release == null) {
			throw new CustomerException("Player with type "+type+" not found");
		}
		return release;
	}
	
	@GetMapping("/releases/status={status}")
	public List<Release> getReleaseByStatus(@PathVariable String status) throws CustomerException {
		List<Release> release = releaseService.getReleaseByStatus(status);
		if(release == null) {
			throw new CustomerException("Player with status "+status+" not found");
		}
		return release;
	}
	
	@GetMapping("/releases/title={title}")
	public List<Release> getReleaseByTitle(@PathVariable String title) throws CustomerException {
		List<Release> release = releaseService.getReleaseByTitle(title);
		if(release == null) {
			throw new CustomerException("Player with title "+title+" not found");
		}
		return release;
	}
	
	@GetMapping("/releases/date={date}")
	public List<Release> getReleaseByDate(@PathVariable Date date) throws CustomerException {
		List<Release> release = releaseService.getReleaseByDate(date);
		if(release == null) {
			throw new CustomerException("Player with date "+date+" not found");
		}
		return release;
	}
	
	@PostMapping("/releases")
	public Release saveRelease(@RequestBody Release release) {
	
		releaseService.saveRelease(release);
		return release;
	}
	
	@DeleteMapping("releases/{id}")
	public boolean deleteRelease(@PathVariable int id) throws CustomerException {
		releaseService.deleteRelease(id);
		List<Iteration> temp = getIterationByReleaseId(id);
		if(temp != null)
		{
			for(Iteration hold:temp)
			{
				deleteIteration(hold.getIterationId());
			}
		}
		List<Item> temp2 = getItemByReleaseId(id);
		if(temp2 != null)
		{
			for(Item hold:temp2)
			{
				deleteItem(hold.getItemId());
			}
		}
		return true;
	}
	
	@PutMapping("/releases")
	public Release updateRelease(@RequestBody Release release) {
		releaseService.updateRelease(release);
		return release;
	}
	
	@GetMapping("/iterations")
	public List<Iteration> getIteration(){
		return releaseService.getIteration();
	}

	@GetMapping("/iterations/id={id}")
	public Iteration getIterationById(@PathVariable int id) throws CustomerException {
		Iteration iteration = releaseService.getIterationById(id);
		if(iteration == null) {
			throw new CustomerException("Player with id "+id+" not found");
		}
		return iteration;
	}
	
	@GetMapping("/iterations/type={type}")
	public List<Iteration> getIterationByType(@PathVariable String type) throws CustomerException {
		List<Iteration> iteration = releaseService.getIterationByType(type);
		if(iteration == null) {
			throw new CustomerException("Player with type "+type+" not found");
		}
		return iteration;
	}
	
	@GetMapping("/iterations/status={status}")
	public List<Iteration> getIterationByStatus(@PathVariable String status) throws CustomerException {
		List<Iteration> iteration = releaseService.getIterationByStatus(status);
		if(iteration == null) {
			throw new CustomerException("Player with status "+status+" not found");
		}
		return iteration;
	}
	
	@GetMapping("/iterations/releaseId={releaseId}")
	public List<Iteration> getIterationByReleaseId(@PathVariable int releaseId) throws CustomerException {
		List<Iteration> iteration = releaseService.getIterationByReleaseId(releaseId);
		if(iteration == null) {
			throw new CustomerException("Player with status "+releaseId+" not found");
		}
		return iteration;
	}
	
	@GetMapping("/iterations/date={date}")
	public List<Iteration> getIterationByDate(@PathVariable Date date) throws CustomerException {
		List<Iteration> iteration = releaseService.getIterationByDate(date);
		if(iteration == null) {
			throw new CustomerException("Player with date "+date+" not found");
		}
		return iteration;
	}
	
	@PostMapping("/iterations")
	public Iteration saveIteration(@RequestBody Iteration iteration) {
		if(releaseService.getReleaseById(iteration.getRelease()) != null)
		{
			releaseService.saveIteration(iteration);
			return iteration;
		}
		
		return null;
	}
	
	@DeleteMapping("/iterations/id={id}")
	public boolean deleteIteration(@PathVariable int id) {
		releaseService.deleteIteration(id);
		return true;
	}
	
	@PutMapping("/iterations")
	public Iteration updateIteration(@RequestBody Iteration iteration) {
		releaseService.updateIteration(iteration);
		return iteration;
	}
	
	@GetMapping("/items")
	public List<Item> viewItem(){
		return releaseService.viewItem();
	}
	
	@PostMapping("/additems")
	public Item addItem(@RequestBody Item item){
		
		if(releaseService.getReleaseById(item.getRelease()) != null ||
				releaseService.getIterationByReleaseId(item.getRelease()) != null)
		{
			releaseService.addItem(item);
			return item;
		}
	
		return null;
	}
	
	@GetMapping("/item/releaseId={releaseId}")
	public List<Item> getItemByReleaseId(@PathVariable int releaseId) throws CustomerException {
		List<Item> item = releaseService.getItemByReleaseId(releaseId);
		if(item == null) {
			throw new CustomerException("Player with status "+releaseId+" not found");
		}
		return item;
	}
	
	@DeleteMapping("/item/id={id}")
	public boolean deleteItem(@PathVariable int id) {
		releaseService.deleteItem(id);
		return true;
	}
}
