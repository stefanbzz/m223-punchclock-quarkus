# M223 Punchclock

​# Kurze Projektbeschreibung

Ein Mitarbeiter einer Ladenkette hat die Möglichkeit, seine Arbeitszeiten zu erfassen (wie bei alten Lochkarten). Die Einträge können von den Mitarbeitern erstellt, aktualisiert und gelöscht werden. Um die Einträge besser zu organisieren, können bestimmte Kategorien hinzugefügt werden. Der Administrator wählt das Geschlecht aus. Ein Mitarbeiter muss sich mit einem Benutzernamen und einem Passwort in sein persönliches Konto einloggen (authentifiziert durch ein JWT-Token). Diese Benutzerkonten werden vom Administrator erstellt.

# Konfiguration

Folgende Schritte sind notwendig um die Applikation zu erstellen und zu starten: 
1. Stellen Sie sicher, dass OpenJDK 11 oder höher installiert und JAVA_HOME korrekt gesetzt ist.  
2. Installieren Sie (falls noch nicht vorhanden) Apache Maven 3.8.1 oder höher
3. Wechseln Sie auf der Kommandozeile in den Ordner dieser Applikation. 
`cd m223-punchclock-quarkus/`
4. Starten Sie die Applikation mit 
```shell script
./mvnw compile quarkus:dev
```

Folgende Dienste stehen während der Ausführung im Profil dev zur Verfügung:

Swagger API: http://localhost:8080/q/swagger-ui/

H2 Console: http://localhost:8080/h2/ 
Datenquelle: jdbc:h2:mem:punchclock
Benutzername: zli
Passwort: zli

