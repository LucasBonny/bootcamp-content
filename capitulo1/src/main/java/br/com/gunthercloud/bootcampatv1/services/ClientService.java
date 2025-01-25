package br.com.gunthercloud.bootcampatv1.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.bootcampatv1.entities.Client;
import br.com.gunthercloud.bootcampatv1.entities.dto.ClientDTO;
import br.com.gunthercloud.bootcampatv1.repositories.ClientRepository;
import br.com.gunthercloud.bootcampatv1.services.exception.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Page<ClientDTO> findAllPaged(PageRequest request) {
		Page<Client> list = repository.findAll(request);
		return list.map(ClientDTO::new);
	}
	
	public ClientDTO findById(Long id) {
		Optional<Client> entity = repository.findById(id);
		return new ClientDTO(entity.orElseThrow(() -> new ResourceNotFoundException("Client id " + id +" does not exists!")));
	}
	
	public ClientDTO inserir(ClientDTO obj) {
		Client entity = new Client(obj);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	public ClientDTO atualizar(Long id, ClientDTO obj) {
		try {
			Client entity = repository.getReferenceById(id);
			copyDtoToEntity(obj, entity);
			entity.setId(id);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		}
		catch(RuntimeException e) {
			throw new ResourceNotFoundException("Client id " + id +" does not exists!");
		}
	}

	public void deletar(Long id) {
		try {
			Client obj = repository.getReferenceById(id);
			repository.delete(obj);
		}
		catch(RuntimeException e) {
			throw new ResourceNotFoundException("Client id " + id + " not exist!");
		}
	}

	private void copyDtoToEntity(ClientDTO obj, Client entity) {
		BeanUtils.copyProperties(obj, entity);		
	}

}
