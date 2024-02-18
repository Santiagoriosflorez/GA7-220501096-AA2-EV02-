package com.example.servicio;

import com.example.dao.IndividuoDao;
import com.example.domain.Individuo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IndividuoServicioImp implements IndividuoServicio {
    
    @Autowired
    private IndividuoDao individuoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Individuo> listaIndividuos() {
        return (List<Individuo>) individuoDao.findAll();
    }

   @Override
@Transactional
public void salvar(Individuo individuo) {
    if (individuo.getId_individuo() == null) {    } else {
        // Verifica si el individuo ya tiene un ID asignado
        Individuo individuoExistente = localizarIndividuo(individuo.getId_individuo());
        if (individuoExistente != null) { // Si el indiviaduo existe, actualiza sus datos
            individuoExistente.setUsuario(individuo.getUsuario());
            individuoExistente.setCorreo(individuo.getCorreo());
            individuoExistente.setContrasena(individuo.getContrasena());
            individuoDao.save(individuoExistente); // Guarda los cambios en la base de datos
            return;
        }
        }
    // Si el individuo es nuevo (no tiene un ID asignado) o no existe en la base de datos,
    // simplemente guarda el individuo como nuevo
    individuoDao.save(individuo);
}

    @Override
    @Transactional(readOnly = true)
    public Individuo localizarIndividuo(Long id) {
        return individuoDao.findById(id).orElse(null);
    }
   @Override
@Transactional
public void editarIndividuo(Long id_individuo, Individuo individuo) {
    Individuo individuoExistente = localizarIndividuo(id_individuo);
    if (individuoExistente != null) {
        // Actualizar los datos del individuo existente con los datos del individuo recibido
        individuoExistente.setUsuario(individuo.getUsuario());
        individuoExistente.setCorreo(individuo.getCorreo());
        individuoExistente.setContrasena(individuo.getContrasena());
        // No es necesario guardar, ya que el objeto individuoExistente es administrado por JPA
    }
}   
    @Override
    @Transactional
    public void borrar(Long id_individuo) {
        individuoDao.deleteById(id_individuo);
    }

}