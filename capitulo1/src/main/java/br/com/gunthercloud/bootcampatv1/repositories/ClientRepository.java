package br.com.gunthercloud.bootcampatv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.bootcampatv1.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{

}
