package grupo11.imobiliaria.IntegrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void deveRetornarAreaDaPropriedade() throws Exception {
            MvcResult result = mockMvc
                    .perform(MockMvcRequestBuilders
                            .get("/area/casa1"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();

            System.out.println(result.getResponse().getContentAsString());
        }

    @Test
    public void deveRetornarValorDaPropriedade() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/valor/casa1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void deveRetornarMaiorComodoDaPropriedade() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/maiorComodo/casa1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void deveRetornarListaDeAreaPorComodosDaPropriedade() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/areaComodos/casa1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

        @Test
        public void deveCadastrarUmaCasa() throws Exception{
            String payLoad = " {\n" +
                    "        \"name\":\"Novacasa\",\n" +
                    "        \"district\":{\n" +
                    "        \"name\":\"Bairro do Limoeiro\",\n" +
                    "        \"squaredMeterValue\":200\n" +
                    "\n" +
                    "        },\n" +
                    "    \"rooms\":[\n" +
                    "        {\"name\":\"quarto\",\n" +
                    "        \"width\":10,\n" +
                    "        \"length\":20\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}\n";
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .post("/prop")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(payLoad))
                    .andExpect(MockMvcResultMatchers.status().isCreated());

        }

    }