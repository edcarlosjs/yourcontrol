package com.fiap.youdelivery.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fiap.youdelivery.repository.IUsuariosRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
	
	
	
   @Autowired
    private final IUsuariosRepository usuarioRepository;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username);
    }
    
    
    public AutenticacaoService (IUsuariosRepository usuarioRepository) {
    	this.usuarioRepository = usuarioRepository;
    }
    
    //Declarando os métodos de execução exemplo: save.
//	  @Transactional
//	  public UsuariosDTO save(UsuariosDTO dto) {
//		  var usuariosSaved = usuarioRepository.save(entity);
//		  return UsuariosDTO.fromEntity(usuariosSaved);
//	  }
//    
    
//	//@Autowired
//    //private ApplicationContext context;
//    
//	  private final IUsuariosRepository userRepository;
//	    private final TokenService tokenService;
//	    private final AuthenticationManager authenticationManager;
//
//	    // Injeta todas as dependências via construtor
//	        public AutenticacaoService(IUsuariosRepository userRepository, TokenService tokenService, AuthenticationManager authenticationManager) {
//	        this.userRepository = userRepository;
//	        this.tokenService = tokenService;
//	        this.authenticationManager = authenticationManager;
//	    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
//        return userRepository.findByUsername(username);
//    } 
//   //Requisição para login
//    public ResponseEntity<Object> login(@RequestBody @Valid AutenticacaoDTO data){
//		//authenticationManager = context.getBean(AuthenticationManager.class);
//		
//        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getSenha());
//        var auth = this.authenticationManager.authenticate(usernamePassword);
//        var token = tokenService.generateToken((Usuarios) auth.getPrincipal());
//        return ResponseEntity.ok(new TokenResponseDTO(token));
//    }
//
//
//    public ResponseEntity<Object> register (@RequestBody UsuariosDTO registerDto){
//        if (this.userRepository.findByUsername(registerDto.getUsername()) != null ) return ResponseEntity.badRequest().build();
//        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.getSenha());
//        
//        Usuarios newUser = new Usuarios(registerDto.getUsername(), encryptedPassword, registerDto.getPapel());
//        newUser.setCreatedAt(new Date(System.currentTimeMillis()));
//        this.userRepository.save(newUser);
//        return ResponseEntity.ok().build();
//        
//        
//    }

}
