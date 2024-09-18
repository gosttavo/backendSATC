package com.example.exercicio08.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/fipe")
public class FipeController {
    RestClient cliente = RestClient.create("https://parallelum.com.br");

    @PostMapping("/valor")
    @ResponseBody
    public HashMap<String, String> valor(@RequestBody Map<String, String> request) {
        // CURL:
        //        curl --location 'http://localhost:8080/fipe/valor' \
        //        --header 'Content-Type: application/json' \
        //        --data '{
        //        "marca": "Fiat",
        //                "modelo": "UNO VIVACE ITALIA 1.0 EVO F. Flex 8V 5p",
        //                "ano": "2015-1"
        //    }'

        HashMap<String, String> respostaPersonalizada = new HashMap<>();

        String marca = request.get("marca");
        String modelo = request.get("modelo");
        String ano = request.get("ano");

        List<Map<String, String>> marcas = cliente.get()
                .uri("/fipe/api/v1/carros/marcas")
                .retrieve()
                .body(List.class);

        if (marcas == null) {
            respostaPersonalizada.put("error", "Erro ao consultar as marcas na API FIPE");
            return respostaPersonalizada;
        }

        String marcaId = marcas.stream()
                .filter(item -> marca.equalsIgnoreCase(item.get("nome")))
                .map(item -> String.valueOf(item.get("codigo")))
                .findFirst()
                .orElse(null);

        if (marcaId == null) {
            respostaPersonalizada.put("error", "Marca não encontrada");
            return respostaPersonalizada;
        }

        Map<String, Object> modelosResponse = cliente.get()
                .uri("/fipe/api/v1/carros/marcas/" + marcaId + "/modelos")
                .retrieve()
                .body(Map.class);

        List<Map<String, String>> modelos = (List<Map<String, String>>) modelosResponse.get("modelos");

        if (modelos == null) {
            respostaPersonalizada.put("error", "Erro ao consultar os modelos na API FIPE");
            return respostaPersonalizada;
        }

        String modeloId = modelos.stream()
                .filter(item -> modelo.equalsIgnoreCase(item.get("nome")))
                .map(item -> String.valueOf(item.get("codigo")))
                .findFirst()
                .orElse(null);

        if (modeloId == null) {
            respostaPersonalizada.put("error", "Modelo não encontrado");
            return respostaPersonalizada;
        }

        List<Map<String, String>> anos = cliente.get()
                .uri("/fipe/api/v1/carros/marcas/" + marcaId + "/modelos/" + modeloId + "/anos")
                .retrieve()
                .body(List.class);

        if (anos == null) {
            respostaPersonalizada.put("error", "Erro ao consultar os anos na API FIPE");
            return respostaPersonalizada;
        }

        System.out.println("anos " + anos);

        String anoId = anos.stream()
                .filter(item -> ano.equalsIgnoreCase(item.get("codigo")))
                .map(item -> String.valueOf(item.get("codigo")))
                .findFirst()
                .orElse(null);

        if (anoId == null) {
            respostaPersonalizada.put("error", "Ano não encontrado");
            return respostaPersonalizada;
        }

        Map<String, String> valorResponse = cliente.get()
                .uri("/fipe/api/v1/carros/marcas/" + marcaId + "/modelos/" + modeloId + "/anos/" + anoId)
                .retrieve()
                .body(Map.class);

        if (valorResponse == null) {
            respostaPersonalizada.put("error", "Erro ao consultar o valor na API FIPE");
            return respostaPersonalizada;
        }

        respostaPersonalizada.put("Valor", valorResponse.get("Valor"));
        respostaPersonalizada.put("MesReferencia", valorResponse.get("MesReferencia"));

        return respostaPersonalizada;
    }
}
