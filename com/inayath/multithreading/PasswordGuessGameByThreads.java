package com.inayath.multithreading;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PasswordGuessGameByThreads {

    private static final int MAX_PASSWORD=999;

    public static void main(String[] args) {
        Random random=new Random();
        Vault vault=new Vault(random.nextInt(MAX_PASSWORD));


        List<Thread> threadList = Arrays.asList(
                            new AscendingOrderHackerThread(vault),
                            new DescendingOrderHackerThread(vault),
                            new policeThread()
                            );

        threadList.stream().forEach(thread->thread.start());
    }

    private static class Vault{
        int password=0;
        Vault(int password){
            this.password=password;
        }

        private boolean iscorrectPassword(int guess){
            try {
               Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return this.password==guess;
        }

    }
    private static abstract  class HackerThread extends Thread{
        protected Vault vault;
        HackerThread(Vault vault){
            this.vault=vault;
            this.setName(this.getClass().getSimpleName());
           this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public  void start() {
            System.out.println("current thread running: "+this.getName());
            super.start();
        }
    }

    private static class AscendingOrderHackerThread extends HackerThread{

        AscendingOrderHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess=0;guess<=MAX_PASSWORD;guess++){
                if(vault.iscorrectPassword(guess)){
                    System.out.println(this.getName()+": guessed the password "+guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingOrderHackerThread extends HackerThread{


        DescendingOrderHackerThread(Vault vault) {
            super(vault);
        }


        @Override
        public void run() {
            for (int guess = MAX_PASSWORD; guess>=0  ; guess--) {
                if (vault.iscorrectPassword(guess)) {
                    System.out.println(this.getName() + ": guessed the password :" + guess);
                    System.exit(0);
                }
            }

        }
    }



    private static class policeThread extends Thread{

        policeThread(){
           // this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void run() {
            for (int i = 10; i>=0; i--) {
                try {
                    Thread.sleep(100);
                    System.out.println("police arriving in : "+i);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                 }

            System.out.println("GAME over..");
            System.exit(0);
        }
    }

}
