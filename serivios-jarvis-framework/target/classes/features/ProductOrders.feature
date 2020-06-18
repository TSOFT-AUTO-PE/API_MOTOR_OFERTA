Feature: Product Orders

  @ProductOrders
 Scenario Outline: Servicio de generacion de token y product orders
    Given Se genera el token que es entrada de product orders
    Then Se llama el servicio de product orders
    Examples:
      | caso_prueba |
      |           1 |

