package com.pc2.quintacat.web;

import com.pc2.quintacat.model.Asalariado;

import com.pc2.quintacat.repository.asalariadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by vfconsulting1 on 24/04/2018.
 */
@Controller
public class ImpuestorentaController {

    @Autowired
    private asalariadoRepository asalariadoRepository;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("asalariado", new Asalariado());
        return "index";
    }

    @PostMapping("/index")
    public String submit(@Valid Asalariado asalariado,
                         BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "index";
        }
        switch(asalariado.getTiposueldo()) {
            case "D":
                asalariado.setProyIngbruto(asalariado.getSueldo() * 12);
                break;
            case "I":
                asalariado.setProyIngbruto(asalariado.getSueldo() * 14);
                break;
        }


            asalariado.setMonto7UIT(7*asalariado.getUit());
            if((asalariado.getProyIngbruto()-asalariado.getMonto7UIT())<0){
                asalariado.setRentaNet(0.0);
            }else{
                asalariado.setRentaNet(asalariado.getProyIngbruto()-asalariado.getMonto7UIT());
            }

            asalariado.setMaximo5(asalariado.getUit() * 5);
            asalariado.setMaximo20(asalariado.getUit() * 20);
            asalariado.setMaximo35(asalariado.getUit() * 35);
            asalariado.setMaximo45(asalariado.getUit() * 45);
            asalariado.setMaximo45m(">" + asalariado.getMaximo45().toString());
            asalariado.setMont5(monto5(asalariado));
            asalariado.setMont20(monto20(asalariado));
            asalariado.setMont35(monto35(asalariado));
            asalariado.setMont45(monto45(asalariado));
            asalariado.setMont45m(monto45m(asalariado));
            asalariado.setImpuesto5(0.08 * asalariado.getMont5());
            asalariado.setImpuesto20(0.14 * asalariado.getMont20());
            asalariado.setImpuesto35(0.17 * asalariado.getMont35());
            asalariado.setImpuesto45(0.2 * asalariado.getMont45());
            asalariado.setImpuesto45m(0.3 * asalariado.getMont45m());
            asalariado.setImpuesto(asalariado.getImpuesto5()+asalariado.getImpuesto20()+asalariado.getImpuesto35()
            +asalariado.getImpuesto45()+asalariado.getImpuesto45m());
            asalariado.setTotalBruto(asalariado.getRentaNet()-asalariado.getImpuesto());
            asalariado.setTotalNeto(asalariado.getRentaNet());
            asalariado.setTotalImpuesto(asalariado.getImpuesto());
            asalariado.setRetmensual(asalariado.getImpuesto() / 12);
        asalariado.setRentaNet(asalariado.getProyIngbruto()-asalariado.getMonto7UIT());
            asalariadoRepository.save(asalariado);

        return "renta";
    }

    @GetMapping("/index/renta")
    public String impuesto(Model model){
        model.addAttribute("asalariado", new Asalariado());
        return "renta";
    }

    @GetMapping("/asalariado/list")
    public String list(Map<String, Object> model) {
        List<Asalariado> asalariados = asalariadoRepository.findAll();
        model.put("asalariados",asalariados);
        return "listAsalariado";
    }


    public Double monto5(Asalariado asalariado){
        if(asalariado.getRentaNet()<asalariado.getMaximo5()) {
            Double resultado = asalariado.getRentaNet();
            asalariado.setRentaNet(asalariado.getRentaNet()-asalariado.getMaximo5());
            return resultado;
        }
        else {
            asalariado.setRentaNet(asalariado.getRentaNet()-asalariado.getMaximo5());
            return asalariado.getMaximo5();
        }
    }

    public Double monto20(Asalariado asalariado){
        if(asalariado.getRentaNet()>0 && asalariado.getMont5()+asalariado.getRentaNet()<=asalariado.getMaximo20()) {
            return asalariado.getRentaNet();
        }
        else if(asalariado.getRentaNet()<=0) {
            asalariado.setRentaNet(0.0);
            return 0.0;
        }
        else {
            asalariado.setRentaNet(asalariado.getRentaNet()-asalariado.getMaximo20()+asalariado.getMont5());
            return asalariado.getMaximo20() - asalariado.getMaximo5();
        }
    }

    public Double monto35(Asalariado asalariado){
        if(asalariado.getRentaNet()>0 && asalariado.getMont5()+ asalariado.getMont20()+asalariado.getRentaNet()<=asalariado.getMaximo35()) {
            return asalariado.getRentaNet();
        }
        else if(asalariado.getRentaNet()<=0) {
            asalariado.setRentaNet(0.0);
            return 0.0;
        }
        else {
            asalariado.setRentaNet(asalariado.getRentaNet()-asalariado.getMaximo35()+asalariado.getMont5()+asalariado.getMont20());
            return asalariado.getMaximo35()-asalariado.getMaximo20();
        }
    }

    public Double monto45(Asalariado asalariado){
        if(asalariado.getRentaNet()>0 && asalariado.getMont5()+asalariado.getMont20()+asalariado.getMont35()+asalariado.getRentaNet()<=asalariado.getMaximo45()) {
            return asalariado.getRentaNet();
        }
        else if(asalariado.getRentaNet()<=0) {
            asalariado.setRentaNet(0.0);
            return 0.0;
        }
        else {
            asalariado.setRentaNet(asalariado.getRentaNet()-asalariado.getMaximo45()+asalariado.getMont35()+asalariado.getMont5()+asalariado.getMont20());
            return asalariado.getMaximo45()-asalariado.getMaximo35();
        }
    }

    public Double monto45m(Asalariado asalariado){
        if(asalariado.getRentaNet()<=0) {
            asalariado.setRentaNet(0.0);
            return 0.0;
        }
        else if((asalariado.getRentaNet()-asalariado.getMaximo45()+asalariado.getMont35()+asalariado.getMont5()+asalariado.getMont20())<0){
            return 0.0;
        }
        return  asalariado.getRentaNet()-asalariado.getMaximo45()+asalariado.getMont35()+asalariado.getMont5()+asalariado.getMont20();
    }

}
