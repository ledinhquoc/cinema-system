package codegym.module4.QuocVietPackage.Services;

import codegym.module4.QuocVietPackage.Entities.ticket;
import codegym.module4.QuocVietPackage.Entities.user;
import codegym.module4.QuocVietPackage.Repositories.PointRepository;
import codegym.module4.QuocVietPackage.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ticketServiceImpl implements ticketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<ticket> StatusTicket(user idUser, String status) {
        return ticketRepository.findByIdUserAndAndStatus(idUser, status);
    }
}
