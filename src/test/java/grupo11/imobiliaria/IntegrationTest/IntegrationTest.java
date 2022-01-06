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
    public void deveRetornarAreaDoImovel() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/area/casa1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void deveRetornarValorDoImovel() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/valor/casa1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void deveRetornarMaiorComodoDoImovel() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/maiorComodo/casa1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void deveRetornarListaDeAreaPorComodosDoImovel() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/areaComodos/casa1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void deveCadastrarUmImovel() throws Exception {
        String payLoad = " {\n" +
                "        \"name\":\"Novacasa\",\n" +
                "        \"district\":{\n" +
                "        \"name\":\"Bairro do Limoeiro\",\n" +
                "        \"squaredMeterValue\":200\n" +
                "\n" +
                "        },\n" +
                "    \"rooms\":[\n" +
                "        {\"name\":\"Quarto\",\n" +
                "        \"width\":10,\n" +
                "        \"length\":20\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/imovel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoad))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void deveRelatarErroAoCadastrarUmImovelComDadosInvalidos() throws Exception {

        String payLoad = " {" +
                "        \"name\":\"novacasa\"," +
                "        \"district\":{\n" +
                "        \"name\":\"Bairro do Limoeiro\"," +
                "        \"squaredMeterValue\":200" +
                "        }," +
                "    \"rooms\":[" +
                "        {\"name\":\"Quarto\"," +
                "        \"width\":10," +
                "        \"length\":20" +
                "        }" +
                "    ]" +
                "}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/imovel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoad))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}