import java.util.ArrayList;

public class Atividades {

  private String id;
  private String description;
  private String startAt;
  private String endAt;
  private String leader;
  private ArrayList<Usuario> members;
  private String instructions;

  public Atividades(String id, String description, String startAt, String endAt, String leader, ArrayList<Usuario> members, String instructions) {
    this.id = id;
    this.description = description;
    this.startAt = startAt;
    this.endAt = endAt;
    this.leader = leader;
    this.members = members;
    this.instructions = instructions;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStartAt() {
    return startAt;
  }

  public String getEndAt() {
    return endAt;
  }

  public String getLeader() {
    return leader;
  }

  public ArrayList<Usuario> getMembers() {
    return members;
  }

  public String getMembersUsername() {
    for (Usuario user : members) {
      return user.getUsername();
    }
    return null;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public void setLeader(String leader) {
    this.leader = leader;
  }

  public void setMembers(ArrayList<Usuario> members) {
    this.members = members;
  }

  public void setEndAt(String endAt) {
    this.endAt = endAt;
  }

  public void setStartAt(String startAt) {
    this.startAt = startAt;
  }

  public String toString() {
    return "ID: " + this.getId() + ", DESCRICAO: " + this.getDescription();
  }

  public String getAllInfo() {
    return "\nID: " + this.getId() + "\nCOMECOU EM: " + this.getStartAt() + "\nTERMINA EM: " + this.getEndAt() + "\nLeader: " + this.getLeader() + 
    "\nMEMBROS: " + this.getMembers() + "\nINSTRUCOES: " + this.getInstructions();
  }
}