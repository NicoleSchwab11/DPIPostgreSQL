package com.dpi.primeraapi.repository;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dpi.primeraapi.model.Registro;

@Repository
public class RegistroRepository {

    private final JdbcTemplate jdbcTemplate;

    public RegistroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Insertar usuario
    public int guardarUsuario(String dni, String nombre, String apellido, String telefono) {
        String sql = "INSERT INTO Usuarios (dni, nombre, apellido, telefono) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, dni, nombre, apellido, telefono);
    }

    // Listar todos
    public List<Registro> obtenerUsuarios() {
        String sql = "SELECT * FROM Usuarios";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Registro u = new Registro();
            u.setId_user(rs.getInt("id_user"));
            u.setDni(rs.getString("dni"));
            u.setNombre(rs.getString("nombre"));
            u.setApellido(rs.getString("apellido"));
            u.setTelefono(rs.getString("telefono"));
            u.setRol(rs.getString("rol"));
            u.setEstado(rs.getBoolean("estado"));
            return u;
        });
    }
}
