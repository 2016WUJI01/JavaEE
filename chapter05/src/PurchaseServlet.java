import cn.itcast.session.entity.Cake;
import cn.itcast.session.entity.CakeDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseServlet", value = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null) {
            String url = "ListCakeServlet";
            response.sendRedirect(url);
            return;
        }
        Cake cake = CakeDB.getCake(id);
        HttpSession session = request.getSession();
        List<Cake> cart = (List) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Cake>();
            session.setAttribute("cart", cart);
        }
        cart.add(cake);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60 * 30);
        cookie.setPath("/Servlet");
        response.addCookie(cookie);
        String url = "CartServlet";
        response.sendRedirect(url);
    }
}
