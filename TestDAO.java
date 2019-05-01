package com.example;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.DAO.releaseManagementDAO;
import com.example.DAO.releaseManagementDAOImpl;
import com.example.model.Item;
import com.example.model.Iteration;
import com.example.model.Release;
import com.example.service.ReleaseManagementServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDAO {
	
	
	@Autowired
	ReleaseManagementServiceImpl test;

	@BeforeClass
	public static void setUp() throws Exception {
		


	}

	@After
	public void tearDown() throws Exception {
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSaveRelease() throws ParseException{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2000-06-11");
		Date d2 = df.parse("2000-02-01");

		Release release = new Release("10","10",d1,d2,d1,"MILESTONE","10","PLANNED","10");
		test.saveRelease(release);	
	
		Release r = null;
		for(Release r1 : test.getReleases() )
		{
			if(r1.getReleaseId()==release.getReleaseId())
				r = r1;
		}
			
		r.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getStartDate().toString()) );
		r.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getReleaseDate().toString()));
		r.setPlannedDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getPlannedDate().toString()));
			
		assertEquals(r,release);	

	}
	
	@Test
	public void testgetReleaseById() throws ParseException{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2001-06-11");
		Date d2 = df.parse("2001-02-01");
		Release release = new Release("20","20",d1,d2,d1,"MILESTONE","20","PLANNED","20");
		test.saveRelease(release);	
		Release r = test.getReleaseById(release.getReleaseId());
	
		r.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getStartDate().toString()) );
		r.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getReleaseDate().toString()));
		r.setPlannedDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getPlannedDate().toString()));
		
		
		assertEquals(r,release);
		
	}

	@Test
	public void testgetReleaseByType() throws ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2002-06-11");
		Date d2 = df.parse("2002-02-01");
		Release release = new Release("30","30",d1,d2,d1,"MILESTONE","30","PLANNED","30");
		test.saveRelease(release);	
		Release r = null;
		for(Release r1 : test.getReleaseByType("MILESTONE"))
		{
			if(r1.getReleaseId()==release.getReleaseId())
				r = r1;
		}
		
		r.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getStartDate().toString()) );
		r.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getReleaseDate().toString()));
		r.setPlannedDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getPlannedDate().toString()));
		
		assertEquals(release,r);
	}
	
	@Test
	public void testgetReleaseByStatus() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2003-06-11");
		Date d2 = df.parse("2003-02-01");
		Release release = new Release("40","40",d1,d2,d1,"MILESTONE","40","PLANNED","40");
		test.saveRelease(release);	
		
		Release r = null;
		
		for(Release r1 : test.getReleaseByStatus("PLANNED"))
		{
			if(r1.getReleaseId()==release.getReleaseId())
				r = r1;
		}
		
		r.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getStartDate().toString()) );
		r.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getReleaseDate().toString()));
		r.setPlannedDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getPlannedDate().toString()));
		
		assertEquals(r,release);
		
	}
	
	@Test
	public void testgetReleaseByTitle() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2004-06-11");
		Date d2 = df.parse("2004-02-01");
		Release release = new Release("50","50",d1,d2,d1,"MILESTONE","50","PLANNED","50");
		test.saveRelease(release);	
		
		Release r = null;
		for(Release r1 : test.getReleaseByTitle("50") )
		{
			if(r1.getReleaseId()==release.getReleaseId())
				r = r1;
		}
		r.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getStartDate().toString()) );
		r.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getReleaseDate().toString()));
		r.setPlannedDate(new SimpleDateFormat("yyyy-MM-dd").parse(r.getPlannedDate().toString()));
		
		assertEquals(r,release);
		
	}
	
	@Test 
	public void testgetReleaseByDate() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2005-06-11");
		Date d2 = df.parse("2005-02-01");
		Release release = new Release("60","60",d1,d2,d1,"MILESTONE","60","PLANNED","60");
		test.saveRelease(release);	
		List <Release> ReleaseList = new ArrayList<>();
		for(Release r1 : test.getReleases())
		{
			if(r1.getReleaseId()==release.getReleaseId())
			{
				ReleaseList.add(r1);	
			}
		}
		
		System.out.println("\n \n \n OKAY THIS WILL WORK \n \n \n");
		
		System.out.println(ReleaseList.toString()+"\n \n \n"+test.getReleases().toString()+"\n \n \n");
		
		assertTrue(test.getReleases().containsAll(ReleaseList));
		
	}
	
	@Test
	public void testdeleteRelease() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2006-06-11");
		Date d2 = df.parse("2006-02-01");
		Release release = new Release("70","70",d1,d2,d1,"MILESTONE","70","PLANNED","70");
		test.saveRelease(release);	
		
		Release r = release;
		test.deleteRelease(r.getReleaseId());	
		
		assertTrue( ! test.getReleases().contains(r));			// this will verify that the object has been deleted
		
		
	}
	
	@Test
	public void testupdateRelease() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2007-06-11");
		Date d2 = df.parse("2007-02-01");
		Release release = new Release("8","8",d1,d2,d1,"MILESTONE","8","PLANNED","8");
		test.saveRelease(release);	
		
		Release fetch = null;
		
		release.setTitle("80");
		test.updateRelease(release);
		for(Release r1 : test.getReleases())
		{
			if(r1.getReleaseId()==release.getReleaseId())
				 fetch = r1;
		}
		
		fetch.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(fetch.getStartDate().toString()) );
		fetch.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(fetch.getReleaseDate().toString()));
		fetch.setPlannedDate(new SimpleDateFormat("yyyy-MM-dd").parse(fetch.getPlannedDate().toString()));
		
		assertEquals(fetch,release);
	}
	
	@Test
	public void testgetIteration() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2002-06-11");
		Date d2 = df.parse("2002-02-01");
		Iteration iteration = new Iteration("title2","description2",d1,d2,"PLANNED","PLANNING",15);
		
		test.saveIteration(iteration);
		Iteration i = null;
		for(Iteration i1 : test.getIteration())
		{
			if(i1.getIterationId()==iteration.getIterationId())
			{
				i = i1;	
				System.out.println(i1.toString());
			}
		}
		
		i.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(i.getStartDate().toString()));
		i.setEndDate((new SimpleDateFormat("yyyy-MM-dd").parse(      i.getEndDate().toString()  ) ));
		
		assertEquals(iteration,i);
	}
	
	@Test
	public void testgetIterationById() throws ParseException {
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2002-06-11");
		Date d2 = df.parse("2002-02-01");
		Iteration iteration = new Iteration("title3","description3",d1,d2,"PLANNED","PLANNING",18);
		
		test.saveIteration(iteration);
		Iteration i = test.getIterationById(iteration.getIterationId());
		
		i.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(i.getStartDate().toString()));
		i.setEndDate((new SimpleDateFormat("yyyy-MM-dd").parse(      i.getEndDate().toString()  ) ));
		
		assertEquals(i,iteration);
	}
	
	@Test
	public void testgetIterationByType() throws ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("2002-06-11");
		Date d2 = df.parse("2002-02-01");
		Iteration iteration = new Iteration("title4","description4",d1,d2,"PLANNED","PLANNING",17);
		
		test.saveIteration(iteration);
		Iteration i = null;
		for(Iteration i1 : test.getIterationByType("PLANNING"))
		{
			if(i1.getIterationId()==iteration.getIterationId())
			{
				i = i1;	
			}
		}
		
		i.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(i.getStartDate().toString()));
		i.setEndDate((new SimpleDateFormat("yyyy-MM-dd").parse(      i.getEndDate().toString()  ) ));
		
		assertEquals(i,iteration);
	}
	
	
	@Test
	public void testgetIterationByStatus() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("1962-06-11");
		Date d2 = df.parse("1962-02-01");
		Iteration iteration = new Iteration("title5","description5",d1,d2,"PLANNED","PLANNING",16);
		
		test.saveIteration(iteration);
		Iteration i = null;
		for(Iteration i1 : test.getIterationByStatus("PLANNED"))
		{
			if(i1.getIterationId()==iteration.getIterationId())
			{
				i = i1;	
			}
		}
		
		i.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(i.getStartDate().toString()));
		i.setEndDate((new SimpleDateFormat("yyyy-MM-dd").parse(      i.getEndDate().toString()  ) ));
		
		assertEquals(i,iteration);
	}
	
	@Test
	public void testgetIterationByDate() throws ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("1362-06-11");
		Date d2 = df.parse("1362-02-01");
		Iteration iteration = new Iteration("title121","description121",d1,d2,"PLANNED","PLANNING",121);
	
		List <Iteration> IterationList = new ArrayList<>();
		for(Iteration e : test.getIteration())
		{
			if(e.getStartDate()==iteration.getStartDate())
			{
				IterationList.add(e);
			}
		}
		
		assertTrue(IterationList.containsAll(test.getIterationByDate(iteration.getStartDate())));
	
	}
	
	@Test
	public void testsaveIteration() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("1992-06-12");
		Date d2 = df.parse("1993-02-05");
		Iteration iteration = new Iteration("title0","description0",d1,d2,"PLANNED","PLANNING",33);
		
		
		test.saveIteration(iteration);
		
		Iteration i = test.getIterationById(iteration.getIterationId());
	
		i.setStartDate( new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(i.getStartDate())));
		i.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(i.getEndDate())));
		
		assertEquals(i,iteration);
	}
	
	@Test
	public void testdeleteIteration() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("1774-06-12");
		Date d2 = df.parse("1777-02-05");
		Iteration iteration = new Iteration("title55","description55",d1,d2,"PLANNED","PLANNING",55);
		
		test.saveIteration(iteration);
		
		List <Iteration> IterationList = test.getIteration();
		
		
		
		test.deleteIteration(iteration.getIterationId()); // Here, we're going to remove that iteration object
		assertTrue( IterationList.size() == ( test.getIteration().size() +1) );		// Size should have decreased by 1
		assertFalse( test.getIteration().contains(iteration));			// the object should no longer be contained in the iteration table
		
	}
	
	@Test
	public void testgetIterationByReleaseId() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("1982-06-12");
		Date d2 = df.parse("1983-02-05");
		Iteration iteration = new Iteration("title11","description10",d1,d2,"PLANNED","PLANNING",73);
		
		test.saveIteration(iteration);
		Iteration i = null;
		for(Iteration i1 : test.getIterationByReleaseId(73))
		{
			if(i1.getIterationId()==iteration.getIterationId())
			{
				i = i1;	
			}
		}
		
		i.setStartDate( new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(i.getStartDate())));
		i.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(i.getEndDate())));
		
		assertEquals(i,iteration);
		
	}
	
	@Test
	public void testupdateIteration() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		Date d1 = df.parse("1882-06-12");
		Date d2 = df.parse("1883-02-05");
		Iteration iteration = new Iteration("title71","description70",d1,d2,"PLANNED","PLANNING",99);
		
		test.saveIteration(iteration);
		
		Iteration i = iteration;
	
		iteration.setDescription("UpdatedDescription");
		
		test.updateIteration(iteration);
		
		
		i.setStartDate( new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(i.getStartDate())));
		i.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(i.getEndDate())));

		assertNotSame(i,test.getIterationById(i.getIterationId()));		// Id remains the same but the values of the description have changed. Hence they're not the same objects after update
	}
	
	@Test
	public void testaddItem() {
		Item item = new Item("name",1);
		test.addItem(item);
		
		Item it = null;
		
		for(Item i: test.getItemByReleaseId(1))
		{
			if(i.getItemId()==item.getItemId())
			{
				it = i;
			}
		}
		assertEquals(item,it);
	
		
	}
	
	@Test
	public void testviewItem() {
		Item item = new Item("name",2);
		test.addItem(item);
		
		Item it = null;
		
		List <Item> ItemList = new ArrayList<>();
		for(int id =0; id<100;id++)				// I only entered items with release id between 0 -> 100
		{
			for(Item i : test.getItemByReleaseId(id))
			{
				ItemList.add(i);
			}
		}
		
		
		
		assertTrue(ItemList.containsAll(test.viewItem()));
	}
	
	@Test
	public void testdeleteItem() {
		
		Item item = new Item("name3",3);
		test.addItem(item);
		
	
		
		List <Item> ItemList =  test.viewItem();
		
		assertTrue( ItemList.contains(item));			// the list contains the

		test.deleteItem(item.getItemId());
		assertNotSame(ItemList,test.viewItem());
		assertTrue(! test.viewItem().contains(item));
								
		
		
	}
	
	@Test 
	public void testgetItemByReleaseId() {
		Item item = new Item("name4",4);
		
		test.addItem(item);
		assertTrue(test.getItemByReleaseId(4).contains(item));
		
		
	}
	
}

