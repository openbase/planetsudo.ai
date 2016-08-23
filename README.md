/*
 * Copyright (C) 2013 Openbase
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

# Installation von PlanetSudo
===========================
- Java/Netbeans Bundle installieren (Jeweils passende Version 32/64 Bit)
- Im Netbeans Menü auf Projekt offnen klicken (File->OpenProject) und den PlanetSudoAI Ordner als Projekt laden.
- Fehlermeldung Ignorieren
- Anschließend die Settings.xml in den .m2 Ordner im Benutzerverzeichniss Kopieren. Settings.xml -> C:\Dokumente und Einstellungen/%USERNAME%/.m2
- Jetzt kann PlanetSudo in Netbeans gestartet werden. (Hierzu auf den Playbutton drücken)
- Um eine bessere Unterstützung bei der KI-Entwickelung zu erhalten, in der Project Ansicht einen rechten Mausklick auf "Dependencies" ausführen und anschließen auf "Download Javadoc" klicken.


# Anlegen einer neuen KI
======================
- Im PlanetSudoAI Projekt in der "Projects" Ansicht das Package de.dc.planetsudo.game.strategy öffnen und hier die Java Klasse "DefaultStategy.java" umbenennen (Refactor->Rename).
- Die neue Stategieklasse kann nun nach belieben erweitert werden.


# Anlegen eines neuen Teams
=========================
- Hierzu in PlanetSudo unter Einstellungen auf "Team erstellen" klicken.
- Wichtig ist hierbei, das eine gültige Strategie angegeben wird. Hier erfolgt die Eingabe des Namens der Javaklasse die die entsprechende Strategie enthält. Der Sufix ".java" wird hierbei nicht angegeben.


# Mit dem Server synchronisieren
==============================
- Zunächst muss das eigene Team definiert werden. Hierzu in dem DropDown Menü (Mein Team) ein Team auswählen und anschließend bestätigen.
- Nun kann über den Synchronisations-Button die Synchronisation erfolgen sofern der Server gestartet ist.
- Ist das Statusfeld Blau, ist der Transfer erfolgreich gewesen.


# Sonstiges
=========
- Viel Spaß beim Spielen und Entwickeln :)
- Sollten euch gravierende Fehler auffallen oder anderweitige Probleme auftreten, wendet euch bitte an die folgende eMailadresse: DivineThreppwood@gmail.com



