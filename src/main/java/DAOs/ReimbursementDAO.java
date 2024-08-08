package DAOs;

import models.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ReimbursementDAO extends JpaRepository<Reimbursement, Integer>{

    public List<Reimbursement> findByUser_UserId(int userId);

}