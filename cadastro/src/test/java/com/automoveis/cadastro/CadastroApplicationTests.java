package com.automoveis.cadastro;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CadastroApplicationTests {
	@Autowired
	private WebApplicationContext context;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private CarRepository repository;
	private MockMvc mockMvc;
	private  static final String URL = "http://localhost:8060";
	private static final String URN_CADASTRO = "/cadastroAutomoveis";
	private static final String URN_LISTAR = "/automoveis";

	@Value("classpath:/request-cadastro.json")
	private Resource requestCadastro;
	@Value("classpath:/response-automoveis.json")
	private Resource responseAutomoveis;

	@Test
	void contextLoads() {
	}

	@Test
	@Sql("classpath:/delete.sql")
	void ShouldCreateANewCarRegister() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		ResultActions result = mockMvc.perform(post(this.URL+URN_CADASTRO).contentType("application/json")
				.content(readFile(requestCadastro))).andExpect(status().isCreated());

		Assertions.assertEquals(201,result.andReturn().getResponse().getStatus());
		Assertions.assertEquals(repository.count(), 1);
	}
	@Test
	@Sql("classpath:/add-car.sql")
	void ShouldListAllCars() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get(this.URL+URN_LISTAR))
				.andExpect(status().isOk()).andExpect(content().json(this.readFile(responseAutomoveis)));

		Assertions.assertEquals(200,result.andReturn().getResponse().getStatus());
	}

	private String readFile(final Resource resource) throws IOException {
		return new String(Files.readAllBytes(resource.getFile().toPath()));
	}
}
