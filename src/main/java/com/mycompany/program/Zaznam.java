/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.program;
import java.time.LocalDate;
import java.util.Scanner;
public class Zaznam {
      public String jmeno;
    public String prijmeni;
    private final int vek;
    private final int telCislo;

    public Zaznam(String jmeno, String prijmeni, int vek, int telCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telCislo = telCislo;
    }

    @Override
    public String toString() {
        return jmeno + " " + prijmeni + " | " + vek + " let | tel. číslo: +420" + telCislo;
    }
}
