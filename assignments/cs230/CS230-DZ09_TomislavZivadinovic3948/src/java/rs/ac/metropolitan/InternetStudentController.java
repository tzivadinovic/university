
package rs.ac.metropolitan;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

@Stereotip

public class InternetStudentController {
    
    private static final Logger logger = Logger.getLogger(
            InternetStudentController.class.getName());
    @Inject
    @Internet
    private TradicionalniStudent tradicionalniStudent;

   
    
    public String navigateToInternetStudents(){
                InternetStudent internetStudent
                = (InternetStudent) tradicionalniStudent;
        logger.log(Level.INFO, "Cuvaju se sledece informacije \n"
                + "{0} {1}, smer = {2}, {3}",
                new Object[]{internetStudent.getIme(),
                    internetStudent.getPrezime(),
                    internetStudent.getSmer(),
                    internetStudent.getEmail()});
        return "internetStudents";
    }
}
