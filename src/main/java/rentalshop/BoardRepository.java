package rentalshop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {

    List<Board> findByRentId(Long rentId);

}