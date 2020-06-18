Feature: Servicio Extraer telefono

  @Servicio
  Scenario Outline: Servicio de extracion de numero telefonico
    Given Se obtine el numero telefonico que es entrada de servicio
    Then Se llama el servicio
    Examples:
      | caso_prueba |
      |           1 |
