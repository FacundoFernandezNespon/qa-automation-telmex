#language: es
@Monitoreo_Infinitum

Característica: Cotizacion exitosa del producto Monitoreo Infinitum

  Esquema del escenario: Flujo completo y verificación de PDF para el producto Monitoreo Infinitum
    Cuando que el usuario "PAM" ha iniciado sesión
    Y el usuario ingresa a la comunidad con Cuenta de nivel "<nivel>"
    Y el usuario selecciona una oportunidad
    Y el usuario crea una nueva cotizacion con producto "MONITOREO_INFINITUM" y subproducto "Monitoreo y gestión Infinitum"
    Y el usuario verifica precios en la pantalla de resumen
    Y el usuario verifica que se ha creado el PDF

    @Oro
    Ejemplos:
      | nivel |
      | Oro   |

    @Platino
    Ejemplos:
      | nivel   |
      | Platino |

    @Plata
    Ejemplos:
      | nivel |
      | Plata |
