/**@IFPB
 * @author Alan Giovanni | Suelando Alves | William Soares
 * @version 1.0
 * @since 03 December 2017
 * @CommentLanguage Pt-Br
 * 
 * Esta cole��o representa um ARRAY de Usuarios que acessar�o o sistema de vendas
 */
package sistemaDeVendas.collections;
import java.io.Serializable;
import java.util.ArrayList;
import sistemaDeVendas.classes.Usuarios;

public class ColUsuarios implements Serializable{
	private ArrayList<Usuarios> colUsuarios = new ArrayList<Usuarios>();
	private static final long serialVersionUID = 1L;
	
	public ColUsuarios(){
		
	}
	
	public void adicionaUsuarioNaLista(Usuarios usuario){
		colUsuarios.add(usuario);
	}
	
	public void removeUsuarioDaLista(Usuarios usuario){
		colUsuarios.remove(usuario);
	}
}