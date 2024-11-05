package com.fiap.youdelivery.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiap.youdelivery.dto.FuncionarioDTO;
import com.fiap.youdelivery.exception.ControllerNotFoundException;
import com.fiap.youdelivery.exception.DatabaseException;
import com.fiap.youdelivery.repository.IFuncionarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {
 
	  //atributo do service
	  private final IFuncionarioRepository funbcionarioRepository;
	  
	  //Construtor do service
	  
	  public FuncionarioService(IFuncionarioRepository funbcionarioRepository) {
		  this.funbcionarioRepository = funbcionarioRepository;
	  }
	 
	  //Declarando os métodos de execução exemplo: fidall.  
	  @Transactional(readOnly = true) //Encapsulo o metodo dentro de uma transação
	  public Page<FuncionarioDTO> findALL(PageRequest pageRequest){
		  var funcionarios = funbcionarioRepository.findAll(pageRequest);
		  return funcionarios.map(FuncionarioDTO::fromEntity); //para cada funcionario transformo o DTO em Entidade
	  }
	  
	  //Declarando os métodos de execução exemplo: finById.
	  @Transactional(readOnly = true)
	  public FuncionarioDTO findById(Long id) {
		  var funcionarios = funbcionarioRepository.findById(id).orElseThrow(()-> new ControllerNotFoundException("Funcionario não encontrado"));
		  return FuncionarioDTO.fromEntity(funcionarios);
	  }
	  
	  //Declarando os métodos de execução exemplo: save.
	  @Transactional
	  public FuncionarioDTO save(FuncionarioDTO dto) {
		  var entity = FuncionarioDTO.toEntity(dto);
		  var funcionarioSaved = funbcionarioRepository.save(entity);
		  return FuncionarioDTO.fromEntity(funcionarioSaved);
	  }
	  
	  //Declardo os métodos de execução ecemplo update.
	  @Transactional
	  public FuncionarioDTO update(Long id, FuncionarioDTO dto) {
		  try {
			  var entity = funbcionarioRepository.getReferenceById(id);
			  entity = FuncionarioDTO.mapperDtoToEntity(dto, entity);
			  entity = funbcionarioRepository.save(entity);
			  return FuncionarioDTO.fromEntity(entity);
		  }catch(EntityNotFoundException e) {
			  throw new ControllerNotFoundException("Funcionário não localizado, id" + id);
		  }
	  }
	  
	//Declardo os métodos de execução ecemplo delete.
	  @Transactional
	  public void  delete(Long id) {
		  try {
			  funbcionarioRepository.deleteById(id);
		  }
		  catch(DataIntegrityViolationException e) {
			  throw new DatabaseException("Violação de integridade dos dados");
			  
		  }
	  }
}
