
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {

    private String message;
    private static final Logger LOGGER = LoggerFactory.getLogger(Hello.class);

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello from Shyam";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>" + message + "</h1>");
        } catch (IOException e) {
            // Log the error using the logger
            LOGGER.error("An IOException occurred", e);
        } catch (Exception e) {
            // Handle any other exceptions appropriately
            LOGGER.error("An unexpected error occurred", e);
        }
    }
}
