package br.com.ecommerce.dto;

public class ProdutoRequestDTO {
	
		private String nome;
		private Long idCategoria;
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Long getIdCategoria() {
			return idCategoria;
		}
		public void setIdCategoria(Long idCategoria) {
			this.idCategoria = idCategoria;
		}
		
}
