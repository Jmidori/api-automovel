package com.automoveis.pagamento.service;

import com.automoveis.pagamento.http.request.IPaymentRequest;
import com.automoveis.pagamento.http.response.IPaymentResponse;

public interface IPayment {
    IPaymentResponse getPaymentOrder(IPaymentRequest<Object> request);
}
