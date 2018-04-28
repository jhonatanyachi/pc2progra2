package com.pc2.quintacat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import javax.persistence.Id;

/**
 * Created by vfconsulting1 on 26/04/2018.
 */
@Entity
public class Asalariado implements Serializable{
    @Id
    @GeneratedValue
    private Integer Id;
    private Double Uit;
    private String Dni;
    private String Nombre;
    private Double Sueldo;
    private String Tiposueldo;
    private String Apellido;
    private Double TotalImpuesto;
    private Double TotalNeto;
    private Double TotalBruto;
    private Double proyIngbruto;
    private Double monto7UIT;
    private Double rentaNet;
    private Double retmensual;
    private Double maximo5;
    private Double maximo20;
    private Double maximo35;
    private Double maximo45;
    private String maximo45m = "";
    private Double montoafecto;
    private Double Impuesto;
    private Double Impuesto5;
    private Double Impuesto20;
    private Double Impuesto35;
    private Double Impuesto45;
    private Double Impuesto45m;
    private Double mont5;
    private Double mont20;
    private Double mont35;
    private Double mont45;
    private Double mont45m;

    public Double getUit() {
        return Uit;
    }

    public void setUit(Double uit) {
        Uit = uit;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Double getTotalImpuesto() {
        return TotalImpuesto;
    }

    public void setTotalImpuesto(Double totalImpuesto) {
        TotalImpuesto = totalImpuesto;
    }

    public Double getTotalNeto() {
        return TotalNeto;
    }

    public void setTotalNeto(Double totalNeto) {
        TotalNeto = totalNeto;
    }

    public Double getTotalBruto() {
        return TotalBruto;
    }

    public void setTotalBruto(Double totalBruto) {
        TotalBruto = totalBruto;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(Double sueldo) {
        Sueldo = sueldo;
    }

    public String getTiposueldo() {
        return Tiposueldo;
    }

    public void setTiposueldo(String tiposueldo) {
        Tiposueldo = tiposueldo;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public Double getProyIngbruto() {
        return proyIngbruto;
    }

    public void setProyIngbruto(Double proyIngbruto) {
        this.proyIngbruto = proyIngbruto;
    }

    public Double getMonto7UIT() {
        return monto7UIT;
    }

    public void setMonto7UIT(Double monto7UIT) {
        this.monto7UIT = monto7UIT;
    }


    public Double getRentaNet() {
        return rentaNet;
    }

    public void setRentaNet(Double rentaNet) {
        this.rentaNet = rentaNet;
    }

    public Double getRetmensual() {
        return retmensual;
    }

    public void setRetmensual(Double retmensual) {
        this.retmensual = retmensual;
    }

    public Double getMaximo5() {
        return maximo5;
    }

    public void setMaximo5(Double maximo5) {
        this.maximo5 = maximo5;
    }

    public Double getMaximo20() {
        return maximo20;
    }

    public void setMaximo20(Double maximo20) {
        this.maximo20 = maximo20;
    }

    public Double getMaximo35() {
        return maximo35;
    }

    public void setMaximo35(Double maximo35) {
        this.maximo35 = maximo35;
    }

    public Double getMaximo45() {
        return maximo45;
    }

    public void setMaximo45(Double maximo45) {
        this.maximo45 = maximo45;
    }

    public String getMaximo45m() {
        return maximo45m;
    }

    public void setMaximo45m(String maximo45m) {
        this.maximo45m = maximo45m;
    }

    public Double getMontoafecto() {
        return montoafecto;
    }

    public void setMontoafecto(Double montoafecto) {
        this.montoafecto = montoafecto;
    }

    public Double getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(Double impuesto) {
        Impuesto = impuesto;
    }

    public Double getImpuesto5() {
        return Impuesto5;
    }

    public void setImpuesto5(Double impuesto5) {
        Impuesto5 = impuesto5;
    }

    public Double getImpuesto20() {
        return Impuesto20;
    }

    public void setImpuesto20(Double impuesto20) {
        Impuesto20 = impuesto20;
    }

    public Double getImpuesto35() {
        return Impuesto35;
    }

    public void setImpuesto35(Double impuesto35) {
        Impuesto35 = impuesto35;
    }

    public Double getImpuesto45() {
        return Impuesto45;
    }

    public void setImpuesto45(Double impuesto45) {
        Impuesto45 = impuesto45;
    }

    public Double getImpuesto45m() {
        return Impuesto45m;
    }

    public void setImpuesto45m(Double impuesto45m) {
        Impuesto45m = impuesto45m;
    }

    public Double getMont5() {
        return mont5;
    }

    public void setMont5(Double mont5) {
        this.mont5 = mont5;
    }

    public Double getMont20() {
        return mont20;
    }

    public void setMont20(Double mont20) {
        this.mont20 = mont20;
    }

    public Double getMont35() {
        return mont35;
    }

    public void setMont35(Double mont35) {
        this.mont35 = mont35;
    }

    public Double getMont45() {
        return mont45;
    }

    public void setMont45(Double mont45) {
        this.mont45 = mont45;
    }

    public Double getMont45m() {
        return mont45m;
    }

    public void setMont45m(Double mont45m) {
        this.mont45m = mont45m;
    }
}
