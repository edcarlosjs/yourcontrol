package com.fiap.youdelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiap.youdelivery.dto.UsuariosDTO;
import com.fiap.youdelivery.entities.Usuarios;
import com.fiap.youdelivery.exception.ControllerNotFoundException;
import com.fiap.youdelivery.repository.IUsuariosRepository;

@Service
public class UsuariosService {
	
//	   @Autowired
//	   private final IUsuariosRepository usuariosRepository;
//	   @Autowired
//	   private final BCryptPasswordEncoder passwordEncoder;
//
//	    
//	    public UsuariosService(IUsuariosRepository usuariosRepository, BCryptPasswordEncoder passwordEncoder) {
//	        this.usuariosRepository = usuariosRepository;
//	        this.passwordEncoder = passwordEncoder;
//	    }
//	 

    
	 @Autowired
	    private final IUsuariosRepository usuariosRepository;
	    
	   // @Autowired
	   // private final IMoradorRepository moradorRepository;
	    
	   // @Autowired
	   // private final IFuncionarioRepository funcionarioRepository;
	    
	    @Autowired
	    private final BCryptPasswordEncoder passwordEncoder;

	    public UsuariosService(IUsuariosRepository usuariosRepository, 
	                          // IMoradorRepository moradorRepository,
	                          // IFuncionarioRepository funcionarioRepository,
	                          BCryptPasswordEncoder passwordEncoder
	                           )
{
	        this.usuariosRepository = usuariosRepository;
	    ///    this.moradorRepository = moradorRepository;
	     //   this.funcionarioRepository = funcionarioRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    
	    @Transactional
	    public UsuariosDTO save(UsuariosDTO dto) {
	        // Validação para verificar se o usuário já existe
	        if (usuariosRepository.findByUsername(dto.getUsername()) != null) {
	            throw new ControllerNotFoundException("Username já existe"); 
	        }
	        // Criptografando a senha
	        String encryptedPassword = passwordEncoder.encode(dto.getPassword());
	        Usuarios entity = new Usuarios(dto.getUsername(), encryptedPassword, dto.getPapel());

	        // Salvando o usuário
	        Usuarios savedUser = usuariosRepository.save(entity);
	        return UsuariosDTO.fromEntity(savedUser);
	    }
	    
	    
//	    @Transactional
//	    public UsuariosDTO saveUsuarioComMoradorOuFuncionario(UsuarioCadastroDTO dto) {
//	        // Validação para verificar se o usuário já existe
//	        if (usuariosRepository.findByUsername(dto.getUsuario().getUsername()) != null) {
//	            throw new ControllerNotFoundException("Username já existe"); 
//	        }
//
//	        // Criptografando a senha
//	        String encryptedPassword = passwordEncoder.encode(dto.getUsuario().getPassword());
//	        
//	        // Criar e salvar o Usuario
//	        Usuarios usuario = new Usuarios(dto.getUsuario().getUsername(),encryptedPassword,dto.getUsuario().getPapel()); // ou outro papel conforme necessário
//	        Usuarios savedUser = usuariosRepository.save(usuario);
//
//	        // Verificar se é Morador
//	        if (dto.getMorador() != null) {
//	            Morador morador = new Morador();
//	            morador.setApartamento(dto.getMorador().getApartamento());
//	            morador.setTelefone(dto.getMorador().getTelefone());
//	            morador.setUsuarios(savedUser); // Associe o usuário ao morador
//	            moradorRepository.save(morador);
//	        }
//
//	        // Verificar se é Funcionario
//	        if (dto.getFuncionario() != null) {
//	            Funcionario funcionario = new Funcionario();
//	            funcionario.setNome(dto.getFuncionario().getNome());
//	            funcionario.setFuncao(dto.getFuncionario().getFuncao());
//	            funcionario.setTurno(dto.getFuncionario().getTurno());
//	            funcionario.setUsuarios(savedUser); // Associe o usuário ao funcionário
//	            
//	            // Log para verificar o estado do objeto antes de salvar
//	            System.out.println("Funcionario a ser salvo: " + funcionario);
//	            funcionarioRepository.save(funcionario);
//	        }
//	        
//
//	        return UsuariosDTO.fromEntity(savedUser);
//	    }
}
