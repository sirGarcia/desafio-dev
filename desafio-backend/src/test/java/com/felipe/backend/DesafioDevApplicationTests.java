package com.felipe.backend;

import com.felipe.backend.controller.FileController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class DesafioDevApplicationTests {
	@Autowired
	FileController controller;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

	@Test
	void persistFileEndPoint() throws Exception{
		MockMultipartFile file = new MockMultipartFile(
				"file",
				"CNABTEST.txt",
				MediaType.TEXT_PLAIN_VALUE,
				"3201903010000014200096206760174753****3153153453JOÃO MACEDO   BAR DO JOÃO       \r\n".getBytes(StandardCharsets.UTF_8)
		);

		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mvc.perform(multipart("/api/parsefile/persist-file").file(file))
				.andExpect(status().isOk());

		file = new MockMultipartFile(
				"file",
				"CNABTEST.txt",
				MediaType.TEXT_PLAIN_VALUE,
				"3201903010000014200096206760174753****3153153453JOÃMACED BAR DO JOÃO       \r\n".getBytes(StandardCharsets.UTF_8)
		);

		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mvc.perform(multipart("/api/parsefile/persist-file").file(file))
				.andExpect(status().isBadRequest());
	}

	@Test
	void consultasTest()throws Exception{
		final String lojaId = "QkFSIERPIEpPw4NPSk/Dg08gTUFDRURP";
		MockMultipartFile file = new MockMultipartFile(
				"file",
				"CNABTEST.txt",
				MediaType.TEXT_PLAIN_VALUE,
				"3201903010000014200096206760174753****3153153453JOÃO MACEDO   BAR DO JOÃO       \r\n".getBytes(StandardCharsets.UTF_8)
		);

		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mvc.perform(multipart("/api/parsefile/persist-file").file(file))
				.andExpect(status().isOk());

		mvc.perform(get("/api/consulta/lojas")).andExpect(status().isOk());

		mvc.perform(get("/api/consulta/transacao-por-loja" ).param("lojaId", lojaId)).andExpect(status().isOk());

	}

}
