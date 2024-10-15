package bbva.com.controller;

import bbva.com.dto.RequestPdfDTO;
import bbva.com.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("descarga")
public class DecargarPDFController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecargarPDFController.class);

    @PostMapping(value ="/mostrarPdf")
    public ResponseEntity<ResponseDTO> descargar(@RequestBody RequestPdfDTO request) throws Exception {
        LOGGER.info("descargar::Inicio---");
        RestTemplate restTemplate = new RestTemplate();
        String result = "";
        ResponseDTO responseDTO = new ResponseDTO();
//        Map<String, String> vars = new HashMap<>();
//        vars.put("hotel", "42");
//        vars.put("booking", "21");
//        String result = restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class, vars);
        byte[] response = null;
        HttpStatusCode statusCode = null;
        try{
            //response = restTemplate.getForObject(request.getHref(), byte[].class);
            ResponseEntity< byte[] > responseEntity = restTemplate.exchange(request.getHref(), HttpMethod.GET, null, byte[].class);
            statusCode = responseEntity.getStatusCode();
            response = responseEntity.getBody();
        }catch (HttpClientErrorException e){
            LOGGER.error("Error", e.getStackTrace());
            responseDTO.setCode(statusCode.toString());
            responseDTO.setMessage("e.getStatusText()");
            return new ResponseEntity<ResponseDTO>(responseDTO, statusCode);
            //throw new Exception("said something");
        }catch (Exception e){
            LOGGER.error("Error", e.getCause());
            return new ResponseEntity<ResponseDTO>(responseDTO, statusCode);
        }

        if(response!=null){
            LOGGER.info("byte length :: {}" , response.length);
            result = "byte length :: " + response.length;
        }

        responseDTO.setCode(HttpStatus.OK.toString());
        responseDTO.setMessage(result);
        LOGGER.info("descargar::Fin---");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
