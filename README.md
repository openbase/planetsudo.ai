# Planet Sudo

## Installation via Netbeans IDE

- Java/Netbeans Bundle installieren (Jeweils passende Version 32/64 Bit)
- Im Netbeans Menü auf Projekt öffnen klicken (File->OpenProject) und den PlanetSudoAI Ordner als Projekt laden.
- Anschließend die settings.xml in den .m2 Ordner im Benutzerverzeichniss Kopieren. Settings.xml -> C:\Dokumente und Einstellungen/%USERNAME%/.m2
- Jetzt kann PlanetSudo in Netbeans gestartet werden. (Hierzu auf den Playbutton drücken)
- Um eine bessere Unterstützung bei der KI-Entwickelung zu erhalten, in der Project Ansicht einen rechten Mausklick auf "Dependencies" ausführen und anschließen auf "Download Javadoc" klicken.

## Anlegen einer neuen KI

- Im PlanetSudoAI Projekt in der "Projects" Ansicht das Package org.openbase.planetsudo.game.strategy öffnen und hier die Java Klasse "DefaultStategy.java" umbenennen (Refactor->Rename).
- Die neue Stategieklasse kann nun nach belieben erweitert werden.
- Informationen über mögliche Funktionalitäten könnt ihr über die Methoden Dokumentation (JavaDoc) herausfinden.
-- z.B ihr schreibt "agent." und drückt dann (Strg + Leertaste).

# Anlegen eines neuen Teams

- Sofern ihr zuvor eine neue Strategieklasse angelegt habt, bitte zunächst das Projekt kompilieren. 
-- Hierzu einen rechten Mausklick auf das Projekt machen und anschließend im Menü "Clean and Build" auswählen. 
- Anschließend in PlanetSudo unter Einstellungen auf "Team erstellen" klicken.
- Wichtig ist hierbei, dass eine gültige Strategie angegeben wird. Hier erfolgt die Eingabe des Namens der Javaklasse die die entsprechende Strategie enthält. Der Sufix ".java" wird hierbei nicht angegeben.

# Mit dem Server synchronisieren

- Zunächst muss das eigene Team definiert werden. Hierzu in dem DropDown Menü (Mein Team) ein Team auswählen und anschließend bestätigen.
- Nun kann über den Synchronisations-Button die Synchronisation erfolgen sofern der Server gestartet ist.
- Ist das Statusfeld Blau, ist der Transfer erfolgreich gewesen.

# Sonstiges

- Viel Spaß beim Spielen und Entwickeln :)
- Sollten euch gravierende Fehler auffallen oder anderweitige Probleme auftreten:
-- Erstellt ein Issue auf Github (https://github.com/openbase/planetsudo/issues/new)
-- Kontaktiert uns per mail: support@openbase.org


======================================
Copyright (C) 2009 - 2016 openbase.org