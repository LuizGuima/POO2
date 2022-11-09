import java.util.ArrayList;
import java.util.Scanner;

public class Universidade {

  public void menu(Conta account) {
    Scanner input = new Scanner(System.in);
    int option = 13;

    
    	while (option != 0) {
      System.out.println("\nO que deseja fazer?: ");
      System.out.println("[1] Login.");
      System.out.println("[2] Criar Conta.");
      System.out.println("[0] Sair.");

      option = input.nextInt();

      switch (option) {
        case 0:
          System.out.println("\nVoce saiu!");
          break;
        case 1:
          login(account);
          break;
        case 2:
          adcNovoUsuario(account);
          break;
      }
    }
  }

  public void system(Conta account, Usuario user) {
    Scanner input = new Scanner(System.in);
    int option = 18;

    while (option != 0) {
    	 System.out.println("\nEscolha o que deseja fazer: ");
         System.out.println("1 - ADICIONAR UM PROJETO.");
         System.out.println("2 - ADICIONAR UMA ATIVIDADE.");
         System.out.println("3 -ADICIONAR UM USUARIO.");
         System.out.println("4 - EDITAR UM PROJETO.");
         System.out.println("5 - EDITAR UMA ATIVIDADE.");
         System.out.println("6 - EDITAR UM USUARIO.");
         System.out.println("7 - REMOVER UM PROJETO.");
         System.out.println("8 - REMOVER UMA ATIVIDADE.");
         System.out.println("9 - REMOVER UM USARIO.");
         System.out.println("10 - CONSULTAR UM USUARIO.");
         System.out.println("11 - CONSULTAR UM PROJETO.");
         System.out.println("12 - CONSULTAR UMA ATIVIDADE.");
         System.out.println("13 - CONSULTAR STATUS DO PROJETO.");
         System.out.println("14 - DEFINIR STATUS DO PROJETO.");
         System.out.println("15 - PAGAMENTO.");
         System.out.println("16 - FOLHA DE PAGAMENTO.");
         System.out.println("17 - SEUS PROJETOS E ATIVIDADES.");
         System.out.println("0 - SAIR.");

      option = input.nextInt();

      switch (option) {
        case 0:
          break;
        case 1:
          adcNovoProjeto(account);
          break;
        case 2:
          adcNovaAtv(account);
          break;
        case 3:
          adcNovoUsuario(account);
          break;
        case 4:
          editarProjeto(account);
          break;
        case 5:
          editarAtv(account);
          break;
        case 6:
          editarUsuario(account);
          break;
        case 7:
          removerProjeto(account);
          break;
        case 8:
          removerAtv(account);
          break;
        case 9:
          removerUsuario(account);
          break;
        case 10:
          userInformation(account);
          break;
        case 11:
          infoProjeto(account);
          break;
        case 12:
          infoAtv(account);
          break;
        case 13:
        	checkStatus(account);
          break;
        case 14:
        	status(account, user);
          break;
        case 15:
          payment(account);
          break;
        case 16:
          folhaDePagamento(account);
          break;
        case 17:
          report(account);
          break;
      }
    }
  }

  public void removerProjeto(Conta account) {
    Scanner input = new Scanner(System.in);
    String id;
    Projeto wantedProject = null;

    System.out.println("INSIRA O ID DO PREOJETO QUE VOCE QUER REMOVER");
    id = input.nextLine();

    
    for (Projeto project : account.getProjects())
        if (project.getId().equals(id)) wantedProject = project;
      
      if (wantedProject != null) {
        account.getProjects().remove(wantedProject);
        System.out.println("\nPROJETO REMOVIDO COM SUCESSO!\n");
      }
      else System.out.println("ESSE PROJETO NAO FOI ENCONTRADO.");
    }
  
  

  public void removerAtv(Conta account) {
    Scanner input = new Scanner(System.in);
    String id;
    Atividades wantedActivity = null;

    System.out.println("INSIRA O ID DA ATIVIDADE QUE DESEJA REMOVER: ");
    id = input.nextLine();

    for (Atividades activity : account.getActivities())
      if (activity.getId().equals(id)) wantedActivity = activity;
    
    if (wantedActivity != null) {
      account.getActivities().remove(wantedActivity);
      System.out.println("\nATIVIDADE REMOVIDA COM SUCESSO!\n");
    }
    
    else System.out.println("A ATIVIDADE NÃO FOI ENCONTRADA.");
  }

  public void removerUsuario(Conta account) {
    Scanner input = new Scanner(System.in);
    String username, password;
    Usuario wantedUser = null;

    System.out.println("INSIRA SEU USERNAME: ");
    username = input.nextLine();

    System.out.println("INSIRA SUA SENHA: ");
    password = input.nextLine();

    for (Usuario user : account.getUsers())
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) wantedUser = user;
    
    if (wantedUser != null) {
      account.getUsers().remove(wantedUser);
      System.out.println("\nUSUARIO REMOVIDO COM SUCESSO\n");
    }
    
    else System.out.println("ALGO DEU ERRADO TENTE NOVAMENTE.");
  }

  public void report(Conta account) {
    System.out.println("\nPROJETOS: ");
    for (Projeto project : account.getProjects())
      System.out.println(project.getAllInfo());
    System.out.println("\nATIVIDADES: ");
    for (Atividades activity : account.getActivities())
      System.out.println(activity.getAllInfo());
  }

  public void folhaDePagamento(Conta account) {
    Scanner input = new Scanner(System.in);
    String id;
    Projeto currentProject = null;

    System.out.println("INSIRA O ID DO PROEJETO QUE DESEJA VER O PAGAMENTO: ");
    id = input.nextLine();
    for (Projeto project : account.getProjects()) 
      if (project.getId().equals(id)) currentProject = project;
    
    System.out.println(currentProject.getPagamaneto());
  }

  public void payment(Conta account) {
    Scanner input = new Scanner(System.in);
    String id;
    Projeto currentProject = null;
    System.out.println("INSIRA O ID DO PROEJTO QUE DESEJA FAZER UM PAGAMENTO: ");
    id  = input.nextLine();
    for (Projeto project : account.getProjects()) 
      if (project.getId().equals(id)) currentProject = project;
    System.out.printf("O VALOR DA BOLSA DESSE PROJETO É %.2f. ", currentProject.getValorDaBolsa());

  }

  public void checkStatus(Conta account) {
    Scanner input = new Scanner(System.in);
    String id;
    String projectStatus = null;

    System.out.println("INSIRA O ID DO PREOJETO QUE DESEJA VER O STATUS: ");
    id = input.nextLine();

    for (Projeto project : account.getProjects()) 
      if (project.getId().equals(id)) projectStatus = project.getStatus();
    
    System.out.printf("%nStatus: %s%n", projectStatus);
  }

  public void status(Conta account, Usuario user) {
    Scanner input = new Scanner(System.in);
    String id;
    int option;

    System.out.println("INSIRA O ID DO PROEJETO QUE DESEJA DEFINIR O STATUS: ");
    id = input.nextLine();
    for (Projeto project : account.getProjects()) {
      {
        if (project.getId().equals(id)) {
          if (project.getCoordinator() == user) {
            System.out.println("QUAL O STATUS DO PROJETO: \n[1] Iniciado.\n[2] Em andamento.\n[3] Concluido");
            option = input.nextInt();
            input.nextLine();

            switch (option) {
              case 1:
                if(project.checkNull()) System.out.println("\nO PROJETO DEVE TER AS INFORMAÇÕES BÁSICAS.");
                else {
                  project.setStatus("Iniciado");
                  System.out.println("\nSTATUS DO PROJETO: 'Iniciado'.");
                }
                break;
              case 2:
                if (project.getStatus() == "Iniciado") {
                  project.setStatus("Em andamento");
                  System.out.println("\nSTATUS DO PROJETO: 'Em andamento'.");
                }
                else System.out.println("\nO PROJETO AINDA NÃO COMEÇOU");
                break;
              case 3:
                if (project.getStatus() == "Em andamento") {
                  for (Atividades activity : project.getActivities()) {
                    if (activity.getDescription() == "") System.out.println("\nO PROJETO DEVE TER AS INFORMAÇÕES BÁSICAS.");
                    else {
                      project.setStatus("Concluido");
                      System.out.println("\nSTATUS DO PROJETO: 'Concluido'.");
                    }
                  }
                }
                else System.out.println("\nPROJETO NAO ESTA EM PROCESSO.");
                break;
            }
          }
          else System.out.println("\nVOCE NAO E UM COORDENADOR DO PROJETO.");
        }
        else System.out.println("\nPROJETO NÃO ENCONTRADO.");
      }
    }
  }

  public void login(Conta account) {
    Scanner input = new Scanner(System.in);

    String firstName, lastName, username, password;
    ArrayList<Usuario> users = new ArrayList<Usuario>();

    Usuario currentUser = null;

    System.out.println("\nINSIRO O USERNAME: ");
    username = input.nextLine();

    System.out.println("INSIRA A SENHA: ");
    password = input.nextLine();

    for (Usuario user : account.getUsers()) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) currentUser = user;
      else if (user.getUsername().equals(username)) {
        int option;
        System.out.println("\n SENHA ERRADA");
        break;

      }
    }
    if (currentUser != null) system(account, currentUser);
    else System.out.println("\nVOCE NAO ESTA REGISTRADO.");
  }



  public void userInformation(Conta account) {
    Scanner input = new Scanner(System.in);

    String username;
    Usuario wantedUser = null;

    System.out.println("\nINSIRA O USERNAME QUE QUER CONSULTAR: ");
    username = input.nextLine();

    for (Usuario user: account.getUsers())
      if (user.getUsername().equals(username)) wantedUser = user;
    
    if (wantedUser != null) System.out.printf("%nINFORMACOES DO USUÁRIO: %s%n", wantedUser);
    else System.out.println("\nUSUÁRIO NAO ENCONTRADO.\n");
  }

  public void infoProjeto(Conta account) {
    Scanner input = new Scanner(System.in);

    String id;
    Projeto wantedProject = null;

    System.out.println("INSIRA O ID DO PROJETO QUE DESEJA CONSULTAR: ");
    id = input.nextLine();

    for (Projeto project : account.getProjects())
      if (project.getId().equals(id)) wantedProject = project;
    
    if (wantedProject != null) System.out.println(wantedProject.getAllInfo());
    else System.out.println("\nPROJETO NAO ENCONTRADO.\n");
  }

  public void infoAtv(Conta account) {
    Scanner input = new Scanner(System.in);

    String id;
    Atividades wantedActivity = null;

    System.out.println("INSIRA O ID DO ATIVIDADE QUE DESEJA CONSULTAR: ");
    id = input.nextLine();

    for (Atividades activity : account.getActivities()) 
      if(activity.getId().equals(id)) wantedActivity = activity;
    
    if (wantedActivity != null) System.out.println(wantedActivity.getAllInfo());
    else System.out.println("\nATIVIDADE NAO ENCONTRADA.\n");
  }

  public void adcNovoUsuario(Conta account) {
    Scanner input = new Scanner(System.in);

    String firstName, lastName, username, password, projectId, activityId;
    ArrayList<Usuario> users = new ArrayList<Usuario>();
    ArrayList<Projeto> projectsEnvolved = new ArrayList<Projeto>();
    ArrayList<Atividades> activitiesEnvolved = new ArrayList<Atividades>();
    Usuario user = null;
    System.out.println("\nINSIRA SEU NOME: ");
    firstName = input.nextLine();
    System.out.println("INSIRA SEU SOBRENOME: ");
    lastName = input.nextLine();

    System.out.println("INSIRA SEU USERNAME: ");
    username = input.nextLine();

    System.out.println("INSIRA SUA SENHA: ");
    password = input.nextLine();

    System.out.println("INSIRA SUA POSIÇAO NA UNIVERDADE: ");
    System.out.println("1 - ESTUDANTE.\n2 - PROFESSOR.\n3 - PESQUISADOR\n4 - PROFISSIONAL: ");
    int optionUserType = input.nextInt();
    input.nextLine();

    switch (optionUserType) {
      case 1:
        String degree = null;
        int degreeOption;
        System.out.println("SELECIONE SUA ESCOLARIDADE:\n1 - GRADUANDO.\n2 - MESTRE.\n3 -  DOUTOR.");
        degreeOption = input.nextInt();
        switch(degreeOption) {
          case 1:
            degree = "GRADUANDO";
            break;
          case 2:
            degree = "MESTRE";
            break;
          case 3:
            degree = "DOUTOR";
            break;
        }
      try {
        	user = new Aluno(firstName, lastName, username, password, degree);
        	System.out.println("\nVOCE FOI REGISTRADOR COM SUCESSO!");
      }
      catch(Exception e) {
    	  System.out.println("\n"+e.getMessage());
      }
        
        break;
      case 2:
        System.out.println("DE QUAL MATERIA? ");
        String subject = input.nextLine();
        user = new Professor(firstName, lastName, username, password, subject);
        break;
      case 3:
        System.out.println("QUAL PESQUISA? ");
        String subjectR = input.nextLine();
        user = new Pesquisador(firstName, lastName, username, password, subjectR);
        break;
      case 4:
        int typeOption;
        String type = null;
        System.out.println("QUE TIPO DE PROFISSIONAL VOCE E?:\n1 - DESENVOLVEDOR.\n2 - TESTADOR.\n3 - ANALISTA.");
        typeOption = input.nextInt();
        switch(typeOption) {
          case 1:
            type = "DESENVOLVEDOR";
            break;
          case 2:
            type = "TESTADOR";
            break;
          case 3:
            type = "ANALISTA";
            break;
        }
      
        user = new Profissional(firstName, lastName, username, password, type);
        System.out.println("\nVOCE FOI REGISTRADOR COM SUCESSO!");
        
        
        
        break;
    }

    users = account.getUsers();
    users.add(user);
    account.setUser(users);

    
  }

  public void editarUsuario(Conta account) {
    Scanner input = new Scanner(System.in);

    String firstName, lastName, username, password, projectId, activityId;
    ArrayList<Usuario> users = new ArrayList<Usuario>();
    ArrayList<Projeto> projectsEnvolved = new ArrayList<Projeto>();
    ArrayList<Atividades> activitiesEnvolved = new ArrayList<Atividades>();

    Usuario currentUser = null;

    System.out.println("INSIRA SEU USERNAME: ");
    username = input.nextLine();

    System.out.println("INSIRA SUA SENHA: ");
    password = input.nextLine();

    for (Usuario user : account.getUsers())
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) currentUser = user;

    if (currentUser != null) {
      System.out.println("\nINSIRA SEU NOME: ");
      firstName = input.nextLine();
      currentUser.setFirstName(firstName);

      System.out.println("INSIRA SEU SOBRENOME: ");
      lastName = input.nextLine();
      currentUser.setLastName(lastName);

      System.out.println("INSIRA SEU USUARIO: ");
      username = input.nextLine();
      currentUser.setUsername(username);

      System.out.println("INSIRA SUA SENHA: ");
      password = input.nextLine();
      currentUser.setPassword(password);

      System.out.println("INSIRA QUAIS PROJETOS ESTA ENVOLVIDO: ");
      int option = 12;
      while(option!=0) {
        System.out.println("1 - ADICIONAR PROJETO.");
        System.out.println("0 - SAIR.");
        option = input.nextInt();
        input.nextLine();

        switch(option) {
          case 0:
            break;
          case 1:
            System.out.println("ID DO PROJETO: ");
            projectId = input.nextLine();
            Projeto project = findProject(projectId, account);
            if (project != null) {
              projectsEnvolved.add(project);
              System.out.println("\nPROJETO ADICIONADO COM SUCESSO.\n");
            }
            else System.out.println("\nID NAO ENCONTRADOR, DIGITE NOVAMENTE.\n");
            break;
        }
      }
      currentUser.setProjectsEnvolved(projectsEnvolved);

      System.out.println("INSIRA QUAIS ATIVIDADES ESTA ENVOLVIDO: ");
      int option2 = 12;
      while(option2!=0) {
        System.out.println("1 -ADICIONAR UMA ATIVIDADES.");
        System.out.println("0 - SAIR.");
        option2 = input.nextInt();
        input.nextLine();

        switch(option2) {
          case 0:
            break;
          case 1:
            System.out.println("ID DA ATIVIDADE: ");
            activityId = input.nextLine();
            Atividades activity = findActivity(activityId, account);
            if (activity != null) {
              activitiesEnvolved.add(activity);
              System.out.println("\nATIVIDADE ADICIONADA COM SUCESSO\n");
            }
            else System.out.println("\nID NAO ENCONTRADO, DIGITE NOVAMENTE.\n");
            break;
        }
      }
      currentUser.setActivitiesEnvolved(activitiesEnvolved);

      System.out.println("\nSUA CONTA FOI EDITADA COM SUCESSO!");
    }

    else System.out.println("\nALGO DEU ERRADO, TENTE NOVAMENTE.");
  }

  public void adcNovaAtv(Conta account) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, leader, instructions, username;
    ArrayList<Usuario> members = new ArrayList<Usuario>();
    ArrayList<Atividades> activities = new ArrayList<Atividades>();

    System.out.println("\nINSIRA O ID DA ATIVIDADE: ");
    id = input.nextLine();

    System.out.println("INSIRA A DESCRICAO DA ATIVIDADE: ");
    description = input.nextLine();

    System.out.println("INSIRA A DATA DE INICIO DA ATIVIDADE: ");
    startAt = input.nextLine();

    System.out.println("INSIRA A DATA DE TERMINO DA ATIVIDADE: ");
    endAt = input.nextLine();

    System.out.println("INSIRA O RESPONSAVEL PELA ATIVIDADE: ");
    leader = input.nextLine();

    System.out.println("INSIRA OS USERNAMES PARA ADICIONAR OS MEMBROS: ");
    int option = 12;
    while(option!=0) {
      System.out.println("1 - ADICIONA UM USERNAME.");
      System.out.println("0 - SAIR.");
      option = input.nextInt();
      input.nextLine();

      switch(option) {
        case 0:
          break;
        case 1:
          System.out.println("USERNAME: ");
          username = input.nextLine();
          Usuario user = findUser(username, account);
          if (user != null) {
            members.add(user);
            System.out.println("USUARIO ADICIONADO COM SUCESSO.");
          }
          else System.out.println("\nUSERNAME NAO ENCONTRADO, TENTE NOVAMENTE.\n");
          break;
      }
    }

    System.out.println("INSIRA AS INSTRUCOES: ");
    instructions = input.nextLine();

    Atividades activity = new Atividades(id, description, startAt, endAt, leader, members, instructions);

    activities = account.getActivities();
    activities.add(activity);
    account.setActivities(activities);

    System.out.printf("%nATIVIDADE CRIADA COM SUCESSO!%n");
  }

  public void editarAtv(Conta account) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, leader, instructions, username;
    ArrayList<Usuario> members = new ArrayList<Usuario>();

    System.out.println("\nINSIRA O ID DA ATIVIDADE QUE QUER EDITAR: ");
    id = input.nextLine();

    Atividades currentActivity = null;

    for (Atividades activity : account.getActivities()) {
      if (activity.getId().equals(id)) {
        currentActivity = activity;
      }
    }

    System.out.println("INSIRA UM ID PARA A ATIVIDADE: ");
    id = input.nextLine();
    currentActivity.setId(id);

    System.out.println("INSIRA UMA DESCRICAO DA ATIVIDADE: ");
    description = input.nextLine();
    currentActivity.setDescription(description);

    System.out.println("INSIRA A DATA DE INICIO DA ATIVIDADE: ");
    startAt = input.nextLine();
    currentActivity.setStartAt(startAt);

    System.out.println("INSIRA A DATA DE TERMINO DA ATIVIDADE: ");
    endAt = input.nextLine();
    currentActivity.setEndAt(endAt);

    System.out.println("INSIRA O RESPONSAVEL PELA ATIVIDADE: ");
    leader = input.nextLine();
    currentActivity.setLeader(leader);

    System.out.println("INSIRA O USERNAME DOS MEMBROS: ");
    int option = 12;
    while(option!=0) {
      System.out.println("1 - ADICIONAR UM USERNAME.");
      System.out.println("0 - SAIR.");
      option = input.nextInt();
      input.nextLine();

      switch(option) {
        case 0:
          break;
        case 1:
          System.out.println("USERNAME: ");
          username = input.nextLine();
          Usuario user = findUser(username, account);
          if (user != null) {
            members.add(user);
            System.out.println("USUARIO ADICIONADO COM SUCESSO.");
          }
          else System.out.println("\nUSERNAME NAO ENCONTRADO, TENTE NOVAMENTE.\n");
          break;
      }
    }
    currentActivity.setMembers(members);

    System.out.println("INSIRA AS INSTRUCOES: ");
    instructions = input.nextLine();
    currentActivity.setInstructions(instructions);

    System.out.printf("\nO PROJETO COM ID %s FOI EDITADO COM SUCESSO.", id);
  }

  public void adcNovoProjeto(Conta account) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, coordinatorUsername, duringAt, username, activityId;
    Usuario coordinator = null;
    double schoolarAmount;
    ArrayList<Usuario> members = new ArrayList<Usuario>();
    ArrayList<Projeto> projects = new ArrayList<Projeto>();
    ArrayList<Atividades> activities = new ArrayList<Atividades>();

    System.out.println("\nINSIRA UM ID PARA O PROJETO: ");
    id = input.nextLine();

    System.out.println("INSIRA A DESCRICAO DO PROJETO: ");
    description = input.nextLine();

    System.out.println("INSIRA A DATA DE INICIO DO PROJETO: ");
    startAt = input.nextLine();

    System.out.println("INSIRA A DATA DE TERMINO DO PROJETO: ");
    endAt = input.nextLine();

    System.out.println("INSIRA O USERNAME DO COORDENADOR DO PROJETO: ");
    coordinatorUsername = input.nextLine();
    for (Usuario user : account.getUsers()) {
      if (user.getUsername().equals(coordinatorUsername)) {
        coordinator = user;
        if (user instanceof Professor | user instanceof Pesquisador) coordinator = user;
        else System.out.println("ESSE USUARIO NAO PODE SER COORDENADOR DO PROJETO.");
      }
    }

    if (coordinator == null) System.out.println("USERNAME NAO ENCONTRADO.");

    System.out.println("INSIRA USERNAMES PARA ADICIONAR MEMBROS: ");
    int option = 12;
    while(option!=0) {
      System.out.println("1 - ADICIONAR UM USERNAME.");
      System.out.println("0 - SAIR.");
      option = input.nextInt();
      input.nextLine();

      switch(option) {
        case 0:
          break;
        case 1:
          System.out.println("USERNAME: ");
          username = input.nextLine();
          Usuario user = findUser(username, account);
          if (user != null) {
            members.add(user);
            System.out.println("USERNAME ADICIONADO COM SUCESSO.");
          }
          else System.out.println("\nUSERNAME NAO ENCONTRADO, TENTE NOVAMENTE.\n");
          break;
      }
    }

    System.out.println("INSIRA OS IDs PARA ADICIONAR ATIVIDADES: ");
    int option2 = 12;
    while(option2!=0) {
      System.out.println("1 - ADCIONAR UMA ATIVIDADE.");
      System.out.println("0 - SAIR.");
      option2 = input.nextInt();
      input.nextLine();

      switch(option2) {
        case 0:
          break;
        case 1:
          System.out.println("ID DA ATIVIDADE: ");
          activityId = input.nextLine();
          Atividades activity = findActivity(activityId, account);
          if (activity != null) {
            activities.add(activity);
            System.out.println("ATIVIDADE ADICIONADA COM SUCESSO.");
          }
          else System.out.println("\nATIVIDADE NAO ENCONTRADA, TENTE NOVAMENTE.\n");
          break;
      }
    }

    System.out.println("INISRA O VALOR DA BOLSA: ");
    schoolarAmount = input.nextDouble();
    input.nextLine();

    System.out.println("INSIRA A DURACAO DO PROJETO: ");
    duringAt = input.nextLine();

    Projeto project = new Projeto(id, description, startAt, endAt, coordinator, members, activities, schoolarAmount, duringAt);

    projects = account.getProjects();
    projects.add(project);
    account.setProject(projects);
    
    System.out.printf("%nPROJETO CRIADO COM SUCESSO!%n");
  }

  public Projeto findProject(String projectId, Conta account) {
    for (Projeto project : account.getProjects())
      if (project.getId().equals(projectId)) return project;
    return null;
  }

  public Usuario findUser(String username, Conta account) {
    for (Usuario user : account.getUsers()) 
      if (user.getUsername().equals(username)) return user;
    return null;
  }

  public Atividades findActivity(String activityId, Conta account) {
    for (Atividades activity : account.getActivities())
      if (activity.getId().equals(activityId)) return activity;
    return null;
  }

  public void editarProjeto(Conta account) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, coordinatorUsername, duringAt, username, activityId;
    Usuario coordinator = null;
    double schoolarAmount;
    ArrayList<Usuario> members = new ArrayList<Usuario>();
    ArrayList<Atividades> activities = new ArrayList<Atividades>();

    System.out.println("INSIRA O ID DO PROJETO QUE DESEJA EDITAR: ");
    id = input.nextLine();

    Projeto currentProject = null;

    for (Projeto project : account.getProjects()) {
      if (project.getId().equals(id)) {
        currentProject = project;
      }
    }

    System.out.println("INSIRA UM ID PARA O PROJETO: ");
    id = input.nextLine();
    currentProject.setId(id);

    System.out.println("INSIRA UMA DESCRICAO DO PROJETO: ");
    description = input.nextLine();
    currentProject.setDescription(description);

    System.out.println("INSIRA A DATA DE INICIO DO PROJETO: ");
    startAt = input.nextLine();
    currentProject.setStartAt(startAt);

    System.out.println("INSIRA A DATA DE TERMINO DO PROJETO: ");
    endAt = input.nextLine();
    currentProject.setEndAt(endAt);

    System.out.println("INSIRA O USERNAME DO CORDENADOR DO PROJETO: ");
    coordinatorUsername = input.nextLine();
    for (Usuario user : account.getUsers()) {
      if (user.getUsername().equals(coordinatorUsername)) {
        coordinator = user;
        if (user instanceof Professor | user instanceof Pesquisador) coordinator = user;
        else System.out.println("ESSE USUARIO NAO PODE SER COORDENADOR DO PROJETO.");
      }
    }

    if (coordinator == null) System.out.println("Username not found.");
    currentProject.setCoordinator(coordinator);

    System.out.println("INSIRA UM USERNAME PARA ADICIONAR AO PROJETO: ");
    int option = 12;
    while(option!=0) {
      System.out.println("1 - ADIONAR UM USERNAME.");
      System.out.println("0 - SAIR.");
      option = input.nextInt();
      input.nextLine();

      switch(option) {
        case 0:
          break;
        case 1:
          System.out.println("Username: ");
          username = input.nextLine();
          Usuario user = findUser(username, account);
          if (user != null) {
            members.add(user);
            System.out.println("USUARIO ADICIONADO COM SUCESSO.");
          }
          else System.out.println("\nUSUARIO NAO ENCONTRADOR, TENTE NOVAMENTE.\n");
          break;
      }
    }
    currentProject.setMembers(members);

    System.out.println("Enter the Id's to add activities: ");
    int option2 = 12;
    while(option2!=0) {
      System.out.println("1 - Add an activity.");
      System.out.println("0 - Exit.");
      option2 = input.nextInt();
      input.nextLine();

      switch(option2) {
        case 0:
          break;
        case 1:
          System.out.println("INISRA O ID DA ATIVIDADE: ");
          activityId = input.nextLine();
          Atividades activity = findActivity(activityId, account);
          if (activity != null) {
            activities.add(activity);
            System.out.println("ATIVIDADE ADICIONADA COM SUCESSO.");
          }
          else System.out.println("\nATIVIDADE NAO ENCONTRADA, TENTE NOVAMENTE.\n");
          break;
      }
    }
    currentProject.setActivities(activities);

    System.out.println("INSIRA O VALOR DA BOLSA: ");
    schoolarAmount = input.nextDouble();
    input.nextLine();
    currentProject.setSchoolarAmount(schoolarAmount);

    System.out.println("INSIRA A DURACAO DO PROJETO: ");
    duringAt = input.nextLine();
    currentProject.setDuringAt(duringAt);

    System.out.printf("\nPROJETO COM ID %s FOI EDITADOR COM SUCESSO.\n", id);

  }
}
