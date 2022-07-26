package org.mich.junit5app.ejemplos.models;

import org.mich.junit5app.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Banco {

    private String nombre;

    private List<Cuenta> cuentas;

    public Banco(){
        this.cuentas = new ArrayList<>();
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void agregarCuenta(Cuenta cuenta){
        this.cuentas.add(cuenta);
    }

    public void agregarCuentas(ArrayList<Cuenta> cuentas){
        for (Cuenta cuenta: cuentas) {
            cuenta.setBanco(this);
        }

        this.cuentas.addAll(cuentas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto) throws DineroInsuficienteException {
        origen.debito(monto);
        destino.credito(monto);
    }
}
