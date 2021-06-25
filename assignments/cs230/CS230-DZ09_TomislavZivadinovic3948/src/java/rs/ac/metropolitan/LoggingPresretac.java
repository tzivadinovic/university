
package rs.ac.metropolitan;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
 
/**
 *
 * @author Vladimir Milicevic
 */
@PovezivanjeLoggingPresretaca
@Interceptor
public class LoggingPresretac implements Serializable {
 
    private static final Logger logger = Logger.getLogger(
            LoggingPresretac.class.getName());
 
    @AroundInvoke
    public Object logMethodCall(InvocationContext invocationContext)
            throws Exception {
        logger.log(Level.INFO, new StringBuilder("Ulazak ").append(
                invocationContext.getMethod().getName()).append(
                " metoda").toString());
        Object retVal = invocationContext.proceed();
        logger.log(Level.INFO, new StringBuilder("Izlazak ").append(
                invocationContext.getMethod().getName()).append(
                " metoda").toString());
        return retVal;
    }
}
