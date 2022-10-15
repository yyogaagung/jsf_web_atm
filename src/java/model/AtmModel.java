/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.AtmDao;

public class AtmModel implements AtmDao {
    InisialisasiSaldo saldo;

    public AtmModel() {
        this.saldo = InisialisasiSaldo.getInstance();
    }
     
    public int limitSaldo(){
        return this.saldo.batassSaldo;
    }

    @Override
    public int getSaldo() {
        return this.saldo.getSaldoAwal();
    }

    @Override
    public int cekTransaksi(int jumlah) {
        if(jumlah % 50000 == 0){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void tambahSaldo(int jumlah) {
        this.saldo.setSaldoAwal(this.saldo.getSaldoAwal()+jumlah);
    }

    @Override
    public void tarikSaldo(int jumlah) {
        this.saldo.setSaldoAwal(this.saldo.getSaldoAwal()-jumlah);
    }

    @Override
    public boolean cekBatasSaldo() {
        if(this.saldo.getSaldoAwal() <= this.saldo.batassSaldo){
            return true;
        } else {
            return false;
        }
    }
}