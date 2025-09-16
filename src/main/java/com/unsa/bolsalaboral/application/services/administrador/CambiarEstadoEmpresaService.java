package com.unsa.bolsalaboral.application.services.administrador;

import com.unsa.bolsalaboral.domain.models.Empresa;
import com.unsa.bolsalaboral.domain.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CambiarEstadoEmpresaService {
    private final EmpresaRepository empresaRepository;

    public CambiarEstadoEmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Optional<Empresa> ejecutar(UUID id) {
        Optional<Empresa> empresaOpt =  empresaRepository.buscarPorId(id);

        return empresaOpt.map(empresa -> {
            empresa.setActiva(!empresa.getActiva());
            return empresaRepository.guardar(empresa);
        });
    }
}