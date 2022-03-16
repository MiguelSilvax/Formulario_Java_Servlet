package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servlet")
public class servelet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String tecnologias[] = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        String comentario = request.getParameter("comentarios");
        String musica = request.getParameter("musicaFavorita");
        try {
            out.print("<html>");
            out.print("<body>");

            //table
            out.print("<table>");

            out.print("<tr>");
            out.print("<td>");
            out.println("Usuario: ");
            out.print("</td>");
            out.print("<td>");
            out.println(usuario);
            out.print("</td>");
            out.print("</tr>");

            out.print("<tr>");
            out.print("<td>");
            out.println("Password: ");
            out.print("</td>");
            out.print("<td>");
            out.println(password);
            out.print("</td>");
            out.print("</tr>");

            for (int i = 0; i < tecnologias.length; i++) {
                String tecnologia = tecnologias[i];
                out.print("<tr>");
                out.print("<td>");
                out.println("Tecnología " + (i + 1) + ": ");
                out.print("</td>");
                out.print("<td>");
                out.println(tecnologia);
                out.print("</td>");
                out.print("</tr>");
            }

            out.print("<tr>");
            out.print("<td>");
            out.println("Género: ");
            out.print("</td>");
            out.print("<td>");
            switch (genero) {
                case "H":
                case "h":
                    out.println("<p>Hombre</p>");
                    out.print("</td>");
                    out.print("</tr>");
                    break;
                case "M":
                case "m":
                    out.println("<p>Mujer</p>");
                    out.print("</td>");
                    out.print("</tr>");
                    break;
            }

            out.print("<tr>");
            out.print("<td>");
            out.println("Ocupación: ");
            out.print("</td>");
            out.print("<td>");

            int oc = Integer.parseInt(ocupacion);
            switch (oc) {
                case 1:
                    out.println("<p>Ingeniero de software</p>");
                    break;
                case 2:
                    out.println("<p>Ingeniero de sistemas</p>");
                    break;
                case 3:
                    out.println("<p>Ingeniero Industrial</p>");
                    break;
            }
            
            out.print("</td>");
            out.print("</tr>");
            
            out.print("<tr>");
            out.print("<td>");
            out.print("Música: ");
            out.print("</td>");
            out.print("<td>");
            if (musica != null) {
                out.print(musica);
            }else{
                out.print("No se ha seleccionado la música");
            }
            out.print("</td>");
            out.print("</tr>");
            

            out.print("<tr>");
            out.print("<td>");
            out.println("Comentario: ");
            out.print("</td>");
            out.print("<td>");
            out.println(comentario);
            out.print("</td>");
            out.print("</tr>");

            

            out.print("<table>");
            
            out.print("</body>");
            out.print("</html>");

        } finally {
            out.close();
        }
    }

}
