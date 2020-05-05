package finalProject.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import finalProject.annotation.MethodRunningTime;

@Aspect
@Component
public class MethodRunningTimeAspect {

	
	@Around("@annotation(methodRunningTime)")
	public Object execute(ProceedingJoinPoint point, MethodRunningTime methodRunningTime) throws Throwable {
		
		if(!methodRunningTime.active()) {
			return point.proceed();
		}
		
		String className = point.getSignature().getDeclaringType().getSimpleName();
		String methodName = point.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		
		Object result = point.proceed();
		
		stopWatch.stop();
		
		
		System.out.println(className + "' deki " + methodName + " metodu " +stopWatch.getTotalTimeMillis() + " ms çalıştı.");
		
		
		return result;
	}
	
}
