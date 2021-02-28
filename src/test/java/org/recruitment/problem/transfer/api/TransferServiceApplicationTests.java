package org.recruitment.problem.transfer.api;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest(classes = TransferServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class TransferServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testPerformTransfer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/transfer")
											  .content("{\n"
											  		+ "    \"sourceAccountNumber\":\"1\",\n"
											  		+ "    \"destinationAccountNumber\":\"2\",\n"
											  		+ "    \"amount\":\"100\"\n"
											  		+ "}")
											  .contentType(MediaType.APPLICATION_JSON)
											  .accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
		        .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.jsonPath("transactionId", Matchers.is(1)));
	}
}
