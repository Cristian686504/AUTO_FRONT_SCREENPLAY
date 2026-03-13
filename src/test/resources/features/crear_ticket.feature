@ticket @e2e
Feature: Creacion de un ticket de soporte
  Como usuario autenticado del sistema
  Quiero crear un ticket de soporte
  Para que el sistema lo registre y se muestre en la lista de tickets

  Background:
    Given que el usuario navega a la pagina de login

  @happy_path
  Scenario Outline: Crear un ticket exitosamente con usuario administrador
    When el usuario inicia sesion con correo "<correo>" y contrasena "<contrasena>"
    Then el usuario es redirigido a la lista de tickets
    When el usuario navega al formulario de creacion de ticket
    And el usuario completa el titulo con "<titulo>"
    And el usuario completa la descripcion con "<descripcion>"
    And el usuario envia el formulario de ticket
    Then el usuario es redirigido a la lista de tickets
    And el ticket "<titulo>" se muestra en la lista de tickets

    Examples:
      | correo           | contrasena         | titulo                        | descripcion                                                                                                                                  |
      | admin@sofkau.com | Admin@SofkaU_2026! | Ticket de prueba automatizada | Este ticket fue creado de forma automatizada mediante Selenium con Screenplay para validar el flujo E2E de creacion de tickets. |
