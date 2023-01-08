
package test;

import datos.PersonaDAO;
import datos.UsuarioDAO;
import domain.Persona;
import domain.Usuario;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        /* PERSONAS */
        //INSERTAR
        Persona persona = new Persona("CArlos", "Lopez", "carlitos@gmail.com", "1234567890");
        //int registro = personaDao.insertar(persona);
        List<Persona> personas = personaDao.listar();
        
        System.out.println("Antes");
        for (Persona personi : personas) {
            System.out.println(personi.toString());
        }
        
        //MODIFICAR
        Persona nuevaPersona = new Persona(5, "Rodolfa", "Hernandez", "maria@gmail.com", "8765439823");
        
        personaDao.actualizar(nuevaPersona);
        List<Persona> personaModificar = personaDao.listar();
        System.out.println("Despues");
        for (Persona personi : personaModificar) {
            System.out.println(personi.toString());
        }
        
        //ELIMINAR
        personaDao.eliminar(nuevaPersona);
        List<Persona> personitas = personaDao.listar();
        System.out.println("Despues");
        for (Persona personi : personitas) {
            System.out.println(personi.toString());
        }
        
//        /* USUARIOS */
//        //INSERTAR
//        Usuario usuario = new Usuario("juan", "1234");
//        Usuario usuario2 = new Usuario("maria", "maria1234");
//        Usuario usuario3 = new Usuario("carlos", "9876");
//        //usuarioDao.insertar(usuario);
//        //usuarioDao.insertar(usuario2);
//        //usuarioDao.insertar(usuario3);
//        
//        //LISTAR
//        List<Usuario> usuariosInsertados = usuarioDao.listar();
//        
//        System.out.println("Antes");
//        for (Usuario user : usuariosInsertados) {
//            System.out.println(user.toString());
//        }
//        
//        //MODIFICAR
//        Usuario usuarioModificado = new Usuario(1, "Juana", "juanita123");
//        usuarioDao.actualizar(usuarioModificado);
//        
//        List<Usuario> usuariosModificados = usuarioDao.listar();
//        
//        System.out.println("DESPUES MODIFICACION");
//        for (Usuario usuariosModificado : usuariosModificados) {
//            System.out.println(usuariosModificado.toString());
//        }
//        
//        //ELIMINAR
//        usuarioDao.eliminar(usuarioModificado);
//        List<Usuario> usuariosEliminados = usuarioDao.listar();
//        System.out.println("DESPUES ELIMINAR");
//        for (Usuario usuariosEliminado : usuariosEliminados) {
//            System.out.println(usuariosEliminado.toString());
//        }
    }
}
