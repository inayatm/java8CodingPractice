package com.inayath.multithreading;

public class RaceConditionSolution {

    public static void main(String[] args) throws InterruptedException {

    InventoryCounter inventoryCounter =new InventoryCounter();
    IncreamentThread thread1=new IncreamentThread(inventoryCounter);
    DecreamentThread thread2=new DecreamentThread(inventoryCounter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("current items in the inventory: "+inventoryCounter.getItem()); //prints correct result -0
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

        private synchronized int increament() {
            return item++;
        }

        private synchronized int decreament() {
            return item--;
        }

        private int getItem(){
            return item;
        }
    }
}
