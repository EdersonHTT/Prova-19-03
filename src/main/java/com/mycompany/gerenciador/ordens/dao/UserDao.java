/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.ordens.dao;

import com.mycompany.gerenciador.ordens.data.GConnection;
import com.mycompany.gerenciador.ordens.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author EDERSONDASILVASCHMID
 */
public class UserDao {
    
    public static void create(User user) {
        String sql = "INSERT INTO usuario (cpf, name_user, email, password_user, profile_user) VALUES (?,?,?,?,?);";
        
        String password = BCrypt.hashpw(user.getPassword_user(), BCrypt.gensalt());
        
        try(Connection con = GConnection.getConnection();
                PreparedStatement psmt = con.prepareStatement(sql)) {
            psmt.setString(1, user.getCpf());           
            psmt.setString(2, user.getName_user());
            psmt.setString(3, user.getEmail());
            psmt.setString(4, password);
            psmt.setString(5, user.getProfile_user());

            psmt.executeUpdate();
            System.out.println("Usuario criador com sucesso");
        } catch(SQLException e) {
            System.out.println("Erro ao criar usuario: " + e.getMessage());
        }
    }
    
    public static void delete(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?;";
        
        try(Connection con = GConnection.getConnection();
                PreparedStatement psmt = con.prepareStatement(sql)) {
            psmt.setInt(1, id);           

            psmt.executeUpdate();
            System.out.println("Usuario deletado com sucesso");
        } catch(SQLException e) {
            System.out.println("Erro ao deletar usuario: " + e.getMessage());
        }
    }
    
    public static void update(User user) {
        String sql = "UPDATE usuario SET cpf = ?, name_user = ?, email = ?, password_user = ?, profile_user = ? WHERE id = ?;";
        
        String password = BCrypt.hashpw(user.getPassword_user(), BCrypt.gensalt());
        
        try(Connection con = GConnection.getConnection();
                PreparedStatement psmt = con.prepareStatement(sql)) {
            psmt.setString(1, user.getCpf());           
            psmt.setString(2, user.getName_user());
            psmt.setString(3, user.getEmail());
            psmt.setString(4, password);
            psmt.setString(5, user.getProfile_user());            
            psmt.setInt(6, user.getId());

            psmt.executeUpdate();
            System.out.println("Usuario atualizado com sucesso");
        } catch(SQLException e) {
            System.out.println("Erro ao atualizar usuario: " + e.getMessage());
        }
    }
    
    public static User serch(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        
        try(Connection con = GConnection.getConnection();
                PreparedStatement psmt = con.prepareStatement(sql)) {
            psmt.setString(1, email);

            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setCpf(rs.getString("cpf"));
                user.setName_user(rs.getString("name_user"));
                user.setEmail(rs.getString("email"));
                user.setPassword_user(rs.getString("password_user"));
                user.setProfile_user(rs.getString("profile_user"));
                return user;
            }
            
            System.out.println("Usuario procurado com sucesso");
        } catch(SQLException e) {
            System.out.println("Erro ao procurar usuario: " + e.getMessage());
        }
        return null;
    }
}
