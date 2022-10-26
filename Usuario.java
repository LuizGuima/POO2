import java.util.ArrayList;

public abstract class Usuario {

  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private ArrayList<Projeto> projectsEnvolved;
  private ArrayList<Atividades> activitiesEnvolved;

  public Usuario(String firstName, String lastName, String username, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.projectsEnvolved = new ArrayList<Projeto>();
    this.activitiesEnvolved = new ArrayList<Atividades>();
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNome() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setProjectsEnvolved(ArrayList<Projeto> projectsEnvolved) {
    this.projectsEnvolved = projectsEnvolved;
  }

  public ArrayList<Projeto> getProjectsEnvolved() {
    return projectsEnvolved;
  }

  public void setActivitiesEnvolved(ArrayList<Atividades> activitiesEnvolved) {
    this.activitiesEnvolved = activitiesEnvolved;
  }

  public ArrayList<Atividades> getActivitiesEnvolved() {
    return activitiesEnvolved;
  }

  public abstract String toString();
}