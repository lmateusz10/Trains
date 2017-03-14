package pl.trains.pl.trains.othercont;

import pl.trains.model.Client;
import pl.trains.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 14.03.2017.
 */
@WebServlet("/addorder")
public class AddOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory emf;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();

        Order order = new Order();
        order.setOrderDetails(request.getParameter("orderDetails"));

        long clientId = Long.parseLong(request.getParameter("clientId"));
        Client client = em.find(Client.class, clientId);
        order.setClient(client);
        System.out.println(client);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(order);
        tx.commit();
        em.close();

        response.sendRedirect(request.getContextPath());
    }
}
