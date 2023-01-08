
package datos;

import java.util.*;

public interface IAccesoDatos<E> {
    
    public List<E> listar();
    public int insertar(E obj);
    public int eliminar(E obj);
    public int actualizar(E obj);
}
