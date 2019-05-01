package com.example.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Item;
import com.example.model.Iteration;
import com.example.model.Release;


@Repository
public class releaseManagementDAOImpl implements releaseManagementDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Release> getReleases() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Release> query = currentSession.createQuery("from Release", Release.class);
		List<Release> list = query.getResultList();
		return list;
	}

	@Override
	public Release getReleaseById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Release relase = currentSession.get(Release.class, id);
		return relase;
	}

	@Override
	public List<Release> getReleaseByType(String type) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Release> query = currentSession.createQuery("SELECT rm FROM Release rm WHERE rm.type = :type",Release.class).setParameter("type", type);
		List<Release> list = query.getResultList();

		return list;
	}

	@Override
	public List<Release> getReleaseByStatus(String status) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Release> query = currentSession.createQuery("SELECT rm FROM Release rm WHERE rm.status = :status",Release.class).setParameter("status", status);
		List<Release> list = query.getResultList();

		return list;
	}

	@Override
	public List<Release> getReleaseByTitle(String title) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Release> query = currentSession.createQuery("SELECT rm FROM Release rm WHERE rm.title = :title",Release.class).setParameter("title", title);
		List<Release> list = query.getResultList();

		return list;
	}

	@Override
	public List<Release> getReleaseByDate(Date releaseDate) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Release> query = currentSession.createQuery("SELECT rm FROM Release rm WHERE rm.releaseDate = TO_DATE(:releaseDate, 'YYYY-MM-DD')",Release.class).setParameter("releaseDate", releaseDate);
		List<Release> list = query.getResultList();

		return list;
	}

	@Override
	public void saveRelease(Release release) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(release);
		
	}

	@Override
	public void deleteRelease(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Release release = currentSession.get(Release.class, id);
		currentSession.delete(release);
		
	}

	@Override
	public void updateRelease(Release release) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(release);
		
	}

	@Override
	public List<Iteration> getIteration() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Iteration> query = currentSession.createQuery("from Iteration", Iteration.class);
		List<Iteration> list = query.getResultList();
		return list;
	}

	@Override
	public Iteration getIterationById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Iteration iteration = currentSession.get(Iteration.class, id);
		return iteration;
	}

	@Override
	public List<Iteration> getIterationByType(String type) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Iteration> query = currentSession.createQuery("SELECT iter FROM Iteration iter WHERE iter.type = :type",Iteration.class).setParameter("type", type);
		List<Iteration> list = query.getResultList();

		return list;
	}

	@Override
	public List<Iteration> getIterationByStatus(String status) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Iteration> query = currentSession.createQuery("SELECT iter FROM Iteration iter WHERE iter.status = :status",Iteration.class).setParameter("status", status);
		List<Iteration> list = query.getResultList();

		return list;
	}

	@Override
	public List<Iteration> getIterationByDate(Date date) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Iteration> query = currentSession.createQuery("SELECT iter FROM Iteration iter WHERE iter.endDate = :endDate",Iteration.class).setParameter("endDate", date);
		List<Iteration> list = query.getResultList();

		return list;
	}

	@Override
	public void saveIteration(Iteration iteration) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(iteration);
	}

	@Override
	public void deleteIteration(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Iteration iteration = currentSession.get(Iteration.class, id);
		currentSession.delete(iteration);
		
	}

	@Override
	public void updateIteration(Iteration iteration) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(iteration);
		
	}

	@Override
	public void addItem(Item item) {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.save(item);
		}

	@Override
	public List<Item> viewItem() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Item> query = currentSession.createQuery("from Item", Item.class);
		List<Item> list = query.getResultList();
		return list;
	}

	@Override
	public List<Iteration> getIterationByReleaseId(int releaseId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Iteration> query = currentSession.createQuery("SELECT iter FROM Iteration iter WHERE iter.release = :release",Iteration.class).setParameter("release", releaseId);
		List<Iteration> list = query.getResultList();

		return list;
	}

	@Override
	public void deleteItem(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Item item = currentSession.get(Item.class, id);
		currentSession.delete(item);
		
	}

	@Override
	public List<Item> getItemByReleaseId(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Item> query = currentSession.createQuery("SELECT iter FROM Item iter WHERE iter.release = :release",Item.class).setParameter("release", id);
		List<Item> list = query.getResultList();

		return list;
	}


}
