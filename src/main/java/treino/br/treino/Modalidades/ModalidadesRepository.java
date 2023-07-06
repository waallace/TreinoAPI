package treino.br.treino.Modalidades;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModalidadesRepository extends JpaRepository<Modalidades, Long> {
    Page<Modalidades> findAllByAtivoTrue(Pageable paginacao);
}
