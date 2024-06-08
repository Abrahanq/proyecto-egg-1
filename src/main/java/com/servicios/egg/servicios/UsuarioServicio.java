package com.servicios.egg.servicios;

import com.servicios.egg.entidades.Usuario;
import com.servicios.egg.enums.Rol;
import com.servicios.egg.excepciones.MyException;
import com.servicios.egg.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
   @Autowired
   private UsuarioRepositorio usuarioRepositorio;

   @Transactional
   public void registrarUsuario(String nombre, String email, String password, String password2, String phone) throws MyException {
      Usuario usuario = new Usuario();

      usuario.setNombre(nombre);
      usuario.setEmail(email);
      usuario.setPassword(password);
      usuario.setRol(Rol.USER);
      usuario.setPhone(phone);
      usuario.setAlta(true);

      usuarioRepositorio.save(usuario);
   }

   @Transactional
   public void actualizarUsuario(Long id, String nombre, String email, String password, String password2, String phone) throws MyException {

      Optional<Usuario> respuestaUsuario = usuarioRepositorio.findById(id);

      if (respuestaUsuario.isPresent()){
         Usuario usuario = respuestaUsuario.get();
         usuario.setNombre(nombre);
         usuario.setEmail(email);
         usuario.setPassword(password);
         usuario.setPhone(phone);

         usuarioRepositorio.save(usuario);
      }
   }

   @Transactional(readOnly = true)
   public List<Usuario> listarUsuarios(){

      List<Usuario> usuariosList = new ArrayList<>();
      usuariosList = usuarioRepositorio.findAll();

      return usuariosList;
   }

   @Transactional
   public  void cambiarRolUsuario(Long id, Rol rol){
      Optional<Usuario> respuestaUsuario = usuarioRepositorio.findById(id);

      if(respuestaUsuario.isPresent()){
         Usuario usuario = respuestaUsuario.get();
         usuario.setRol(rol);
      }
   }

   private void validar(String nombre, String email, String password, String password2) throws MyException {

      if (nombre.isEmpty() || nombre == null) {
         throw new MyException("el nombre no puede ser nulo o estar vacío");
      }
      if (email.isEmpty() || email == null) {
         throw new MyException("el email no puede ser nulo o estar vacío");
      }
      if (password.isEmpty() || password == null || password.length() <= 5) {
         throw new MyException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
      }
      if (!password.equals(password2)) {
         throw new MyException("Las contraseñas ingresadas deben ser iguales");
      }

   }
}