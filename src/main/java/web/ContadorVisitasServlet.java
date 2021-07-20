
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException{
    
       int contador = 0;
        
       //revisar si existe la cookie contador 
    
       Cookie[] cookies = request.getCookies();
       
        if (cookies != null) {
            
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("contadorVisitas")) {
                 
                    contador =Integer.parseInt( cooky.getValue());
                }
            }
        }
        
        //incrementar el contador
        
        contador++;
        
        //respuesta al navegador
        
        Cookie c = new Cookie("contadorVisitas",Integer.toString(contador));
        
        //la cookie se almacena por una hora
        c.setMaxAge(3600);
        
        response.addCookie(c);
        
        //mandamos el mensaje al navegador
        response.setContentType("text/html; charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        out.print("contador de visitas de cada cliente "+contador);
        
    }
    
}
