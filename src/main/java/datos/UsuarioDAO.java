
package datos;

import domain.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {
    //Sentencias
    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idUsuario = ?";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE idUsuario = ?";
    
    //Métodos
    public List<Usuario> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                usuario = new Usuario(rs.getInt("idUsuario"),rs.getString("usuario"), rs.getString("password"));
                usuarios.add(usuario);
            }
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return usuarios;
    }
    
    public int insertar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            
            registros = stmt.executeUpdate(); //modifica el estado de la base de datos (insert, update, delete)
            
            Conexion.close(stmt);
            Conexion.close(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return registros;
    }
    
    public int eliminar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0; //cantidad de registros modificados
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            
            registro = stmt.executeUpdate(); //modifica el estado de la base de datos (insert, update, delete)
            
            Conexion.close(stmt);
            Conexion.close(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return registro;
    }
    
    public int actualizar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0; //cantidad de registros modificados
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdUsuario());
            
            registro = stmt.executeUpdate(); //modifica el estado de la base de datos (insert, update, delete)
            
            Conexion.close(stmt);
            Conexion.close(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return registro;
    }
    
}
