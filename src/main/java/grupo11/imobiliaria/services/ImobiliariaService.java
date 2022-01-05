package grupo11.imobiliaria.services;

import grupo11.imobiliaria.ImobiliariaDTO.ComodoDTO;
import grupo11.imobiliaria.entity.District;
import grupo11.imobiliaria.entity.Prop;
import grupo11.imobiliaria.entity.Room;
import grupo11.imobiliaria.exceptions.BusinessException;
import grupo11.imobiliaria.repository.ImobiliariaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ImobiliariaService {

    ImobiliariaRepository imobiliariaRepository;
    List<Prop> props;

    public ImobiliariaService(ImobiliariaRepository imobiliariaRepository) {
        this.imobiliariaRepository = imobiliariaRepository;
        this.props = imobiliariaRepository.getPropertiesList();
    }

    public String valor(String casa){
        Double valorCasa = area(casa) * 800;
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

    public Double area(String casa){
        List<ComodoDTO> comodos = areaComodos(casa);
        Double areaTotal = 0d;

        for (int i = 0; i < comodos.size(); i++){
            areaTotal += comodos.get(i).getArea();
        }

        return areaTotal;
    }

    public List<ComodoDTO> areaComodos(String casa){
        List<ComodoDTO> comodos = new ArrayList<>();
        for (int i = 0; i < props.size(); i++){
            if (casa.equals(props.get(i).getProp_name())){
                for (int j = 0; j < props.get(i).getProp_rooms().size(); j++){
                    comodos.add(ComodoDTO.converte(props.get(i).getProp_rooms().get(j)));
                }
            }
        }
        return comodos;
    }
    public Prop casaNova(Prop prop){
        for (District d: imobiliariaRepository.getDistrictList()) {
            if(d.equals(prop.getProp_district())){
                imobiliariaRepository.casaNova(prop);
                return prop;
            }
        } throw new BusinessException("Não é permito cadastro de casas em bairros não registrados");
    }


}
