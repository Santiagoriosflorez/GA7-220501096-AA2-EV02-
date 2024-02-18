package com.example.servicio;

import com.example.domain.Individuo;
import java.util.List;

public interface IndividuoServicio {
    
    public List<Individuo> listaIndividuos();
    
    public void salvar(Individuo individuo);
    
    public void editarIndividuo(Long id_individuo,Individuo individuo);

    public Individuo localizarIndividuo(Long id_individuo);

    public void borrar(Long id_individuo);
    
}
