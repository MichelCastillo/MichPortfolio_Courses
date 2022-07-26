package org.mich.junit5app.ejemplos.models;

import java.math.BigDecimal;

public class Cuenta {

    private String persona;
    private BigDecimal saldo;

    public Cuenta() {

    }

    public Cuenta(String persona, BigDecimal saldo) {
        this.saldo = saldo;
        this.persona = persona;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void debito(BigDecimal monto){
        //Usando la API de BigDecimal, este numero es inmutable
        //this.saldo.subtract(monto);//esto restaría monto al BigDecimal, pero devolveria el nuevo valor, el original no se cambió.

        //Por ello debemos usar esta sintaxis:
        this.saldo = this.saldo.subtract(monto);
    }

    public void credito(BigDecimal monto){
        this.saldo = this.saldo.add(monto);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Cuenta)){
            return false;
        }
        Cuenta c = (Cuenta) obj;
        if (this.persona == null || this.saldo == null) {
            return false;
        }
        return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());
    }


}
