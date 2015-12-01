package com.dev.backend.services.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.backend.services.Services;
import com.dev.backend.spring.SpringContext;
import com.dev.backend.to.Customer;

@Path("/services")
public class ServicesImpl implements Services{
	
	@Autowired
	private Dao dao;
	
	@POST
	@Path("/save/customer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Customer customer) {
		SpringContext.getApplicationContext().getBean(Dao.class).save(customer);
		
		return Response.status(200).build();
	}

	@GET
	@Path("/read/record/{code}/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object readRecordByCode(
			@PathParam("code") String code,
			@PathParam("type") int objectType) {
		return SpringContext.getApplicationContext().getBean(Dao.class).readRecordByCode(code, objectType);
	}

	@GET
	@Path("/delete/record/{code}/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteRecordByCode(
			@PathParam("code") String code,
			@PathParam("type") int objectType) {
		return SpringContext.getApplicationContext().getBean(Dao.class).deleteRecordByCode(code, objectType);
	}

	@GET
	@Path("/list/record/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object> listCurrentRecords(
			@PathParam("type") int objectType) {
		return SpringContext.getApplicationContext().getBean(Dao.class).listCurrentRecords(objectType);
	}

	@GET
	@Path("/list/record/references/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object[]> listCurrentRecordRefernces(
			@PathParam("type") int objectType) {
		return null;
	}

	@GET
	@Path("/get/product/price/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public double getProductPrice(
			@PathParam("code") String productCode) {
		return 0;
	}
}