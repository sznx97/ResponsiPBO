package com.company;

import java.util.Scanner;

import java.text.DecimalFormat;

public class Akun {
    private int noCust;
    private int noPin;
    private double  saldo;


    Scanner input = new Scanner(System.in);
    DecimalFormat formatUang = new DecimalFormat("'Rp'###,###.00");

    public int getNoCust(){
        return noCust;
    }

    public int getNoPin(){
        return noPin;
    }

    public double getSaldo(){
        return saldo;
    }

    public int setNoCust(int noCust){
        this.noCust = noCust;
        return noCust;
    }
    public int setNoPin(int noPin){
        this.noPin = noPin;
        return noPin;
    }

    public double hitungPenarikanSaldo(double besarnya){
        saldo= (saldo - besarnya);
        return  saldo;
    }

    public double hitungDepositoSaldo(double besarnya){
        saldo = (saldo + besarnya);
        return  saldo;
    }

    public void getInputPenarikanSaldo(){
        System.out.println("Saldo : "+formatUang.format(saldo));
        System.out.println("Masukkan jumlah saldo yang ingin ditarik :");
        double besarnya = input.nextDouble();

        if ((saldo - besarnya) >= 0){
            hitungPenarikanSaldo(besarnya);
            System.out.println("Sisa saldo : "+formatUang.format(saldo));
        }else {
            System.out.println("Saldo kurang");
        }
    }

    public void getInputDepositoSaldo(){
        System.out.println("Saldo : "+formatUang.format(saldo));
        System.out.println("Masukkan jumlah saldo yang ingin dideposito :");
        double besarnya = input.nextDouble();

        if((saldo + besarnya) >= 0){
            hitungDepositoSaldo(besarnya);
            System.out.println("Saldo : " + formatUang.format(saldo));
        }else {
            System.out.println("Saldo tidak bisa kurang dari 0 ");
        }
    }

}
