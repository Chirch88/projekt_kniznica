# 📚 Knižnica 

## 1. Účel projektu
Cieľom projektu je vytvoriť jednoduchú konzolovú aplikáciu na správu knižnice v jazyku **Java**.  
Program umožňuje pracovať s inventárom kníh, evidovať ich vypožičanie a zobrazovať rôzne prehľady pomocou textového menu.


---

## 2. Použité technológie a nástroje
- programovací jazyk **Java**
- vývojové prostredie **IntelliJ IDEA**
- verzovací systém **Git**
- repozitár **GitHub**
- konzolové (textové) používateľské rozhranie

---

## 3. Štruktúra projektu
Projekt je rozdelený do viacerých tried, pričom každá trieda má jasne definovanú zodpovednosť.

```
src/
 ├── Kniznica01.Main.java        (vstupný bod programu)
 ├── Kniznica01.Kniznica.java   (hlavná logika aplikácie a menu)
 ├── Kniznica01.Inventar.java   (správa kolekcie kníh)
 └── Kniznica01.Kniha.java      (reprezentácia jednej knihy)
```

---

## 4. Spustenie programu
Program sa spúšťa spustením triedy **Kniznica01.Main.java**.

Postup v IntelliJ IDEA:
1. Otvoriť súbor `Kniznica01.Main.java`
2. Kliknúť na tlačidlo **Run**
3. Program sa spustí v konzole

Po spustení sa automaticky načítajú testovacie dáta a zobrazí sa hlavné menu programu.

---

## 5. Ovládanie programu
Používateľ ovláda aplikáciu pomocou **číselného menu** v konzole.  
Jednotlivé voľby menu umožňujú vykonávať operácie s knihami, ako napríklad ich pridanie, vyradenie alebo vypožičanie.

---

## 6. Funkcionalita aplikácie
Aplikácia umožňuje:
- pridať novú knihu do inventára
- vyradiť knihu z inventára
- požičať knihu na zadaný počet dní
- vrátiť požičanú knihu
- vypísať všetky knihy v inventári
- vypísať iba požičané knihy
- vypísať knihy po prekročení výpožičnej lehoty
- vypísať knihy podľa zvolenej kategórie

---

## 7. Popis tried

### Trieda `Kniznica01.Kniha`
Trieda reprezentuje jednu knihu v knižnici.  
Obsahuje základné informácie o knihe a jej stave (či je požičaná alebo nie).

---

### Trieda `Kniznica01.Inventar`
Trieda zabezpečuje správu všetkých kníh v knižnici.  
Knihy sú uložené v poli a trieda poskytuje metódy na ich vyhľadávanie, pridávanie, odstraňovanie a výpis.

---

### Trieda `Kniznica01.Kniznica`
Trieda obsahuje hlavnú logiku aplikácie a textové menu.  
Spracováva vstupy od používateľa a volá príslušné metódy triedy `Kniznica01.Inventar`.

---

### Trieda `Kniznica01.Main`
Trieda `Kniznica01.Main` predstavuje vstupný bod programu.  
Obsahuje metódu `main`, ktorá spustí aplikáciu.

---

## 8. Testovacie dáta
Program po spustení automaticky načíta testovacie knihy, aby bolo možné aplikáciu okamžite používať bez nutnosti ručného zadávania údajov.

---

## 9. Diagram tried (Class Diagram)
Tento diagram zobrazuje štruktúru objektov v aplikácii.

```mermaid
classDiagram
    class Kniznica01.Main {
        +main(String[] args)
    }
    class Kniznica01.Kniznica {
        -Kniznica01.Inventar inventar
        -Scanner sc
        +Kniznica01.Kniznica()
        +spusti()
        -menuFiltrovania()
        -nacitajData()
    }
    class Kniznica01.Inventar {
        -Kniznica01.Kniha[] knihy
        -int pocet
        +pridajKnihu(Kniznica01.Kniha k)
        +vymazKnihu(String nazov)
        +vypisPodlaMenaAutora(String meno)
    }
    class Kniznica01.Kniha {
        -String nazov
        -String autor
        -boolean pozicana
        +vypis()
    }

    Kniznica01.Main --> Kniznica01.Kniznica : spúšťa
    Kniznica01.Kniznica "" *-- "" Kniznica01.Inventar : vlastní
    Kniznica01.Inventar "" *-- "" Kniznica01.Kniha : spravuje
```

---

## 10. Vývojový diagram – Požičanie knihy (Flowchart)
Nasledujúci vývojový diagram znázorňuje proces požičania knihy v aplikácii.
Diagram popisuje vyhľadanie knihy podľa názvu, kontrolu jej dostupnosti a rozhodnutie o ďalšom postupe.

```mermaid
flowchart TD
    A[Začiatok požičania knihy] --> B[Prehľadávanie zoznamu kníh]
    B --> C{Našla sa kniha?}

    C -->|Nie| D[Vypísať: Kniznica01.Kniha sa nenašla]
    D --> E[Koniec]

    C -->|Áno| F{Je kniha požičaná?}
    F -->|Áno| G[Vypísať: Kniznica01.Kniha je už požičaná]
    G --> E

    F -->|Nie| H[Požičať knihu na zadaný počet dní]
    H --> I[Vypísať: Kniznica01.Kniha bola požičaná]
    I --> E

```
