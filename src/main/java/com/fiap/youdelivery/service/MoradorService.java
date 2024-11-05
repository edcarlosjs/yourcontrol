package com.fiap.youdelivery.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiap.youdelivery.dto.MoradorDTO;
import com.fiap.youdelivery.exception.ControllerNotFoundException;
import com.fiap.youdelivery.exception.DatabaseException;
import com.fiap.youdelivery.repository.IMoradorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MoradorService {
 
	  //atributo do service
	  private final IMoradorRepository moradorRepository;
	  
	  //Construtor do service
	  
	  public MoradorService(IMoradorRepository moradorRepository) {
		  this.moradorRepository = moradorRepository;
	  }
	 
	  //Declarando os métodos de execução exemplo: fidall.  
	  @Transactional(readOnly = true) //Encapsulo o metodo dentro de uma transação
	  public Page<MoradorDTO> findALL(PageRequest pageRequest){
		  var moradores = moradorRepository.findAll(pageRequest);
		  return moradores.map(MoradorDTO::fromEntity); //para cada morador transformo o DTO em Entidade
	  }
	  
	  //Declarando os métodos de execução exemplo: finById.
	  @Transactional(readOnly = true)
	  public MoradorDTO findById(Long id) {
		  var morador = moradorRepository.findById(id).orElseThrow(()-> new ControllerNotFoundException("Morador não encontrado"));
		  return MoradorDTO.fromEntity(morador);
	  }
	  
	  //Declarando os métodos de execução exemplo: save.
	  @Transactional
	  public MoradorDTO save(MoradorDTO dto) {
		  var entity = MoradorDTO.toEntity(dto);
		  var moradorSaved = moradorRepository.save(entity);
		  return MoradorDTO.fromEntity(moradorSaved);
	  }
	  
	  //Declardo os métodos de execução ecemplo update.
	  @Transactional
	  public MoradorDTO update(Long id, MoradorDTO dto) {
		  try {
			  var entity = moradorRepository.getReferenceById(id);
			  entity = MoradorDTO.mapperDtoToEntity(dto, entity);
			  entity = moradorRepository.save(entity);
			  return MoradorDTO.fromEntity(entity);
		  }catch(EntityNotFoundException e) {
			  throw new ControllerNotFoundException("Morador não localizado, id" + id);
		  }
	  }
	  
	//Declardo os métodos de execução ecemplo delete.
	  @Transactional
	  public void  delete(Long id) {
		  try {
			  moradorRepository.deleteById(id);
		  }
		  catch(DataIntegrityViolationException e) {
			  throw new DatabaseException("Violação de integridade dos dados");
			  
		  }
	  }
}
