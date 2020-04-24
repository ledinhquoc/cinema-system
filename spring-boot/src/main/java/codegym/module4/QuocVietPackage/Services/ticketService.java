package codegym.module4.QuocVietPackage.Services;

import codegym.module4.QuocVietPackage.Entities.ticket;
import codegym.module4.QuocVietPackage.Entities.user;

import java.util.List;

public interface ticketService {
    List<ticket> StatusTicket(user idUser, String status);
}
