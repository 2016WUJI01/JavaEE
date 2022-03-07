import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TestServlet02", value = "/TestServlet02")
public class TestServlet02 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init method is called");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello World");
    }

    @Override
    public void destroy() {
        System.out.println("destroy method is called");
    }
}
