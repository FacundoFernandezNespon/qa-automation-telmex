#language: es
@InicioSesion
Característica: Inicio sesion exitoso

  @InicioSesionCRM
  Escenario: Inicio sesion exitoso en CRM
    Cuando el usuario inicia sesión como "PAM" en CRM
    Entonces el usuario accede a CRM

  @InicioSesionCOmunidad
  Escenario: Inicio sesion exitoso en la Comunidad Telmex
    Cuando el usuario inicia sesión como "PAM" en Comunidad
    Entonces el usuario accede a Comunidad