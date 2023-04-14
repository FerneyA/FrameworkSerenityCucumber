Feature: Login to Facebook

  Scenario Outline: Login to facebook with wrong credentials
    Given User enters Facebook page
    When User types the username: "<username>" and password: "<password>"
    Then User should see the message: "<message>"

    Examples:
      | username                | password | message                                                                       |
      | faq.sau@gmail.com       | 1234567  | La contraseña que has introducido es incorrecta. ¿Has olvidado la contraseña? |
      | vidalarroyave@gmail.com | 01478520 | El correo electrónico que has introducido no está conectado a una cuenta.     |