package com.company;


import java.util.Scanner;

import java.text.DecimalFormat;
import java.util.stream.DoubleStream;


public class Akun {
    private int noCust;
    private int noPin;
    private int  saldo;
    private int maxDraw = 3150000;
    private double[] noRek = {2000018441,2000018442, 2000018439, 2000018438, 2000018437};




    Scanner input = new Scanner(System.in);
    DecimalFormat formatUang = new DecimalFormat("'Rp'###,###.00");

    public int getNoCust(){
        return noCust;
    }


    public int getNoPin(){
        return noPin;
    }

    public int getSaldo(){
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

    public int hitungPenarikanSaldo(int besarnya){
        saldo= (saldo - besarnya);
        return  saldo;
    }

    public int hitungDepositoSaldo(int besarnya){
        saldo = (saldo + besarnya);
        return  saldo;
    }
    public int transfer(int besarnya){
        saldo = (saldo - besarnya);
        return saldo;
    }

    public int getInputTransfer(){
        System.out.println("Masukkan no rekening tujuan : ");
        double noRek = input.nextDouble();
        boolean contains = DoubleStream.of(this.noRek).anyMatch(x -> x == noRek);
        if(contains){

            System.out.println("Masukkan jumlah saldo yang ignin ditransfer : ");
            int besarnya = input.nextInt();
            if((saldo - besarnya) >= 0){
                return transfer(besarnya);
            }else {
                System.out.println("Saldo tidak cukup ");
                return saldo;
            }

        }else{
            System.out.println("Nomor rekening tidak terdafrar");
            return saldo;
        }


    }
    public int getInputPenarikanSaldo(int moneyDrawn){
        System.out.println("Saldo : "+formatUang.format(saldo));
        System.out.println("Masukkan jumlah saldo yang ingin ditarik :");
        int besarnya = input.nextInt();
        int maxDraw = this.maxDraw;
        if(moneyDrawn + besarnya <= maxDraw ){
          if ((saldo - besarnya) >= 0){
              hitungPenarikanSaldo(besarnya);
              System.out.println("Sisa saldo : "+formatUang.format(saldo));
              return besarnya;
          }else {
              System.out.println("Saldo kurang");
              return 0;
          }  
        }else {
            System.out.println("Tidak boleh melebihi batas");
            return  -1;
        }
    }

    public void getInputDepositoSaldo(){
        System.out.println("Saldo : "+formatUang.format(saldo));
        System.out.println("Masukkan jumlah saldo yang ingin dideposito :");
        int besarnya = input.nextInt();

        if((saldo + besarnya) >= 0){
            hitungDepositoSaldo(besarnya);
            System.out.println("Saldo : " + formatUang.format(saldo));
        }else {
            System.out.println("Saldo tidak bisa kurang dari 0 ");
        }
    }

}
