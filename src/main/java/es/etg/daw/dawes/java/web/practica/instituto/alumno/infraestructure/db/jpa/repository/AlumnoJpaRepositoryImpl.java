package es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.Alumno;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.model.AlumnoId;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.domain.repository.AlumnoRepository;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.web.practica.instituto.alumno.infraestructure.mapper.AlumnoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlumnoJpaRepositoryImpl implements AlumnoRepository {

    private final AlumnoEntityJpaRepository repository;

    @Override
    public Alumno save(Alumno a) {
        AlumnoEntity entity = AlumnoMapper.toEntity(a);
        return AlumnoMapper.toDomain(repository.save(entity));
    }

    @Override
    public List<Alumno> getAll() {
        return AlumnoMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
        Optional<AlumnoEntity> ae = repository.findById(id.getValue());
        return ae.map(AlumnoMapper::toDomain);
    }

    @Override
    public void deleteById(AlumnoId id) {
        repository.deleteById(id.getValue());
    }

    @Override
    public Optional<Alumno> getByName(String name) {
        AlumnoEntity ae = repository.findByNombre(name);
        return ae != null ? Optional.of(AlumnoMapper.toDomain(ae)) : Optional.empty();
    }
}
