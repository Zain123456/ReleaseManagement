package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DAO.releaseManagementDAO;
import com.example.model.Item;
import com.example.model.Iteration;
import com.example.model.Release;

@Service
public class ReleaseManagementServiceImpl implements ReleaseManagementService{

	@Autowired
    private releaseManagementDAO rmDao;
    
    @Transactional
    @Override
    public List<Release> getReleases() {
        // TODO Auto-generated method stub
        return rmDao.getReleases();
    }

    @Transactional
    @Override
    public Release getReleaseById(int id) {
        // TODO Auto-generated method stub
        return rmDao.getReleaseById(id);
    }

    @Transactional
    @Override
    public List<Release> getReleaseByType(String type) {
    	
    	if(type.toUpperCase().equals("MILESTONE")
	        	|| type.toUpperCase().equals("BUILD")
	        	|| type.toUpperCase().equals("MAJOR")
	        	|| type.toUpperCase().equals("MINOR")
	        	|| type.toUpperCase().equals("FINAL"))
	        {
	        	return rmDao.getReleaseByType(type);
	        }
	        else { 
	        	return null;
	        }
    }

    @Transactional
    @Override
    public List<Release> getReleaseByStatus(String status) {
    	if(status.toUpperCase().equals("PLANNED")
   	    	 || status.toUpperCase().equals("RELEASED")
   	    	 || status.toUpperCase().equals("DELAYED")
   	    	 || status.toUpperCase().equals("SUSPENDED")
   	    	 || status.toUpperCase().equals("RESUMED"))
   	       {
   	    	   return rmDao.getReleaseByStatus(status);
   	       }
   	       else {	
   	    	   	return null;
   	       }
    }

    @Transactional
    @Override
    public List<Release> getReleaseByTitle(String title) {
        // TODO Auto-generated method stub
        return rmDao.getReleaseByTitle(title);
    }

    @Transactional
    @Override
    public List<Release> getReleaseByDate(Date date) {
        // TODO Auto-generated method stub
        return rmDao.getReleaseByDate(date);
    }

    @Transactional
    @Override
    public void saveRelease(Release release) {
        rmDao.saveRelease(release);
    }

    @Transactional
    @Override
    public void deleteRelease(int id) {
        // TODO Auto-generated method stub
        rmDao.deleteRelease(id);
    }

    @Transactional
    @Override
    public void updateRelease(Release release) {
        // TODO Auto-generated method stub
        rmDao.updateRelease(release);
    }

    @Transactional
    @Override
    public List<Iteration> getIteration() {
        // TODO Auto-generated method stub
        return rmDao.getIteration();
    }

    @Transactional
    @Override
    public Iteration getIterationById(int id) {
        // TODO Auto-generated method stub
        return rmDao.getIterationById(id);
    }

    @Transactional
    @Override
    public List<Iteration> getIterationByType(String type) {
    	 
    	if(type.toUpperCase()=="DEV"
    	         || type.toUpperCase().equals("QA")	
    	         || type.toUpperCase().equals("PLANNING")	
    	         || type.toUpperCase().equals("RELEASE")	
    	         || type.toUpperCase().equals("REGRESSION"))
    	        return rmDao.getIterationByType(type);
    	        else {
    	        	return null;
    	        }
    }

    @Transactional
    @Override
    public List<Iteration> getIterationByStatus(String status) {
    	
    	if(status.toUpperCase().equals("PLANNED")
    	    	|| status.toUpperCase().equals("WORKING")	  
    	    	|| status.toUpperCase().equals("COMPLETED")
    	    	|| status.toUpperCase().equals("DELAYED"))
    	        return rmDao.getIterationByStatus(status);
    	       else {

    	    	   return null;
    	       }
    }

    @Transactional
    @Override
    public List<Iteration> getIterationByDate(Date date) {
        // TODO Auto-generated method stub
        return rmDao.getIterationByDate(date);
    }

    @Transactional
    @Override
    public void saveIteration(Iteration iteration) {
        // TODO Auto-generated method stub
        rmDao.saveIteration(iteration);
    }

    @Transactional
    @Override
    public void deleteIteration(int id) {
        // TODO Auto-generated method stub
        rmDao.deleteIteration(id);
    }

    @Transactional
    @Override
    public void updateIteration(Iteration iteration) {
        // TODO Auto-generated method stub
        rmDao.updateIteration(iteration);
    }

    @Transactional
	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		rmDao.addItem(item);
	}

    @Transactional
	@Override
	public List<Item> viewItem() {
		// TODO Auto-generated method stub
		return rmDao.viewItem();
	}

    @Transactional
	@Override
	public List<Iteration> getIterationByReleaseId(int releaseId) {
		// TODO Auto-generated method stub
		return rmDao.getIterationByReleaseId(releaseId);
	}

	@Transactional
	@Override
	public void deleteItem(int id) {
		rmDao.deleteItem(id);
		
	}

	@Transactional
	@Override
	public List<Item> getItemByReleaseId(int id) {
		// TODO Auto-generated method stub
		return rmDao.getItemByReleaseId(id);
	}

    

}