package services;
import DAOs.*;
import models.*;
import jakarta.transaction.Transactional;
import models.DTOs.IncomingReimbursementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReimbursementService {

    private ReimbursementDAO rDAO;
    private UserDAO uDAO;

    @Autowired
    public ReimbursementService(ReimbursementDAO rDAO, UserDAO uDAO) {
        this.rDAO = rDAO;
        this.uDAO = uDAO;
    }


    public Reimbursement addReimbursement(IncomingReimbursementDTO newReimbursement) throws IllegalArgumentException
    {
        if (newReimbursement == null)
        {
            throw new IllegalArgumentException("Reimbursement cannot be null");
        }

        Reimbursement r = new Reimbursement(0, newReimbursement.getDescription(), newReimbursement.getAmount(), newReimbursement.getStatus(), null);

        Optional<User> u = (uDAO.findById(newReimbursement.getUserId()));

        if(u.isPresent()){
            r.setUser(u.get()); //assign the User to the Car
            Reimbursement newr = rDAO.save(r); //save our Car to the DB
            return newr;
        } else {
            return null;
        }

    }

    public List<Reimbursement> getAllReimbursements(){
        return rDAO.findAll();

    }

    public void deleteReimbursementsById(int id)
    {
        Reimbursement r = rDAO.findById(id).get();

        r.getUser().getReimbursementList().remove(r);

        rDAO.deleteById(id);

    }

    public List<Reimbursement> getReimbursementsbyUserId(int userId) throws IllegalArgumentException
    {
        if (userId < 0)
        {
            throw new IllegalArgumentException("UserId cannot be negative");
        }
        return rDAO.findByUser_UserId(userId);

    }


}
