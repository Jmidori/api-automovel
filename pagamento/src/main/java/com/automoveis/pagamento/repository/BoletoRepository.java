package com.automoveis.pagamento.repository;

import com.automoveis.pagamento.entity.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepository extends JpaRepository<Boleto,Long> {
}
