package thai.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class DataPersistenceAspect {
    @AfterReturning("execution(public * org.springframework.data.repository.Repository+.save(*))")
    public void afterSaving(JoinPoint joinPoint) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username == null) {
            username = "anonymous";
        }
        Object argument = joinPoint.getArgs()[0];
        log.info("The user " + username + " saved record " + argument);
    }
}
