package com.automoveis.pagamento.service;

import com.automoveis.pagamento.http.request.BoletoRequestImpl;
import com.automoveis.pagamento.http.request.IPaymentRequest;
import com.automoveis.pagamento.http.response.BoletoResponseImpl;
import com.automoveis.pagamento.http.response.IPaymentResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class BoletoImpl implements IPayment {


    @Override
    public IPaymentResponse<BoletoResponseImpl> getPaymentOrder(IPaymentRequest<Object> req) {

        BoletoResponseImpl response = new BoletoResponseImpl();
        BoletoRequestImpl request = (BoletoRequestImpl)req;

        response.setBoletoCode(this.boletoCodeGenerate());
        response.setMaturityDate(this.getMaturityDate());
        response.setValue(String.valueOf(request.getPrice()));

        return response;
    }

    //o metodo retorna um GUID como forma de simular uma linha digitavel de um boleto real
    private String boletoCodeGenerate() {
        UUID guid = UUID.randomUUID();
        return String.valueOf(guid);
    }

    private LocalDate getMaturityDate() {
        return LocalDate.now().plusMonths(1);
    }
}
