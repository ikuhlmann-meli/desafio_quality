package grupo11.imobiliaria.services;

import grupo11.imobiliaria.ImobiliariaDTO.ComodoDTO;
import grupo11.imobiliaria.entity.Casa;
import grupo11.imobiliaria.entity.Comodo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ImobiliariaService {

    private  Comodo com1 = Comodo.builder().nome("cozinha").largura(3f).comprimento(5f).build();
    private  Comodo com2 = Comodo.builder().nome("sala").largura(5f).comprimento(6f).build();
    private  List<Comodo> comodos = Arrays.asList(com1, com2);

    private Casa casaTeste = Casa.builder()
            .nome("casaTeste")
            .endereco("Rua dos bobos numero 0")
            .comodos(Arrays.asList(
                    Comodo.builder()
                            .nome("quarto")
                            .largura(5f)
                            .comprimento(4f)
                            .build(),
                    Comodo.builder()
                            .nome("banheiro")
                            .largura(3f)
                            .comprimento(2f)
                            .build())).build();


    private  List<Casa> casas = Arrays.asList(
            Casa.builder()
                    .nome("maurosHouse")
                    .endereco("Rua Tal, numero 0")
                    .comodos(comodos).build(),
            Casa.builder()
                    .nome("iberesHouse")
                    .endereco("Rua dos bobos numero 0")
                    .comodos(Arrays.asList(
                            Comodo.builder()
                                    .nome("quarto")
                                    .largura(5f)
                                    .comprimento(4f)
                                    .build(),
                            Comodo.builder()
                                    .nome("banheiro")
                                    .largura(3f)
                                    .comprimento(2f)
                                    .build()))
                    .build());

    public String valor(String casa){
        Float valorCasa = area(casa) * 800;
        return "O valor da casa " + casa + " é de R$ " + valorCasa;
    }

    public String maiorComodo(String casa){
        List<ComodoDTO> comodos = areaComodos(casa);
        String maior = "";
        Float tamanho = 0f;

        for (int i = 0; i < comodos.size(); i++){
            if (comodos.get(i).getArea() > tamanho){
                maior = comodos.get(i).getNome();
            }
        }
        return maior;
    }

    public Float area(String casa){
        List<ComodoDTO> comodos = areaComodos(casa);
        Float areaTotal = 0f;

        for (int i = 0; i < comodos.size(); i++){
            areaTotal += comodos.get(i).getArea();
        }

        return areaTotal;
    }

    public List<ComodoDTO> areaComodos(String casa){
        List<ComodoDTO> comodos = new ArrayList<>();
        for (int i = 0; i < casas.size(); i++){
            if (casa.equals(casas.get(i).getNome())){
                for (int j = 0; j < casas.get(i).getComodos().size(); j++){
                    comodos.add(ComodoDTO.converte(casas.get(i).getComodos().get(j)));
                }
            }
        }
        return comodos;
    }
}
