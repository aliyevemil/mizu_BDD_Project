@sign
Feature: Mizu web alisveris sitesine giris yapmak
  Background: BU senaryolarda kullanicinin ana sayfada olmasi beklenir.
    Given Kullanici Web uygulamasinin ana sayfasini acmalidir.
  @login
  Scenario: Mail ve sifresini girerek kullanicinin sayfasina giris yapmasi
    When Kullanici web sayfadaki cerez uyarisini kapatmalidir.
    When Kullanici Email alanina gecerli bir email girmelidir.
    And Password alanına gecerli bir password girmelidir.
    And Sign in düğmesine tiklamalidir.
    Then Web sayfasina giren kullanici profilini ekranda gormelidir.

    @wronglogin
    Scenario: Kullanici mail adresini yanlis yazmasi sonucu uygulamanin tepkisi
      When Kullanici Email alanina gecersiz bir email girmelidir.
      And Kullanici passsword alanina gecerli bir password girmelidir.
      And Sign in butonuna tiklamalidir.
      Then Web sayfasina giren kullanici uyari mesaji ile karsilasmalidir.



