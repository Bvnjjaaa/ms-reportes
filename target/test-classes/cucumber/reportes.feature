# language: es
Característica: Servicio Reportes y Cumplimiento (microservicio reportes del caso caso04)
  Los escenarios validan el contrato REST del microservicio alineado a sus endpoints.

  Escenario: el listado del recurso responde 200
    Dado el servicio "Reportes y Cumplimiento" está disponible
    Cuando consulto el listado de "reportes"
    Entonces el listado responde con código 200

  Escenario: ciclo de vida completo del recurso
    Dado un nuevo "reporte" con nombre "hola-cucumber"
    Cuando consulto el "reporte" recién creado
    Entonces el recurso tiene nombre "hola-cucumber" y código 200
    Cuando actualizo el "reporte" con nombre "cucumber-actualizado"
    Entonces el recurso queda con nombre "cucumber-actualizado" y código 200
    Cuando elimino el "reporte"
    Entonces la eliminación responde con código 204
    Y al consultar el "reporte" eliminado responde 404
