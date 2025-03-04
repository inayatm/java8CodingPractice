package com.inayath.multithreading;

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {

    InventoryCounter inventoryCounter =new InventoryCounter();
    IncreamentThread thread1=new IncreamentThread(inventoryCounter);
    DecreamentThread thread2=new DecreamentThread(inventoryCounter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(inventoryCounter.getItem());  //incorrect results. , it supposed to be print zero itemms.
    }

    private static class IncreamentThread extends Thread{
        private InventoryCounter inventoryCounter;
        IncreamentThread(InventoryCounter inventoryCounter){
            this.inventoryCounter=inventoryCounter;
        }

        @Override
        public void run() {

            for (int i = 0; i < 1000; i++) {
                inventoryCounter.increament();
            }

        }
    }
    private static class DecreamentThread extends Thread{
        private InventoryCounter inventoryCounter;
        DecreamentThread(InventoryCounter inventoryCounter){
            this.inventoryCounter=inventoryCounter;
        }

        @Override
        public void run() {

            for (int i = 0; i < 1000; i++) {
                inventoryCounter.decreament();
            }

        }
    }


    private static class InventoryCounter {
        private int item=0;

        private int increament() {
            return item++;
        }

        private int decreament() {
            return item--;
        }

        private int getItem(){
            return item;
        }
    }
}
