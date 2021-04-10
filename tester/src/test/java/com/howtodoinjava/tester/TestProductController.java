package com.howtodoinjava.tester;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class TestProductController {

	@Autowired
	MockMvc mvc;

	@MockBean
	iProdRepo prodRepo;

	@Test
	public void get_all_products_returns_200() throws Exception {
		RequestBuilder getReq = MockMvcRequestBuilders.get("/products").contentType(MediaType.APPLICATION_JSON);
		mvc.perform(getReq).andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void getting_products_returns_all_available_products() throws Exception {
//		create sample data
		Product iphone12 = new Product(1L, "iphone12", "apple", new BigDecimal(1199.99));
		Product motoZ4 = new Product(2L, "motoz4", "motorola", new BigDecimal(499.99));
		Product iphoneSE = new Product(3L, "iphonese", "apple", new BigDecimal(399.99));

		List<Product> productList = Arrays.asList(iphone12, motoZ4, iphoneSE);

//		Mock out the service or DAO repository
//		BDDMockito.given(prodRepo.findAll()).willReturn(productList);
		Mockito.when(prodRepo.findAll()).thenReturn(productList);

//		create a get request
		RequestBuilder getReq = MockMvcRequestBuilders.get("/products");

//		perform the get request and set up an assertion using andExpect.
		mvc.perform(getReq).andExpect(jsonPath("$", hasSize(3)));

		mvc.perform(getReq).andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(iphone12.getName()));

	}

	@Test
	public void get_product_by_id_status_200() throws Exception {
		Long id = 1L;
		RequestBuilder getReq = MockMvcRequestBuilders.get("/products", id);

		mvc.perform(getReq).andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void get_product_by_id_returns_valid_id() throws Exception {

		Product iphone12 = new Product(1L, "iphone12", "apple", new BigDecimal(1199.99));
		Mockito.when(prodRepo.findById(any())).thenReturn(Optional.of(iphone12));

		RequestBuilder getReq = MockMvcRequestBuilders.get("/products/1");

		Gson gson = new Gson();
		String prodJSON = gson.toJson(iphone12);
		System.out.println(prodJSON);
		mvc.perform(getReq).andDo(print());
		mvc.perform(getReq).andExpect(content().json(prodJSON));
	}


	@Test
	@SneakyThrows
	public void get_product_by_invalid_id_returns_404() {
		Long invalidID = 983L;
		RequestBuilder getReq = MockMvcRequestBuilders.get("/products/" + invalidID);
		mvc.perform(getReq).andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void add_product_returns_product() throws Exception {
		Product prod = new Product(5L, "macbook", "apple", new BigDecimal(3597.00));
		System.out.println(prod);
		Gson gson = new Gson();
		String prodJSON = gson.toJson(prod);
		System.out.println(prodJSON);

		Mockito.when(prodRepo.save(any())).thenReturn(prod);

		RequestBuilder postReq = MockMvcRequestBuilders.post("/products").contentType(MediaType.APPLICATION_JSON).content(prodJSON);

		mvc.perform(postReq).andExpect(content().json(prodJSON));
	}

	@Test
	public void updateProduct_status202_and_returnsUpdatedProduct() throws Exception {
		Product prod = new Product(1L, "macbook", "apple", new BigDecimal(3597.00));

//		serialize the product into JSON
		Gson gson = new Gson();
		String prodJSON = gson.toJson(prod);

//		create a put request
		RequestBuilder putReq = MockMvcRequestBuilders.put("/products/" + prod.getId()).contentType(MediaType.APPLICATION_JSON).content(prodJSON);

//		"mock" or simulate the retrieval of the data from the database.  why???
		Mockito.when(prodRepo.findById(prod.getId())).thenReturn(Optional.of(prod));
		Mockito.when(prodRepo.save(any())).thenReturn(prod);


//		peform the put request
		mvc.perform(putReq).andExpect(MockMvcResultMatchers.status().is(202)).andExpect(MockMvcResultMatchers.content().json(prodJSON));
	}

	@Test
	public void deletingProduct_returns_204() throws Exception {


//		choose a valid id to send a delete request with
		Long id = 1L;

//		mock the repo delete method
		Mockito.doNothing().when(prodRepo).deleteById(id);

//		create a delete req
		RequestBuilder delReq = MockMvcRequestBuilders.delete("/products/" + id);

//		perform delete request
		//assert the response code is 204.
		mvc.perform(delReq).andExpect(MockMvcResultMatchers.status().is(204));

	}


}
