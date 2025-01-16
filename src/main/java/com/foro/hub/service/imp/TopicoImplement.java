package com.foro.hub.service.imp;

import com.foro.hub.model.Curso;
import com.foro.hub.model.Topico;
import com.foro.hub.model.Usuario;
import com.foro.hub.model.record.TopicoActualizarRecord;
import com.foro.hub.model.record.TopicoGetRecord;
import com.foro.hub.model.record.TopicoRecord;
import com.foro.hub.repository.CursoRepository;
import com.foro.hub.repository.TopicoRepository;
import com.foro.hub.repository.UsuarioRepository;
import com.foro.hub.service.TopicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoImplement implements TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoImplement(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public ResponseEntity guardarTopico(TopicoRecord topicoRecord) {
        Optional<Topico> existente = topicoRepository.findByTituloAndMensaje(topicoRecord.titulo(), topicoRecord.mensaje());

        if (existente.isPresent()) {
            return ResponseEntity.badRequest().body("El tópico con el mismo título y mensaje ya existe.");
        }else {
            Optional<Usuario> usuario = usuarioRepository.findById(topicoRecord.autorId());
            Optional<Curso> curso = cursoRepository.findById(topicoRecord.cursoId());
            if (usuario.isEmpty() || curso.isEmpty()) {
                return ResponseEntity.badRequest().body("usuario/curso no encontrado");
            }else {
                topicoRepository.save(new Topico(topicoRecord, usuario.get(), curso.get()));
            }

            return ResponseEntity.ok("Topico registrado con exito");
        }

    }

    @Override
    public Page<TopicoGetRecord> listarTopicos(Pageable paginacion) {
        Page<Object[]> results = topicoRepository.findCustomTopicoDataNative(paginacion);
        return results.map(t -> new TopicoGetRecord(
                ((Number) t[0]).longValue(),
                (String) t[1],
                (String) t[2],
                (String) t[3],
                (String) t[4],
                (String) t[5]
        ));
    }

    @Override
    public ResponseEntity actualizarTopico(Long id, TopicoActualizarRecord topicoActualizarRecord) {

        Topico topico = topicoRepository.getReferenceById(id);

            if (topico.getTitulo().equals(topicoActualizarRecord.titulo()) && topico.getMensaje().equals(topicoActualizarRecord.mensaje())) {
                return ResponseEntity.badRequest().body("El tópico no se actualizo, tópico con el mismo título y mensaje ya existe ");
            } else {
                topico.actualizarTopico(topicoActualizarRecord);
                return ResponseEntity.ok("Topico actualizado con exito");
            }

    }
    /*

    @Override
    public ResponseEntity eliminarTopico(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            topicoRepository.delete(topico.get());
            return ResponseEntity.ok("Topico eliminado con exito");
        } else {
            return ResponseEntity.badRequest().body("El tópico no fue encontrado");
        }

    }

     */
    @Override
    public ResponseEntity eliminarTopico(Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.eliminarTopico();
        return ResponseEntity.ok("Topico eliminado con exito");
    }
}
