import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CrudOperations crud = new CrudOperations(); 

        try {

            List<User> allUsers = crud.getAllUsers("clients"); // Listando todos os usuários da tabela "clients"
            for (User user : allUsers) {
                System.out.println("ID de usuário: " + user.getId() + ", Nome: " + user.getName());
            }

            
            User userById = crud.getUserById("clients", 1);  // Listando usuário de id 1 da tabela "clients"
            System.out.println("ID de usuário: " + userById.getId() + ", Nome: " + userById.getName());
            
            
            crud.deleteUserById("clients", 2); // Deletando usuário de id 2 da tabela "clients"
            
            User userToUpdate = crud.getUserById("clients", 99); // Listando usuário de id 99 da tabela "clients"
            userToUpdate.setName("Dafran"); // Setando novo "name" para a instância de User
            crud.updateUserById("clients", userToUpdate); // Atualizando o usuário com o novo nome

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
