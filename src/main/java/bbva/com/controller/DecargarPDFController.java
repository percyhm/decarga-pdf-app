package bbva.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("descarga")
public class DecargarPDFController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecargarPDFController.class);

    @GetMapping(value ="/mostrarPdf")
    public String descargar(){
        LOGGER.info("descargar::Inicio---");
        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> vars = new HashMap<>();
//        vars.put("hotel", "42");
//        vars.put("booking", "21");
//        String result = restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class, vars);
        byte[] response = null;
        try{
            response = restTemplate.getForObject("https://documentos-royal.rimac.com/vida/vividaaddons/planesvidainversion/poliza/2024/08/21/83388d79-31c5-41b5-9541-f273889bfc24.pdf", byte[].class);
        }catch (Exception e){
            LOGGER.error("Error", e);
        }

        if(response!=null){
            LOGGER.info("byte length :: {}" , response.length);
        }
        String result = "response";
        System.out.println(result);
        LOGGER.info("descargar::Fin---");
        return result;
    }
}
