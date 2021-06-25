
package rs.ac.metropolitan;

import javax.inject.Inject;

@Stereotip
public class TradicionalniStudentController {
    
    @Inject
    private TradicionalniStudent tradicionalniStudent;

    public TradicionalniStudentController() {
    }

    public void setTradicionalniStudent(TradicionalniStudent tradicionalniStudent) {
        this.tradicionalniStudent = tradicionalniStudent;
    }
    
    public String navigateToTraditionalStudents(){
        return "traditionalStudents";
    }
}
