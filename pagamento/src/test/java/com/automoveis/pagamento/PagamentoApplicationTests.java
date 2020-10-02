package com.automoveis.pagamento;

import com.automoveis.pagamento.repository.BoletoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PagamentoApplicationTests {
	@Autowired
	private WebApplicationContext context;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private BoletoRepository repository;
	private MockMvc mockMvc;
	private  static final String URL = "http://localhost:8050";
	private static final String URN_BOLETO = "/boleto";
	@Value("classpath:/request-boleto.json")
	private Resource requestBoleto;

	@Test
	void contextLoads() {
	}

	@Test
	@Sql("classpath:/delete.sql")
	public void shouldGenerateBoleto() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		ResultActions result = mockMvc.perform(post(this.URL+URN_BOLETO).contentType("application/json")
				.content(this.readFile(requestBoleto))).andExpect(status().isCreated());

		Assertions.assertEquals(201,result.andReturn().getResponse().getStatus());
		Assertions.assertEquals(repository.count(), 1);
	}
	private String readFile(final Resource resource) throws IOException {
		return new String(Files.readAllBytes(resource.getFile().toPath()));
	}

}
