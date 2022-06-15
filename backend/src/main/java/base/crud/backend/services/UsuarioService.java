package base.crud.backend.services;

import base.crud.backend.models.Usuario;
import base.crud.backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElse(null);
    }
    public List<Usuario> findAll() {
        return repository.findAll();
    }
    public Usuario update(Long id, Usuario obj) {
        Usuario newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setSobrenome(obj.getSobrenome());
        newObj.setEmail(obj.getEmail());
        newObj.setSenha(obj.getSenha());
        return repository.save(newObj);
    }
    public Usuario create(Usuario obj) {
        return repository.save(obj);
    }
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
