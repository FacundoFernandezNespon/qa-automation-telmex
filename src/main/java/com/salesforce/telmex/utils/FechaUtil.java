package com.salesforce.telmex.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FechaUtil {
    public static String obtenerFechaActual() {
        LocalDate fechaHoy = LocalDate.now();
        DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fechaHoy.format(formateadorFecha);
    }

    public static String obtenerFechaFutura(int diasASumar) {
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaFutura = fechaHoy.plusDays(diasASumar);
        DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaFutura.format(formateadorFecha);
    }

    public static String obtenerFechaFuturaFormatoES(int diasASumar) {
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaFutura = fechaHoy.plusDays(diasASumar);
        DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        return fechaFutura.format(formateadorFecha);
    }

    public static String obtenerFechaFuturaEnLetra(int diasASumar) {
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaFutura = fechaHoy.plusDays(diasASumar);
        DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("EEE MMM dd yyyy", Locale.ENGLISH);
        return fechaFutura.format(formateadorFecha);
    }

}
