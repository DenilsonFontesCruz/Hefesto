package interceptor;

import annotations.ResourcePermission;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      if(!(handler instanceof HandlerMethod)) {
        return false;
      }

      var method = ((HandlerMethod) handler).getMethod();

      if(method.isAnnotationPresent(ResourcePermission.class)) {
        var permissoesMetodo = method.getAnnotation(ResourcePermission.class)
            .values();
        var permissoesUsuario = request.getHeader("Permissions")
            .split(",");

        var resultado = Arrays.stream(permissoesUsuario)
            .anyMatch(List.of(permissoesMetodo)::contains);

        var userId = request.getHeader("UserId");
        var userEmail = request.getHeader("UserEmail");

        if(userId == null || userEmail == null) {
          response.setStatus(403);
          return false;
        }

        request.setAttribute("UserId", userId);
        request.setAttribute("UserEmail", userEmail);

        if (!resultado) {
          response.setStatus(403);
          return false;
        }
      }

      return true;
    }

}
