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

import com.dev.backend.services.ProductService;
import com.dev.backend.spring.SpringContext;
import com.dev.backend.to.Product;
import javax.ws.rs.PathParam;

@Path("/product/services")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@POST
	@Path("/save/product")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Product product) {
		SpringContext.getApplicationContext().getBean(ProductDao.class).save(product);

		return Response.status(200).build();
	}

	@GET
	@Path("/read/product/record/{code}/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object readRecordByCode(
			@PathParam("code") String code,
			@PathParam("type") int objectType) {
		return SpringContext.getApplicationContext().getBean(ProductDao.class).readRecordByCode(code, objectType);
	}

	@GET
	@Path("/delete/product/record/{code}/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteRecordByCode(
			@PathParam("code") String code,
			@PathParam("type") int objectType) {
		return SpringContext.getApplicationContext().getBean(ProductDao.class).deleteRecordByCode(code, objectType);
	}

	@GET
	@Path("/list/product/record/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object> listCurrentRecords(
			@PathParam("type") int objectType) {
		return SpringContext.getApplicationContext().getBean(ProductDao.class).listCurrentRecords(objectType);
	}

	@GET
	@Path("/list/product/record/references/{type}")
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
