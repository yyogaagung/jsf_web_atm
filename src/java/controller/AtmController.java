/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import model.AtmModel;
//import atm.mvc.Tampilan;
//import java.util.Scanner;

/**
 *
 * @author Asus
 */

@Named
@RequestScoped

public class AtmController {
//    Scanner myObj = new Scanner(System.in);
//    Tampilan object = Tampilan.getInstance();
    private AtmModel model;
    private int jumlah;
    private String responeTarikTunai;    
    private String responeSetorTunai; 
    
    public AtmController(){
        model = new AtmModel();
    }
    
    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    public int cekSaldo() {
        return model.getSaldo();
    }

    public String getResponeTarikTunai() {
         if(model.cekBatasSaldo()){
            return "Saldo Anda Mencapai Limit";
        } else if((model.getSaldo()- jumlah)< model.limitSaldo()){
            return "Jumlah Penarikan melebihi limit penarikan";
        } else if((model.getSaldo()> jumlah) && (model.cekTransaksi(jumlah) == 1)){
            model.tarikSaldo(jumlah);
            return "Tarik Tunai Berhasil";
        } else{
            return  "Penarikan harus kelipatan 50000";
        }         
    }
 
    
    


    public String getResponeSetorTunai() {
        if(model.cekTransaksi(jumlah)==1){
            model.tambahSaldo(jumlah);
            return "Setor Tunai berhasil";
        } else{
            return ("Setor Tunai harus kelipatan 50000");
        }
    }
    
}