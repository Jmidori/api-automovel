package com.automoveis.pagamento.http;

import com.automoveis.pagamento.entity.Boleto;
import com.automoveis.pagamento.http.request.BoletoRequestImpl;
import com.automoveis.pagamento.http.response.BoletoResponseImpl;
import com.automoveis.pagamento.http.response.IPaymentResponse;
import com.automoveis.pagamento.repository.BoletoRepository;
import com.automoveis.pagamento.service.IPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagamento")
public class BoletoController {

    @Autowired
    private IPayment service;
    @Autowired
    private BoletoRepository repository;
    private Boleto boleto;

    @GetMapping("/boleto")
    @ResponseBody
    public ResponseEntity<BoletoResponseImpl> generateBoleto(@RequestBody @Validated BoletoRequestImpl request){
       try {
           IPaymentResponse<BoletoResponseImpl> response = service.getPaymentOrder(request);

           boleto = new Boleto(request.getBrand(),
                   request.getModel(),
                   request.getPrice(),
                   ((BoletoResponseImpl) response).getMaturityDate(),
                   ((BoletoResponseImpl) response).getBoletoCode());
           repository.save(boleto);

           return new ResponseEntity<>((BoletoResponseImpl)response, HttpStatus.CREATED);
       } catch (RuntimeException ex)
    }
}
