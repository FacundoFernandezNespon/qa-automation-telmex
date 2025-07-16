#language: es
@Respaldo_Informacion

Característica: Cotizacion exitosa del producto Respaldo de Informacion

  Esquema del escenario: Flujo completo y verificación de PDF para el producto Respaldo de Informacion y subproducto Profesional 15GB
    Cuando que el usuario "PAM" ha iniciado sesión
    Y el usuario ingresa a la comunidad con Cuenta de nivel "<nivel>"
    Y el usuario selecciona una oportunidad
    Y el usuario crea una nueva cotizacion con producto "RESPALDO_INFORMACION" y subproducto "<subproducto>"
    Y el usuario verifica precios en la pantalla de resumen
    Y el usuario verifica que se ha creado el PDF

    @15GB
    Ejemplos:
      | nivel   | subproducto                     |
      | Platino | Profesional (Respaldo de 15 GB) |
      | Oro     | Profesional (Respaldo de 15 GB) |
      | Plata   | Profesional (Respaldo de 15 GB) |

    @75GB
    Ejemplos:
      | nivel   | subproducto                  |
      | Platino | Avanzado (Respaldo de 75 GB) |
      | Oro     | Avanzado (Respaldo de 75 GB) |
      | Plata   | Avanzado (Respaldo de 75 GB) |

    @150GB
    Ejemplos:
      | nivel   | subproducto               |
      | Platino | Plus (Respaldo de 150 GB) |
      | Oro     | Plus (Respaldo de 150 GB) |
      | Plata   | Plus (Respaldo de 150 GB) |

    @375GB
    Ejemplos:
      | nivel   | subproducto                  |
      | Platino | Premium (Respaldo de 375 GB) |
      | Oro     | Premium (Respaldo de 375 GB) |
      | Plata   | Premium (Respaldo de 375 GB) |

    @750GB
    Ejemplos:
      | nivel   | subproducto                      |
      | Platino | Empresarial (Respaldo de 750 GB) |
      | Oro     | Empresarial (Respaldo de 750 GB) |
      | Plata   | Empresarial (Respaldo de 750 GB) |

    @1500GB
    Ejemplos:
      | nivel   | subproducto                       |
      | Platino | Corporativo (Respaldo de 1500 GB) |
      | Oro     | Corporativo (Respaldo de 1500 GB) |
      | Plata   | Corporativo (Respaldo de 1500 GB) |


