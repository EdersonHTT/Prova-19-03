/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciador.ordens;

import com.mycompany.gerenciador.ordens.dao.UserDao;
import com.mycompany.gerenciador.ordens.model.User;

/**
 *
 * @author EDERSONDASILVASCHMID
 */
public class GerenciadorOrdens {

    public static void main(String[] args) {
//        -> Cria Usuario
        
        User user1 = new User(5, "05194255020", "Ederson", "eder@gmail", "123", "T");
        
//        UserDao.create(user1);

//        -> Deletar Usuario

//        UserDao.delete(3);
        
//        -> Atualiza usuario

//        UserDao.update(user1);

//        -> Procura usuario

          User user = UserDao.serch(user1.getEmail());
          
          System.out.println("Nome: " + user.getName_user());
        
    }
}
