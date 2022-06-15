package base.crud.backend.services;

import base.crud.backend.models.Midia;
import base.crud.backend.repositories.MidiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MidiaService {

    @Autowired
    private MidiaRepository repository;

    public Midia findById(Long id) {
        Optional<Midia> obj = repository.findById(id);
        return obj.orElse(null);
    }
    public List<Midia> findAll() {
        return repository.findAll();
    }
    public Midia update(Long id, Midia obj) {
        Midia newObj = findById(id);
        newObj.setTitulo(obj.getTitulo());
        newObj.setTipo(obj.getTipo());
        newObj.setDescrição(obj.getDescrição());
        newObj.setNota(obj.getNota());
        newObj.setUsuario(obj.getUsuario());
        return repository.save(newObj);
    }
    public Midia create(Midia obj) {
        return repository.save(obj);
    }
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
