
package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDAO implements IAccesoDatos<Persona>{
    //Sentencias
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona = ?";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idPersona = ?";
    
    //Métodos
    @Override
    public List<Persona> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                persona = new Persona(rs.getInt("idPersona"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("telefono"));
                personas.add(persona);
            }
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return personas;
    }
    
    @Override
    public int insertar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate(); //modifica el estado de la base de datos (insert, update, delete)
            
            Conexion.close(stmt);
            Conexion.close(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return registros;
    }
    
    @Override
    public int eliminar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0; //cantidad de registros modificados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registro = stmt.executeUpdate(); //modifica el estado de la base de datos (insert, update, delete)
            
            Conexion.close(stmt);
            Conexion.close(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return registro;
    }
    
    @Override
    public int actualizar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0; //cantidad de registros modificados
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registro = stmt.executeUpdate(); //modifica el estado de la base de datos (insert, update, delete)
            
            Conexion.close(stmt);
            Conexion.close(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return registro;
    }
}
