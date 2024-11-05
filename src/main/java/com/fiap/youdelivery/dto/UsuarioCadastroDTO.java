package com.fiap.youdelivery.dto;

public class UsuarioCadastroDTO {
	
	    private UsuariosDTO usuario;
	    private MoradorDTO morador; // Pode ser nulo se for um funcionário
	    private FuncionarioDTO funcionario; // Pode ser nulo se for um morador
		
	    
	    
	    public UsuarioCadastroDTO() {

		}


		public UsuarioCadastroDTO(UsuariosDTO usuario, MoradorDTO morador, FuncionarioDTO funcionario) {
			this.usuario = usuario;
			this.morador = morador;
			this.funcionario = funcionario;
		}


		public UsuariosDTO getUsuario() {
			return usuario;
		}


		public void setUsuario(UsuariosDTO usuario) {
			this.usuario = usuario;
		}


		public MoradorDTO getMorador() {
			return morador;
		}


		public void setMorador(MoradorDTO morador) {
			this.morador = morador;
		}


		public FuncionarioDTO getFuncionario() {
			return funcionario;
		}


		public void setFuncionario(FuncionarioDTO funcionario) {
			this.funcionario = funcionario;
		}
	    
}
