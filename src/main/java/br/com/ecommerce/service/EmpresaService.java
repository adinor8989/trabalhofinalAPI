package br.com.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ecommerce.dto.EmpresaResponseDTO;
import br.com.ecommerce.entity.Empresa;
import br.com.ecommerce.exception.ResourceNotFoundException;
import br.com.ecommerce.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	public EmpresaResponseDTO buscar(String cnpj) {
		Optional<Object> empresa = Optional.ofNullable(repository.findByCnpj(cnpj));
		if (empresa.isPresent()) {
			return new EmpresaResponseDTO(empresa.get());
		} else {
			RestTemplate rs = new RestTemplate();
			String url = "https://receitaws.com.br/v1/cnpj/" + cnpj;
			Optional<Empresa> empresaCnpj = Optional.ofNullable(rs.getForObject(url, Empresa.class));
			if (empresaCnpj.get().getCnpj() != null) {
				String cnpjSemPonto = empresaCnpj.get().getCnpj().replaceAll("-", "");
				empresaCnpj.get().setCnpj(cnpjSemPonto);
				return inserir(empresaCnpj.get());
			} else {
				throw new ResourceNotFoundException("Cnpj não encontrado !");
			}
		}
	}

	public EmpresaResponseDTO inserir(Empresa empresa) {
		return new EmpresaResponseDTO(repository.save(empresa));
	}

	public List<EmpresaResponseDTO> listar() {
		List<Empresa> empresas = repository.findAll();
		return empresas.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	public EmpresaResponseDTO atualizar(Long id, Empresa empresa) {
		 Optional<Empresa> empresaOpt = repository.findById(id);
	        if (empresaOpt.isPresent()) {
	            Empresa empresas = empresaOpt.get();
	            empresas.setNome(empresa.getNome());
	            empresas.setCnpj(empresa.getCnpj());
	            Empresa salvo = repository.save(empresas);
	            return convertToDto(salvo);
	        }		
		return null;
	}
	public boolean deletar(Long id) {
        Optional<Empresa> empresaOpt = repository.findById(id);
        if (empresaOpt.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
	private EmpresaResponseDTO convertToDto(Empresa empresa) {
		EmpresaResponseDTO dto = new EmpresaResponseDTO(empresa);
		dto.setNome(empresa.getNome());
		dto.setCnpj(empresa.getCnpj());
		return dto;

	}
}
