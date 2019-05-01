package com.example.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Item;
import com.example.model.Release;
import com.example.model.Iteration;



public interface releaseManagementDAO {
	
	public List<Release> getReleases();
	public Release getReleaseById(int id);
	public List<Release> getReleaseByType(String type);
	public List<Release> getReleaseByStatus(String status);
	public List<Release> getReleaseByTitle(String title);
	public List<Release> getReleaseByDate(Date date);
	public void saveRelease(Release release);
	public void deleteRelease(int id);
	public void updateRelease(Release release);
	
	public List<Iteration> getIteration();
	public Iteration getIterationById(int id);
	public List<Iteration> getIterationByType(String type);
	public List<Iteration> getIterationByStatus(String status);
	public List<Iteration> getIterationByDate(Date releaseDate);
	public List<Iteration> getIterationByReleaseId(int releaseId);
	public void saveIteration(Iteration iteration);
	public void deleteIteration(int id);
	public void updateIteration(Iteration iteration);
	
	public void addItem(Item item);
	public List<Item> viewItem();
	public List<Item> getItemByReleaseId(int id);
	public void deleteItem(int id);
	

}
