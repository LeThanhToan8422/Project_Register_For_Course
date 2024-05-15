package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.IdClass.GradeId;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.Grades;

import java.util.Optional;

@Repository
public interface GradesRepository extends JpaRepository<Grades, GradeId> {
}
