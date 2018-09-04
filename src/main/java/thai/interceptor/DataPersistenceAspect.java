package thai.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class DataPersistenceAspect {
    @AfterReturning("execution(public * org.springframework.data.repository.Repository+.save(*))")
    public void afterSaving(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication == null ? "anonymous" : authentication.getName();
        Object argument = joinPoint.getArgs()[0];
        log.info("The user " + username + " saved record " + argument);
    }
}
